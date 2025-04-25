package org.oberon.oss.chess.move.generator;

import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.game.data.ChessGame;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Move;
import org.oberon.oss.chess.base.interfaces.Piece;

import java.util.List;

/**
 * Contract for classes that want to generate moves from a given position.
 *
 * @param <F> Represents the class type providing field information
 * @param <P> A class that implements the {@link Piece} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public interface MoveGenerator<F extends Field, P extends Piece<F>> {

    /**
     * Creates a list of moves for the given piece and chessGame.
     *
     * @param piece     The piece to generate the moves for
     * @param chessGame The chessGame to use as source for the list of moves to create
     *
     * @return A list of move(s) for the specified piece and board. The list will contain at least 3 moves.
     *
     * @since 1.0.0
     */
    List<Move<F, P>> createMoveList(@NotNull P piece, @NotNull ChessGame<F, P> chessGame);

    /**
     * Creates a list for all pieces of specific color.
     *
     * @param color     Specifies the color of the side to generate the moves for.
     * @param chessGame The chessGame to use as source for the list of moves to create
     *
     * @return List of moves generated
     *
     * @since 1.2.2
     */
    List<Move<F, P>> createMoveList(@NotNull ChessColor color, @NotNull ChessGame<F, P> chessGame);
}
