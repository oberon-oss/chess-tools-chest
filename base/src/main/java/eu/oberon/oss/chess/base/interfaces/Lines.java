package eu.oberon.oss.chess.base.interfaces;

import eu.oberon.oss.chess.base.enums.MoveDirection;

import java.util.List;

/**
 * Provides information on various 'virtual lines' that can be defined on a chess board. These lines are used when expressing
 * information in lines from
 * <ul>
 * <li>left to right ({@link MoveDirection#WEST} --> {@link MoveDirection#WEST})</li>
 * <li>top to bottom ({@link MoveDirection#NORTH} --> {@link MoveDirection#SOUTH})</li>
 * <li>bottom left to upper right ({@link MoveDirection#SOUTH_WEST} --> {@link MoveDirection#NORTH_EAST})</li>
 * <li>top left to bottom right ({@link MoveDirection#NORTH_WEST} --> {@link MoveDirection#SOUTH_EAST})</li>
 * </ul>
 *
 * @param <F> Designates an Implementation of the {@link Field} interface that identifies the fields on the chess board.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public interface Lines<F extends Field> {
    /**
     * Returns the name of the line.
     *
     * @return name of the line
     *
     * @since 1.0.0
     */
    String getName();

    /**
     * Returns the MoveDirection of the Lines instance.
     *
     * @return a value from the {@link MoveDirection} interface.
     *     <p>
     *     The value {@link MoveDirection#NONE} should normally not be returned by implementing classes. If the implementing class
     *     needs to return this value, it is strongly advised to clearly document that fact, along with the reason why.
     *
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    MoveDirection getMoveDirection();

    /**
     * Returns the field(s) associated with the line.
     *
     * @return A list of 1 or more fields that are part of the line. The fields should be ordered in the order that would match the
     *     order specified by the value returned by the {@link #getMoveDirection()} method.
     *
     * @since 1.0.0
     */
    List<F> getFields();
}
