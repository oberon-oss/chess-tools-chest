package eu.oberon.oss.chess.move.generator;

import eu.oberon.oss.chess.base.interfaces.*;
import eu.oberon.oss.chess.game.data.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author Fabien H. Dumay
 */
public class ChessGameTestImpl implements ChessGame<Field, Piece<Field>> {
    private final GameStartPosition<Field,Piece<Field>> startPosition;

    public ChessGameTestImpl(GameStartPosition<Field, Piece<Field>> startPosition) {
        this.startPosition = startPosition;
        currentPosition = startPosition.getStartPosition();
    }

    @Getter
    @Setter
    private Position<Field,Piece<Field>> currentPosition;

    @Override
    public BasicGameDetails getGameDetails() {
        return new BasicGameDetails() {
            @Override
            public Player getPlayerWhitePieces() {
                return () -> "white player";
            }

            @Override
            public Player getPlayerBlackPieces() {
                return () -> "black player";
            }

            @Override
            public ZonedDateTime gameStartingDate() {
                return ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
            }

            @Override
            public GameResult getGameResult() {
                return GameResult.GAME_STILL_ONGOING;
            }

            @Override
            public Site getSite() {
                return () -> "site";
            }

            @Override
            public Event getEvent() {
                return () -> "event";
            }

            @Override
            public Round getRound() {
                return () -> "round";
            }
        };
    }

    @Override
    public GameStartPosition<Field, Piece<Field>> getStartPosition() {
        return startPosition;
    }

    @Override
    public ChessClock getWhiteChessClock() {
        return null;
    }

    @Override
    public ChessClock getBlackChessClock() {
        return null;
    }

    @Override
    public List<MoveListEntry<Field, Piece<Field>>> getMoveList() {
        return List.of();
    }
}
