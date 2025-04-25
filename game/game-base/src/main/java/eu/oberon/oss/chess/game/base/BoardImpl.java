package eu.oberon.oss.chess.game.base;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.enums.PieceType;
import eu.oberon.oss.chess.base.interfaces.Board;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;

import java.util.HashMap;
import java.util.Map;

/**
 * default implementation of the {@link Board} interface
 *
 * @param <F> Represents the class type providing field information
 * @param <P> A class that implements the {@link Piece} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */

@Getter
@Accessors(fluent = true)
@SuppressWarnings({"unused"})
public class BoardImpl<F extends Field, P extends Piece<F>> implements Board<F, P> {
    private final Map<F, P> pieceMapping;

    private BoardImpl(final Map<F, P> pieceMapping) {
        this.pieceMapping = Map.copyOf(pieceMapping);
    }

    @Override
    public Map<F, P> getPiecesForColorAndType(ChessColor color, PieceType pieceType) {
        Map<F, P> result = new HashMap<>();
        for (Map.Entry<F, P> entry : pieceMapping.entrySet()) {
            P piece = entry.getValue();
            if (piece.getPieceType() == pieceType && piece.getPieceColor() == color) {
                result.put(entry.getKey(), piece);
            }
        }
        return result;
    }

    @Override
    public Map<F, P> getPiecesForColor(ChessColor color) {
        Map<F, P> result = new HashMap<>();
        for (Map.Entry<F, P> entry : pieceMapping.entrySet()) {
            P piece = entry.getValue();
            if (piece.getPieceColor() == color) {
                result.put(entry.getKey(), piece);
            }
        }
        return result;
    }

    @Override
    public Map<F, P> getPieceMapping() {
        return pieceMapping;
    }

    @Override
    public boolean fieldContainsPiece(F field, PieceType pieceType, ChessColor color) {
        P piece = pieceMapping.get(field);
        return piece != null && piece.getPieceType() == pieceType && piece.getPieceColor() == color;
    }

    @Override
    public @Nullable P getPieceOnField(F field) {
        return pieceMapping.get(field);
    }

    @Override
    public @NotNull Board<F, P> duplicate() {
        BoardBuilder<Field, Piece<Field>> builder = new BoardBuilder<>();

        for (P piece : pieceMapping.values()) {
            //noinspection unchecked
            builder.addPiece((Piece<Field>) piece.duplicate());
        }
        //noinspection unchecked
        return (Board<F, P>) builder.build();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        BoardImpl<?, ?> board = (BoardImpl<?, ?>) o;
        return pieceMapping.equals(board.pieceMapping);
    }

    @Override
    public int hashCode() {
        return pieceMapping.hashCode();
    }

    /**
     * @author Fabien H. Dumay
     */
    public static class BoardBuilder<F extends Field, P extends Piece<F>> {
        private final Map<F, P> pieceMap = new HashMap<>();

        public BoardBuilder<F, P> copyFromBoard(Board<F, P> source) {
            pieceMap.putAll(source.getPieceMapping());
            return this;
        }

        public BoardBuilder<F, P> addPiece(final P piece) {
            pieceMap.put(piece.getCurrentField(), piece);
            return this;
        }

        public Board<F, P> build() {
            return new BoardImpl<>(pieceMap);
        }
    }
}
