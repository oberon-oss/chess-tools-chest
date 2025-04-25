package org.oberon.oss.chess.move.generator;

import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.move.generator.tables.Direction;
import org.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import org.oberon.oss.chess.game.base.MoveImpl;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Move;
import org.oberon.oss.chess.base.interfaces.Piece;
import org.oberon.oss.chess.base.interfaces.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.oberon.oss.chess.base.enums.MoveDirection.NONE;

/**
 * @author Fabien H. Dumay
 */
public class NonDirectionalMoveGenerator {
    private NonDirectionalMoveGenerator() {

    }

    public static <F extends Field, P extends Piece<F>> List<Move<F, P>> generate(
        @NotNull TargetFieldMapping<Field> fieldMapping,
        @NotNull Piece<Field> pieceToMove,
        @NotNull Position<F, P> position) {
        List<Move<F, P>> moves        = new ArrayList<>();
        Map<F, P>        pieceMapping = position.board().getPieceMapping();

        Direction<Field> direction = fieldMapping.getDirectionMap().getDirection(NONE);
        assert direction != null;

        for (Field targetField : direction.getTargetFields()) {
            //noinspection unchecked,SuspiciousMethodCalls
            Piece<Field> pieceFound = (Piece<Field>) pieceMapping.get(targetField);

            if (pieceFound == null) {
                //noinspection unchecked
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
                //noinspection unchecked
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
            }
        }
        return moves;
    }
}
