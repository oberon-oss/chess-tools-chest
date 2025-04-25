package eu.oberon.oss.chess.game.base.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import eu.oberon.oss.chess.base.enums.CBFiles;

import eu.oberon.oss.chess.game.base.FieldIteratorImpl;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.FieldIterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fabien H. Dumay
 */
class CBFilesTest {
    private FieldIterator<Field> iterator;

    @BeforeEach
    void setUp() {
        iterator = FieldIteratorImpl.chessBoardFieldIterator();
    }

    @Test
    void testFiles() {
        while (iterator.hasNext()) {
            Field field = iterator.next();
            assertEquals(CBFiles.getFile(field), CBFiles.getFile((field.getFile())));
            assertTrue(CBFiles.lookup(field).getFields().contains(field));
            switch (field.getFile()) {
                case "A" -> assertEquals(CBFiles.A_FILE.getName(), CBFiles.getFile("A").getName());
                case "B" -> assertEquals(CBFiles.B_FILE.getName(), CBFiles.getFile("B").getName());
                case "C" -> assertEquals(CBFiles.C_FILE.getName(), CBFiles.getFile("C").getName());
                case "D" -> assertEquals(CBFiles.D_FILE.getName(), CBFiles.getFile("D").getName());
                case "E" -> assertEquals(CBFiles.E_FILE.getName(), CBFiles.getFile("E").getName());
                case "F" -> assertEquals(CBFiles.F_FILE.getName(), CBFiles.getFile("F").getName());
                case "G" -> assertEquals(CBFiles.G_FILE.getName(), CBFiles.getFile("G").getName());
                case "H" -> assertEquals(CBFiles.H_FILE.getName(), CBFiles.getFile("H").getName());
                default -> fail("Unrecognized file: " + field.getFile());
            }
        }
    }
}