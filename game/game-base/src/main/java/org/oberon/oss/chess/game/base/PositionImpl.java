package org.oberon.oss.chess.game.base;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.game.base.validators.BoardValidator;
import org.oberon.oss.chess.game.base.validators.PositionValidatorImpl;
import org.oberon.oss.chess.base.interfaces.Board;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Piece;
import org.oberon.oss.chess.base.interfaces.Position;
import org.oberon.oss.chess.base.interfaces.validators.ChessValidator;

import java.util.Objects;

/**
 * Describes a position in a chess game.
 *
 * @param <F> Represents the class type providing field information
 * @param <P> A class that implements the {@link Piece} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@SuppressWarnings("unused")
@Getter
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PositionImpl<F extends Field, P extends Piece<F>, S extends Position<F, P>> implements Position<F, P> {
    private final ChessValidator<Position<F, P>> validator = PositionValidatorImpl.getInstance();

    private final Board<F, P> board;
    private final ChessColor  sideToMove;
    private final F           enPassantField;
    private final int         halveMoveClock;
    private final int         fullMoveNumber;
    private final Boolean     whiteCanCastleKingSide;
    private final Boolean     whiteCanCastleQueenSide;
    private final Boolean     blackCanCastleKingSide;
    private final Boolean     blackCanCastleQueenSide;


    @Override
    public @NotNull Position<F, P> duplicate() {
        //noinspection unchecked
        return (Position<F, P>) new PositionBuilder<>()
            .board((Board<Field, Piece<Field>>) board.duplicate())
            .sideToMove(sideToMove)
            .enPassantField(enPassantField)
            .halfMoveClock(halveMoveClock)
            .fullMoveNumber(fullMoveNumber)
            .blackCanCastleKingSide(blackCanCastleKingSide)
            .blackCanCastleQueenSide(blackCanCastleQueenSide)
            .whiteCanCastleKingSide(whiteCanCastleKingSide)
            .whiteCanCastleQueenSide(whiteCanCastleQueenSide)
            .build();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        PositionImpl<?, ?, ?> position = (PositionImpl<?, ?, ?>) o;
        return halveMoveClock == position.halveMoveClock
               && fullMoveNumber == position.fullMoveNumber
               && Objects.equals(
            board,
            position.board
        )
               && sideToMove == position.sideToMove
               && Objects.equals(enPassantField, position.enPassantField)
               && Objects.equals(whiteCanCastleKingSide, position.whiteCanCastleKingSide)
               && Objects.equals(whiteCanCastleQueenSide, position.whiteCanCastleQueenSide)
               && Objects.equals(blackCanCastleKingSide, position.blackCanCastleKingSide)
               && Objects.equals(blackCanCastleQueenSide, position.blackCanCastleQueenSide);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(board);
        result = 31 * result + Objects.hashCode(sideToMove);
        result = 31 * result + Objects.hashCode(enPassantField);
        result = 31 * result + halveMoveClock;
        result = 31 * result + fullMoveNumber;
        result = 31 * result + Objects.hashCode(whiteCanCastleKingSide);
        result = 31 * result + Objects.hashCode(whiteCanCastleQueenSide);
        result = 31 * result + Objects.hashCode(blackCanCastleKingSide);
        result = 31 * result + Objects.hashCode(blackCanCastleQueenSide);
        return result;
    }

    public static class PositionBuilder<F extends Field, P extends Piece<F>> {
        private Board<F, P> board;
        private ChessColor  sideToMove;
        private F           enPassantField;
        private int         halfMoveClock;
        private int         fullMoveNumber;
        private Boolean     whiteCanCastleKingSide;
        private Boolean     whiteCanCastleQueenSide;
        private Boolean     blackCanCastleKingSide;
        private Boolean     blackCanCastleQueenSide;

        public PositionBuilder<F, P> board(Board<F, P> board) {
            this.board = board;
            return this;
        }

        public PositionBuilder<F, P> sideToMove(ChessColor sideToMove) {
            this.sideToMove = sideToMove;
            return this;
        }

        public PositionBuilder<F, P> enPassantField(F enPassantField) {
            this.enPassantField = enPassantField;
            return this;
        }

        public PositionBuilder<F, P> halfMoveClock(int halfMoveClock) {
            this.halfMoveClock = halfMoveClock;
            return this;
        }

        public PositionBuilder<F, P> fullMoveNumber(int fullMoveNumber) {
            this.fullMoveNumber = fullMoveNumber;
            return this;
        }

        public PositionBuilder<F, P> whiteCanCastleKingSide(Boolean whiteCanCastleKingSide) {
            this.whiteCanCastleKingSide = whiteCanCastleKingSide;
            return this;
        }

        public PositionBuilder<F, P> whiteCanCastleQueenSide(Boolean whiteCanCastleQueenSide) {
            this.whiteCanCastleQueenSide = whiteCanCastleQueenSide;
            return this;
        }


        public PositionBuilder<F, P> blackCanCastleKingSide(Boolean blackCanCastleKingSide) {
            this.blackCanCastleKingSide = blackCanCastleKingSide;
            return this;
        }

        public PositionBuilder<F, P> blackCanCastleQueenSide(Boolean blackCanCastleQueenSide) {
            this.blackCanCastleQueenSide = blackCanCastleQueenSide;
            return this;
        }

        public Position<F, P> build() {
            ChessValidator<Board<Field, Piece<Field>>> instance = BoardValidator.getInstance();

            return new PositionImpl<>(
                board,
                sideToMove,
                enPassantField,
                halfMoveClock,
                fullMoveNumber,
                whiteCanCastleKingSide,
                whiteCanCastleQueenSide,
                blackCanCastleKingSide,
                blackCanCastleQueenSide
            );
        }
    }
}
