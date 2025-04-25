package org.oberon.oss.chess.base.interfaces;

import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.base.enums.FieldLocation;

/**
 * Interface describing the contract for classes that provide information on fields on a chess board.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public interface Field {
    /**
     * Returns the color of the field.
     *
     * @return a value from the {@link ChessColor} enumeration specifying the color of the field
     */
    ChessColor getFieldColor();

    /**
     * Returns the file of the field.
     *
     * @return a String in the range "A"..."H" indicating the file the pieces belongs to
     *
     * @since 1.0.0
     */
    @NotNull String getFile();

    /**
     * Returns the rank of the field.
     *
     * @return a number in the range 1...8 indicating the rank the pieces belongs to
     *
     * @since 1.0.0
     */
    int getRank();

    /**
     * Returns a bit mask for the field.
     *
     * @return The bitmask of a field.
     *
     * @since 1.0.0
     */
    long getBitMask();

    /**
     * Returns the field index of a field within a board arrangement.
     *
     * @return A value in the range 0...63 (inclusive).
     *
     * @since 2.0.0
     */
    int fieldIndex();

    /**
     * The location of the field on the chess board.
     *
     * @return A value from the {@link FieldLocation} enumeration
     *
     * @since 2.0.0
     */
    FieldLocation getFieldLocation();

    /**
     * Returns the algebraic field name (A1...H8) of the field.
     *
     * @return the field name
     *
     * @since 1.0.0
     */
    String getName();
}
