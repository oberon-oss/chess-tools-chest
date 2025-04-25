package org.oberon.oss.chess.base.interfaces;

import org.oberon.oss.chess.base.enums.CastlingType;
import org.oberon.oss.chess.base.enums.ChessColor;

import java.util.Collection;

/**
 * @author Fabien H. Dumay
 */
public interface GameStartPosition<F extends Field, P extends Piece<F>> {
    Position<F, P> getStartPosition();

    Collection<CastlingConfiguration<F>> getCastlingTypes();

    CastlingConfiguration<F> getCastlingConfiguration(ChessColor color, CastlingType type);
}

