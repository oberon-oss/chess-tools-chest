package eu.oberon.oss.chess.game.base.field.util;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static eu.oberon.oss.chess.base.enums.ChessField.*;

/**
 * @author Fabien H. Dumay
 */
@SuppressWarnings("unused")
public class MethodSources {

    public static Stream<Arguments> getRankFields() {
        return Stream.of(
            Arguments.of(1, List.of(A1, B1, C1, D1, E1, F1, G1, H1)),
            Arguments.of(2, List.of(A2, B2, C2, D2, E2, F2, G2, H2)),
            Arguments.of(3, List.of(A3, B3, C3, D3, E3, F3, G3, H3)),
            Arguments.of(4, List.of(A4, B4, C4, D4, E4, F4, G4, H4)),
            Arguments.of(5, List.of(A5, B5, C5, D5, E5, F5, G5, H5)),
            Arguments.of(6, List.of(A6, B6, C6, D6, E6, F6, G6, H6)),
            Arguments.of(7, List.of(A7, B7, C7, D7, E7, F7, G7, H7)),
            Arguments.of(8, List.of(A8, B8, C8, D8, E8, F8, G8, H8))
        );
    }

    public static Stream<Arguments> getFileFields() {
        return Stream.of(
            Arguments.of("A", List.of(A1, A2, A3, A4, A5, A6, A7, A8)),
            Arguments.of("B", List.of(B1, B2, B3, B4, B5, B6, B7, B8)),
            Arguments.of("C", List.of(C1, C2, C3, C4, C5, C6, C7, C8)),
            Arguments.of("D", List.of(D1, D2, D3, D4, D5, D6, D7, D8)),
            Arguments.of("E", List.of(E1, E2, E3, E4, E5, E6, E7, E8)),
            Arguments.of("F", List.of(F1, F2, F3, F4, F5, F6, F7, F8)),
            Arguments.of("G", List.of(G1, G2, G3, G4, G5, G6, G7, G8)),
            Arguments.of("H", List.of(H1, H2, H3, H4, H5, H6, H7, H8))
        );
    }

    public static Stream<Arguments> getFieldByCoordinates() {
        return Stream.of(
            Arguments.of(1, "A", A1),
            Arguments.of(1, "B", B1),
            Arguments.of(1, "C", C1),
            Arguments.of(1, "D", D1),
            Arguments.of(1, "E", E1),
            Arguments.of(1, "F", F1),
            Arguments.of(1, "G", G1),
            Arguments.of(1, "H", H1),

            Arguments.of(2, "A", A2),
            Arguments.of(2, "B", B2),
            Arguments.of(2, "C", C2),
            Arguments.of(2, "D", D2),
            Arguments.of(2, "E", E2),
            Arguments.of(2, "F", F2),
            Arguments.of(2, "G", G2),
            Arguments.of(2, "H", H2),

            Arguments.of(3, "A", A3),
            Arguments.of(3, "B", B3),
            Arguments.of(3, "C", C3),
            Arguments.of(3, "D", D3),
            Arguments.of(3, "E", E3),
            Arguments.of(3, "F", F3),
            Arguments.of(3, "G", G3),
            Arguments.of(3, "H", H3),


            Arguments.of(4, "A", A4),
            Arguments.of(4, "B", B4),
            Arguments.of(4, "C", C4),
            Arguments.of(4, "D", D4),
            Arguments.of(4, "E", E4),
            Arguments.of(4, "F", F4),
            Arguments.of(4, "G", G4),
            Arguments.of(4, "H", H4),


            Arguments.of(5, "A", A5),
            Arguments.of(5, "B", B5),
            Arguments.of(5, "C", C5),
            Arguments.of(5, "D", D5),
            Arguments.of(5, "E", E5),
            Arguments.of(5, "F", F5),
            Arguments.of(5, "G", G5),
            Arguments.of(5, "H", H5),


            Arguments.of(6, "A", A6),
            Arguments.of(6, "B", B6),
            Arguments.of(6, "C", C6),
            Arguments.of(6, "D", D6),
            Arguments.of(6, "E", E6),
            Arguments.of(6, "F", F6),
            Arguments.of(6, "G", G6),
            Arguments.of(6, "H", H6),


            Arguments.of(7, "A", A7),
            Arguments.of(7, "B", B7),
            Arguments.of(7, "C", C7),
            Arguments.of(7, "D", D7),
            Arguments.of(7, "E", E7),
            Arguments.of(7, "F", F7),
            Arguments.of(7, "G", G7),
            Arguments.of(7, "H", H7),

            Arguments.of(8, "A", A8),
            Arguments.of(8, "B", B8),
            Arguments.of(8, "C", C8),
            Arguments.of(8, "D", D8),
            Arguments.of(8, "E", E8),
            Arguments.of(8, "F", F8),
            Arguments.of(8, "G", G8),
            Arguments.of(8, "H", H8)
        );
    }

}
