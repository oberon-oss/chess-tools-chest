package eu.oberon.oss.chess.move.generator;

import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.Position;
import eu.oberon.oss.chess.game.base.BoardImpl;
import eu.oberon.oss.chess.game.base.PieceImpl;
import eu.oberon.oss.chess.game.base.PositionImpl;

import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;
import static eu.oberon.oss.chess.base.enums.ChessField.*;
import static eu.oberon.oss.chess.base.enums.PieceType.*;

/**
 * @author Fabien H. Dumay
 */
public class Util {

    protected static Position<Field, Piece<Field>> getInitialPosition() {
        BoardImpl.BoardBuilder<Field, Piece<Field>> builder = new BoardImpl.BoardBuilder<>();
        getInitialPiecesForWhite(getInitialPiecesForBlack(builder));
        return new PositionImpl.PositionBuilder<>()
            .board(builder.build())
            .sideToMove(ChessColor.WHITE)
            .blackCanCastleKingSide(true)
            .blackCanCastleQueenSide(true)
            .whiteCanCastleKingSide(true)
            .whiteCanCastleQueenSide(true)
            .build();
    }

    protected static BoardImpl.BoardBuilder<Field, Piece<Field>> getInitialPiecesForWhite(BoardImpl.BoardBuilder<Field, Piece<Field>> builder) {
        return builder
            .addPiece(new PieceImpl<>(PAWN, WHITE, A2))
            .addPiece(new PieceImpl<>(PAWN, WHITE, B2))
            .addPiece(new PieceImpl<>(PAWN, WHITE, C2))
            .addPiece(new PieceImpl<>(PAWN, WHITE, D2))
            .addPiece(new PieceImpl<>(PAWN, WHITE, E2))
            .addPiece(new PieceImpl<>(PAWN, WHITE, F2))
            .addPiece(new PieceImpl<>(PAWN, WHITE, G2))
            .addPiece(new PieceImpl<>(PAWN, WHITE, H2))

            .addPiece(new PieceImpl<>(ROOK, WHITE, A1))
            .addPiece(new PieceImpl<>(KNIGHT, WHITE, B1))
            .addPiece(new PieceImpl<>(BISHOP, WHITE, C1))
            .addPiece(new PieceImpl<>(QUEEN, WHITE, D1))
            .addPiece(new PieceImpl<>(KING, WHITE, E1))
            .addPiece(new PieceImpl<>(BISHOP, WHITE, F1))
            .addPiece(new PieceImpl<>(KNIGHT, WHITE, G1))
            .addPiece(new PieceImpl<>(ROOK, WHITE, H1));
    }

    protected static BoardImpl.BoardBuilder<Field, Piece<Field>> getInitialPiecesForBlack(BoardImpl.BoardBuilder<Field, Piece<Field>> builder) {
        return builder
            .addPiece(new PieceImpl<>(ROOK, BLACK, A8))
            .addPiece(new PieceImpl<>(KNIGHT, BLACK, B8))
            .addPiece(new PieceImpl<>(BISHOP, BLACK, C8))
            .addPiece(new PieceImpl<>(QUEEN, BLACK, D8))
            .addPiece(new PieceImpl<>(KING, BLACK, E8))
            .addPiece(new PieceImpl<>(BISHOP, BLACK, F8))
            .addPiece(new PieceImpl<>(KNIGHT, BLACK, G8))
            .addPiece(new PieceImpl<>(ROOK, BLACK, H8))

            .addPiece(new PieceImpl<>(PAWN, BLACK, A7))
            .addPiece(new PieceImpl<>(PAWN, BLACK, B7))
            .addPiece(new PieceImpl<>(PAWN, BLACK, C7))
            .addPiece(new PieceImpl<>(PAWN, BLACK, D7))
            .addPiece(new PieceImpl<>(PAWN, BLACK, E7))
            .addPiece(new PieceImpl<>(PAWN, BLACK, F7))
            .addPiece(new PieceImpl<>(PAWN, BLACK, G7))
            .addPiece(new PieceImpl<>(PAWN, BLACK, H7));
    }

}
