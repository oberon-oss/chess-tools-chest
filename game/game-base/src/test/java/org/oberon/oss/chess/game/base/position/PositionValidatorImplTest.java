package org.oberon.oss.chess.game.base.position;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.oberon.oss.chess.game.base.validators.PositionValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Fabien H. Dumay
 */
@Log4j2
class PositionValidatorImplTest {

    @Test
    void getInstance() {
        assertNotNull(PositionValidatorImpl.getInstance());
    }
}