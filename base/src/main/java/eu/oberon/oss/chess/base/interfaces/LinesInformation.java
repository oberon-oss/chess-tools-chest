package eu.oberon.oss.chess.base.interfaces;

import java.util.List;

/**
 * Provides information on {@link Field} and {@link Lines}
 *
 * @param <F> Designates an Implementation of the {@link Field} interface that identifies the fields on the chess board.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public interface LinesInformation<F extends Field> {

    /**
     * Returns a list of lines that the specified field is part of.
     *
     * @param field The field for which to retrieve the lines it is part of
     *
     * @return List with 1 or more lines that the field is part of.
     *
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    List<Lines<F>> getLinesInformation(F field);
}
