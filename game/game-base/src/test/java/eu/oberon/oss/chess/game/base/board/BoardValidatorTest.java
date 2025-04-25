package eu.oberon.oss.chess.game.base.board;

import eu.oberon.oss.chess.game.base.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import eu.oberon.oss.chess.base.enums.CBRanks;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.enums.PieceType;
import eu.oberon.oss.chess.base.exceptions.BoardValidationException;
import eu.oberon.oss.chess.game.base.BoardImpl.BoardBuilder;
import eu.oberon.oss.chess.game.base.PieceImpl;
import eu.oberon.oss.chess.game.base.validators.BoardValidator;
import eu.oberon.oss.chess.base.interfaces.Board;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.ValidatorResult;
import eu.oberon.oss.chess.base.interfaces.validators.ChessValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static eu.oberon.oss.chess.base.enums.ChessField.*;
import static eu.oberon.oss.chess.base.enums.PieceType.*;
import static org.junit.jupiter.api.Assertions.*;
import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;

/**
 * @author Fabien H. Dumay
 */
class BoardValidatorTest extends Util {
    private ChessValidator<Board<Field, Piece<Field>>> boardValidator;

    @BeforeEach
    void setUp() {
        boardValidator = BoardValidator.getInstance();
    }

    private Board<Field, Piece<Field>> generateToManyPieces(ChessColor color, PieceType piece) {
        BoardBuilder<Field, Piece<Field>> builder = new BoardBuilder<>();
        Field[]                           fields;

        if (color == WHITE) {
            builder = getInitialPiecesForBlack(builder);
            builder.addPiece(new PieceImpl<>(KING, WHITE, E1));
            fields = new Field[]{A2, B2, C2, D2, E2, F2, G2, H2, A3, B3};
        } else {
            builder = getInitialPiecesForWhite(builder);
            builder.addPiece(new PieceImpl<>(KING, BLACK, E8));
            fields = new Field[]{A7, B7, C7, D7, E7, F7, G7, H7, A6, B6};
        }

        for (int i = 0; i < (piece == PAWN ? 9 : 10); i++) {
            builder.addPiece(new PieceImpl<>(piece, color, fields[i]));
        }

        return builder.build();
    }

    public static Stream<Arguments> validate_invalid_PawnsOnRank8OrOne() {
        List<Field> fieldInformation = new ArrayList<>();
        fieldInformation.addAll(CBRanks.EIGHTH_RANK.getFields());
        fieldInformation.addAll(CBRanks.FIRST_RANK.getFields());

        List<Arguments> arguments = new ArrayList<>();
        for (Field field : fieldInformation) {
            arguments.add(Arguments.of(field, WHITE));
            arguments.add(Arguments.of(field, BLACK));
        }

        return arguments.stream();
    }

    @ParameterizedTest
    @MethodSource
    void validate_invalid_PawnsOnRank8OrOne(Field field, ChessColor color) {
        BoardBuilder<Field, Piece<Field>> builder = new BoardBuilder<>()
            .addPiece(new PieceImpl<>(KING, WHITE, A5))
            .addPiece(new PieceImpl<>(KING, BLACK, H5))
            .addPiece(new PieceImpl<>(PAWN, color, field));
        Board<Field, Piece<Field>> board = assertDoesNotThrow(builder::build);
        assertThrows(BoardValidationException.class, () -> boardValidator.validate(board));
    }

    public static Stream<Arguments> validate_invalid_ToManyWhitePiecesOfType() {
        return Stream.of(
            Arguments.of(WHITE, QUEEN, "queens", 10, 9),
            Arguments.of(WHITE, ROOK, "rooks", 10, 9),
            Arguments.of(WHITE, BISHOP, "bishops", 10, 9),
            Arguments.of(WHITE, KNIGHT, "knights", 10, 9),
            Arguments.of(WHITE, PAWN, "pawns", 9, 8),

            Arguments.of(BLACK, QUEEN, "queens", 10, 9),
            Arguments.of(BLACK, ROOK, "rooks", 10, 9),
            Arguments.of(BLACK, BISHOP, "bishops", 10, 9),
            Arguments.of(BLACK, KNIGHT, "knights", 10, 9),
            Arguments.of(BLACK, PAWN, "pawns", 9, 8)
        );
    }


