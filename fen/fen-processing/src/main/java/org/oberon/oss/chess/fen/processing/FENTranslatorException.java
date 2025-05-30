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

import org.oberon.oss.chess.base.exceptions.ValidationResultException;
import org.oberon.oss.chess.base.interfaces.ValidatorResult;

/**
 * Exception intended for implementations of the {@link FENPositionTranslator} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public class FENTranslatorException extends ValidationResultException {
    public FENTranslatorException(String message) {
        super(message, null);
    }

    public FENTranslatorException(String message, ValidatorResult validatorResult) {
        super(message, validatorResult);
    }
}
