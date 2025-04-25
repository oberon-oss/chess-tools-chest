package org.oberon.oss.chess.base.exceptions;

/**
 * Exception that can be thrown in case validation of a chess position fails.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */

public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String message) {
        super(message);
    }
}
