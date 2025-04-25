package org.oberon.oss.chess.game.base;

import org.oberon.oss.chess.base.enums.CBDiagonals;
import org.oberon.oss.chess.base.enums.CBFiles;
import org.oberon.oss.chess.base.enums.CBRanks;
import org.oberon.oss.chess.base.enums.ChessField;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Lines;
import org.oberon.oss.chess.base.interfaces.LinesInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Default implementation of the {@link LinesInformation} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public final class LinesInformationImpl implements LinesInformation<Field> {
    private final Map<Field, List<Lines<Field>>> lines;

    private LinesInformationImpl() {
        Map<Field, List<Lines<Field>>> wrk = new HashMap<>();
        for (ChessField f : ChessField.values()) {
            List<Lines<Field>> list = wrk.computeIfAbsent(f, k -> new ArrayList<>());
            list.addAll(CBDiagonals.lookup(f));
            list.add(CBRanks.lookup(f));
            list.add(CBFiles.lookup(f));
        }
        lines = Map.copyOf(wrk);
    }

    @Override
    public List<Lines<Field>> getLinesInformation(Field field) {
        return lines.get(field);
    }

    private static final LinesInformation<Field> INSTANCE = new LinesInformationImpl();

    /**
     * Returns an instance of the {@link LinesInformation} interface.
     *
     * @return An implementation instance of the LinesInformation interface.
     *
     * @since 1.0.0
     */
    public static LinesInformation<Field> getInstance() {
        return INSTANCE;
    }
}
