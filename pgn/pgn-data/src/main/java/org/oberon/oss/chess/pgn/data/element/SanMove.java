package org.oberon.oss.chess.pgn.data.element;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SanMove implements Element<String>{
    private final String text;

    public SanMove(String text) {
        this.text = text;
    }

    @Override
    public String getElementData() {
        return "";
    }
}
