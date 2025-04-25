package eu.oberon.oss.chess.base.enums;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import eu.oberon.oss.chess.base.interfaces.Field;

import java.math.BigInteger;

import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;
import static eu.oberon.oss.chess.base.enums.FieldLocation.*;


/**
 * Enumerates the fields present on a chess board.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@SuppressWarnings("JavadocDeclaration")
@Getter
@Log4j2
public enum ChessField implements Field {

    //@formatter:off
     A8(WHITE, CORNER),  B8(BLACK, EDGE),  C8(WHITE, EDGE), D8(BLACK, EDGE),    E8(WHITE, EDGE),    F8(BLACK, EDGE), G8(WHITE, EDGE),   H8(BLACK, CORNER),
     A7(BLACK, EDGE),    B7(WHITE),        C7(BLACK),       D7(WHITE),          E7(BLACK),          F7(WHITE),       G7(BLACK),         H7(WHITE, EDGE),
     A6(WHITE, EDGE),    B6(BLACK),        C6(WHITE),       D6(BLACK),          E6(WHITE),          F6(BLACK),       G6(WHITE),         H6(BLACK, EDGE),
     A5(BLACK, EDGE),    B5(WHITE),        C5(BLACK),       D5(WHITE, CENTER),  E5(BLACK, CENTER),  F5(WHITE),       G5(BLACK),         H5(WHITE, EDGE),
     A4(WHITE, EDGE),    B4(BLACK),        C4(WHITE),       D4(BLACK, CENTER),  E4(WHITE, CENTER),  F4(BLACK),       G4(WHITE),         H4(BLACK, EDGE),
     A3(BLACK, EDGE),    B3(WHITE),        C3(BLACK),       D3(WHITE),          E3(BLACK),          F3(WHITE),       G3(BLACK),         H3(WHITE, EDGE),
     A2(WHITE, EDGE),    B2(BLACK),        C2(WHITE),       D2(BLACK),          E2(WHITE),          F2(BLACK),       G2(WHITE),         H2(BLACK, EDGE),
     A1(BLACK, CORNER),  B1(WHITE, EDGE),  C1(BLACK, EDGE), D1(WHITE, EDGE),    E1(BLACK, EDGE),    F1(WHITE, EDGE), G1(BLACK, EDGE),   H1(WHITE, CORNER);
    //@formatter:on

    /**
     * Returns the chess field color
     *
     * @return the color of the chess field.
     * @since 1.0.0
     */
    private final ChessColor    fieldColor;
    private final FieldLocation fieldLocation;
    private final String        file;
    private final int           rank;

    /**
     * {@inheritDoc} Field A8 occupies the most significant bit (63), H1 the least significant bit (0).
     */
    private final long bitMask;

    ChessField(ChessColor fieldColor) {
        this(fieldColor, FieldLocation.REGULAR_FIELD);
    }

    ChessField(ChessColor fieldColor, FieldLocation fieldLocation) {
        this.fieldColor    = fieldColor;
        this.fieldLocation = fieldLocation;

        file    = name().charAt(0) + "";
        rank    = Integer.parseInt(name().charAt(1) + "");
        bitMask = BigInteger.valueOf(0L).setBit(63 - ordinal()).longValue();
    }


    /**
     * Returns a field from the specified for the given coordinate parameters 'file' and 'rank'.
     *
     * @param file The file of the field, in the range A...H (inclusive)
     * @param rank The rank of the field, in the range 1...8 (inclusive)
     *
     * @return The field as specified by the file and rank
     *
     * @throws IllegalArgumentException in one of the following cases:
     *                                  <ul>
     *                                  <li>if the specified file is outside the range A...H</li>
     *                                  <li>if the specified rank number is outside the range 1...8</li>
     *                                  </ul>
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    public static Field getFieldByCoordinates(String file, int rank) {
        if (rank < 1 || rank > 8) {
            throw new IllegalArgumentException("Rank out of bounds (1..8): " + rank);
        }
        if (file.length() != 1) {
            throw new IllegalArgumentException("Invalid file specified: " + file);
        }
        if (!"ABCDEFGH".contains(file)) {
            throw new IllegalArgumentException("File out of range A..H: " + file);
        }
        return ChessField.valueOf(file.toUpperCase() + rank);
    }


    @Override
    public String toString() {
        return "ChessField{"
               + "fieldColor=" + fieldColor
               + ", file='" + file + '\''
               + ", rank=" + rank
               + ", bitMask=" + String.format("%016X", bitMask)
               + ", fieldLocation=" + fieldLocation
               + '}';
    }

    @Override
    public int fieldIndex() {
        return ordinal();
    }

    @Override
    public String getName() {
        return name();
    }


}
