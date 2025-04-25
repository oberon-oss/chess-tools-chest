/*
MIT No Attribution

Copyright 2024 Fabien H. Dumay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package org.oberon.oss.chess.fen.processing;

import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.base.enums.ChessField;
import org.oberon.oss.chess.base.enums.PieceType;
import org.oberon.oss.chess.base.interfaces.*;
import org.oberon.oss.chess.fen.processing.FENPositionImpl.FENPositionBuilder;
import org.oberon.oss.chess.game.base.BoardImpl.BoardBuilder;
import org.oberon.oss.chess.game.base.CastlingConfigValidator;
import org.oberon.oss.chess.game.base.CastlingConfigurationImpl;
import org.oberon.oss.chess.game.base.FieldIteratorImpl;
import org.oberon.oss.chess.game.base.PieceImpl;
import org.oberon.oss.chess.base.interfaces.validators.ExtendedChessValidator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.oberon.oss.chess.base.enums.CastlingType.KING_SIDE;
import static org.oberon.oss.chess.base.enums.CastlingType.QUEEN_SIDE;
import static org.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static org.oberon.oss.chess.base.enums.ChessColor.WHITE;
import static org.oberon.oss.chess.base.enums.ChessField.H1;
import static org.oberon.oss.chess.base.enums.PieceType.PAWN;


/**
 * Default implementation for the {@link FENPositionTranslator} interface
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@Log4j2
@EqualsAndHashCode
public class FENPositionTranslatorImpl implements FENPositionTranslator<Field, Piece<Field>> {
    protected static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");
    protected static final Pattern FEN_PATTERN   = Pattern.compile(
        "((?:[kqrbnpKQRBNP1-8]{1,8}/?){8})" // group 1: position
        + "\\s([bw])"                       // group 2: sideToMove
        + "\\s(-|[KQkq]{1,4})"              // group 3: castling rights
        + "\\s(-|[aAeE][36])"               // group 4: en-passant field
        + "\\s(100|\\d{1,2})"               // group 5: half-move (ply) count
        + "\\s(\\d{1,3})"                   // group 6: move count
    );

    private static final ExtendedChessValidator<Board<Field, Piece<Field>>, CastlingConfiguration<Field>> VALIDATOR;

    static {
        VALIDATOR = CastlingConfigValidator.getInstance();
    }

    @Override
    public FENPosition<Field, Piece<Field>> toFENPosition(@NotNull String fenPositionSetupString) {
        FENPositionBuilder<Field, Piece<Field>> fenPositionBuilder = new FENPositionBuilder<>();

        Matcher wrk = FEN_PATTERN.matcher(fenPositionSetupString);
        if (!wrk.matches()) {
            throw new FENTranslatorException("Invalid setup string: " + fenPositionSetupString);
        }

        Board<Field, Piece<Field>> board = extract(wrk.group(1));
        fenPositionBuilder
            .board(board)
            .sideToMove(wrk.group(2).contentEquals("b") ? BLACK : WHITE)
            .enPassantField(setEnPassantField(board, wrk.group(4)))
            .halveMoveClock(Integer.parseInt(wrk.group(5)))
            .fullMoveNumber(Integer.parseInt(wrk.group(6)));
        checkCastlingRights(board, wrk.group(3), fenPositionBuilder);

        return fenPositionBuilder.build();
    }

    @Override
    public String toFENString(@NotNull Position<Field, Piece<Field>> position) {
        StringBuilder sb = new StringBuilder();
        convertPositionToString(position.board().getPieceMapping(), sb);

        sb.append(" ").append(position.sideToMove() == BLACK ? "b" : "w");
        sb.append(" ");
        int length = sb.length();
        sb.append(Boolean.TRUE.equals(position.whiteCanCastleKingSide()) ? "K" : "");
        sb.append(Boolean.TRUE.equals(position.whiteCanCastleQueenSide()) ? "Q" : "");
        sb.append(Boolean.TRUE.equals(position.blackCanCastleKingSide()) ? "k" : "");
        sb.append(Boolean.TRUE.equals(position.blackCanCastleQueenSide()) ? "q" : "");

        if (sb.length() == length) {
            sb.append("-");
        }

        sb.append(" ").append(position.enPassantField() == null ? "-" : position.enPassantField());
        sb.append(" ").append(position.halveMoveClock());
        sb.append(" ").append(position.fullMoveNumber());
        return sb.toString();
    }

    private void checkCastlingRights(Board<Field, Piece<Field>> board, String castlingRights, FENPositionBuilder<Field, Piece<Field>> builder) {
        if (!castlingRights.contentEquals("-")) {
            for (int i = 0; i < castlingRights.length(); i++) {
                char            c = castlingRights.charAt(i);
                ValidatorResult result;

                CastlingConfiguration<Field> castlingConfiguration = switch (c) {
                    case 'K' -> CastlingConfigurationImpl.getConfiguration(board, KING_SIDE, WHITE);
                    case 'Q' -> CastlingConfigurationImpl.getConfiguration(board, QUEEN_SIDE, WHITE);
                    case 'k' -> CastlingConfigurationImpl.getConfiguration(board, KING_SIDE, BLACK);
                    case 'q' -> CastlingConfigurationImpl.getConfiguration(board, QUEEN_SIDE, BLACK);
                    default -> throw new FENTranslatorException("Invalid castlingRights: " + castlingRights);
                };
                result = VALIDATOR.validate(board, castlingConfiguration);
                if (result.isValid()) {
                    builder.castlingConfiguration(castlingConfiguration);
                }
            }
        }
    }

    private void verifyIfFieldContainsPawn(Board<Field, Piece<Field>> board, ChessField field, ChessColor color) {
        Piece<Field> pieceFound = board.getPieceOnField(field);
        if (pieceFound == null) {
            throw new FENTranslatorException(String.format("Field %s is empty", field.name()));
        }
        PieceType  pieceType  = pieceFound.getPieceType();
        ChessColor pieceColor = pieceFound.getPieceColor();
        if (pieceType != PAWN || pieceColor != color) {
            throw new FENTranslatorException(String.format("Field %s does not contain a %s pawn", field.name(), color));
        }
    }

    private Field setEnPassantField(Board<Field, Piece<Field>> position, String enPassantField) {
        if (enPassantField.contentEquals("-")) {
            return null;
        }
        ChessField field = ChessField.valueOf(enPassantField);

        verifyIfFieldContainsPawn(position, field, field.getRank() == 6 ? BLACK : WHITE);
        return field;
    }

    private Board<Field, Piece<Field>> extract(String positionString) {
        FieldIterator<Field> iterator = FieldIteratorImpl.chessBoardFieldIterator();
        BoardBuilder<Field, Piece<Field>> builder  = new BoardBuilder<>();

        for (String rank : positionString.split("/")) {
            validateRankData(rank);
            processRank(rank, iterator, builder);
        }
        return builder.build();
    }

    private void validateRankData(String rank) {
        int length = 0;
        for (char c : rank.toCharArray()) {
            if (Character.isDigit(c)) {
                length += c - '0';
            } else {
                ++length;
            }
        }
        if (length != 8) {
            throw new FENTranslatorException("Invalid rank: " + rank);
        }
    }

    private void processRank(String rank, FieldIterator<Field> iterator, BoardBuilder<Field, Piece<Field>> builder) {
        for (int i = 0; i < rank.length(); i++) {
            Field   currentField = iterator.next();
            String  content      = rank.substring(i, i + 1);
            Matcher m            = DIGIT_PATTERN.matcher(content);
            if (m.matches()) {
                int parseInt = Integer.parseInt(m.group(0));
                if (currentField != H1) {
                    iterator.skipFields(parseInt);
                    LOGGER.info("Skipping {} fields", parseInt);
                }
            } else {
                PieceType  fenChessPiece = FENChessPieceTranslator.translate(content);
                ChessColor color;
                if ("kqrbnp".contains(content)) {
                    color = BLACK;
                } else {
                    color = WHITE;
                }
                builder.addPiece(new PieceImpl<>(fenChessPiece, color, currentField));
                LOGGER.info("Processing piece {} @ {}", content, currentField);
            }
        }
    }

    private void convertPositionToString(Map<Field, Piece<Field>> position, StringBuilder sb) {
        for (int rank = 8; rank >= 1; rank--) {
            int                  emptyFieldsCount = 0;
            FieldIterator<Field> iterator         = FieldIteratorImpl.fieldIterator(rank);
            while (iterator.hasNext()) {
                Field        field = iterator.next();
                Piece<Field> piece = position.get(field);
                emptyFieldsCount = appendData(sb, piece, emptyFieldsCount);
            }
            if (emptyFieldsCount > 0) {
                sb.append(emptyFieldsCount);
            }
            if (rank > 1) {
                sb.append("/");
            }
        }
    }

    private int appendData(StringBuilder sb, Piece<Field> piece, int fieldsToSkip) {
        if (piece != null) {
            if (fieldsToSkip > 0) {
                sb.append(fieldsToSkip);
                fieldsToSkip = 0;
            }
            sb.append(FENChessPieceTranslator.getFENCharacterForPiece(piece));
        } else {
            ++fieldsToSkip;
        }
        return fieldsToSkip;
    }

}
