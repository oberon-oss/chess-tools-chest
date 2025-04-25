package org.oberon.oss.chess.game.base.board;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.oberon.oss.chess.base.enums.CBDiagonals;
import org.oberon.oss.chess.game.base.FieldIteratorImpl;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.FieldIterator;
import org.oberon.oss.chess.base.enums.FieldLocation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.oberon.oss.chess.base.enums.CBDiagonals.*;
import static org.oberon.oss.chess.base.enums.MoveDirection.*;

/**
 * @author Fabien H. Dumay
 */
@Log4j2
class CBDiagonalsTest {

    @Test
    void testDiagonals_NorthEast() {
        List<CBDiagonals> cbDiagonals = CBDiagonals.lookupByMoveDirection(NORTH_EAST);
        assertNotNull(cbDiagonals);
        assertEquals(7, cbDiagonals.size());
        assertTrue(cbDiagonals.containsAll(List.of(A1_H8, A2_G8, A3_F8, A4_E8, A5_D8, A6_C8, A7_B8)));
    }

    @Test
    void testDiagonals_SouthEast() {
        List<CBDiagonals> cbDiagonals = CBDiagonals.lookupByMoveDirection(SOUTH_EAST);
        assertNotNull(cbDiagonals);
        assertEquals(6, cbDiagonals.size());
        assertTrue(cbDiagonals.containsAll(List.of(A2_B1, A3_C1, A4_D1, A5_E1, A6_F1, A7_G1)));
    }

    @Test
    void testDiagonals_NorthWest() {
        List<CBDiagonals> cbDiagonals = CBDiagonals.lookupByMoveDirection(NORTH_WEST);
        assertNotNull(cbDiagonals);
        assertEquals(7, cbDiagonals.size());
        assertTrue(cbDiagonals.containsAll(List.of(H1_A8, H2_B8, H3_C8, H4_D8, H5_E8, H6_F8, H7_G8)));
    }

    @Test
    void testDiagonals_SouthWest() {
        List<CBDiagonals> cbDiagonals = CBDiagonals.lookupByMoveDirection(SOUTH_WEST);
        assertNotNull(cbDiagonals);
        assertEquals(6, cbDiagonals.size());
        assertTrue(cbDiagonals.containsAll(List.of(H2_G1, H3_F1, H4_E1, H5_D1, H6_C1, H7_B1)));
    }

    @Test
    void testFieldsInDiagonals() {
        FieldIterator<Field> iterator = FieldIteratorImpl.chessBoardFieldIterator();
        while (iterator.hasNext()) {
            Field field = iterator.next();
            LOGGER.info("Checking: {}", field);
            if (field.getFieldLocation() == FieldLocation.CORNER) {
                assertEquals(1, CBDiagonals.lookup(field).size());
                assertEquals(8, lookup(field).get(0).getFields().size());
            } else {
                assertEquals(2, CBDiagonals.lookup(field).size());
                assertTrue(CBDiagonals.lookup(field).size() > 1 && CBDiagonals.lookup(field).size() <= 7 );
            }
        }
    }

}