package eu.oberon.oss.chess.game.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.enums.PieceType;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;

import java.util.Objects;

/**
 * Describes the attribute of an active piece on the chess board.
 *
 * @param <F> Represents the class type providing field information
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */

@ToString
@Getter
@Setter
public class PieceImpl<F extends Field> implements Piece<F> {
    private final PieceType  pieceType;
    private final ChessColor pieceColor;
    private       F          currentField;
    private       int        timesMoved;

    public PieceImpl(PieceType pieceType, ChessColor pieceColor, F currentField) {
        this(pieceType, pieceColor, currentField, 0);
    }

    @Override
    public @NotNull Piece<F> duplicate() {
        PieceImpl<F> fPiece = new PieceImpl<>(pieceType, pieceColor, currentField);
        fPiece.timesMoved = timesMoved;
        return fPiece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PieceImpl<?> piece = (PieceImpl<?>) o;
        return pieceType == piece.pieceType &&
               pieceColor == piece.pieceColor &&
               Objects.equals(currentField, piece.currentField);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(pieceType);
        result = 31 * result + Objects.hashCode(pieceColor);
        result = 31 * result + Objects.hashCode(currentField);
        return result;
    }

    private PieceImpl(PieceType pieceType, ChessColor pieceColor, F currentField, int timesMoved) {
        this.pieceType    = pieceType;
        this.pieceColor   = pieceColor;
        this.currentField = currentField;
        this.timesMoved   = timesMoved;
    }

    public static class PieceBuilder<F extends Field> {
        private PieceType  pieceType;
        private ChessColor pieceColor;
        private F          currentField;
        private int        timesMoved;

        public PieceBuilder<F> setChessPiece(PieceType pieceType) {
            this.pieceType = pieceType;
            return this;
        }

        public PieceBuilder<F> setPieceColor(ChessColor pieceColor) {
            this.pieceColor = pieceColor;
            return this;
        }

        public PieceBuilder<F> setCurrentField(F currentField) {
            this.currentField = currentField;
            return this;
        }

        public PieceBuilder<F> setPieceMoved() {
            this.timesMoved = -1;
            return this;
        }

        public Piece<F> build() {
            return new PieceImpl<>(pieceType, pieceColor, currentField, timesMoved);
        }
    }
}
