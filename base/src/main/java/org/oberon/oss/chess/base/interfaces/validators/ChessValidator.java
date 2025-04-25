package org.oberon.oss.chess.base.interfaces.validators;

import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.interfaces.ValidatorResult;

/**
 * Contract for classes that want to validate castling for a specific setting
 *
 * @param <S> Specifies the source against wich the castling validation should take place.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public interface ChessValidator<S> {
    /**
     * Generic definition of a validation
     *
     * @param source The source to perform the validation on
     *
     * @return ChessValidator result indicating if the source is considered valid. If not ({@link ValidatorResult#isValid()} returns
     *     <b>false</b>), the {@link ValidatorResult#getMessages()} will return a non-empty list of message(s) describing the
     *     errors that were found.
     *
     * @since 1.0.0
     */
    ValidatorResult validate(@NotNull S source);
}
