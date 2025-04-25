package eu.oberon.oss.chess.move.generator;

import org.jetbrains.annotations.NotNull;
import eu.oberon.oss.chess.base.enums.CBRanks;
import eu.oberon.oss.chess.base.enums.ChessField;
import eu.oberon.oss.chess.base.enums.MoveDirection;
import eu.oberon.oss.chess.base.enums.PieceType;
import eu.oberon.oss.chess.move.generator.tables.Direction;
import eu.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import eu.oberon.oss.chess.game.base.MoveImpl;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Move;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;
import static eu.oberon.oss.chess.base.enums.MoveDirection.*;
import static eu.oberon.oss.chess.base.enums.PieceType.*;
import static eu.oberon.oss.chess.base.interfaces.Move.*;

/**
 * @author Fabien H. Dumay
 */
public class PawnMoveGenerator {
    private PawnMoveGenerator() {

    }

    @SuppressWarnings("unchecked")
    public static <F extends Field, P extends Piece<F>> List<Move<Field, Piece<Field>>> generate(
        @NotNull TargetFieldMapping<Field> fieldMapping,
        @NotNull Piece<Field> pieceToMove,
        @NotNull Position<F, P> position) {
        Map<Field, Piece<Field>>        pieceMapping;
        List<Move<Field, Piece<Field>>> moves;

        moves        = new ArrayList<>();
        pieceMapping = (Map<Field, Piece<Field>>) position.board().getPieceMapping();

        MoveDirection[] directions;
        if (pieceToMove.getPieceColor() == BLACK) {
            directions = new MoveDirection[]{SOUTH, SOUTH_EAST, SOUTH_WEST};
        } else {
            directions = new MoveDirection[]{NORTH, NORTH_EAST, NORTH_WEST};
        }

        for (MoveDirection direction : directions) {
            Direction<Field> currentDirection = fieldMapping.getDirectionMap().getDirection(direction);
            if (currentDirection == null) {
                continue;
            }

            // Non-capturing pawn moves.
            if (direction == SOUTH || direction == NORTH) {
                List<Field> targetFields = currentDirection.getTargetFields();

                if (addRegularMove(pieceMapping, moves, pieceToMove, targetFields.get(0), BIT_FLAG_REGULAR_MOVE)
                    && targetFields.size() > 1) {
                    addRegularMove(
                        pieceMapping,
                        moves,
                        pieceToMove,
                        targetFields.get(1),
                        BIT_FLAG_REGULAR_MOVE | BIT_FLAG_PAWN_ADVANCED_2_FIELDS
                    );
                }

            } else if (position.enPassantField() != null) {
                addEnPassantMove(
                    moves,
                    currentDirection.getTargetFields().get(0),
                    position.enPassantField(),
                    pieceMapping,
                    pieceToMove
                );
            } else {
                addCaptureMove(
                    pieceMapping,
                    moves,
                    pieceToMove,
                    currentDirection.getTargetFields().get(0)
                );
            }
        }
        return moves;
    }

    @SuppressWarnings("unchecked")
    private static <F extends Field, P extends Piece<F>> void addEnPassantMove(
        List<Move<F, P>> moves,
        F targetField,
        F epField,
        Map<F, P> pieceMapping,
        Piece<Field> pieceToMove
    ) {
        if (targetField == epField) {
            if (pieceToMove.getPieceColor() == WHITE) {
                epField = (F) ChessField.getFieldByCoordinates(epField.getFile(), epField.getRank() - 1);
            } else {
                epField = (F) ChessField.getFieldByCoordinates(epField.getFile(), epField.getRank() + 1);
            }
            Piece<Field> pawnToRemove = (Piece<Field>) pieceMapping.get(epField);
            add(moves, pieceToMove, targetField, BIT_FLAG_CAPTURE | BIT_FLAG_EN_PASSANT, pawnToRemove, null);
        }
    }

    private static <F extends Field, P extends Piece<F>> void addCaptureMove(
        Map<F, P> pieceMapping,
        List<Move<F, P>> moves,
        Piece<Field> pieceToMove,
        F targetField
    ) {
        //noinspection unchecked
        Piece<Field> capturedPiece = (Piece<Field>) pieceMapping.get(targetField);
        if (capturedPiece != null && capturedPiece.getPieceColor() != pieceToMove.getPieceColor()) {
            if (isPromotionRank(pieceToMove, targetField)) {
                for (PieceType pieceType : new PieceType[]{QUEEN, ROOK, BISHOP, KNIGHT}) {
                    add(moves, pieceToMove, targetField, BIT_FLAG_CAPTURE | BIT_FLAG_PROMOTION, capturedPiece, pieceType);
                }
            } else {
                add(moves, pieceToMove, targetField, BIT_FLAG_CAPTURE, capturedPiece, null);
            }
        }
    }

    private static <F extends Field, P extends Piece<F>> boolean addRegularMove(
        Map<F, P> pieceMapping,
        List<Move<F, P>> moves,
        Piece<Field> pieceToMove,
        F targetField,
        int flags) {
        if (pieceMapping.get(targetField) == null) {
            if (isPromotionRank(pieceToMove, targetField)) {
                for (PieceType pieceType : new PieceType[]{QUEEN, ROOK, BISHOP, KNIGHT}) {
                    add(moves, pieceToMove, targetField, flags | BIT_FLAG_PROMOTION, null, pieceType);
                }
            } else {
                add(moves, pieceToMove, targetField, flags, null, null);
            }
            return true;
        }
        return false;
    }

    private static <F extends Field, P extends Piece<F>> boolean isPromotionRank(P pieceToMove, F targetField) {
        return (
            pieceToMove.getPieceColor() == WHITE && CBRanks.getRank(targetField.getRank()) == CBRanks.EIGHTH_RANK ||
            pieceToMove.getPieceColor() == BLACK && CBRanks.getRank(targetField.getRank()) == CBRanks.FIRST_RANK
        );
    }

    private static <F extends Field, P extends Piece<F>> void add(
        List<Move<F, P>> moves,
        Piece<Field> pieceToMove,
        F targetField,
        int flags,
        Piece<Field> capturedPiece,
        PieceType promotedToPiece
    ) {
        //noinspection unchecked
        moves.add(
            (Move<F, P>) MoveImpl
                .builder()
                .moveFlags(flags)
                .pieceToMove(pieceToMove)
                .fromField(pieceToMove.getCurrentField())
                .toField(targetField)
                .capturedPiece(capturedPiece)
                .promotedToPiece(promotedToPiece)
                .build()
        );
    }
}
