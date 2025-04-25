package org.oberon.oss.chess.game.base.validators;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.interfaces.*;
import org.oberon.oss.chess.base.interfaces.validators.ChessValidator;

/**
 * @param <F> Represents the class type providing field information
 * @param <P> A class that implements the {@link Piece} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@Log4j2
public class PositionValidatorImpl<F extends Field, P extends Piece<F>, S extends Position<F, P>> implements ChessValidator<S> {

    private static final ChessValidator<Position<Field, Piece<Field>>> INSTANCE =
        new PositionValidatorImpl<>();

    private PositionValidatorImpl() {

    }

    public static <F extends Field, P extends Piece<F>, S extends Position<F, P>> ChessValidator<S> getInstance() {
        //noinspection unchecked
        return (ChessValidator<S>) INSTANCE;
    }

    @Override
    public ValidatorResult validate(@NotNull S position) {
        //noinspection unchecked
        return BoardValidator.getInstance().validate((Board<Field, Piece<Field>>) position.board());
    }
}