    @SuppressWarnings("java:S5778")
    @ParameterizedTest
    @MethodSource
    void validate_invalid_ToManyWhitePiecesOfType(ChessColor color, PieceType piece, String name, int found, int max) {
        BoardValidationException exception =
            assertThrows(BoardValidationException.class, () -> boardValidator.validate(generateToManyPieces(color, piece)));
        String msg = String.format("Number of %s %s (%d) exceeds maximum of %d", color.name().toLowerCase(), name, found, max);
        assertEquals(msg, exception.getMessage());
    }

    @Test
    @SuppressWarnings("java:S5778")
    void validate_invalid_ToManyWhitePieces() {
        BoardBuilder<Field, Piece<Field>> builder = new BoardBuilder<>();
        Board<Field, Piece<Field>> board = getInitialPiecesForWhite(builder)
            .addPiece(new PieceImpl<>(KING, BLACK, E8))
            .addPiece(new PieceImpl<>(ROOK, WHITE, F5))
            .build();
        ValidatorResult result = boardValidator.validate(board);
        assertFalse(result.isValid());
        assertEquals("There can only be 16 white pieces on the board, 17 where found", result.getMessages().get(0));
    }

    @Test
    @SuppressWarnings("java:S5778")
    void validate_invalid_ToManyBlackPieces() {
        BoardBuilder<Field, Piece<Field>> builder = new BoardBuilder<>();
        Board<Field, Piece<Field>> board = getInitialPiecesForBlack(builder)
            .addPiece(new PieceImpl<>(KING, WHITE, E1))
            .addPiece(new PieceImpl<>(ROOK, BLACK, F5))
            .build();
        ValidatorResult result = boardValidator.validate(board);
        assertFalse(result.isValid());
        assertEquals("There can only be 16 black pieces on the board, 17 where found", result.getMessages().get(0));
    }


    @Test
    void validate_withOneWhiteAndOneBlackNotAdjacent() {
        assertDoesNotThrow(() -> boardValidator.validate(new BoardBuilder<>()
                                                             .addPiece(new PieceImpl<>(KING, WHITE, E1))
                                                             .addPiece(new PieceImpl<>(KING, BLACK, E8))
                                                             .build()));
    }

    @Test
    @SuppressWarnings("java:S5778")
    void validate_withOneWhiteKingOnly() {
        ValidatorResult result = boardValidator.validate(new BoardBuilder<>().addPiece(new PieceImpl<>(KING, WHITE, E1)).build());
        assertFalse(result.isValid());
        assertEquals("Board must contain at least 2 pieces. pieces in position: 1", result.getMessages().get(0));
    }

    @Test
    @SuppressWarnings("java:S5778")
    void validate_withOneBlackKingOnly() {
        ValidatorResult result = boardValidator.validate(new BoardBuilder<>().addPiece(new PieceImpl<>(KING, BLACK, E8)).build());
        assertEquals("Board must contain at least 2 pieces. pieces in position: 1", result.getMessages().get(0));
    }

    @Test
    @SuppressWarnings("java:S5778")
    void validate_WithToWhiteKings() {
        ValidatorResult result = boardValidator.validate(
            new BoardBuilder<>()
                .addPiece(new PieceImpl<>(KING, WHITE, E1))
                .addPiece(new PieceImpl<>(KING, WHITE, G1))
                .addPiece(new PieceImpl<>(KING, BLACK, E8))
                .build()
        );
        assertFalse(result.isValid());
        assertEquals("Expected 1 white king, but found 2", result.getMessages().get(0));
    }

    @Test
    @SuppressWarnings("java:S5778")
    void validate_WithToBlackKings() {
        ValidatorResult result = boardValidator.validate(
            new BoardBuilder<>()
                .addPiece(new PieceImpl<>(KING, WHITE, E1))
                .addPiece(new PieceImpl<>(KING, BLACK, E8))
                .addPiece(new PieceImpl<>(KING, BLACK, G8))
                .build()
        );
        assertFalse(result.isValid());
        assertEquals("Expected 1 black king, but found 2", result.getMessages().get(0));
    }

    @Test
    @SuppressWarnings("java:S5778")
    void validate_WithMoreThan32Pieces() {
        BoardBuilder<Field, Piece<Field>> builder = new BoardBuilder<>();
        getInitialPiecesForWhite(getInitialPiecesForBlack(builder));
        ValidatorResult result = boardValidator.validate(
            new BoardBuilder<>()
                .copyFromBoard(builder.build())
                .addPiece(new PieceImpl<>(QUEEN, WHITE, E4))
                .build()
        );
        assertFalse(result.isValid());
        assertEquals("Board must contain no more than 32 pieces, pieces in position:33", result.getMessages().get(0));
    }
}