package eu.oberon.oss.chess.base.enums;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import eu.oberon.oss.chess.base.interfaces.Field;

import static eu.oberon.oss.chess.base.enums.ChessField.*;

/**
 * Describes the type of castling.
 *
 * @author Fabien H. Dumay
 * @since 2.0.0
 */
@Getter
public enum CastlingType {
    QUEEN_SIDE("O-O-O"),
    KING_SIDE("O-O");

    private final String notation;

    CastlingType(String notation) {
        this.notation = notation;
    }

    public Field getKingTargetField(@NotNull ChessColor color) {
        return getTargetField(color, PieceType.KING);
    }

    public Field getRookTargetField(@NotNull ChessColor color) {
        return getTargetField(color, PieceType.ROOK);
    }

    private static final Field[] TARGET_FIELDS_WHITE_KING = new Field[]{C1, G1};
    private static final Field[] TARGET_FIELDS_BLACK_KING = new Field[]{C8, G8};
    private static final Field[] TARGET_FIELDS_WHITE_ROOK = new Field[]{D1, F1};
    private static final Field[] TARGET_FIELDS_BLACK_ROOK = new Field[]{D8, F8};

    private Field getTargetField(ChessColor color, PieceType pieceType) {
        if (pieceType == PieceType.KING) {
            return select(color == ChessColor.BLACK ? TARGET_FIELDS_BLACK_KING : TARGET_FIELDS_WHITE_KING);
        } else {
            return select(color == ChessColor.BLACK ? TARGET_FIELDS_BLACK_ROOK : TARGET_FIELDS_WHITE_ROOK);
        }
    }

    private Field select(Field[] targetFields) {
        if (this == QUEEN_SIDE) {
            return targetFields[0];
        } else {
            return targetFields[1];
        }
    }

    /**
     * Returns the castling type based on the specified notation string.
     *
     * @param notation Notation string to retrieve the castling type to retrieve.
     *
     * @return The CastlingXX type.
     *
     * @throws IllegalArgumentException If the specified notation string is not recognized.
     * @since 2.0.0
     */
    public static CastlingType fromNotation(@NotNull String notation) {
        if (notation.contentEquals("O-O")) {
            return KING_SIDE;
        } else if (notation.contentEquals("O-O-O")) {
            return QUEEN_SIDE;
        }
        throw new IllegalArgumentException(notation + " is not a valid castling type");
    }
}
