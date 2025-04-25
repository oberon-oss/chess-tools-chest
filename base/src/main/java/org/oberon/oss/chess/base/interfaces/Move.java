package org.oberon.oss.chess.base.interfaces;

import org.jetbrains.annotations.Nullable;
import org.oberon.oss.chess.base.enums.CBRanks;
import org.oberon.oss.chess.base.enums.PieceType;

/**
 * Represents a move that can be played from a specific {@link Position}.
 *
 * @param <F> Represents the class type providing field information
 * @param <P> A class that implements the {@link Piece} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public interface Move<F extends Field, P extends Piece<F>> {
    /**
     * Returns the piece being moved.
     *
     * @return The piece being moved
     *
     * @since 1.0.0
     */
    P getPieceToMove();

    /**
     * Returns the field from where the piece is being moved.
     *
     * @return the pieces' 'from' field.
     *
     * @since 1.0.0
     */
    @Nullable F getFromField();

    /**
     * Returns the field the piece is being moved to.
     *
     * @return the pieces' 'to' field.
     *
     * @since 1.0.0
     */
    @Nullable F getToField();

    /**
     * Returns, for a pawn move, the type of piece the pawn is promoted to.
     * <p>
     * The {@link #getMoveFlags()} method can be used to determine if this is a promotion move or not. If true, the returned value
     * will contain the {@link #BIT_FLAG_PROMOTION} bit set to '1'.
     *
     * @return The piece type the pawn is promoted to, or, if <b>not</b> a pawn move, or the pawn move is not the
     *     {@link CBRanks#EIGHTH_RANK EIGHTH_RANK}  (for white pawns) or {@link CBRanks#FIRST_RANK FIRST_RANK} (for black pawns),
     *     this method will return a {@literal <null>}  value.
     *
     * @since 1.0.0
     */
    @Nullable PieceType getPromotedToPiece();

    /**
     * Returns the captured piece for this move, if the target field ({@link #getToField()} contains an enemy piece.
     * <p>
     * The {@link #getMoveFlags()} method will return a value where the bit for the {@link #BIT_FLAG_CAPTURE} is set to '1'.
     *
     * @return The capture piece, or {@literal <null>} if the target field was empty.
     *
     * @since 1.0.0
     */
    @Nullable P getCapturedPiece();

    /**
     * Returns the flags with specific attributes set that reflect additional information about the move.
     * <p>
     * The value returned will be composed of one or more of the BIT_FLAG... values specified in this interface.
     *
     * @return The bitflags active for this move.
     *
     * @since 1.0.0
     */
    int getMoveFlags();

    /**
     * Default if no flags have been set.
     *
     * @since 1.0.0
     */
    int BIT_FLAG_REGULAR_MOVE = 0x0000_0001;

    /**
     * Indicates this move captures a piece. If this bit has been set, the {@link #getCapturedPiece()} method will return a non-null
     * value
     *
     * @since 1.0.0
     */
    int BIT_FLAG_CAPTURE = 0x0000_0002;

    /**
     * Indicates castling to the {@link PieceType#KING Kingside} (<b>O-O</b>) is performed.
     *
     * @since 1.0.0
     */
    int BIT_FLAG_CASTLE_KING_SIDE = 0x0000_0004;

    /**
     * Indicates castling to the {@link PieceType#QUEEN Queenside} (<b>O-O-O</b>) is performed.
     *
     * @since 1.0.0
     */
    int BIT_FLAG_CASTLE_QUEEN_SIDE = 0x0000_0008;

    /**
     * Flag will be set if the piece being moved is a pawn, and it moves, from its original field, 2 fields ahead.
     *
     * @since 1.0.0
     */
    int BIT_FLAG_PAWN_ADVANCED_2_FIELDS = 0x0001_0000;

    /**
     * Indicates this move captures a pawn en-passant. If this bit has been set, the {@link #getCapturedPiece()} method will return
     * a non-null value for the captured pawn.
     *
     * @since 1.0.0
     */
    int BIT_FLAG_EN_PASSANT = 0x0002_0000;

    /**
     * Indicates that a pawn promotion will take place. If this bit has been set, the {@link #getPromotedToPiece()} method will
     * return a non-null value
     *
     * @since 1.0.0
     */
    int BIT_FLAG_PROMOTION = 0x0004_0000;


    static boolean isRegularMove(final int moveFlags) {
        return moveFlags == BIT_FLAG_REGULAR_MOVE;
    }

    static boolean isPawnAdvanced2Fields(final int moveFlags) {
        return (BIT_FLAG_PAWN_ADVANCED_2_FIELDS & moveFlags) != 0;
    }

    static boolean isCastleKingSide(final int moveFlags) {
        return (BIT_FLAG_CASTLE_KING_SIDE & moveFlags) != 0;
    }

    static boolean isCastleQueenSide(final int moveFlags) {
        return (BIT_FLAG_CASTLE_QUEEN_SIDE & moveFlags) != 0;
    }

    static boolean isCapture(final int moveFlags) {
        return (BIT_FLAG_CAPTURE & moveFlags) != 0;
    }

    static boolean isEnPassant(final int moveFlags) {
        return (BIT_FLAG_EN_PASSANT & moveFlags) != 0;
    }

    static boolean isPromotion(final int moveFlags) {
        return (BIT_FLAG_PROMOTION & moveFlags) != 0;
    }

}
