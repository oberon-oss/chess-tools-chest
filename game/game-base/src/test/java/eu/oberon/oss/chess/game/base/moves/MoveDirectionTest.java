package eu.oberon.oss.chess.game.base.moves;

import org.junit.jupiter.api.Test;
import eu.oberon.oss.chess.base.enums.MoveDirection;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fabien H. Dumay
 */
class MoveDirectionTest {
    @Test
    void testOppositeDirection() {
        for (MoveDirection direction : MoveDirection.values()) {
            switch (direction) {
                case NORTH:
                    assertEquals(MoveDirection.SOUTH, direction.opposite());
                    break;
                case NORTH_EAST:
                    assertEquals(MoveDirection.SOUTH_WEST, direction.opposite());
                    break;
                case EAST:
                    assertEquals(MoveDirection.WEST, direction.opposite());
                    break;
                case SOUTH_EAST:
                    assertEquals(MoveDirection.NORTH_WEST, direction.opposite());
                    break;
                case SOUTH:
                    assertEquals(MoveDirection.NORTH, direction.opposite());
                    break;
                case SOUTH_WEST:
                    assertEquals(MoveDirection.NORTH_EAST, direction.opposite());
                    break;
                case WEST:
                    assertEquals(MoveDirection.EAST, direction.opposite());
                    break;
                case NORTH_WEST:
                    assertEquals(MoveDirection.SOUTH_EAST, direction.opposite());
                    break;
                case NONE:
                    assertEquals(MoveDirection.NONE, direction.opposite());
                    break;
            }
        }
    }
}