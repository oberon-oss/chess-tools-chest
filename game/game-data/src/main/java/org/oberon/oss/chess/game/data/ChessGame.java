package org.oberon.oss.chess.game.data;


import org.oberon.oss.chess.base.interfaces.*;

import java.util.List;

/**
 * Represents a chess game that is being or has been played.
 *
 * @param <F> Represents the class type providing field information
 * @param <P> A class that implements the {@link Piece} interface.
 *
 * @author Fabien H. Dumay
 * @since 2.0.0
 */
public interface ChessGame<F extends Field, P extends Piece<F>> {
    /**
     * Retrieves elementary information on a chess game.
     *
     * @return Elementary information on a chess game (being) played.
     *
     * @since 2.0.0
     */
    BasicGameDetails getGameDetails();

    /**
     * Returns the starting position for a chess game.
     *
     * @return The starting position for this game.
     *
     * @since 2.0.0
     */
    GameStartPosition<F, P> getStartPosition();

    /**
     * Returns the actual/current position of the chess game that is in progress.
     *
     * @return The current position in the game.
     *
     * @since 2.0.0
     */
    Position<F, P> getCurrentPosition();

    /**
     * Returns the current time chess clock + time control setting for the white pieces
     *
     * @return The current chess clock in effect for white.
     *
     * @since 2.0.0
     */
    ChessClock getWhiteChessClock();

    /**
     * Returns the current time chess clock + time control setting for the black pieces
     *
     * @return The current chess clock in effect for black.
     *
     * @since 2.0.0
     */
    ChessClock getBlackChessClock();

    /**
     * Returns the list of moves that has been played in the chess game.
     *
     * @return A non-null List containing all moves played in the chess game.
     *
     * @since 2.0.0
     */
    List<MoveListEntry<F, P>> getMoveList();
}
