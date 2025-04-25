package org.oberon.oss.chess.base.interfaces;

import org.oberon.oss.chess.base.enums.CastlingType;
import org.oberon.oss.chess.base.enums.ChessColor;


import java.util.Collection;
import java.util.List;

/**
 * Contract for classes that want to provide castling configuration services.
 *
 * @param <F> Designates the class that extends/implements the {@link Field} interface
 *
 * @author Fabien H. Dumay
 * @since 2.0.0
 */
public interface CastlingConfiguration<F extends Field> {

    /**
     * Defines the color of the side that the configuration applies to.
     *
     * @return A value from the ChessColor interface
     *
     * @since 2.0.0
     */
    ChessColor getColor();

    /**
     * Specifies the castling type.
     *
     * @return A value from the CastlingType interface
     *
     * @since 2.0.0
     */
    CastlingType getCastlingType();

    /**
     * The initial/starting of the KING for this configuration.
     *
     * @return The field where the king is expected to reside.
     *
     * @since 2.0.0
     */
    F getInitialLocationKing();

    /**
     * The initial/starting of the ROOk for this configuration.
     * <p>
     * The rook should be located to the right of the king for KING_SIDE castling (O-O), and to the LEFT for QUEEN side castling
     * (O-O-O)
     *
     * @return The field where the king is expected to reside.
     *
     * @since 2.0.0
     */
    F getInitialLocationRook();

    /**
     * A list of fields that are located between the KING and ROOk pieces.
     *
     * @return A list of zero or more fields that enumerates the fields located between the ROOK and KING
     *
     * @since 2.0.0
     */
    List<F> getIntermediateFields();

    /**
     * Checks the provided collection of configurations for a configurations that matches the specified color and castling type.
     *
     * @param configurations The collection to examine
     * @param color          The color of the castling configuration to find.
     * @param castlingType   The type of castling to check for.
     * @param <F>            Designates the class that extends/implements the {@link Field} interface
     *
     * @return <b>True</b> if  configuration for the specified color and type was found, or <b>false</b> otherwise.
     *
     * @since 2.0.0
     */
    static <F extends Field> boolean isCastlingConfigurationPresent(Collection<CastlingConfiguration<F>> configurations, ChessColor color, CastlingType castlingType) {
        for (CastlingConfiguration<F> configurationItem : configurations) {
            if (configurationItem.getCastlingType().equals(castlingType) && configurationItem.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Utility method that allows construction of a castling configuration using a board, color and castling type as input
     * parameters.
     *
     * @param board        The board to use as the basis of the request
     * @param castlingType Type of castling involved
     * @param color        The color of the side to create the castling option for.
     *
     * @return The CastlingConfiguration object that was created.
     *
     * @throws IllegalArgumentException if the board does not support the creation of the requested configuration.
     * @since 2.0.0
     */
    @SuppressWarnings("java:S3776") // Excepting this issue, as it is part of the interface definition.
    static CastlingConfiguration<Field> _getConfiguration(Board<Field, Piece<Field>> board, CastlingType castlingType, ChessColor color) {
//        String rankErrorMsg = "for '%s' castling, the %s must be located on the %s rank.";
//
//        Piece<Field> king = board.getPiecesForColorAndType(color, PieceType.KING).values().iterator().next();
//        if (color == BLACK && king.getCurrentField().getRank() != 8) {
//            throw new InvalidCastlingConfigurationException(String.format(rankErrorMsg, color, king.getPieceType(), "8th"));
//        }
//
//        if (color == WHITE && king.getCurrentField().getRank() != 1) {
//            throw new InvalidCastlingConfigurationException(String.format(rankErrorMsg, color, king.getPieceType(), "1st"));
//        }
//
//        Piece<Field> rook = null;
//
//        // For the KING side, we need to locate the rook that is located to the RIGHT of the king's position
//        Iterator<Piece<Field>> iterator = board.getPiecesForColorAndType(color, PieceType.ROOK).values().iterator();
//        if (castlingType == KING_SIDE) {
//            while (iterator.hasNext()) {
//                rook = iterator.next();
//                if (rook.getCurrentField().fieldIndex() > king.getCurrentField().fieldIndex()) {
//                    break;
//                }
//            }
//        } // For the QUEEN side, we need to locate the rook that is located to the LEFT of the king's position
//        else {
//            while (iterator.hasNext()) {
//                rook = iterator.next();
//                if (rook.getCurrentField().fieldIndex() < king.getCurrentField().fieldIndex()) {
//                    break;
//                }
//            }
//        }
//
//        if (rook == null) {
//            throw new InvalidCastlingConfigurationException(
//                String.format(
//                    "No Rook was found to the %s of the %s king on %s. ",
//                    castlingType == KING_SIDE ? "right" : "left", king.getPieceColor(), king.getCurrentField().getName()
//                )
//            );
//        }
//
//        if (rook.getCurrentField().getRank() != king.getCurrentField().getRank()) {
//            throw new InvalidCastlingConfigurationException(
//                String.format(
//                    "Rook should be on the same rank (%s) as the king on %s"
//                    , king.getCurrentField().getRank(), king.getCurrentField().getName()
//                )
//            );
//        }
//        return new CastlingConfigurationImpl<>(castlingType, color, king.getCurrentField(), rook.getCurrentField());
        return null;
    }
}
