package org.oberon.oss.chess.game.data;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.oberon.oss.chess.game.data.Chess960StartingPositions;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Piece;
import org.oberon.oss.chess.base.interfaces.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Fabien H. Dumay
 */
class Chess960LoaderTest {

    public static Stream<Arguments> loadChess960() {
        List<Arguments> arguments = new ArrayList<>();
        for (Chess960StartingPositions p : Chess960StartingPositions.values()) {
            arguments.add(Arguments.of(p.getIndex()));
        }
        return arguments.stream();
    }

    @ParameterizedTest
    @MethodSource
    void loadChess960(int chess960ID) {
        Position<Field, Piece<Field>> startingPosition = Chess960StartingPositions.getPosition(chess960ID);
        assertNotNull(startingPosition);
    }
}