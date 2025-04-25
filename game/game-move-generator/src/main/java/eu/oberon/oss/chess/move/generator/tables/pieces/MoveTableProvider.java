package eu.oberon.oss.chess.move.generator.tables.pieces;

import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.move.generator.MoveTable;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.enums.PieceType;

/**
 * @author Fabien H. Dumay
 * {@link #getPawnMoveTable(ChessColor)}
 */
@SuppressWarnings("unchecked")
public class MoveTableProvider<F extends Field> {
    private final MoveTable<F> kingMoveTable;
    private final MoveTable<F> rookMoveTable;
    private final MoveTable<F> bishopMoveTable;
    private final MoveTable<F> queenMoveTable;
    private final MoveTable<F> knightMoveTable;
    private final MoveTable<F> whitePawnMoveTable;
    private final MoveTable<F> blackPawnMoveTable;

    private MoveTableProvider() {
        kingMoveTable      = new KingMoveTable<>();
        rookMoveTable      = (MoveTable<F>) new RookMoveTable();
        bishopMoveTable    = (MoveTable<F>) new BishopMoveTable();
        queenMoveTable     = (MoveTable<F>) new QueenMoveTable();
        whitePawnMoveTable = (MoveTable<F>) new WhitePawnMoveTable();
        knightMoveTable    = (MoveTable<F>) new KnightMoveTable();
        blackPawnMoveTable = (MoveTable<F>) new BlackPawnMoveTable();
    }

    public MoveTable<F> getPieceMoveTable(PieceType pieceType) {
        return switch (pieceType) {
            case KING -> kingMoveTable;
            case QUEEN -> queenMoveTable;
            case ROOK -> rookMoveTable;
            case BISHOP -> bishopMoveTable;
            case KNIGHT -> knightMoveTable;
            default -> throw new IllegalArgumentException("for Pawns, use method 'getPawnMoveTable(ChessColor)'");
        };
    }

    public MoveTable<F> getPawnMoveTable(ChessColor color) {
        if (color == ChessColor.BLACK) {
            return blackPawnMoveTable;
        } else if (color == ChessColor.WHITE) {
            return whitePawnMoveTable;
        }
        throw new IllegalArgumentException("Invalid color specified: " + color);
    }

    private static final MoveTableProvider<? extends Field> INSTANCE = new MoveTableProvider<>();


    public static <F extends Field> MoveTableProvider<F> getInstance() {
        return (MoveTableProvider<F>) INSTANCE;
    }
}
