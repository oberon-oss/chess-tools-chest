package eu.oberon.oss.chess.game.data;


import eu.oberon.oss.chess.base.interfaces.ChessClock;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Move;
import eu.oberon.oss.chess.base.interfaces.Piece;

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
