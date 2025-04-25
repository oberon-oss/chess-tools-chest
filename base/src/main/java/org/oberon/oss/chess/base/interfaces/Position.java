package org.oberon.oss.chess.base.interfaces;

import org.jetbrains.annotations.Nullable;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.base.enums.ChessField;

/**
 * Allows the querying of the information extracted from a FEN setup string.
 *
 * @param <F> Represents the class type providing field information
 * @param <P> A class that implements the {@link Piece} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public interface Position<F extends Field, P extends Piece<F>> extends Duplicator<Position<F,P>> {
    /**
     * Returns a map of the fields occupied by pieces defined in the FEN position.
     *
     * @return a read-only map of the chess position.
     *
     * @since 1.0.0
     */
    Board<F, P> board();

    /**
     * Returns the color that is to make the next move.
     *
     * @return a value from the {@link ChessColor} enumeration specifying the color to move next.
     *
     * @since 1.0.0
     */
    ChessColor sideToMove();

    /**
     * Returns the {@link F} that would allow an en-passant capture.
     *
     * @return The en-passant field, which is a chess field in the range
     *           <ul>
     *              <li> {@link ChessField#A3 A3}-{@link ChessField#H3 H3} (if {@link #sideToMove()} returns {@link ChessColor#BLACK BLACK})</li>
     *              <li> {@link ChessField#A6 A6}-{@link ChessField#H6 H6} (if {@link #sideToMove()} returns {@link ChessColor#WHITE WHITE})</li>
     *           </ul>
     *     or {@literal <null>} if there is no en-passant move to be made.
     *
     * @since 1.0.0
     */
    @Nullable F enPassantField();

    /**
     * Returns a flag indicating if {@link ChessColor#WHITE WHITE}) is allowed to castle King side (O-O).
     *
     * @return <b>true</b> if allowed, or <b>false</b> if not allowed.
     *
     * @since 1.0.0
     */
    Boolean whiteCanCastleKingSide();

    /**
     * Returns a flag indicating if {@link ChessColor#WHITE WHITE}) is allowed to castle Queen side (O-O-O).
     *
     * @return <b>true</b> if allowed, or <b>false</b> if not allowed.
     *
     * @since 1.0.0
     */
    Boolean whiteCanCastleQueenSide();

    /**
     * Returns a flag indicating if {@link ChessColor#BLACK BLACK}) is allowed to castle King side (O-O).
     *
     * @return <b>true</b> if allowed, or <b>false</b> if not allowed.
     *
     * @since 1.0.0
     */
    Boolean blackCanCastleKingSide();

    /**
     * Returns a flag indicating if {@link ChessColor#BLACK BLACK}) is allowed to castle Queen side (O-O-O).
     *
     * @return <b>true</b> if allowed, or <b>false</b> if not allowed.
     *
     * @since 1.0.0
     */
    Boolean blackCanCastleQueenSide();


    /**
     * Returns the number of half-moves played that lead op to the position captured in the FEN setup string.
     *
     * @return the number of half moves (or plies) that have been played so far
     *
     * @since 1.0.0
     */
    int halveMoveClock();

    /**
     * Returns the number of full moves (1 half move for {@link ChessColor#WHITE WHITE} and 1 half move for
     * {@link ChessColor#BLACK BLACK}).
     *
     * @return The number of full moves played so far
     *
     * @since 1.0.0
     */
    int fullMoveNumber();

    int BIT_FLAG_NORMAL_POSITION            = 0x0000_0000;
    int BIT_FLAG_CURRENT_SIDE_IN_CHECK      = 0x0000_0010;
    int BIT_FLAG_DRAW_3RD_REPETITION        = 0x0800_0000;
    int BIT_FLAG_DRAW_50_MOVE_RULE          = 0x0400_0000;
    int BIT_FLAG_DRAW_INSUFFICIENT_MATERIAL = 0x0200_0000;
    int BIT_FLAG_DRAW_STALE_MATE            = 0x0100_0000;
    int BIT_FLAG_CHECK_MATE                 = 0x8000_0000;

}
