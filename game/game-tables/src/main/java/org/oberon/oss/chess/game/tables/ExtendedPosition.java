package org.oberon.oss.chess.game.tables;

import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Piece;
import org.oberon.oss.chess.base.interfaces.Position;

public interface ExtendedPosition<F extends Field, P extends Piece<F>> {
    Position<F, P> position();

    PositionTable<F, P> tablePositions();
}
