package eu.oberon.oss.chess.move.generator;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.enums.PieceType;
import eu.oberon.oss.chess.game.data.Chess960StartingPositions;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Move;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fabien H. Dumay
 */
@Log4j2
class MoveGeneratorImplTest extends Util {
    private        Position<Field, Piece<Field>>      initialPosition;
    private static MoveGenerator<Field, Piece<Field>> generator;

    @BeforeAll
    static void setup() {
        generator = MoveGeneratorImpl.getInstance();
    }

    public static Stream<Arguments> generateBlackMoves() {
        List<Arguments> arguments = new ArrayList<>();

        for (Piece<Field> piece : getInitialPosition()
            .board()
            .getPiecesForColor(ChessColor.BLACK)
            .values()
        ) {
            arguments.add(Arguments.of(piece.getCurrentField(), piece.getPieceType()));
        }

        return arguments.stream();
    }

    public static Stream<Arguments> generateWhiteMoves() {
        List<Arguments> arguments = new ArrayList<>();

        for (Piece<Field> piece : getInitialPosition()
            .board()
            .getPiecesForColor(ChessColor.WHITE)
            .values()
        ) {
            arguments.add(Arguments.of(piece.getCurrentField(), piece.getPieceType()));
        }

        return arguments.stream();
    }

    @BeforeEach
    void setUp() {
        initialPosition = getInitialPosition();
    }

    @Test
    void testAllMoves() {
        List<Move<Field, Piece<Field>>> moveList;

        ChessGameTestImpl chessGameTest = new ChessGameTestImpl(Chess960StartingPositions.P_518);

        moveList = assertDoesNotThrow(() -> generator.createMoveList(ChessColor.WHITE, chessGameTest));
        assertEquals(20, moveList.size());


        moveList = assertDoesNotThrow(() -> generator.createMoveList(ChessColor.BLACK, chessGameTest));
        assertEquals(20, moveList.size());

    }

    @ParameterizedTest
    @MethodSource
    void generateWhiteMoves(Field field, PieceType pieceType) {
        generate(field, pieceType);
    }

    @ParameterizedTest
    @MethodSource
    void generateBlackMoves(Field field, PieceType pieceType) {
        generate(field, pieceType);
    }

    private void generate(Field field, PieceType pieceType) {
        List<Move<Field, Piece<Field>>> moveList;

        ChessGameTestImpl chessGameTest = new ChessGameTestImpl(Chess960StartingPositions.P_518);

        moveList = generator.createMoveList(initialPosition.board().getPieceMapping().get(field), chessGameTest);
        if (pieceType == PieceType.PAWN || pieceType == PieceType.KNIGHT) {
            assertFalse(moveList.isEmpty());
            for (Move<Field, Piece<Field>> move : moveList) {
                assertFalse(move.toString().isEmpty());
            }
        } else {
            assertTrue(moveList.isEmpty());
        }
    }
}