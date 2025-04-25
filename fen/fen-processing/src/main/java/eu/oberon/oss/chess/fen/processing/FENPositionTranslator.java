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

import org.jetbrains.annotations.NotNull;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.Position;


/**
 * Provides services to create a {@link FENPosition} object from a setup string, or vice versa.
 *
 * @param <F> interface or class that extends the Field Interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public interface FENPositionTranslator<F extends Field, P extends Piece<F>> {
    /**
     * Represents chess board at the start of a chess game.
     *
     * @since 1.0.0
     */
    String INITIAL_POSITION_FEN_SETUP_STRING = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w QKqk - 0 0";

    /**
     * Constructs a {@link FENPosition} object from the provided setup string.
     *
     * @param fenPositionSetupString The string to create the FENPosition object from.
     *
     * @return The FENPosition
     *
     * @throws FENTranslatorException if an error is detected while processing the setup string.
     * @since 1.0.0
     */
    FENPosition<F, P> toFENPosition(@NotNull String fenPositionSetupString);

    /**
     * Converts the provided position into the equivalent FEN string representation.
     *
     * @param position The position to create the setup string for
     *
     * @return The resulting string object.
     *
     * @since 1.0.0
     */
    String toFENString(@NotNull Position<F, P> position);
}
