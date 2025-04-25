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


import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.Position;

/**
 * Allows the querying of the information extracted from a FEN setup string.
 *
 * @param <F> interface or class that extends the Field Interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public interface FENPosition<F extends Field, P extends Piece<F>> {
    Position<F, P> createPosition();
}
