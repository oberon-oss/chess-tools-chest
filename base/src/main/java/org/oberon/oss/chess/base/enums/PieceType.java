package org.oberon.oss.chess.base.enums;

import lombok.Getter;

/**
 * Enumeration of the chess pieces.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
@Getter
public enum PieceType {
    KING("K"),
    QUEEN("Q"),
    ROOK("R"),
    BISHOP("B"),
    KNIGHT("N"),
    PAWN("");

    private final String shortHandName;

    PieceType(String shortHandName) {
        this.shortHandName = shortHandName;
    }
}
