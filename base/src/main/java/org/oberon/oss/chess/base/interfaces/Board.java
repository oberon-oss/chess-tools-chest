package org.oberon.oss.chess.base.interfaces;


import org.jetbrains.annotations.Nullable;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.base.enums.PieceType;

import java.util.Map;

/**
 * Defines the board in a chess game.
 *
 * @param <F> Represents the class type providing field information
 * @param <P> A class that implements the {@link Piece} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public interface Board<F extends Field, P extends Piece<F>> extends Duplicator<Board<F,P>> {
    /**
     * Returns the pieces currently present on the board.
     *
     * @return An unmodifiable map of the fields and the occupying pieces on that field (if applicable) on the board. The returned
     *     map will contain at least 2 and at most 32 entries.
     *
     * @since 1.0.0
     */

    Map<F, P> getPieceMapping();

    /**
     * Retrieves the pieceType(s) specified by their color and type.
     *
     * @param color     The color of the pieceType to get
     * @param pieceType The pieceType type to get.
     *
     * @return A mapping of the found pieces, using the field they were found on as key.
     *
     * @since 1.0.0
     */

    Map<F, P> getPiecesForColorAndType(ChessColor color, PieceType pieceType);

    /**
     * Retrieves all pieces for the specified color.
     *
     * @param color The color of the pieceType to get
     *
     * @return A mapping of the found pieces, using the field they were found on as key.
     *
     * @since 1.0.0
     */
    Map<F, P> getPiecesForColor(ChessColor color);

    /**
     * Retrieves the piece (if any) located on the specified field.
     *
     * @param field The field for which to retrieve the piece.
     *
     * @return The piece found, or {@literal <null>} if the field is empty.
     *
     * @since 1.0.0
     */
    @Nullable P getPieceOnField(F field);

    /**
     * Validates if the specified 'field' contains a piece of the specified type and color.
     *
     * @param field     The field to check
     * @param pieceType The expected type of piece on the field
     * @param color     The expected color of the piece.
     *
     * @return <b>True</b> if the specified field contains a piece of the specified type and color, or <b>false</b> otherwise.
     *
     * @since 1.0.0
     */
    boolean fieldContainsPiece(F field, PieceType pieceType, ChessColor color);
}
