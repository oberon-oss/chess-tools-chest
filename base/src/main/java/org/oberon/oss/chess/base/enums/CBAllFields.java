package org.oberon.oss.chess.base.enums;

import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Lines;

import java.util.List;

/**
 * @author Fabien H. Dumay
 */
@SuppressWarnings("java:S6548")
public enum CBAllFields implements Lines<Field> {
    ALL_FIELDS;

    @Override
    public String getName() {
        return name();
    }

    @Override
    public MoveDirection getMoveDirection() {
        return MoveDirection.NONE;
    }

    private static final List<Field> ALL_FIELDS_LIST;

    static {
        ALL_FIELDS_LIST = List.of(ChessField.values());
    }

    @Override
    public List<Field> getFields() {
        return ALL_FIELDS_LIST;
    }
}
