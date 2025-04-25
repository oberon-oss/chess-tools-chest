package eu.oberon.oss.chess.move.generator.tables.pieces;

import org.jetbrains.annotations.Nullable;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.enums.PieceType;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.move.generator.MoveTable;
import eu.oberon.oss.chess.move.generator.tables.Direction;
import eu.oberon.oss.chess.move.generator.tables.DirectionMap;
import eu.oberon.oss.chess.move.generator.tables.MoveTableImpl;
import eu.oberon.oss.chess.move.generator.tables.TargetFieldMapping;

import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;
import static eu.oberon.oss.chess.base.enums.ChessField.*;
import static eu.oberon.oss.chess.base.enums.MoveDirection.*;
import static eu.oberon.oss.chess.base.enums.PieceType.PAWN;

/**
 * @author Fabien H. Dumay
 */
class WhitePawnMoveTable implements MoveTable<Field> {
    private final MoveTable<Field> moveTable;

    @Override
    public @Nullable TargetFieldMapping<Field> getFieldMapping(Field field) {
        return moveTable.getFieldMapping(field);
    }

    @Override
    public PieceType getPiece() {
        return moveTable.getPiece();
    }

    @Override
    public @Nullable ChessColor getColor() {
        return moveTable.getColor();
    }

    //@formatter:off
    WhitePawnMoveTable() {
        moveTable = new MoveTableImpl.MoveTableBuilder<>()
            .setPiece(PAWN)
            .setColor(WHITE)
            /* 2nd RANK */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A2)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A3, A4))
                            .addDirection(new Direction<>(NORTH_EAST, B3))
                            .build())
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B2)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, A3))
                            .addDirection(new Direction<>(NORTH, B3, B4))
                            .addDirection(new Direction<>(NORTH_EAST, C3))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C2)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, B3))
                            .addDirection(new Direction<>(NORTH, C3, C4))
                            .addDirection(new Direction<>(NORTH_EAST, D3))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D2)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, C3))
                            .addDirection(new Direction<>(NORTH, D3, D4))
                            .addDirection(new Direction<>(NORTH_EAST, E3))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E2)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, D3))
                            .addDirection(new Direction<>(NORTH, E3, E4))
                            .addDirection(new Direction<>(NORTH_EAST, F3))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F2)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, E3))
                            .addDirection(new Direction<>(NORTH, F3, F4))
                            .addDirection(new Direction<>(NORTH_EAST, G3))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G2)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, F3))
                            .addDirection(new Direction<>(NORTH, G3, G4))
                            .addDirection(new Direction<>(NORTH_EAST, H3))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H2)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, G3))
                            .addDirection(new Direction<>(NORTH, H3, H4))
                            .build()
                    )
                    .build()
            )
            /* 3rd RANK */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A3)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A4))
                            .addDirection(new Direction<>(NORTH_EAST, B4))
                            .build())
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B3)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, A4))
                            .addDirection(new Direction<>(NORTH, B4))
                            .addDirection(new Direction<>(NORTH_EAST, C4))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C3)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, B4))
                            .addDirection(new Direction<>(NORTH, C4))
                            .addDirection(new Direction<>(NORTH_EAST, D4))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D3)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, C4))
                            .addDirection(new Direction<>(NORTH, D4))
                            .addDirection(new Direction<>(NORTH_EAST, E4))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E3)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, D4))
                            .addDirection(new Direction<>(NORTH, E4))
                            .addDirection(new Direction<>(NORTH_EAST, F4))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F3)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, E4))
                            .addDirection(new Direction<>(NORTH, F4))
                            .addDirection(new Direction<>(NORTH_EAST, G4))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G3)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, F4))
                            .addDirection(new Direction<>(NORTH, G4))
                            .addDirection(new Direction<>(NORTH_EAST, H4))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H3)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, G4))
                            .addDirection(new Direction<>(NORTH, H4))
                            .build()
                    )
                    .build()
            )
            /* 4th RANK */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A4)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A5))
                            .addDirection(new Direction<>(NORTH_EAST, B5))
                            .build())
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B4)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, A5))
                            .addDirection(new Direction<>(NORTH, B5))
                            .addDirection(new Direction<>(NORTH_EAST, C5))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C4)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, B5))
                            .addDirection(new Direction<>(NORTH, C5))
                            .addDirection(new Direction<>(NORTH_EAST, D5))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D4)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, C5))
                            .addDirection(new Direction<>(NORTH, D5))
                            .addDirection(new Direction<>(NORTH_EAST, E5))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E4)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, D5))
                            .addDirection(new Direction<>(NORTH, E5))
                            .addDirection(new Direction<>(NORTH_EAST, F5))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F4)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, E5))
                            .addDirection(new Direction<>(NORTH, F5))
                            .addDirection(new Direction<>(NORTH_EAST, G5))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G4)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, F5))
                            .addDirection(new Direction<>(NORTH, G5))
                            .addDirection(new Direction<>(NORTH_EAST, H5))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H4)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, G5))
                            .addDirection(new Direction<>(NORTH, H5))
                            .build()
                    )
                    .build()
            )
            /* 5th RANK */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A5)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A6))
                            .addDirection(new Direction<>(NORTH_EAST, B6))
                            .build())
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B5)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, A6))
                            .addDirection(new Direction<>(NORTH, B6))
                            .addDirection(new Direction<>(NORTH_EAST, C6))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C5)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, B6))
                            .addDirection(new Direction<>(NORTH, C6))
                            .addDirection(new Direction<>(NORTH_EAST, D6))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D5)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, C6))
                            .addDirection(new Direction<>(NORTH, D6))
                            .addDirection(new Direction<>(NORTH_EAST, E6))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E5)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, D6))
                            .addDirection(new Direction<>(NORTH, E6))
                            .addDirection(new Direction<>(NORTH_EAST, F6))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F5)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, E6))
                            .addDirection(new Direction<>(NORTH, F6))
                            .addDirection(new Direction<>(NORTH_EAST, G6))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G5)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, F6))
                            .addDirection(new Direction<>(NORTH, G6))
                            .addDirection(new Direction<>(NORTH_EAST, H6))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H5)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, G6))
                            .addDirection(new Direction<>(NORTH, H6))
                            .build()
                    )
                    .build()
            )
            /* 6th RANK */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A6)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A7))
                            .addDirection(new Direction<>(NORTH_EAST, B7))
                            .build())
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B6)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, A7))
                            .addDirection(new Direction<>(NORTH, B7))
                            .addDirection(new Direction<>(NORTH_EAST, C7))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C6)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, B7))
                            .addDirection(new Direction<>(NORTH, C7))
                            .addDirection(new Direction<>(NORTH_EAST, D7))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D6)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, C7))
                            .addDirection(new Direction<>(NORTH, D7))
                            .addDirection(new Direction<>(NORTH_EAST, E7))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E6)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, D7))
                            .addDirection(new Direction<>(NORTH, E7))
                            .addDirection(new Direction<>(NORTH_EAST, F7))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F6)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, E7))
                            .addDirection(new Direction<>(NORTH, F7))
                            .addDirection(new Direction<>(NORTH_EAST, G7))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G6)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, F7))
                            .addDirection(new Direction<>(NORTH, G7))
                            .addDirection(new Direction<>(NORTH_EAST, H7))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H6)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, G7))
                            .addDirection(new Direction<>(NORTH, H7))
                            .build()
                    )
                    .build()
            )
            /* 7th RANK */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A7)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A8))
                            .addDirection(new Direction<>(NORTH_EAST, B8))
                            .build())
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B7)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, A8))
                            .addDirection(new Direction<>(NORTH, B8))
                            .addDirection(new Direction<>(NORTH_EAST, C8))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C7)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, B8))
                            .addDirection(new Direction<>(NORTH, C8))
                            .addDirection(new Direction<>(NORTH_EAST, D8))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D7)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, C8))
                            .addDirection(new Direction<>(NORTH, D8))
                            .addDirection(new Direction<>(NORTH_EAST, E8))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E7)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, D8))
                            .addDirection(new Direction<>(NORTH, E8))
                            .addDirection(new Direction<>(NORTH_EAST, F8))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F7)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, E8))
                            .addDirection(new Direction<>(NORTH, F8))
                            .addDirection(new Direction<>(NORTH_EAST, G8))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G7)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, F8))
                            .addDirection(new Direction<>(NORTH, G8))
                            .addDirection(new Direction<>(NORTH_EAST, H8))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H7)
                    .setDirectionMap(
                        new DirectionMap.DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, G8))
                            .addDirection(new Direction<>(NORTH, H8))
                            .build()
                    )
                    .build()
            )
            /* Build the resulting table*/
            .build();
    }

    // @formatter:on
}
