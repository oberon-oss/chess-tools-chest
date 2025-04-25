package eu.oberon.oss.chess.base.enums;

/**
 * Directions a piece can travel from a given starting field.
 *
 * @author Fabien H. Dumay
 * @since 1.0.0
 */
public enum MoveDirection {
    /**
     * No specific directions,
     *
     * @since 1.0.0
     */
    NONE,

    /**
     * Vertically - from bottom to top (A1->A8)
     *
     * @since 1.0.0
     */
    NORTH,

    /**
     * Diagonally - from lower left to upper right (A1->H8)
     *
     * @since 1.0.0
     */
    NORTH_EAST,

    /**
     * Horizontally - from left to right (A1->H1)
     *
     * @since 1.0.0
     */
    EAST,

    /**
     * Diagonally - From upper left to lower right (A8->H1)
     *
     * @since 1.0.0
     */
    SOUTH_EAST,

    /**
     * Vertically - from top to bottom (A8->A1)
     *
     * @since 1.0.0
     */
    SOUTH,

    /**
     * Diagonally - From Upper right to lower left (H8->A1)
     *
     * @since 1.0.0
     */
    SOUTH_WEST,

    /**
     * Vertically - right to left (H1->A1)
     *
     * @since 1.0.0
     */
    WEST,

    /**
     * Diagonally - From lower right to upper left (H1->A8)
     *
     * @since 1.0.0
     */
    NORTH_WEST;

    /**
     * Returns the direction that is opposite of the current direction.
     *
     * @return The opposite direction of the current direction
     *
     * @since 1.0.0
     */
    public MoveDirection opposite() {
        switch (this) {
            case NORTH -> {
                return SOUTH;
            }
            case SOUTH -> {
                return NORTH;
            }
            case EAST -> {
                return WEST;
            }
            case WEST -> {
                return EAST;
            }
            case NORTH_EAST -> {
                return SOUTH_WEST;
            }
            case SOUTH_WEST -> {
                return NORTH_EAST;
            }
            case SOUTH_EAST -> {
                return NORTH_WEST;
            }
            case NORTH_WEST -> {
                return SOUTH_EAST;
            }
            default -> {
                return NONE;
            }
        }
    }
}
