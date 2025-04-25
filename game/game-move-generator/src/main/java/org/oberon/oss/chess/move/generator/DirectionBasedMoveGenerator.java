package org.oberon.oss.chess.move.generator;

import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Move;
import org.oberon.oss.chess.game.base.MoveImpl;
import org.oberon.oss.chess.move.generator.tables.Direction;
import org.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import org.oberon.oss.chess.base.enums.MoveDirection;
import org.oberon.oss.chess.base.interfaces.Piece;
import org.oberon.oss.chess.base.interfaces.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Fabien H. Dumay
 */
public class DirectionBasedMoveGenerator {
    private DirectionBasedMoveGenerator() {

    }

    @SuppressWarnings("unchecked")
    static <F extends Field, P extends Piece<F>> List<Move<F, P>> generate(
        @NotNull TargetFieldMapping<Field> fieldMapping,
        @NotNull Piece<Field> pieceToMove,
        @NotNull Position<F, P> position,
        @NotNull MoveDirection... directions) {
        List<Move<F, P>> moves        = new ArrayList<>();
        Map<F, P>        pieceMapping = position.board().getPieceMapping();

        for (MoveDirection direction : directions) {
            Direction<Field> currentDirection = fieldMapping.getDirectionMap().getDirection(direction);
            if (currentDirection == null) {
                continue;
            }
            for (Field targetField : currentDirection.getTargetFields()) {
                //noinspection SuspiciousMethodCalls
                Piece<Field> pieceFound = (Piece<Field>) pieceMapping.get(targetField);
                if (pieceFound == null) {
                    moves.add(
                        (Move<F, P>) MoveImpl
                            .builder()
                            .moveFlags(Move.BIT_FLAG_REGULAR_MOVE)
                            .pieceToMove(pieceToMove)
                            .fromField(pieceToMove.getCurrentField())
                            .toField(targetField)
                            .build()
                    );
                } else if (pieceFound.getPieceColor() != pieceToMove.getPieceColor()) {
                    moves.add(
                        (Move<F, P>) MoveImpl
                            .builder()
                            .moveFlags(Move.BIT_FLAG_CAPTURE)
                            .pieceToMove(pieceToMove)
                            .fromField(pieceToMove.getCurrentField())
                            .toField(targetField)
                            .capturedPiece(pieceFound)
                            .build()
                    );
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
