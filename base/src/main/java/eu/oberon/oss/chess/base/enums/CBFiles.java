package eu.oberon.oss.chess.base.enums;

import lombok.Getter;
import eu.oberon.oss.chess.base.interfaces.Lines;
import eu.oberon.oss.chess.base.interfaces.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static eu.oberon.oss.chess.base.enums.ChessField.*;
import static eu.oberon.oss.chess.base.enums.MoveDirection.SOUTH;

/**
 * Enumerates the files (vertical columns) of a chess board.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@Getter
public enum CBFiles implements Lines<Field> {
    A_FILE(SOUTH, A8, A7, A6, A5, A4, A3, A2, A1),
    B_FILE(SOUTH, B8, B7, B6, B5, B4, B3, B2, B1),
    C_FILE(SOUTH, C8, C7, C6, C5, C4, C3, C2, C1),
    D_FILE(SOUTH, D8, D7, D6, D5, D4, D3, D2, D1),
    E_FILE(SOUTH, E8, E7, E6, E5, E4, E3, E2, E1),
    F_FILE(SOUTH, F8, F7, F6, F5, F4, F3, F2, F1),
    G_FILE(SOUTH, G8, G7, G6, G5, G4, G3, G2, G1),
    H_FILE(SOUTH, H8, H7, H6, H5, H4, H3, H2, H1);

    private final MoveDirection moveDirection;
    private final List<Field>   fields;

    CBFiles(MoveDirection moveDirection, Field... fields) {
        this.moveDirection = moveDirection;
        this.fields        = List.of(fields);
    }

    @Override
    public String getName() {
        return name();
    }

    /**
     * Returns The CBFile object for the specified file.
     *
     * @param file The file to return. The value must be in the range A...H (inclusive)
     *
     * @return The CBFile object.
     *
     * @throws IllegalArgumentException if the specified file is outside the range A...H
     * @since 1.0.0
     */
    public static CBFiles getFile(String file) {
        return switch (file) {
            case "A" -> A_FILE;
            case "B" -> B_FILE;
            case "C" -> C_FILE;
            case "D" -> D_FILE;
            case "E" -> E_FILE;
            case "F" -> F_FILE;
            case "G" -> G_FILE;
            case "H" -> H_FILE;
            default -> throw new IllegalArgumentException("Specified file outside of range A-H: " + file);
        };
    }

    /**
     * Returns the CBFiles object for the specified field
     *
     * @param field The field to return the CBFiles object for.
     *
     * @return The CBFiles object
     *
     * @since 1.0.0
     */
    public static CBFiles getFile(Field field) {
        return getFile(field.getFile());
    }

    /**
     * Returns the File the specified field is part of.
     *
     * @param field the field to perform the lookup for.
     *
     * @return The File the specified field is part of.
     *
     * @since 1.0.0
     */
    public static Lines<Field> lookup(Field field) {
        return LOOKUP.get(field);
    }

    private static final Map<Field, CBFiles> LOOKUP;

    static {
        Map<Field, CBFiles> wrk = new HashMap<>();
        for (CBFiles h : values()) {
            for (Field f : h.fields) {
                wrk.put(f, h);
            }
        }
        LOOKUP = Map.copyOf(wrk);
    }
}
