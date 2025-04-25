package eu.oberon.oss.chess.game.base.validators;

import org.jetbrains.annotations.NotNull;
import eu.oberon.oss.chess.base.enums.CBRanks;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.exceptions.BoardValidationException;
import eu.oberon.oss.chess.game.base.ValidatorResultImpl;
import eu.oberon.oss.chess.base.interfaces.Board;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.ValidatorResult;
import eu.oberon.oss.chess.base.interfaces.validators.ChessValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;

/**
 * @param <F> Represents the class type providing field information
 * @param <P> A class that implements the {@link Piece} interface.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public class BoardValidator<F extends Field, P extends Piece<F>, S extends Board<F, P>> implements ChessValidator<S> {
    private static final ChessValidator<Board<Field, Piece<Field>>> INSTANCE = new BoardValidator<>();

    public static <F extends Field, P extends Piece<F>, S extends Board<F, P>> ChessValidator<S> getInstance() {
        //noinspection unchecked
        return (ChessValidator<S>) INSTANCE;
    }

    private BoardValidator() {
    }

    @Override
    public ValidatorResult validate(@NotNull S board) {
        List<String> messages = new ArrayList<>();

        int pieceCount = board.getPieceMapping().size();
        if (pieceCount < 2) {
            messages.add("Board must contain at least 2 pieces. pieces in position: " + pieceCount);
        } else if (pieceCount > 32) {
            messages.add("Board must contain no more than 32 pieces, pieces in position:" + pieceCount);
        }

        validatePieces(board, WHITE, messages);
        validatePieces(board, BLACK, messages);

        return new ValidatorResultImpl(messages);
    }


    private void validatePieces(Board<F, P> board, ChessColor color, List<String> messages) {
        List<P> pieces = new ArrayList<>();

        for (Map.Entry<F, P> entry : board.getPieceMapping().entrySet()) {
            if (entry.getValue().getPieceColor() == color) {
                pieces.add(entry.getValue());
            }
        }

        if (pieces.size() > 16) {
            messages.add("There can only be 16 "
                         + color.name().toLowerCase()
                         + " pieces on the board, "
                         + pieces.size()
                         + " where found");
        } else {

            String colorName = color.name().toLowerCase();

            int kingCount   = 0;
            int queenCount  = 0;
            int rookCount   = 0;
            int bishopCount = 0;
            int knightCount = 0;
            int pawnCount   = 0;

            for (P piece : pieces) {
                switch (piece.getPieceType()) {
                    case KING -> kingCount++;
                    case QUEEN -> ++queenCount;
                    case ROOK -> ++rookCount;
                    case BISHOP -> ++bishopCount;
                    case KNIGHT -> ++knightCount;
                    case PAWN -> {
                        checkPawnRank(piece, colorName);
                        ++pawnCount;
                    }
                }
            }
            if (kingCount != 1) {
                messages.add("Expected 1 " + colorName + " king, but found " + kingCount);
            } else {
                validPieceCount(colorName, "pawns", pawnCount, 8);
                validPieceCount(colorName, "queens", queenCount, 9);
                validPieceCount(colorName, "queens", queenCount, 9);
                validPieceCount(colorName, "rooks", rookCount, 9);
                validPieceCount(colorName, "bishops", bishopCount, 9);
                validPieceCount(colorName, "knights", knightCount, 9);
            }
        }
    }

    private void checkPawnRank(P piece, String colorName) {
        int rank = piece.getCurrentField().getRank();
        if (rank == 1 || rank == 8) {
            throw new BoardValidationException(colorName + " pawn detected on invalid rank " + CBRanks.getRank(rank));
        }
    }

    private void validPieceCount(String colorName, String name, int pieceCount, int maxPieceCount) {
        if (pieceCount > maxPieceCount) {
            throw new BoardValidationException(String.format(
                "Number of %s %s (%d) exceeds maximum of %d",
                colorName,
                name,
                pieceCount,
                maxPieceCount
            ));
        }
    }
}
