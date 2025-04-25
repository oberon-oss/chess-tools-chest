package eu.oberon.oss.chess.base.exceptions;

/**
 * @author Fabien H. Dumay
 */
public class BoardValidationException extends RuntimeException {
    public BoardValidationException(String message) {
        super(message);
    }
}
