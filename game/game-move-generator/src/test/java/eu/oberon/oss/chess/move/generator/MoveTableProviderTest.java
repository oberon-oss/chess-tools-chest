package eu.oberon.oss.chess.move.generator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import eu.oberon.oss.chess.base.enums.CBRanks;
import eu.oberon.oss.chess.base.enums.ChessField;
import eu.oberon.oss.chess.base.enums.PieceType;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import eu.oberon.oss.chess.move.generator.tables.pieces.MoveTableProvider;

import static eu.oberon.oss.chess.base.enums.PieceType.*;
import static org.junit.jupiter.api.Assertions.*;
import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;

/**
 * @author Fabien H. Dumay
 */
class MoveTableProviderTest {
    @Test
    void testRegularPieces_specifying_pawn() {
        MoveTableProvider<Field> instance = Assertions.assertDoesNotThrow(() -> MoveTableProvider.getInstance());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> instance.getPieceMoveTable(PAWN));

        assertEquals("for Pawns, use method 'getPawnMoveTable(ChessColor)'", exception.getMessage());
    }

    @Test
    void testPawn_with_invalid_color() {
        MoveTableProvider<Field> instance = Assertions.assertDoesNotThrow(() -> MoveTableProvider.getInstance());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> instance.getPawnMoveTable(null));

        assertEquals("Invalid color specified: null", exception.getMessage());
    }

    @Test
    void moveTableProviderTest_regular_pieces() {
        for (PieceType pieceType : new PieceType[]{KING, QUEEN, ROOK, BISHOP, KNIGHT}) {
            MoveTable<Field> moveTable =
                Assertions.assertDoesNotThrow(() -> MoveTableProvider.getInstance().getPieceMoveTable(pieceType)
                );
            assertNotNull(moveTable);
            assertEquals(moveTable.getPiece(), pieceType);
            assertNull(moveTable.getColor());
            for (Field field : ChessField.values()) {
                assertNotNull(moveTable.getFieldMapping(field), "Field: " + field + " PieceType: " + pieceType);
            }
        }
    }

    @Test
    void moveTableProviderTest_white_pawns() {
        MoveTable<Field> moveTable =
            Assertions.assertDoesNotThrow(() -> MoveTableProvider.getInstance().getPawnMoveTable(WHITE)
            );
        assertNotNull(moveTable);
        assertEquals(PAWN, moveTable.getPiece());
        assertEquals(WHITE, moveTable.getColor());
        for (int rank : new int[]{2, 3, 4, 5, 6, 7}) {
            for (Field field : CBRanks.getRank(rank).getFields()) {
                assertNotNull(moveTable.getFieldMapping(field), "Field: " + field + " PieceType: " + PAWN);
            }
        }
    }

    @Test
    void moveTableProviderTest_white_pawns_invalid_ranks() {
        MoveTable<Field> moveTable =
            Assertions.assertDoesNotThrow(() -> MoveTableProvider.getInstance().getPawnMoveTable(WHITE)
            );
        assertNotNull(moveTable);
        assertEquals(PAWN, moveTable.getPiece());
        assertEquals(WHITE, moveTable.getColor());
        for (int rank : new int[]{1, 8}) {
            for (Field field : CBRanks.getRank(rank).getFields()) {
                TargetFieldMapping<Field> mapping = moveTable.getFieldMapping(field);
                assertNull(mapping, "Field: " + field + " PieceType: " + PAWN);
            }
        }
    }

    @Test
    void moveTableProviderTest_black_pawns() {
        MoveTable<Field> moveTable =
            Assertions.assertDoesNotThrow(() -> MoveTableProvider.getInstance().getPawnMoveTable(BLACK)
            );
        assertNotNull(moveTable);
        assertEquals(PAWN, moveTable.getPiece());
        assertEquals(BLACK, moveTable.getColor());
        for (int rank : new int[]{2, 3, 4, 5, 6, 7}) {
            for (Field field : CBRanks.getRank(rank).getFields()) {
                assertNotNull(moveTable.getFieldMapping(field), "Field: " + field + " PieceType: " + PAWN);
            }
        }
    }

    @Test
    void moveTableProviderTest_black_pawns_invalid_ranks() {
        MoveTable<Field> moveTable =
            Assertions.assertDoesNotThrow(() -> MoveTableProvider.getInstance().getPawnMoveTable(BLACK)
            );
        assertNotNull(moveTable);
        assertEquals(PAWN, moveTable.getPiece());
        assertEquals(BLACK, moveTable.getColor());
        for (int rank : new int[]{1, 8}) {
            for (Field field : CBRanks.getRank(rank).getFields()) {
                TargetFieldMapping<Field> mapping = moveTable.getFieldMapping(field);
                assertNull(mapping, "Field: " + field + " PieceType: " + PAWN);
            }
        }
    }
}