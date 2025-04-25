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
package org.oberon.oss.chess.fen.processing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Piece;
import org.oberon.oss.chess.base.interfaces.Position;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.oberon.oss.chess.fen.processing.FENPositionTranslator.INITIAL_POSITION_FEN_SETUP_STRING;

/**
 * @author Fabien H. Dumay
 */
class FENPositionTranslatorImplTest {

    private FENPositionTranslator<Field, Piece<Field>> translator;

    @BeforeEach
    void init() {
        translator = new FENPositionTranslatorImpl();
    }

    //@formatter:off
    private static final String INVALID_SETUP_STRING                             = "rnbqkbnr/pppppppx/9/8/8/8/PPPPPPPP/RNBQKBNR w QKqk - 0 0";
    private static final String INVALID_SETUP_STRING_INVALID_RANK                = "rnbqkbnr/ppppppp222/9/8/8/8/PPPPPPPP/RNBQKBNR w QKqk - 0 0";
    private static final String POSTION_AFTER_1_WHITE_MOVE                       = "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq - 0 0";
    private static final String POSITION_SETUP_STRING_NO_CASTLING                = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w - - 0 0";
    private static final String EN_PASSANT_WITH_EMPTY_FIELD                      = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w QKqk E6 0 0";
    private static final String EN_PASSANT_WHITE_WITH_WHITE_PAWN                 = "rnbqkbnr/pppppppp/4P3/8/8/8/PPPPPPPP/RNBQKBNR w QKqk E6 0 0";
    private static final String EN_PASSANT_WHITE_WITH_BLACK_PAWN                 = "rnbqkbnr/pppppppp/4p3/8/8/8/PPPPPPPP/RNBQKBNR w QKqk E6 0 0";
    private static final String EN_PASSANT_BLACK_WITH_WHITE_PAWN                 = "rnbqkbnr/pppppppp/8/8/8/4P3/PPPPPPPP/RNBQKBNR b QKqk E3 0 0";
    private static final String EN_PASSANT_BLACK_WITH_BLACK_PAWN                 = "rnbqkbnr/pppppppp/8/8/8/4p3/PPPPPPPP/RNBQKBNR b QKqk E3 0 0";
    private static final String CASTLING_BLACK_KING_SIDE_NOT_ON_8TH_RANK         = "1nbq1bn1/rpppkppr/8/8/8/8/PPPPPPPP/RNBQKBNR w k - 0 0";
    private static final String CASTLING_BLACK_KING_SIDE_ROOK_ON_INCORRECT_SIDE  = "rnbqkbnq/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w k - 0 0";
    private static final String CASTLING_BLACK_QUEEN_SIDE_ROOK_ON_INCORRECT_SIDE = "qnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w q - 0 0";
    private static final String CASTLING_WHITE_KING_SIDE_NOT_ON_1ST_RANK         = "rnbqkbnr/pppppppp/8/8/8/8/RPPPKPPP/1NBQ1BN1 w K - 0 0";
    //@formatter:on

    @Test
    void toFENPosition() {
        FENPosition<Field, Piece<Field>> position1;
        FENPosition<Field, Piece<Field>> position2;

        position1 = translator.toFENPosition(INITIAL_POSITION_FEN_SETUP_STRING);
        position2 = translator.toFENPosition(translator.toFENString(position1.createPosition()));

        assertEquals(position1, position2);
        assertEquals(translator.toFENString(position1.createPosition()), translator.toFENString(position2.createPosition()));

        assertTrue(position1.createPosition().blackCanCastleKingSide());
        assertTrue(position1.createPosition().blackCanCastleQueenSide());
        assertTrue(position2.createPosition().whiteCanCastleKingSide());
        assertTrue(position2.createPosition().whiteCanCastleQueenSide());
    }

    @Test
    void testInvalidSetupString() {
        assertThrows(FENTranslatorException.class, () -> translator.toFENPosition(INVALID_SETUP_STRING));
    }

    @Test
    void setupStringWithInvalidRankDataTest() {
        assertThrows(FENTranslatorException.class, () -> translator.toFENPosition(INVALID_SETUP_STRING_INVALID_RANK));
    }

    @Test
    void testNoCastlingRights() {
        FENPosition<Field, Piece<Field>> fenPosition =
            translator.toFENPosition(POSITION_SETUP_STRING_NO_CASTLING);
        Position<Field, Piece<Field>> position = fenPosition.createPosition();

        assertFalse(position.blackCanCastleKingSide());
        assertFalse(position.blackCanCastleQueenSide());
        assertFalse(position.whiteCanCastleKingSide());
        assertFalse(position.whiteCanCastleQueenSide());

        assertEquals(POSITION_SETUP_STRING_NO_CASTLING, translator.toFENString(position));
    }

    @Test
    void testWithBlackToMoveNext() {
        FENPosition<Field, Piece<Field>> position = translator.toFENPosition(POSTION_AFTER_1_WHITE_MOVE);
        assertEquals(POSTION_AFTER_1_WHITE_MOVE, translator.toFENString(position.createPosition()));
    }

    public static Stream<Arguments> castlingTest() {
        return Stream.of(
            Arguments.of(
                CASTLING_WHITE_KING_SIDE_NOT_ON_1ST_RANK,
                "for 'WHITE' castling, the KING must be located on the 1st rank."
            ),
            Arguments.of(
                CASTLING_BLACK_KING_SIDE_NOT_ON_8TH_RANK,
                "for 'BLACK' castling, the KING must be located on the 8th rank."
            ),
            Arguments.of(
                CASTLING_BLACK_KING_SIDE_ROOK_ON_INCORRECT_SIDE,
                "for 'O-O', the rook must be located to the RIGHT of the king @E8, but was located on A8"
            ),
            Arguments.of(
                CASTLING_BLACK_QUEEN_SIDE_ROOK_ON_INCORRECT_SIDE,
                "for 'O-O-O', the rook must be located to the LEFT of the king @E8, but was located on H8"
            )
        );
    }

    @ParameterizedTest
    @MethodSource
    void castlingTest(String fenString, String expectedError) {
        Exception exception;
        if (expectedError != null) {
            exception = assertThrows(Exception.class, () -> translator.toFENPosition(fenString));
            assertEquals(expectedError, exception.getMessage());
        } else {
            assertDoesNotThrow(() -> translator.toFENPosition(fenString));
        }
    }

    public static Stream<Arguments> enPassantTest() {
        return Stream.of(
            Arguments.of(EN_PASSANT_WITH_EMPTY_FIELD, "Field E6 is empty"),
            Arguments.of(EN_PASSANT_WHITE_WITH_WHITE_PAWN, "Field E6 does not contain a BLACK pawn"),
            Arguments.of(EN_PASSANT_WHITE_WITH_BLACK_PAWN, null),
            Arguments.of(EN_PASSANT_BLACK_WITH_BLACK_PAWN, "Field E3 does not contain a WHITE pawn"),
            Arguments.of(EN_PASSANT_BLACK_WITH_WHITE_PAWN, null)
        );
    }

    @ParameterizedTest
    @MethodSource
    void enPassantTest(String fenString, String expectedError) {
        if (expectedError != null) {
            FENTranslatorException exception = assertThrows(
                FENTranslatorException.class,
                () -> translator.toFENPosition(fenString)
            );
            assertEquals(expectedError, exception.getMessage());
        } else {
            assertDoesNotThrow(() -> translator.toFENPosition(fenString));
        }
    }

}