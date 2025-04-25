/*
MIT No Attribution

Copyright 2024 Fabien H. Dumay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package eu.oberon.oss.chess.fen.processing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.game.base.PieceImpl;
import eu.oberon.oss.chess.base.enums.PieceType;

import java.util.stream.Stream;

import static eu.oberon.oss.chess.base.enums.PieceType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;
import static eu.oberon.oss.chess.base.enums.ChessField.A1;


/**
 * @author Fabien H. Dumay
 */
class FENChessPieceTest {
    public static Stream<Arguments> fenPieceDefs() {
        Stream<Arguments> argumentsStream = Stream.of(
                Arguments.of("K", KING, WHITE),
                Arguments.of("k", KING, BLACK),
                Arguments.of("Q", QUEEN, WHITE),
                Arguments.of("q", QUEEN, BLACK),
                Arguments.of("R", ROOK, WHITE),
                Arguments.of("r", ROOK, BLACK),
                Arguments.of("B", BISHOP, WHITE),
                Arguments.of("b", BISHOP, BLACK),
                Arguments.of("N", KNIGHT, WHITE),
                Arguments.of("n", KNIGHT, BLACK),
                Arguments.of("P", PAWN, WHITE),
                Arguments.of("p", PAWN, BLACK)
        );
        return argumentsStream;
    }

    @ParameterizedTest
    @MethodSource("fenPieceDefs")
    void translate(String fenChessPieceName, PieceType pieceType) {
        assertEquals(pieceType, FENChessPieceTranslator.translate(fenChessPieceName));
    }

    @ParameterizedTest
    @MethodSource("fenPieceDefs")
    void get(String fenChessPieceName, PieceType pieceType, ChessColor color) {
        assertEquals(fenChessPieceName, FENChessPieceTranslator.getFENCharacterForPiece(new PieceImpl<>(pieceType, color, A1)));
    }

    @Test
    void testInvalidFenChessPieceName() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> FENChessPieceTranslator.translate("X")
        );

        assertEquals("Parameter 'fenPieceType': invalid type was specified: X", exception.getMessage());
    }
}