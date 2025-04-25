package org.oberon.oss.chess.base.interfaces;

import java.util.Iterator;

/**
 * Extends the basic Iterator class with a method to skip fields.
 *
 * @param <F> Represents the class type providing field information
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public interface FieldIterator<F extends Field> extends Iterator<F> {
    /**
     * Returns the number of fields present in the iterator.
     *
     * @return The number of fields
     *
     * @since 1.0.0
     */
    int getFieldCount();

    /**
     * Default implementation, throws a {@link UnsupportedOperationException}. Implementing classes should override this method if a
     * useful skipping method is provided.
     *
     * @param fieldsToSkip Number of fields to skip
     *
     * @throws UnsupportedOperationException If not supported by the implementing class.
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    default void skipFields(int fieldsToSkip) {
        throw new UnsupportedOperationException("skipFields");
    }
}
