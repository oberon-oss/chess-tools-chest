package eu.oberon.oss.chess.base.exceptions;

import lombok.Getter;
import eu.oberon.oss.chess.base.interfaces.ValidatorResult;

/**
 * @author Fabien H. Dumay
 */
@Getter
public class ValidationResultException extends RuntimeException {
    private final transient ValidatorResult validatorResult;

    public ValidationResultException(String msg, ValidatorResult validatorResult) {
        super(msg);
        this.validatorResult = validatorResult;
    }
}
