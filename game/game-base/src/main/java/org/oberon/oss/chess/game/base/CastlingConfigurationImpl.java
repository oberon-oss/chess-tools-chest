package org.oberon.oss.chess.game.base;

import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.enums.CBRanks;
import org.oberon.oss.chess.base.enums.CastlingType;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.base.enums.PieceType;
import org.oberon.oss.chess.base.exceptions.InvalidCastlingConfigurationException;
import org.oberon.oss.chess.base.interfaces.*;

import java.util.*;

import static org.oberon.oss.chess.base.enums.CastlingType.KING_SIDE;
import static org.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static org.oberon.oss.chess.base.enums.ChessColor.WHITE;

/**
 * @author Fabien H. Dumay
 * @since 2.0.0
 */
public final class CastlingConfigurationImpl<F extends Field> implements CastlingConfiguration<F> {
    private static final String FORMAT1 = "for '%s', the rook must be located to the %s of the king @%s, but was located on %s";
    private static final String FORMAT2 = "for '%s' castling, the rook and king must be located on the %s rank.";

    private final          ChessColor   color;
    private final          CastlingType castlingType;
    private final          F            initialLocationKing;
    private final          F            initialLocationRook;
    private final @NotNull List<F>      intermediateFields;

    public CastlingConfigurationImpl(@NotNull CastlingType castlingType,
                                     @NotNull ChessColor color,
                                     @NotNull F initialLocationKing,
                                     @NotNull F initialLocationRook) {
        this.color = color;

        if (initialLocationRook.getRank() != initialLocationKing.getRank()) {
            throw new IllegalArgumentException("initialLocationRook.getRank() must be equal to initialLocationKing.getRank()");
        }

        if ((initialLocationKing.getRank() != 8) && color == ChessColor.BLACK) {
            throw new IllegalArgumentException(String.format(FORMAT2, ChessColor.BLACK, "8th"));
        }

        if ((initialLocationKing.getRank() != 1) && color == ChessColor.WHITE ) {
            throw new IllegalArgumentException(String.format(FORMAT2, ChessColor.WHITE, "1st"));
        }

        if (castlingType == CastlingType.KING_SIDE) {
            if (initialLocationRook.fieldIndex() < initialLocationKing.fieldIndex()) {
                throw new IllegalArgumentException(
                    String.format(
                        FORMAT1, castlingType.getNotation(), "RIGHT", initialLocationKing.getName(), initialLocationRook.getName()
                    )
                );
            }
        } else {
            if (initialLocationRook.fieldIndex() > initialLocationKing.fieldIndex()) {
                throw new IllegalArgumentException(
                    String.format(
                        FORMAT1, castlingType.getNotation(), "LEFT", initialLocationKing.getName(), initialLocationRook.getName()
                    )
                );
            }
        }

        this.castlingType        = castlingType;
        this.initialLocationKing = initialLocationKing;
        this.initialLocationRook = initialLocationRook;

        List<F> wrk = new ArrayList<>();
        //noinspection unchecked
        FieldIterator<F> iterator = (FieldIterator<F>) FieldIteratorImpl.fieldIterator(
            CBRanks.getRank(initialLocationKing.getRank()),
            initialLocationKing,
            initialLocationRook,
            false
        );

        while (iterator.hasNext()) {
            wrk.add(iterator.next());
        }

        intermediateFields = Collections.unmodifiableList(wrk);
    }

    @Override
    public CastlingType getCastlingType() {
        return castlingType;
    }

    @Override
    public F getInitialLocationKing() {
        return initialLocationKing;
    }

    @Override
    public F getInitialLocationRook() {
        return initialLocationRook;
    }

    @Override
    public @NotNull List<F> getIntermediateFields() {
        return intermediateFields;
    }

    @Override
    public ChessColor getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        //noinspection unchecked
        CastlingConfigurationImpl<F> that = (CastlingConfigurationImpl<F>) obj;
        return Objects.equals(this.castlingType, that.castlingType) &&
               Objects.equals(this.initialLocationKing, that.initialLocationKing) &&
               Objects.equals(this.initialLocationRook, that.initialLocationRook) &&
               Objects.equals(this.intermediateFields, that.intermediateFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(castlingType, initialLocationKing, initialLocationRook, intermediateFields);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CastlingConfigurationImpl{");
        sb.append("initialLocationRook=").append(initialLocationRook.getName());
        sb.append(", initialLocationKing=").append(initialLocationKing.getName());
        sb.append(", castlingType=").append(castlingType);
        sb.append(", color=").append(color);
        sb.append(", intermediateFields=[");
        Iterator<F> iterator = intermediateFields.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().getName());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
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
    public static CastlingConfiguration<Field> getConfiguration(Board<Field, Piece<Field>> board, CastlingType castlingType, ChessColor color) {
        String rankErrorMsg = "for '%s' castling, the %s must be located on the %s rank.";

        Piece<Field> king = board.getPiecesForColorAndType(color, PieceType.KING).values().iterator().next();
        if (color == BLACK && king.getCurrentField().getRank() != 8) {
            throw new InvalidCastlingConfigurationException(String.format(rankErrorMsg, color, king.getPieceType(), "8th"));
        }

        if (color == WHITE && king.getCurrentField().getRank() != 1) {
            throw new InvalidCastlingConfigurationException(String.format(rankErrorMsg, color, king.getPieceType(), "1st"));
        }

        Piece<Field> rook = null;

        // For the KING side, we need to locate the rook that is located to the RIGHT of the king's position
        Iterator<Piece<Field>> iterator = board.getPiecesForColorAndType(color, PieceType.ROOK).values().iterator();
        if (castlingType == KING_SIDE) {
            while (iterator.hasNext()) {
                rook = iterator.next();
                if (rook.getCurrentField().fieldIndex() > king.getCurrentField().fieldIndex()) {
                    break;
                }
            }
        } // For the QUEEN side, we need to locate the rook that is located to the LEFT of the king's position
        else {
            while (iterator.hasNext()) {
                rook = iterator.next();
                if (rook.getCurrentField().fieldIndex() < king.getCurrentField().fieldIndex()) {
                    break;
                }
            }
        }

        if (rook == null) {
            throw new InvalidCastlingConfigurationException(
                    String.format(
                            "No Rook was found to the %s of the %s king on %s. ",
                            castlingType == KING_SIDE ? "right" : "left", king.getPieceColor(), king.getCurrentField().getName()
                    )
            );
        }

        if (rook.getCurrentField().getRank() != king.getCurrentField().getRank()) {
            throw new InvalidCastlingConfigurationException(
                    String.format(
                            "Rook should be on the same rank (%s) as the king on %s"
                            , king.getCurrentField().getRank(), king.getCurrentField().getName()
                    )
            );
        }
        return new CastlingConfigurationImpl<>(castlingType, color, king.getCurrentField(), rook.getCurrentField());
    }
}
