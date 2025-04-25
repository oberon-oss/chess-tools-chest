package eu.oberon.oss.chess.game.tables;

import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.Position;

public interface ExtendedPosition<F extends Field, P extends Piece<F>> {
    Position<F, P> position();

    PositionTable<F, P> tablePositions();
}
