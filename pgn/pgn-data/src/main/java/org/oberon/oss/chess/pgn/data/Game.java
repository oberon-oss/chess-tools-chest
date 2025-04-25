package org.oberon.oss.chess.pgn.data;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.oberon.oss.chess.pgn.data.element.ElementSequence;
import eu.oberon.oss.chess.game.data.GameResult;
import org.oberon.oss.chess.pgn.data.tags.TagSection;


@Builder
@Getter
@ToString
public class Game {
    private final TagSection      tagSection;
    private final ElementSequence elementSequence;
    private final GameResult      gameResult;
}
