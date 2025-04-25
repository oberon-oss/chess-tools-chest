package org.oberon.oss.chess.move.generator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.oberon.oss.chess.base.enums.ChessField;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Move;
import org.oberon.oss.chess.base.interfaces.Piece;
import org.oberon.oss.chess.base.interfaces.Position;
import org.oberon.oss.chess.game.base.BoardImpl;
import org.oberon.oss.chess.game.base.MoveImpl;
import org.oberon.oss.chess.game.base.PieceImpl;
import org.oberon.oss.chess.game.base.PositionImpl;
import org.oberon.oss.chess.game.data.Chess960StartingPositions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static org.oberon.oss.chess.base.enums.ChessColor.WHITE;
import static org.oberon.oss.chess.base.enums.ChessField.*;
import static org.oberon.oss.chess.base.enums.PieceType.*;
import static org.oberon.oss.chess.base.interfaces.Move.BIT_FLAG_REGULAR_MOVE;

/**
 * @author Fabien H. Dumay
 */
class MoveTest {
    private static MoveGenerator<Field, Piece<Field>> instance;

    @BeforeAll
    static void setUpBeforeClass() {
        instance = MoveGeneratorImpl.getInstance();
    }

    private PositionImpl.PositionBuilder<Field, Piece<Field>> positionBuilder;
    private BoardImpl.BoardBuilder<Field, Piece<Field>> boardBuilder;

    @BeforeEach
    void setUp() {
        positionBuilder = new PositionImpl.PositionBuilder<>();
        boardBuilder = new BoardImpl.BoardBuilder<>();
    }

    private List<Move<Field, Piece<Field>>> compareMoveList(Position<Field, Piece<Field>> position, Field field, int listSize, List<String> strings) {
        ChessGameTestImpl chessGame = new ChessGameTestImpl(Chess960StartingPositions.P_518);
        chessGame.setCurrentPosition(position);
        List<Move<Field, Piece<Field>>> moveList =
                new ArrayList<>(assertDoesNotThrow(() -> instance.createMoveList(
                        chessGame.getCurrentPosition().board().getPieceMapping().get(field),
                        chessGame
                )));
        assertEquals(listSize, moveList.size());
        for (Move<Field, Piece<Field>> move : moveList) {
            assertTrue(strings.contains(move.toString()));
        }
        return moveList;
    }

    @Test
    void testEnPassant_white() {
        List<Move<Field, Piece<Field>>> moveList;

        Position<Field, Piece<Field>> position = assertDoesNotThrow(() -> positionBuilder
                .board(boardBuilder
                        .addPiece(new PieceImpl<>(KING, BLACK, E8))
                        .addPiece(new PieceImpl<>(KING, WHITE, E1))
                        .addPiece(new PieceImpl<>(PAWN, BLACK, F5))
                        .addPiece(new PieceImpl<>(PAWN, WHITE, E5))
                        .build()
                )
                .enPassantField(F6)
                .build()
        );
        assertNotNull(position);
        moveList = compareMoveList(position, E5, 2, List.of("E5-E6", "E5xF6 e.p."));
        for (Move<Field, Piece<Field>> move : moveList) {
            if (Move.isEnPassant(move.getMoveFlags())) {
                Piece<Field> capturedPiece = move.getCapturedPiece();
                assertNotNull(capturedPiece);
                assertEquals(F5, capturedPiece.getCurrentField());
                assertTrue(Move.isCapture(move.getMoveFlags()));
            }
        }
    }

    @Test
    void testEnPassant_black() {
        List<Move<Field, Piece<Field>>> moveList;
        Position<Field, Piece<Field>> position = assertDoesNotThrow(() -> positionBuilder
                .board(boardBuilder
                        .addPiece(new PieceImpl<>(KING, BLACK, E8))
                        .addPiece(new PieceImpl<>(KING, WHITE, E1))
                        .addPiece(new PieceImpl<>(PAWN, BLACK, F4))
                        .addPiece(new PieceImpl<>(PAWN, WHITE, E4))
                        .build()
                )
                .enPassantField(E3)
                .build()
        );
        assertNotNull(position);
        moveList = compareMoveList(position, F4, 2, List.of("F4-F3", "F4xE3 e.p."));
        for (Move<Field, Piece<Field>> move : moveList) {
            if (Move.isEnPassant(move.getMoveFlags())) {
                Piece<Field> capturedPiece = move.getCapturedPiece();
                assertNotNull(capturedPiece);
                assertEquals(E4, capturedPiece.getCurrentField());
                assertTrue(Move.isCapture(move.getMoveFlags()));
            }
        }
    }

    @Test
    void testPromotion_White_with_capture() {
        Position<Field, Piece<Field>> position = assertDoesNotThrow(() -> positionBuilder
                .board(boardBuilder
                        .addPiece(new PieceImpl<>(KING, BLACK, E8))
                        .addPiece(new PieceImpl<>(KING, WHITE, E1))
                        .addPiece(new PieceImpl<>(PAWN, WHITE, B7))
                        .addPiece(new PieceImpl<>(ROOK, BLACK, A8))
                        .build()
                ).build()
        );
        assertNotNull(position);
        List<Move<Field, Piece<Field>>> moveList = compareMoveList(
                position, B7, 8, List.of(
                        "B7xA8=Q", "B7xA8=R", "B7xA8=B", "B7xA8=N",
                        "B7-B8=Q", "B7-B8=R", "B7-B8=B", "B7-B8=N"
                )
        );
        for (Move<Field, Piece<Field>> move : moveList) {
            assertTrue(Move.isPromotion(move.getMoveFlags()));
        }
    }

