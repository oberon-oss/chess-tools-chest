package eu.oberon.oss.chess.base.interfaces;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Structure containing the results of a validation operation.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public interface ValidatorResult {
    /**
     * States the result of a validation operation.
     *
     * @return <b>True</b> if the validation operation was successful, or <b>false</b> otherwise.
     *
     * @since 1.0.0
     */
    boolean isValid();

    /**
     * Returns a list of 0 or more messages providing (error) information of the validation operation.
     *
     * @return A non-null list of message(s).
     *
     * @since 1.0.0
     */
    @NotNull List<String> getMessages();
}
