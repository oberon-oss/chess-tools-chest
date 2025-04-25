package org.oberon.oss.chess.move.generator.tables;

import org.jetbrains.annotations.Nullable;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.enums.MoveDirection;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Fabien H. Dumay
 */
public class DirectionMap<F extends Field> {
    private final Map<MoveDirection, Direction<F>> directionMapping;

    public DirectionMap(Map<MoveDirection, Direction<F>> directionMapping) {
        this.directionMapping = directionMapping;
    }

    public @Nullable Direction<F> getDirection(final MoveDirection direction) {
        return directionMapping.get(direction);
    }

    /**
     * @author Fabien H. Dumay
     */
    public static class DirectionMapBuilder<F extends Field> {
        private final Map<MoveDirection, Direction<F>> directionMapping = new EnumMap<>(MoveDirection.class);

        public DirectionMapBuilder<F> addDirection(Direction<F> direction) {
            directionMapping.put(direction.getMoveDirection(), direction);
            return this;
        }


        public DirectionMap<F> build() {
            return new DirectionMap<>(directionMapping);
        }
    }
}
