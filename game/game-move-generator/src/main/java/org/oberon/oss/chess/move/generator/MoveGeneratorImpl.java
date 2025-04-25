package org.oberon.oss.chess.move.generator;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.enums.CastlingType;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.base.enums.PieceType;
import org.oberon.oss.chess.base.interfaces.*;
import org.oberon.oss.chess.game.data.ChessGame;
import org.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import org.oberon.oss.chess.move.generator.tables.pieces.MoveTableProvider;
import org.oberon.oss.chess.game.base.MoveImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.oberon.oss.chess.base.enums.MoveDirection.*;

/**
 * @author Fabien H. Dumay
 */
@SuppressWarnings("java:S6548")
@Log4j2
public class MoveGeneratorImpl implements MoveGenerator<Field, Piece<Field>> {
    private MoveGeneratorImpl() {

    }

    private static final MoveGeneratorImpl INSTANCE = new MoveGeneratorImpl();

    public static <F extends Field, P extends Piece<F>> MoveGenerator<F, P> getInstance() {
        //noinspection unchecked
        return (MoveGenerator<F, P>) INSTANCE;
    }

    @Override
    public List<Move<Field, Piece<Field>>> createMoveList(@NotNull ChessColor color, @NotNull ChessGame<Field, Piece<Field>> chessGame) {
        List<Move<Field, Piece<Field>>> list = new ArrayList<>();
        for (Piece<Field> piece : chessGame.getCurrentPosition().board().getPiecesForColor(color).values()) {
            list.addAll(createMoveList(piece, chessGame));
        }
        return list;
    }

    @Override
    public List<Move<Field, Piece<Field>>> createMoveList(@NotNull Piece<Field> piece, @NotNull ChessGame<Field, Piece<Field>> chessGame) {
        TargetFieldMapping<Field> fieldMapping;
        if (piece.getPieceType() == PieceType.PAWN) {
            fieldMapping =
                MoveTableProvider
                    .getInstance()
                    .getPawnMoveTable(piece.getPieceColor())
                    .getFieldMapping(piece.getCurrentField());
        } else {
            fieldMapping = MoveTableProvider
                .getInstance()
                .getPieceMoveTable(piece.getPieceType())
                .getFieldMapping(piece.getCurrentField()
                );
        }
        assert fieldMapping != null;

        List<Move<Field, Piece<Field>>> list = new ArrayList<>();
        switch (piece.getPieceType()) {
            case ROOK:
                list.addAll(
                    DirectionBasedMoveGenerator.generate(
                        fieldMapping,
                        piece,
                        chessGame.getCurrentPosition(),
                        NORTH, EAST, SOUTH, WEST
                    )
                );
                break;
            case BISHOP:
                list.addAll(
                    DirectionBasedMoveGenerator.generate(
                        fieldMapping,
                        piece,
                        chessGame.getCurrentPosition(),
                        NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORTH_WEST
                    )
                );
                break;
            case QUEEN:
                list.addAll(
                    DirectionBasedMoveGenerator.generate(
                        fieldMapping,
                        piece,
                        chessGame.getCurrentPosition(),
                        NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST
                    )
                );
                break;
            case KING:
                list.addAll(NonDirectionalMoveGenerator.generate(fieldMapping, piece, chessGame.getCurrentPosition()));
                list.addAll(considerCastlingMoves(piece, chessGame));
                break;
            case KNIGHT:
                list.addAll(NonDirectionalMoveGenerator.generate(fieldMapping, piece, chessGame.getCurrentPosition()));
                break;
            case PAWN:
                list.addAll(PawnMoveGenerator.generate(fieldMapping, piece, chessGame.getCurrentPosition()));
                break;
        }
        return list;
    }

    private Collection<? extends Move<Field, Piece<Field>>> considerCastlingMoves(@NotNull Piece<Field> piece, @NotNull ChessGame<Field, Piece<Field>> chessGame) {
        List<Move<Field, Piece<Field>>> list = new ArrayList<>();

        for (CastlingConfiguration<Field> config : chessGame.getStartPosition().getCastlingTypes()) {
            if (shouldBeAdded(piece, config, chessGame.getCurrentPosition())) {
                int moveFlags = config.getCastlingType() == CastlingType.KING_SIDE
                                ? Move.BIT_FLAG_CASTLE_KING_SIDE
                                : Move.BIT_FLAG_CASTLE_QUEEN_SIDE;
                list.add(new MoveImpl<>(piece, null, null, null, null, moveFlags));
            }
        }
        return list;
    }

    private boolean shouldBeAdded(@NotNull Piece<Field> piece, CastlingConfiguration<Field> config, Position<Field, Piece<Field>> currentPosition) {
        return config.getColor() == piece.getPieceColor() &&
               checkPiece(currentPosition.board().getPieceOnField(config.getInitialLocationKing()), PieceType.KING) &&
               checkPiece(currentPosition.board().getPieceOnField(config.getInitialLocationRook()), PieceType.ROOK) &&
               checkIntermediateFields(config.getIntermediateFields(), currentPosition.board());
    }

    private boolean checkPiece(Piece<Field> pieceOnField, PieceType type) {
        return (pieceOnField != null && pieceOnField.getPieceType() == type && pieceOnField.getTimesMoved() == 0);
    }

    private boolean checkIntermediateFields(List<Field> fields, Board<Field, Piece<Field>> board) {
        for (Field field : fields) {
            if (board.getPieceOnField(field) != null) {
                return false;
            }
        }
        return true;
    }
}
