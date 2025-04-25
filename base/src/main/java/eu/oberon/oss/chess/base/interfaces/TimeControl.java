package eu.oberon.oss.chess.base.interfaces;

import java.time.Duration;

/**
 * @author Fabien H. Dumay
 */
public interface TimeControl {
    String getName();

    int numberOfRequiredMoves();

    Duration timeControlDuration();
}
