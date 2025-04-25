package org.oberon.oss.chess.base.enums;

import lombok.Getter;
import org.oberon.oss.chess.base.interfaces.Lines;
import org.oberon.oss.chess.base.interfaces.Field;

import java.util.*;

import static org.oberon.oss.chess.base.enums.ChessField.*;
import static org.oberon.oss.chess.base.enums.MoveDirection.*;

/**
 * enumeration of CBDiagonals that can be identified on a chess board.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@Getter
public enum CBDiagonals implements Lines<Field> {
    A1_H8(NORTH_EAST, A1, B2, C3, D4, E5, F6, G7, H8),

    A2_G8(NORTH_EAST, A2, B3, C4, D5, E6, F7, G8),
    A2_B1(SOUTH_EAST, A2, B1),

    A3_F8(NORTH_EAST, A3, B4, C5, D6, E7, F8),
    A3_C1(SOUTH_EAST, A3, B2, C1),

    A4_E8(NORTH_EAST, A4, B5, C6, D7, E8),
    A4_D1(SOUTH_EAST, A4, B3, C2, D1),

    A5_D8(NORTH_EAST, A5, B6, C7, D8),
    A5_E1(SOUTH_EAST, A5, B4, C3, D2, E1),

    A6_C8(NORTH_EAST, A6, B7, C8),
    A6_F1(SOUTH_EAST, A6, B5, C4, D3, E2, F1),

    A7_B8(NORTH_EAST, A7, B8),
    A7_G1(SOUTH_EAST, A7, B6, C5, D4, E3, F2, G1),

    H1_A8(NORTH_WEST, H1, G2, F3, E4, D5, C6, B7, A8),

    H2_B8(NORTH_WEST, H2, G3, F4, E5, D6, C7, B8),
    H2_G1(SOUTH_WEST, H2, G1),

    H3_C8(NORTH_WEST, H3, G4, F5, E6, D7, C8),
    H3_F1(SOUTH_WEST, H3, G2, F1),

    H4_D8(NORTH_WEST, H4, G5, F6, E7, D8),
    H4_E1(SOUTH_WEST, H4, G3, F2, E1),

    H5_E8(NORTH_WEST, H5, G6, F7, E8),
    H5_D1(SOUTH_WEST, H5, G4, F3, E2, D1),

    H6_F8(NORTH_WEST, H6, G7, F8),
    H6_C1(SOUTH_WEST, H6, G5, F4, E3, D2, C1),

    H7_G8(NORTH_WEST, H7, G8),
    H7_B1(SOUTH_WEST, H7, G6, F5, E4, D3, C2, B1);

    private final MoveDirection moveDirection;
    private final List<Field>   fields;

    CBDiagonals(MoveDirection moveDirection, ChessField... fields) {
        this.moveDirection = moveDirection;
        this.fields        = List.of(fields);
    }

    @Override
    public String getName() {
        return name();
    }

    /**
     * Returns the Diagonal(s) the specified field is part of.
     *
     * @param field the field to perform the lookup for. If the specified field is <b>A1</b>, <b>A8</b>, <b>H1</b> or <b>H8</b>, the
     *              list will contain only 1 result, as these fields are corner fields.
     *
     * @return List of 1 or 2 diagonals the specified field is part of.
     *
     * @since 1.0.0
     */
    public static List<Lines<Field>> lookup(Field field) {
        return LOOKUP_MAP.get(field);
    }

    public static List<CBDiagonals> lookupByMoveDirection(MoveDirection moveDirection) {
        return LOOKUP_DIAGONALS.get(moveDirection);
    }

    private static final Map<Field, List<Lines<Field>>>        LOOKUP_MAP;
    private static final Map<MoveDirection, List<CBDiagonals>> LOOKUP_DIAGONALS;

    static {
        Map<Field, List<Lines<Field>>>        map          = new HashMap<>();
        Map<MoveDirection, List<CBDiagonals>> mapDiagonals = new EnumMap<>(MoveDirection.class);

        for (CBDiagonals diagonal : CBDiagonals.values()) {
            mapDiagonals.computeIfAbsent(diagonal.moveDirection, k -> new ArrayList<>()).add(diagonal);
            for (Field field : diagonal.fields) {
                map.computeIfAbsent(field, k -> new ArrayList<>()).add(diagonal);
            }
        }
        LOOKUP_MAP       = Map.copyOf(map);
        LOOKUP_DIAGONALS = Map.copyOf(mapDiagonals);
    }

}
