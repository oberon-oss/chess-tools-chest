package org.oberon.oss.chess.move.generator.tables;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.move.generator.MoveTable;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.enums.PieceType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fabien H. Dumay
 */
public class MoveTableImpl<F extends Field> implements MoveTable<F> {
    @Getter
    private final PieceType piece;
    @Getter
    private final ChessColor color;

    private final Map<F, TargetFieldMapping<F>> moveTableMapping;

    public MoveTableImpl(PieceType piece, ChessColor color, Map<F, TargetFieldMapping<F>> moveTableMapping) {
        this.piece            = piece;
        this.color            = color;
        this.moveTableMapping = moveTableMapping;
    }

    @Override
    public @Nullable TargetFieldMapping<F> getFieldMapping(F field) {
        return moveTableMapping.get(field);
    }

    /**
     * @author Fabien H. Dumay
     */
    public static class MoveTableBuilder<F extends Field> {

        private       PieceType                        piece;
        private       ChessColor                        color;
        private final HashMap<F, TargetFieldMapping<F>> moveTableMapping = new HashMap<>();

        public MoveTableBuilder<F> setPiece(PieceType piece) {
            this.piece = piece;
            return this;
        }

        public MoveTableBuilder<F> setColor(ChessColor color) {
            this.color = color;
            return this;
        }

        public MoveTableBuilder<F> addTargetFieldMapping(TargetFieldMapping<F> targetFieldMapping) {
            moveTableMapping.put(targetFieldMapping.getFromField(), targetFieldMapping);
            return this;
        }

        public MoveTable<F> build() {
            return new MoveTableImpl<>(piece, color, moveTableMapping);
        }
    }
}
