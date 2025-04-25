/*
MIT No Attribution

Copyright 2024 Fabien H. Dumay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package eu.oberon.oss.chess.fen.processing;

import eu.oberon.oss.chess.base.interfaces.*;
import lombok.Builder;
import lombok.Singular;
import lombok.experimental.Accessors;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.game.base.PositionImpl.PositionBuilder;

import java.util.Objects;
import java.util.Set;

import static eu.oberon.oss.chess.base.enums.CastlingType.KING_SIDE;
import static eu.oberon.oss.chess.base.enums.CastlingType.QUEEN_SIDE;
import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;
import static eu.oberon.oss.chess.base.interfaces.CastlingConfiguration.isCastlingConfigurationPresent;

/**
 * Default implementation of the {@link FENPosition} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@Accessors(fluent = true)
@Builder(builderClassName = "FENPositionBuilder")
public final class FENPositionImpl<F extends Field, P extends Piece<F>> implements FENPosition<F, P> {
    private final Board<F, P> board;
    private final int halveMoveClock;
    private final int fullMoveNumber;
    private final ChessColor sideToMove;
    private final Field enPassantField;
    @Singular
    private final Set<CastlingConfiguration<F>> castlingConfigurations;

    /**
     *
     */
    public FENPositionImpl(Board<F, P> board, int halveMoveClock,
                           int fullMoveNumber, ChessColor sideToMove,
                           Field enPassantField, Set<CastlingConfiguration<F>> castlingConfigurations) {
        this.board = board;
        this.halveMoveClock = halveMoveClock;
        this.fullMoveNumber = fullMoveNumber;
        this.sideToMove = sideToMove;
        this.enPassantField = enPassantField;
        this.castlingConfigurations = castlingConfigurations;
    }

    @Override
    public Position<F, P> createPosition() {
        //noinspection unchecked
        return (Position<F, P>) new PositionBuilder<>()
                .board((Board<Field, Piece<Field>>) board)
                .sideToMove(sideToMove)
                .fullMoveNumber(fullMoveNumber)
                .halfMoveClock(halveMoveClock)
                .enPassantField(enPassantField)
                .blackCanCastleKingSide(isCastlingConfigurationPresent(castlingConfigurations, BLACK, KING_SIDE))
                .blackCanCastleQueenSide(isCastlingConfigurationPresent(castlingConfigurations, BLACK, QUEEN_SIDE))
                .whiteCanCastleKingSide(isCastlingConfigurationPresent(castlingConfigurations, WHITE, KING_SIDE))
                .whiteCanCastleQueenSide(isCastlingConfigurationPresent(castlingConfigurations, WHITE, QUEEN_SIDE))
                .build();
    }

    public Board<F, P> board() {
        return board;
    }

    public int halveMoveClock() {
        return halveMoveClock;
    }

    public int fullMoveNumber() {
        return fullMoveNumber;
    }

    public ChessColor sideToMove() {
        return sideToMove;
    }

    public Field enPassantField() {
        return enPassantField;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        FENPositionImpl<?, ?> that = (FENPositionImpl<?, ?>) o;
        return halveMoveClock == that.halveMoveClock && fullMoveNumber == that.fullMoveNumber && Objects.equals(
                board,
                that.board
        )
                && sideToMove == that.sideToMove
                && Objects.equals(enPassantField, that.enPassantField)
                && Objects.equals(castlingConfigurations, that.castlingConfigurations);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(board);
        result = 31 * result + halveMoveClock;
        result = 31 * result + fullMoveNumber;
        result = 31 * result + Objects.hashCode(sideToMove);
        result = 31 * result + Objects.hashCode(enPassantField);
        result = 31 * result + Objects.hashCode(castlingConfigurations);
        return result;
    }

    @Override
    public String toString() {
        return "FENPositionImpl[" +
                "board=" + board + ", " +
                "halveMoveClock=" + halveMoveClock + ", " +
                "fullMoveNumber=" + fullMoveNumber + ", " +
                "sideToMove=" + sideToMove + ", " +
                "enPassantField=" + enPassantField + ']';
    }

}
