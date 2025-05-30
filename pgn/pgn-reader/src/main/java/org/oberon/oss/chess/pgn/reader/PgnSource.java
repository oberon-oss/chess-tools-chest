package org.oberon.oss.chess.pgn.reader;

import java.net.URL;

/**
 * Describes the source of a processed PGN game(s).
 *
 * @author fhdumay
 * @since 1.0.0
 */
public interface PgnSource {
    /**
     * Returns the source type a PGN game was read from.
     *
     * @return A value from the {@link PgnSourceType } enumeration
     *
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    PgnSourceType getSourceType();

    /**
     * Returns a URL describing the PGN source location.
     *
     * @return The PGN source URL
     *
     * @since 1.0.0
     */
    URL getSourceURL();
}
