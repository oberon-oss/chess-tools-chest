package eu.oberon.oss.chess.game.base.field;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import eu.oberon.oss.chess.base.enums.CBFiles;
import eu.oberon.oss.chess.base.enums.CBRanks;
import eu.oberon.oss.chess.base.enums.ChessField;
import eu.oberon.oss.chess.game.base.FieldIteratorImpl;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.FieldIterator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fabien H. Dumay
 */
class ChessFieldTest {

    @ParameterizedTest
    @MethodSource("eu.oberon.oss.chess.game.base.field.util.MethodSources#getRankFields")
    void getRankFields(int rank, List<ChessField> target) {
        assertTrue(CBRanks.getRank(rank).getFields().containsAll(target));
    }

    @ParameterizedTest
    @MethodSource("eu.oberon.oss.chess.game.base.field.util.MethodSources#getFileFields")
    void getFileFields(String file, List<ChessField> target) {
        assertTrue(CBFiles.getFile(file).getFields().containsAll(target));
    }

    @ParameterizedTest
    @MethodSource("eu.oberon.oss.chess.game.base.field.util.MethodSources#getFieldByCoordinates")
    void getFieldByCoordinates(int rank, String file, ChessField target) {
        assertEquals(target, ChessField.getFieldByCoordinates(file, rank));
    }

    @Test
    void testInvalidRanks() {
        assertThrows(IllegalArgumentException.class, () -> CBRanks.getRank(0));
        assertThrows(IllegalArgumentException.class, () -> CBRanks.getRank(-1));
        assertThrows(IllegalArgumentException.class, () -> CBRanks.getRank(9));
    }

    @Test
    void testInvalidFiles() {
        assertThrows(IllegalArgumentException.class, () -> CBFiles.getFile("1"));
        assertThrows(IllegalArgumentException.class, () -> CBFiles.getFile(" "));
        assertThrows(IllegalArgumentException.class, () -> CBFiles.getFile("Z"));

        //noinspection DataFlowIssue
        Exception exception = assertThrows(Exception.class, () -> CBFiles.getFile((String) null));
        assertTrue(exception instanceof IllegalArgumentException || exception instanceof NullPointerException);
        assertThrows(IllegalArgumentException.class, () -> CBFiles.getFile("IllegalFieldLength"));
    }

    @Test
    void testInvalidCoordinates() {
        assertThrows(IllegalArgumentException.class, () -> ChessField.getFieldByCoordinates("Invalid length", 1));
        assertThrows(IllegalArgumentException.class, () -> ChessField.getFieldByCoordinates("Z", 1));
        assertThrows(IllegalArgumentException.class, () -> ChessField.getFieldByCoordinates("A", 0));
        assertThrows(IllegalArgumentException.class, () -> ChessField.getFieldByCoordinates("F", -1));
        assertThrows(IllegalArgumentException.class, () -> ChessField.getFieldByCoordinates("H", 10));
    }

    @Test
    void testFieldBitMasks() {
        long                 result   = 0L;
        FieldIterator<Field> iterator = FieldIteratorImpl.chessBoardFieldIterator();
        while (iterator.hasNext()) {
            result |= iterator.next().getBitMask();
        }
        assertEquals(0xFFFF_FFFF_FFFF_FFFFL, result);
    }
}