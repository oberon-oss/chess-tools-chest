package org.oberon.oss.chess.game.data;


import org.oberon.oss.chess.base.interfaces.ChessClock;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Move;
import org.oberon.oss.chess.base.interfaces.Piece;

/**
 * @author Fabien H. Dumay
 */
public interface MoveListEntry<F extends Field, P extends Piece<F>> {
    int getMoveNumber();

    int getPlyNumber();

    ChessClock getWhiteClock();

    ChessClock getBlackClock();

    Move<F, P> getMove();
}
