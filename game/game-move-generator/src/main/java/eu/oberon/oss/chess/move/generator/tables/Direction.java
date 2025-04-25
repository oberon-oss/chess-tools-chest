package eu.oberon.oss.chess.move.generator.tables;

import lombok.Getter;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.enums.MoveDirection;

import java.util.List;

/**
 * @author Fabien H. Dumay
 */
@Getter
public class Direction<F extends Field> {
    private final MoveDirection moveDirection;
    private final List<F>       targetFields;

    @SafeVarargs
    public Direction(MoveDirection moveDirection, F... targetFields) {
        this.moveDirection = moveDirection;
        this.targetFields  = List.of(targetFields);
    }
}
