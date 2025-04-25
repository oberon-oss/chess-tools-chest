package org.oberon.oss.chess.game.tables;

import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.base.interfaces.Piece;

import java.util.List;

public interface PositionTable<F extends Field, P extends Piece<F>> {
    List<F> getAttackersForField(F field);
    List<F> getDefendersForField(F field);
}
