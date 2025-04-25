package eu.oberon.oss.chess.game.base;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import eu.oberon.oss.chess.base.enums.CBAllFields;
import eu.oberon.oss.chess.base.enums.CBFiles;
import eu.oberon.oss.chess.base.enums.CBRanks;
import eu.oberon.oss.chess.base.enums.ChessField;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.FieldIterator;
import eu.oberon.oss.chess.base.interfaces.Lines;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Math.abs;

/**
 * Provides access to various iterators of implementations of the {@link Field} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@Log4j2
public class FieldIteratorImpl<F extends Field> implements FieldIterator<F> {
    private final List<F> fields;
    private       int     index = 0;

    private FieldIteratorImpl(@NotNull Lines<F> line) {
        fields = line.getFields();
    }

    private FieldIteratorImpl(@NotNull Lines<F> line, F start, F end, boolean inclusive) {
        int foundFirst = -1;
        int foundLast  = -1;

        //noinspection unchecked
        F[] workList = (F[]) line.getFields().toArray(new Field[0]);

        for (int i = 0; i < workList.length; i++) {
            if (workList[i].equals(start)) {
                foundFirst = i;
            }
            if (workList[i].equals(end)) {
                foundLast = i;
            }
        }

        if (foundFirst == -1) {
            throw new IllegalArgumentException(start.getName() + " not in " + line.getName());
        }
        if (foundLast == -1) {
            throw new IllegalArgumentException(end.getName() + " not in " + line.getName());
        }

        // If the fields are adjacent, there are no intermediate fields, so short-circuit the iterator with zero elements.
        if (abs(foundFirst - foundLast) == 1) {
            fields = handleAdjacentFields(workList, foundFirst, foundLast, inclusive);
        } else {
            fields = handleRegularRange(workList, foundFirst, foundLast, inclusive, start);
        }
    }

    private List<F> handleRegularRange(F[] workList, int foundFirst, int foundLast, boolean inclusive, F start) {
        if (foundFirst > foundLast) {
            int swap = foundFirst;
            foundFirst = foundLast;
            foundLast  = swap;
        }

        if (!inclusive) {
            foundFirst++;
            foundLast--;
        }


        if (foundFirst > foundLast) {
            throw new IllegalArgumentException("Start and end fields are equal "
                                               + start.getName()
                                               + " (inclusive: "
                                               + inclusive
                                               + ")");
        }
        if (foundFirst == foundLast) {
            return List.of(workList[foundFirst]);
        }

        return List.of(Arrays.copyOfRange(workList, foundFirst, foundLast + 1));
    }

    private List<F> handleAdjacentFields(F[] fieldArray, int first, int last, boolean inclusive) {
        if (inclusive) {
            return List.of(fieldArray[first], fieldArray[last]);
        } else {
            return List.of();
        }
    }

    @Override
    public int getFieldCount() {
        return fields.size();
    }

    @Override
    public boolean hasNext() {
        return index < fields.size();
    }

    @Override
    public F next() {
        if (index == fields.size()) throw new NoSuchElementException();
        LOGGER.trace("Current field: {}", fields.get(index));
        return fields.get(index++);
    }


    /**
     * {@summary}
     * <p>
     * Provides a method to move the index for the iterator forward to instruct the iterator to skip a specified number of fields.
     *
     * @throws IllegalArgumentException if the skip count {@literal <= 1} or if the current index + skip count would refer to an
     *                                  element outside the underlying data structure
     */
    @Override
    public void skipFields(int skipCount) {
        if (skipCount < 1 || skipCount + index > fields.size()) {
            throw new IllegalArgumentException("Invalid skip count: " + skipCount);
        }
        index += skipCount - 1;
    }

    /**
     * Returns an iterator over the fields on the chess board, as enumerated by the {@link ChessField} enum.
     * <p>
     * The returned iterator will start with the field {@link ChessField#A8 A8}, and will end with the field
     * {@link ChessField#H1 H1}
     *
     * @return An iterator over the chess boards fields from {@link ChessField#A8 A8}...{@link ChessField#H1 H1}
     *
     * @since 1.0.0
     */
    public static @NotNull <F extends Field> FieldIterator<F> chessBoardFieldIterator() {
        //noinspection unchecked
        return (FieldIterator<F>) new FieldIteratorImpl<>(CBAllFields.ALL_FIELDS);
    }

    /**
     * Returns an iterator for the fields in a rank (horizontal line) of a chess board.
     * <p>
     * The iterator will return the fields in the order from A...H
     *
     * @param rank The rank to return an iterator for. Must be in the range 1...8
     *
     * @return an iterator over the fields in the specified rank, ordered from A...H
     *
     * @since 1.0.0
     */
    public static @NotNull <F extends Field> FieldIterator<F> fieldIterator(@NotNull Integer rank) {
        //noinspection unchecked
        return (FieldIterator<F>) new FieldIteratorImpl<>(CBRanks.getRank(rank));
    }

    /**
     * Returns an iterator for the fields in a file (vertical line) of a chess board.
     * <p>
     * The iterator will return the fields in the order from 8...1
     *
     * @param file The file to return an iterator for. Must be in the range A...H
     *
     * @return an iterator over the fields in the specified file, ordered from 8...1
     *
     * @since 1.0.0
     */
    public static @NotNull <F extends Field> FieldIterator<F> fieldIterator(@NotNull String file) {
        //noinspection unchecked
        return (FieldIterator<F>) new FieldIteratorImpl<>(CBFiles.getFile(file));
    }

    /**
     * Returns an iterator for the fields in a {@link Lines} instance, optionally limited by the start, end and inclusive parameter
     * values.
     *
     * @param line      The instance of the line to create the iterator for.
     * @param start     The start field. If {@literal <null>} is specified, the first field of the {@link Lines#getFields()} will be
     *                  assumed.
     * @param end       the end field. If {@literal <null>} is specified, the last field of the {@link Lines#getFields()} will be
     *                  assumed.
     * @param inclusive If specified as <b>true</b>, the start and end field will be included in the iterator. If false, they will
     *                  not be part of the iterator
     *
     * @return an iterator over the fields in the specified file, ordered from 8...1
     *
     * @since 1.0.0
     */
    public static @NotNull <F extends Field> FieldIterator<F> fieldIterator(@NotNull Lines<F> line, @NotNull F start, @NotNull F end, boolean inclusive) {
        return new FieldIteratorImpl<>(line, start, end, inclusive);
    }
}
