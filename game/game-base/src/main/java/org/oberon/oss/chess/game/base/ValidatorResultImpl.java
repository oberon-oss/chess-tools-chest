package org.oberon.oss.chess.game.base;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.oberon.oss.chess.base.interfaces.ValidatorResult;

import java.util.List;

/**
 * @author Fabien H. Dumay
 */
@Getter
public class ValidatorResultImpl implements ValidatorResult {
    private final boolean      isValid;
    @NotNull
    private final List<String> messages;

    public ValidatorResultImpl(List<String> messages) {
        this.messages = messages == null ? List.of() : List.of(messages.toArray(new String[0]));
        this.isValid  = this.messages.isEmpty();
    }

}
