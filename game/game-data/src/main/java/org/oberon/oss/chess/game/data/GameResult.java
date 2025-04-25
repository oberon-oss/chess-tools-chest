package org.oberon.oss.chess.game.data;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fabien H. Dumay
 */
@Getter
public enum GameResult {
    WON_BY_WHITE("1-0"),
    WON_BY_BLACK("0-1"),
    ENDED_IN_DRAW("1/2-1/2"),
    GAME_STILL_ONGOING("*");

    private final        String                  pgnRepresentation;
    private static final Map<String, GameResult> LOOKUP_MAP;

    static {
        LOOKUP_MAP = new HashMap<>();
        for (GameResult value : GameResult.values()) {
            LOOKUP_MAP.put(value.pgnRepresentation, value);
        }
    }

    GameResult(String pgnRepresentation) {
        this.pgnRepresentation = pgnRepresentation;
    }

    public static GameResult getByPgnRepresentation(String pgnRepresentation) {
        return LOOKUP_MAP.get(pgnRepresentation);
    }
}
