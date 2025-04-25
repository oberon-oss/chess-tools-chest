package org.oberon.oss.chess.pgn.data.tags;

import org.jetbrains.annotations.NotNull;
import eu.oberon.oss.chess.fen.processing.FENPosition;
import eu.oberon.oss.chess.fen.processing.FENPositionTranslatorImpl;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import org.oberon.oss.chess.pgn.data.tags.defs.AbstractTag;
import org.oberon.oss.chess.pgn.data.tags.defs.TagValueFromString;

/**
 * Defines the FEN tag that may appear in the {@link TagSection} of a PGN notated game.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public class FENTag<F extends Field, P extends Piece<F>> extends AbstractTag<FENPosition<F, P>> {
    private static final FENPositionTagValueFromString<Field, Piece<Field>> CONVERTER;

    static {
        CONVERTER = new FENPositionTagValueFromString<>();
    }

    public FENTag(@NotNull String tagValue) {
        //noinspection unchecked
        super(TagType.FEN, (FENPosition<F, P>) CONVERTER.fromString(tagValue));
    }

    private static class FENPositionTagValueFromString<F extends Field, P extends Piece<F>> implements TagValueFromString<FENPosition<F, P>> {
        private static final FENPositionTranslatorImpl translator = new FENPositionTranslatorImpl();

        @Override
        public FENPosition<F, P> fromString(String tagValue) {
            //noinspection unchecked
            return (FENPosition<F, P>) translator.toFENPosition(tagValue);
        }
    }
}
