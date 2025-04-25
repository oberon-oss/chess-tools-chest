package org.oberon.oss.chess.move.generator;

import org.jetbrains.annotations.Nullable;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import org.oberon.oss.chess.base.enums.PieceType;

/**
 * @author Fabien H. Dumay
 */
public interface MoveTable<F extends Field> {
    @Nullable TargetFieldMapping<F> getFieldMapping(F field);

    PieceType getPiece();

    @Nullable ChessColor getColor();
}
