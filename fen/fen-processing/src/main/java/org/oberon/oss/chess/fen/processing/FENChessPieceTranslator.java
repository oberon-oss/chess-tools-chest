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

import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Piece;
import org.oberon.oss.chess.base.enums.PieceType;

import static org.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static org.oberon.oss.chess.base.enums.PieceType.*;


/**
 * Extends the information contained in the {@link PieceType} enumeration by adding the representation of the black and white pieces
 * as defined in a FEN setup string.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public class FENChessPieceTranslator {

    private FENChessPieceTranslator() {

    }

    public static PieceType translate(@NotNull String fenPieceType) {
        return switch (fenPieceType.toLowerCase()) {
            case "k" -> KING;
            case "q" -> QUEEN;
            case "r" -> ROOK;
            case "b" -> BISHOP;
            case "n" -> KNIGHT;
            case "p" -> PAWN;
            default -> throw new IllegalArgumentException("Parameter 'fenPieceType': invalid type was specified: " + fenPieceType);
        };
    }

    /**
     * Returns the correct single character representation of the provided pieces based on its type and color.
     *
     * @param piece The piece to return the character representation for.
     *
     * @return The character representation of the provided piece
     *
     * @since 1.0.0
     */
    public static String getFENCharacterForPiece(@NotNull Piece<? extends Field> piece) {
        if (piece.getPieceType() == PAWN) {
            return piece.getPieceColor() == BLACK
                   ? "p"
                   : "P";
        } else {
            return piece.getPieceColor() == BLACK
                   ? piece.getPieceType().getShortHandName().toLowerCase()
                   : piece.getPieceType().getShortHandName();
        }
    }
}
