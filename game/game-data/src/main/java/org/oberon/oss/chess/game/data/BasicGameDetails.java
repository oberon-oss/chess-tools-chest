package org.oberon.oss.chess.game.data;

import java.time.ZonedDateTime;

/**
 * Record the minimal information on a chess game (either concluded, or still in progress).
 * <p>
 * The information record is the same that is required for the 'Seven tag roster' as laid out in the PGN format.
 *
 * @author Fabien H. Dumay
 * @since 2.0.0
 */
public interface BasicGameDetails {
    /**
     * Returns information on the player of the white pieces.
     *
     * @return White pieces player information.
     *
     * @since 2.0.0
     */
    Player getPlayerWhitePieces();

    /**
     * Returns information on the player of the black pieces.
     *
     * @return Black pieces player information.
     *
     * @since 2.0.0
     */
    Player getPlayerBlackPieces();

    /**
     * Record the date and time the game started.
     *
     * @return Date and time of the start of the game.
     *
     * @since 2.0.0
     */
    ZonedDateTime gameStartingDate();

    /**
     * Returns the game result of the chess game.
     *
     * @return the result of the game - a value from the GameResult enumeration
     *
     * @since 2.0.0
     */
    GameResult getGameResult();

    /**
     * Returns the site where the game is being/was played.
     *
     * @return The games site location.
     *
     * @since 2.0.0
     */
    Site getSite();

    /**
     * The event where the game is being/was played.
     *
     * @return The games' event.
     *
     * @since 2.0.0
     */
    Event getEvent();

    /**
     * Returns the round where game is being/was played.
     *
     * @return The round for the chess game.
     *
     * @since 2.0.0
     */
    Round getRound();

}
