package eu.oberon.oss.chess.game.tables;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.Position;

public class ExtendedPositionImpl<F extends Field, P extends Piece<F>> implements ExtendedPosition<F, P> {

    @NotNull
    private final Position<F, P> position;

    @Nullable
    PositionTable<F, P> tablePositions = null;

    public ExtendedPositionImpl(@NotNull Position<F, P> position) {
        this.position = position;
    }

    public void createPositionTables() {

    }

    @Override
    public Position<F, P> position() {
        return position;
    }

    @Override
    public PositionTable<F, P> tablePositions() {
        return null;
    }
}
