package eu.oberon.oss.chess.base.interfaces;

import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.enums.PieceType;

/**
 * Contains the information related to a chess piece.
 *
 * @param <F> Represents the class type providing field information
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public interface Piece<F extends Field> extends Duplicator<Piece<F>> {
    /**
     * Returns the type of the chess piece.
     *
     * @return A value of the {@link PieceType} enum stating the type of piece
     *
     * @since 1.0.0
     */
    PieceType getPieceType();

    /**
     * Returns the pieces' color.
     *
     * @return The color of the piece (a value from the {@link ChessColor} enum)
     *
     * @since 1.0.0
     */
    ChessColor getPieceColor();

    /**
     * Returns the field on the chess board the piece currently resides on.
     *
     * @return The chess field the piece is occupying.
     *
     * @since 1.0.0
     */
    F getCurrentField();

    /**
     * Returns the number of times the piece has moved.
     *
     * @return Count of the number times the piece has been moved
     *
     * @since 1.0.0
     */
    int getTimesMoved();
}
