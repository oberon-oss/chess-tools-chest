package org.oberon.oss.chess.base.interfaces;

import org.jetbrains.annotations.NotNull;

/**
 * Interface to create (deep) copies of data structures used in the tool chest.
 *
 * @param <O> Specifies the type of object that can be duplicated by an implementation of this inteface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public interface Duplicator<O> {
    /**
     * Duplicates an object.
     *
     * @return the duplicated object.
     *
     * @since 1.0.0
     */
    @NotNull O duplicate();
}
