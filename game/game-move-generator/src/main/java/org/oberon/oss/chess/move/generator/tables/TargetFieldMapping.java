package org.oberon.oss.chess.move.generator.tables;

import lombok.Getter;
import org.oberon.oss.chess.base.interfaces.Field;

/**
 * @author Fabien H. Dumay
 */
@Getter
public class TargetFieldMapping<F extends Field> {
    private final F               fromField;
    private final DirectionMap<F> directionMap;

    public TargetFieldMapping(F fromField, DirectionMap<F> directionMap) {
        this.fromField    = fromField;
        this.directionMap = directionMap;
    }

    /**
     * @author Fabien H. Dumay
     */
    public static class TargetFieldMapBuilder<F extends Field> {
        private F               fromField;
        private DirectionMap<F> directionMap;

        public TargetFieldMapBuilder<F> setFromField(F fromField) {
            this.fromField = fromField;
            return this;
        }

        public TargetFieldMapBuilder<F> setDirectionMap(DirectionMap<F> directionMap) {
            this.directionMap = directionMap;
            return this;
        }

        public TargetFieldMapping<F> build() {
            return new TargetFieldMapping<>(fromField, directionMap);
        }
    }
}