    @Test
    void testPromotion_Black_with_capture() {
        Position<Field, Piece<Field>> position = assertDoesNotThrow(() -> positionBuilder
                .board(boardBuilder
                        .addPiece(new PieceImpl<>(KING, BLACK, E8))
                        .addPiece(new PieceImpl<>(KING, WHITE, E1))
                        .addPiece(new PieceImpl<>(PAWN, BLACK, B2))
                        .addPiece(new PieceImpl<>(ROOK, WHITE, A1))
                        .build()
                ).build()
        );
        assertNotNull(position);
        List<Move<Field, Piece<Field>>> moveList = compareMoveList(
                position, B2, 8, List.of(
                        "B2xA1=Q", "B2xA1=R", "B2xA1=B", "B2xA1=N",
                        "B2-B1=Q", "B2-B1=R", "B2-B1=B", "B2-B1=N"
                )
        );
        for (Move<Field, Piece<Field>> move : moveList) {
            assertTrue(Move.isPromotion(move.getMoveFlags()));
        }
    }

    @Test
    void testPromotion_White() {
        Position<Field, Piece<Field>> position = assertDoesNotThrow(() -> positionBuilder
                .board(boardBuilder
                        .addPiece(new PieceImpl<>(KING, BLACK, E1))
                        .addPiece(new PieceImpl<>(KING, WHITE, E8))
                        .addPiece(new PieceImpl<>(PAWN, WHITE, B7))
                        .build()
                ).build()
        );
        assertNotNull(position);
        compareMoveList(position, B7, 4, List.of("B7-B8=Q", "B7-B8=R", "B7-B8=B", "B7-B8=N"));
    }

    @Test
    void testPromotion_Black() {
        Position<Field, Piece<Field>> position = assertDoesNotThrow(() -> positionBuilder
                .board(boardBuilder
                        .addPiece(new PieceImpl<>(KING, BLACK, E8))
                        .addPiece(new PieceImpl<>(KING, WHITE, E1))
                        .addPiece(new PieceImpl<>(PAWN, BLACK, B2))
                        .build()
                ).build()
        );
        assertNotNull(position);
        compareMoveList(position, B2, 4, List.of("B2-B1=Q", "B2-B1=R", "B2-B1=B", "B2-B1=N"));
    }

    @Test
    void testCapture_White() {
        Position<Field, Piece<Field>> position = assertDoesNotThrow(() -> positionBuilder
                .board(boardBuilder
                        .addPiece(new PieceImpl<>(KING, BLACK, E8))
                        .addPiece(new PieceImpl<>(KING, WHITE, E1))
                        .addPiece(new PieceImpl<>(ROOK, BLACK, D1))
                        .build()
                ).build()
        );
        assertNotNull(position);
        compareMoveList(position, E1, 5, List.of("K E1xD1", "K E1-D2", "K E1-E2", "K E1-F2", "K E1-F1"));
    }

    @Test
    void testCapture_Black() {
        Position<Field, Piece<Field>> position = assertDoesNotThrow(() -> positionBuilder
                .board(boardBuilder
                        .addPiece(new PieceImpl<>(KING, BLACK, E8))
                        .addPiece(new PieceImpl<>(ROOK, WHITE, D8))
                        .addPiece(new PieceImpl<>(KING, WHITE, E1))
                        .build()
                ).build()
        );
        assertNotNull(position);
        compareMoveList(position, E8, 5, List.of("K E8xD8", "K E8-D7", "K E8-E7", "K E8-F7", "K E8-F8"));
    }

    @Test
//    @Disabled("Temporary - we need to get castling back in")
    void testCastling_whitePieces() {
        Position<Field, Piece<Field>> position = assertDoesNotThrow(() -> positionBuilder
                .board(boardBuilder
                        .addPiece(new PieceImpl<>(KING, BLACK, E8))
                        .addPiece(new PieceImpl<>(KING, WHITE, E1))
                        .addPiece(new PieceImpl<>(ROOK, WHITE, H1))
                        .addPiece(new PieceImpl<>(ROOK, WHITE, A1))
                        .build()
                ).build()
        );
        assertNotNull(position);
        compareMoveList(position, E1, 7, List.of("K E1-D1", "K E1-D2", "K E1-E2", "K E1-F2", "K E1-F1", "O-O", "O-O-O"));
    }

    @Test
//    @Disabled("Temporary - we need to get castling back in")
    void testCastling_blackPieces() {
        Position<Field, Piece<Field>> position = assertDoesNotThrow(() -> positionBuilder
                .board(boardBuilder
                        .addPiece(new PieceImpl<>(KING, WHITE, E1))
                        .addPiece(new PieceImpl<>(KING, BLACK, E8))
                        .addPiece(new PieceImpl<>(ROOK, BLACK, H8))
                        .addPiece(new PieceImpl<>(ROOK, BLACK, A8))
                        .build()
                ).build()
        );
        assertNotNull(position);
        compareMoveList(position, E8, 7, List.of("K E8-D8", "K E8-D7", "K E8-E7", "K E8-F7", "K E8-F8", "O-O", "O-O-O"));
    }

    @Test
    void testRegularMove_non_castle_omit_from_field() {
        PieceImpl<ChessField> piece = new PieceImpl<>(KING, BLACK, E8);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new MoveImpl<>(piece, null, E1, null, null, BIT_FLAG_REGULAR_MOVE)
        );
        assertEquals("fromField cannot be null", exception.getMessage());
    }

    @Test
    void testRegularMove_non_castle_omit_to_field() {
        PieceImpl<ChessField> piece = new PieceImpl<>(KING, BLACK, E8);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new MoveImpl<>(piece, E1, null, null, null, BIT_FLAG_REGULAR_MOVE)
        );
        assertEquals("toField cannot be null", exception.getMessage());
    }
}