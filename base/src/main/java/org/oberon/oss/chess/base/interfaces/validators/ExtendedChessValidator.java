package org.oberon.oss.chess.base.interfaces.validators;

import org.oberon.oss.chess.base.interfaces.ValidatorResult;

/**
 * @param <S> Specifies the source against wich the castling validation should take place.
 * @param <V> Specifies the class of the object that should control the actual validation to take place.
 *
 * @author Fabien H. Dumay
 */
public interface ExtendedChessValidator<S, V> {
    ValidatorResult validate(S source, V validationEngine);
}
