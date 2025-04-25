package eu.oberon.oss.chess.game.base;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import eu.oberon.oss.chess.base.enums.ChessField;
import eu.oberon.oss.chess.base.enums.PieceType;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Move;
import eu.oberon.oss.chess.base.interfaces.Piece;

/**
 * @author Fabien H. Dumay
 */
@SuppressWarnings("ClassCanBeRecord")
@Builder
@Getter
public class MoveImpl<F extends Field, P extends Piece<F>> implements Move<F, P> {
    @NotNull
    private final P         pieceToMove;
    @Nullable
    private final F         fromField;
    @Nullable
    private final F         toField;
    @Nullable
    private final P         capturedPiece;
    @Nullable
    private final PieceType promotedToPiece;
    private final int       moveFlags;

    public MoveImpl(@NotNull P pieceToMove, @Nullable F fromField, @Nullable F toField, @Nullable P capturedPiece, @Nullable PieceType promotedToPiece, int moveFlags) {
        this.moveFlags = moveFlags;
        if ((this.moveFlags & Move.BIT_FLAG_CASTLE_KING_SIDE) == 0 && (this.moveFlags & Move.BIT_FLAG_CASTLE_QUEEN_SIDE) == 0) {
            if (fromField == null) {
                throw new IllegalArgumentException("fromField cannot be null");
            }
            if (toField == null) {
                throw new IllegalArgumentException("toField cannot be null");
            }
        }
        this.pieceToMove     = pieceToMove;
        this.fromField       = fromField;
        this.toField         = toField;
        this.capturedPiece   = capturedPiece;
        this.promotedToPiece = promotedToPiece;
    }

    @Override
    public String toString() {
        if ((moveFlags & Move.BIT_FLAG_CASTLE_KING_SIDE) != 0) {
            return "O-O";
        } else if ((moveFlags & Move.BIT_FLAG_CASTLE_QUEEN_SIDE) != 0) {
            return "O-O-O";
        } else {
            assert toField != null;
            assert fromField != null;
            StringBuilder buf = new StringBuilder(pieceToMove.getPieceType().getShortHandName());
            if (pieceToMove.getPieceType() != PieceType.PAWN) {
                buf.append(' ');
            }
            buf.append(((ChessField) fromField).name());
            if ((moveFlags & Move.BIT_FLAG_CAPTURE) != 0) {
                buf.append("x");
            } else {
                buf.append("-");
            }
            buf.append(((ChessField) toField).name());
            if ((moveFlags & Move.BIT_FLAG_EN_PASSANT) != 0) {
                buf.append(" e.p.");
            } else if ((moveFlags & Move.BIT_FLAG_PROMOTION) != 0) {
                assert promotedToPiece != null;
                buf.append("=").append(promotedToPiece.getShortHandName());
            }
            return buf.toString();
        }
    }
}
