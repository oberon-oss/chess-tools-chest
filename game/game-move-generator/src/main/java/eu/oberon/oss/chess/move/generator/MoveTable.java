package eu.oberon.oss.chess.move.generator;

import org.jetbrains.annotations.Nullable;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import eu.oberon.oss.chess.base.enums.PieceType;

/**
 * @author Fabien H. Dumay
 */
public interface MoveTable<F extends Field> {
    @Nullable TargetFieldMapping<F> getFieldMapping(F field);

    PieceType getPiece();

    @Nullable ChessColor getColor();
}
