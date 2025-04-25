package org.oberon.oss.chess.pgn.data.tags;


import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.pgn.data.tags.defs.AbstractTag;

@Getter
@ToString
public class StandardTag extends AbstractTag<String> {
    public StandardTag(final @NotNull TagType tagType, final @NotNull String tagValue) {
        super(tagType, tagValue);
    }

}
