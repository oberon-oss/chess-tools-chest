package org.oberon.oss.chess.base.interfaces;

import org.oberon.oss.chess.base.enums.ChessColor;

import java.util.List;

/**
 * @author Fabien H. Dumay
 * @since 2.0.0
 */
public interface ChessClock {
    ChessColor getColor();

    void start();

    void stop();

    int getCurrentTimeControl();

    List<TimeControl> timeControls();
}
