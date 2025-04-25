package eu.oberon.oss.chess.game.base.position;

import org.junit.jupiter.api.Test;
import eu.oberon.oss.chess.game.base.Util;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.Position;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fabien H. Dumay
 * @since 1.2.0
 */
class PositionImplTest extends Util {

    @Test
    void testInitialPosition() {
        Position<Field, Piece<Field>> initialPosition = getInitialPosition();
        assertNotNull(initialPosition);

        assertEquals(ChessColor.WHITE, initialPosition.sideToMove());
        assertTrue(initialPosition.blackCanCastleKingSide());
        assertTrue(initialPosition.blackCanCastleQueenSide());
        assertTrue(initialPosition.whiteCanCastleKingSide());
        assertTrue(initialPosition.whiteCanCastleQueenSide());
    }

    @Test
    void testPositionDuplication() {
        Position<Field, Piece<Field>> position   = getInitialPosition();
        Position<Field, Piece<Field>> duplicated = position.duplicate();
        assertNotNull(duplicated);
        assertEquals(position,duplicated);
    }
}