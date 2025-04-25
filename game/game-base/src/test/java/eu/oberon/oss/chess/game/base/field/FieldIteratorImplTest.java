package eu.oberon.oss.chess.game.base.field;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import eu.oberon.oss.chess.base.enums.CBRanks;
import eu.oberon.oss.chess.base.enums.ChessField;
import eu.oberon.oss.chess.game.base.FieldIteratorImpl;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.FieldIterator;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static eu.oberon.oss.chess.base.enums.ChessField.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fabien H. Dumay
 */
class FieldIteratorImplTest {

    @ParameterizedTest
    @MethodSource("eu.oberon.oss.chess.game.base.field.util.MethodSources#getRankFields")
    void rankIteratorTest(int rank, List<ChessField> target) {
        FieldIterator<Field> iterator = FieldIteratorImpl.fieldIterator(rank);
        for (ChessField field : target) {
            assertTrue(iterator.hasNext());
            assertEquals(field, iterator.next());
        }
    }

    @ParameterizedTest
    @MethodSource("eu.oberon.oss.chess.game.base.field.util.MethodSources#getFileFields")
    void fileIteratorTest(String file, List<ChessField> target) {
        FieldIterator<Field> iterator = FieldIteratorImpl.fieldIterator(file);
        ChessField[]         array    = target.toArray(new ChessField[0]);
        for (int i = 7; i > 0; i--) {
            assertTrue(iterator.hasNext());
            assertEquals(array[i], iterator.next());
        }
    }

    public static Stream<Arguments> testSubRangeIterator() {
        return Stream.of(
            Arguments.of(CBRanks.getRank(1), B1, G1, 6, true, null),
            Arguments.of(CBRanks.getRank(1), G1, B1, 6, true, null),
            Arguments.of(CBRanks.getRank(1), B1, G1, 4, false, null),
            Arguments.of(CBRanks.getRank(1), D1, F1, 3, true, null),
            Arguments.of(CBRanks.getRank(1), D1, D1, 0, false, "Start and end fields are equal D1 (inclusive: false)"),
            Arguments.of(CBRanks.getRank(1), B2, F1, 0, false, "B2 not in FIRST_RANK"),
            Arguments.of(CBRanks.getRank(1), D1, G2, 0, false, "G2 not in FIRST_RANK")
        );
    }

    @ParameterizedTest
    @MethodSource
    void testSubRangeIterator(CBRanks rank, Field fromField, Field toField, int fieldCount, boolean inclusive, String msg) {
        if (msg == null) {
            FieldIterator<Field> iterator = FieldIteratorImpl.fieldIterator(rank, fromField, toField, inclusive);
            assertNotNull(iterator);
            assertEquals(fieldCount, iterator.getFieldCount());
        } else {
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> FieldIteratorImpl.fieldIterator(rank, fromField, toField, inclusive)
            );
            assertEquals(msg, exception.getMessage());
        }
    }

    @Test
    void testFieldIterator_skipToEndOfFieldList() {
        FieldIterator<Field> iterator = FieldIteratorImpl.chessBoardFieldIterator();
        assertTrue(iterator.hasNext());
        iterator.skipFields(64);
        assertEquals(H1, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    public static Stream<Arguments> testFieldIterator_skipMultipleTimes() {
        return Stream.of(
            Arguments.of(A8, 0),
            Arguments.of(A7, 8),
            Arguments.of(A6, 16),
            Arguments.of(A5, 24),
            Arguments.of(A4, 32),
            Arguments.of(A3, 40),
            Arguments.of(A2, 48),
            Arguments.of(A1, 56)
        );
    }

    @ParameterizedTest
    @MethodSource
    void testFieldIterator_skipMultipleTimes(ChessField field, int skipCount) {
        FieldIterator<Field> iterator = FieldIteratorImpl.chessBoardFieldIterator();
        assertTrue(iterator.hasNext());
        assertEquals(A8, iterator.next());
        if (skipCount > 0) {
            iterator.skipFields(skipCount);
            assertEquals(field, iterator.next());
            assertThrows(IllegalArgumentException.class, () -> iterator.skipFields(64));
        } else {
            assertThrows(IllegalArgumentException.class, () -> iterator.skipFields(0));
        }
    }
}