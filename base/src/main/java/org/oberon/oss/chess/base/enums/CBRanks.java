package org.oberon.oss.chess.base.enums;

import lombok.Getter;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Lines;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.oberon.oss.chess.base.enums.ChessField.*;
import static org.oberon.oss.chess.base.enums.MoveDirection.EAST;

/**
 * @author Fabien H. Dumay
 */
@Getter
public enum CBRanks implements Lines<Field> {
    //@formatter:off
     EIGHTH_RANK(EAST, A8, B8, C8, D8, E8, F8, G8, H8),
    SEVENTH_RANK(EAST, A7, B7, C7, D7, E7, F7, G7, H7),
      SIXTH_RANK(EAST, A6, B6, C6, D6, E6, F6, G6, H6),
      FIFTH_RANK(EAST, A5, B5, C5, D5, E5, F5, G5, H5),
     FOURTH_RANK(EAST, A4, B4, C4, D4, E4, F4, G4, H4),
      THIRD_RANK(EAST, A3, B3, C3, D3, E3, F3, G3, H3),
     SECOND_RANK(EAST, A2, B2, C2, D2, E2, F2, G2, H2),
      FIRST_RANK(EAST, A1, B1, C1, D1, E1, F1, G1, H1)
    //@formatter:on
    ;
    private final MoveDirection moveDirection;
    private final List<Field>   fields;

    CBRanks(MoveDirection moveDirection, Field... fields) {
        this.moveDirection = moveDirection;
        this.fields        = List.of(fields);
    }

    @Override
    public String getName() {
        return name();
    }

    /**
     * Returns the CBRank object for the specified rank
     *
     * @param rank The rank to return. The value must be in the range 1...8 (inclusive)
     *
     * @return The CBRank object found.
     *
     * @throws IllegalArgumentException if the specified rank number is outside the range 1...8
     * @since 1.0.0
     */
    public static CBRanks getRank(int rank) {
        return switch (rank) {
            case 1 -> FIRST_RANK;
            case 2 -> SECOND_RANK;
            case 3 -> THIRD_RANK;
            case 4 -> FOURTH_RANK;
            case 5 -> FIFTH_RANK;
            case 6 -> SIXTH_RANK;
            case 7 -> SEVENTH_RANK;
            case 8 -> EIGHTH_RANK;
            default -> throw new IllegalArgumentException("Specified rank outside of range 1-8: " + rank);
        };
    }

    /**
     * Returns the CBRanks object for the specified field
     *
     * @param field The field to return the CBRank object for.
     *
     * @return The CBRank object
     *
     * @since 1.0.0
     */
    public static CBRanks getRank(Field field) {
        return getRank(field.getRank());
    }
    /**
     * Returns the Rank the specified field is part of.
     *
     * @param field the field to perform the lookup for.
     *
     * @return The Rank the field is part of.
     *
     * @since 1.0.0
     */
    public static Lines<Field> lookup(Field field) {
        return LOOKUP.get(field);
    }

    private static final Map<Field, CBRanks> LOOKUP;

    static {
        Map<Field, CBRanks> wrk = new HashMap<>();
        for (CBRanks v : values()) {
            for (Field f : v.fields) {
                wrk.put(f, v);
            }
        }
        LOOKUP = Map.copyOf(wrk);
    }
}
