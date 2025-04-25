package eu.oberon.oss.chess.move.generator.tables.pieces;

import org.jetbrains.annotations.Nullable;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.move.generator.MoveTable;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.move.generator.tables.Direction;
import eu.oberon.oss.chess.move.generator.tables.DirectionMap.DirectionMapBuilder;
import eu.oberon.oss.chess.move.generator.tables.MoveTableImpl;
import eu.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import eu.oberon.oss.chess.move.generator.tables.TargetFieldMapping.TargetFieldMapBuilder;
import eu.oberon.oss.chess.base.enums.PieceType;

import static eu.oberon.oss.chess.base.enums.ChessField.*;
import static eu.oberon.oss.chess.base.enums.MoveDirection.*;
import static eu.oberon.oss.chess.base.enums.PieceType.BISHOP;

/**
 * @author Fabien H. Dumay
 */
class BishopMoveTable implements MoveTable<Field> {
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


    BishopMoveTable() {
        moveTable = new MoveTableImpl.MoveTableBuilder<>()
            .setPiece(BISHOP)
            /* 8th Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_EAST, B7, C6, D5, E4, F3, G2, H1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_EAST, C7, D6, E5, F4, G3, H2))
                            .addDirection(new Direction<>(SOUTH_WEST, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_EAST, D7, E6, F5, G4, H3))
                            .addDirection(new Direction<>(SOUTH_WEST, B7, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_EAST, E7, F6, G5, H4))
                            .addDirection(new Direction<>(SOUTH_WEST, C7, B6, A5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_EAST, F7, G6, H5))
                            .addDirection(new Direction<>(SOUTH_WEST, D7, C6, B5, A4))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_EAST, G7, H6))
                            .addDirection(new Direction<>(SOUTH_WEST, E7, D6, C5, B4, A3))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_EAST, H7))
                            .addDirection(new Direction<>(SOUTH_WEST, F7, E6, D5, C4, B3, A2))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_WEST, G7, F6, E5, D4, C3, B2, A1))
                            .build()
                    )
                    .build()
            )
            /* 7th Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, B8))
                            .addDirection(new Direction<>(SOUTH_EAST, B6, C5, D4, E3, F2, G1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, C8))
                            .addDirection(new Direction<>(SOUTH_EAST, C6, D5, E4, F3, G2, H1))
                            .addDirection(new Direction<>(SOUTH_WEST, A6))
                            .addDirection(new Direction<>(NORTH_WEST, A8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, D8))
                            .addDirection(new Direction<>(SOUTH_EAST, D6, E5, F4, G3, H2))
                            .addDirection(new Direction<>(SOUTH_WEST, B6, A5))
                            .addDirection(new Direction<>(NORTH_WEST, B8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, E8))
                            .addDirection(new Direction<>(SOUTH_EAST, E6, F5, G4, H3))
                            .addDirection(new Direction<>(SOUTH_WEST, C6, B5, A4))
                            .addDirection(new Direction<>(NORTH_WEST, C8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, F8))
                            .addDirection(new Direction<>(SOUTH_EAST, F6, G5, H4))
                            .addDirection(new Direction<>(SOUTH_WEST, D6, C5, B4, A3))
                            .addDirection(new Direction<>(NORTH_WEST, D8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, G8))
                            .addDirection(new Direction<>(SOUTH_EAST, G6, H5))
                            .addDirection(new Direction<>(SOUTH_WEST, E6, D5, C4, B3, A2))
                            .addDirection(new Direction<>(NORTH_WEST, E8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, H8))
                            .addDirection(new Direction<>(SOUTH_EAST, H6))
                            .addDirection(new Direction<>(SOUTH_WEST, F6, E5, D4, C3, B2, A1))
                            .addDirection(new Direction<>(NORTH_WEST, F8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_WEST, G6, F5, E4, D3, C2, B1))
                            .addDirection(new Direction<>(NORTH_WEST, G8))
                            .build()
                    )
                    .build()
            )
            /* 6th Rank*/
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, B7, C8))
                            .addDirection(new Direction<>(SOUTH_EAST, B5, C4, D3, E2, F1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, C7, D8))
                            .addDirection(new Direction<>(SOUTH_EAST, C5, D4, E3, F2, G1))
                            .addDirection(new Direction<>(SOUTH_WEST, A5))
                            .addDirection(new Direction<>(NORTH_WEST, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, D7, E8))
                            .addDirection(new Direction<>(SOUTH_EAST, D5, E4, F3, G2, H1))
                            .addDirection(new Direction<>(SOUTH_WEST, B5, A4))
                            .addDirection(new Direction<>(NORTH_WEST, B7, A8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, E7, F8))
                            .addDirection(new Direction<>(SOUTH_EAST, E5, F4, G3, H2))
                            .addDirection(new Direction<>(SOUTH_WEST, C5, B4, A3))
                            .addDirection(new Direction<>(NORTH_WEST, C7, B8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, F7, G8))
                            .addDirection(new Direction<>(SOUTH_EAST, F5, G4, H3))
                            .addDirection(new Direction<>(SOUTH_WEST, D5, C4, B3, A2))
                            .addDirection(new Direction<>(NORTH_WEST, D7, C8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, G7, H8))
                            .addDirection(new Direction<>(SOUTH_EAST, G5, H4))
                            .addDirection(new Direction<>(SOUTH_WEST, E5, D4, C3, B2, A1))
                            .addDirection(new Direction<>(NORTH_WEST, E7, D8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, H7))
                            .addDirection(new Direction<>(SOUTH_EAST, H5))
                            .addDirection(new Direction<>(SOUTH_WEST, F5, E4, D3, C2, B1))
                            .addDirection(new Direction<>(NORTH_WEST, F7, E8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_WEST, G5, F4, E3, D2, C1))
                            .addDirection(new Direction<>(NORTH_WEST, G7, F8))
                            .build()
                    )
                    .build()
            )
            /* 5th Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, B6, C7, D8))
                            .addDirection(new Direction<>(SOUTH_EAST, B4, C3, D2, E1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, C6, D7, E8))
                            .addDirection(new Direction<>(SOUTH_EAST, C4, D3, E2, F1))
                            .addDirection(new Direction<>(SOUTH_WEST, A4))
                            .addDirection(new Direction<>(NORTH_WEST, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, D6, E7, F8))
                            .addDirection(new Direction<>(SOUTH_EAST, D4, E3, F2, G1))
                            .addDirection(new Direction<>(SOUTH_WEST, B4, A3))
                            .addDirection(new Direction<>(NORTH_WEST, B6, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, E6, G7, G8))
                            .addDirection(new Direction<>(SOUTH_EAST, E4, F3, G2, H1))
                            .addDirection(new Direction<>(SOUTH_WEST, C4, B3, A2))
                            .addDirection(new Direction<>(NORTH_WEST, C6, B7, A8))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, F6, G7, H8))
                            .addDirection(new Direction<>(SOUTH_EAST, F4, G3, H2))
                            .addDirection(new Direction<>(SOUTH_WEST, D4, C3, B2, A1))
                            .addDirection(new Direction<>(NORTH_WEST, D6, C7, B8))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, G6, H7))
                            .addDirection(new Direction<>(SOUTH_EAST, G4, H3))
                            .addDirection(new Direction<>(SOUTH_WEST, E4, D3, C2, B1))
                            .addDirection(new Direction<>(NORTH_WEST, E6, D7, C8))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, H6))
                            .addDirection(new Direction<>(SOUTH_EAST, H4))
                            .addDirection(new Direction<>(SOUTH_WEST, F4, E3, D2, C1))
                            .addDirection(new Direction<>(NORTH_WEST, F6, E7, D8))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_WEST, G4, F3, E2, D1))
                            .addDirection(new Direction<>(NORTH_WEST, G6, F7, E8))
                            .build()
                    )
                    .build()
            )
            /* 4th Rank*/
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, B5, C6, D7, E8))
                            .addDirection(new Direction<>(SOUTH_EAST, B3, C2, D1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, C5, D6, E7, F8))
                            .addDirection(new Direction<>(SOUTH_EAST, C3, D2, E1))
                            .addDirection(new Direction<>(SOUTH_WEST, A3))
                            .addDirection(new Direction<>(NORTH_WEST, A5))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, D5, E6, F7, G8))
                            .addDirection(new Direction<>(SOUTH_EAST, D3, E2, F1))
                            .addDirection(new Direction<>(SOUTH_WEST, B3, A2))
                            .addDirection(new Direction<>(NORTH_WEST, B5, A6))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, E5, F6, G7, H8))
                            .addDirection(new Direction<>(SOUTH_EAST, E3, F2, G1))
                            .addDirection(new Direction<>(SOUTH_WEST, C3, B2, A1))
                            .addDirection(new Direction<>(NORTH_WEST, C5, B6, A7))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, F5, G6, H7))
                            .addDirection(new Direction<>(SOUTH_EAST, F3, G2, H1))
                            .addDirection(new Direction<>(SOUTH_WEST, D3, C2, B1))
                            .addDirection(new Direction<>(NORTH_WEST, D5, C6, B7, A8))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, G5, H6))
                            .addDirection(new Direction<>(SOUTH_EAST, G3, H2))
                            .addDirection(new Direction<>(SOUTH_WEST, E3, D2, C1))
                            .addDirection(new Direction<>(NORTH_WEST, E5, D6, C7, B8))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, H5))
                            .addDirection(new Direction<>(SOUTH_EAST, H3))
                            .addDirection(new Direction<>(SOUTH_WEST, F3, E2, D1))
                            .addDirection(new Direction<>(NORTH_WEST, E5, D6, C7, B8))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_WEST, G3, F2, E1))
                            .addDirection(new Direction<>(NORTH_WEST, G5, F6, E7, D8))
                            .build()
                    ).build()
            )
            /* 3rd Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, B4, C5, D6, E7, F8))
                            .addDirection(new Direction<>(SOUTH_EAST, B2, C1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, C4, D5, E6, F7, G8))
                            .addDirection(new Direction<>(SOUTH_EAST, C2, D1))
                            .addDirection(new Direction<>(SOUTH_WEST, A2))
                            .addDirection(new Direction<>(NORTH_WEST, A4))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, D4, E5, F6, G7, H8))
                            .addDirection(new Direction<>(SOUTH_EAST, D2, E1))
                            .addDirection(new Direction<>(SOUTH_WEST, B2, A1))
                            .addDirection(new Direction<>(NORTH_WEST, B4, A5))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, E4, F5, G6, H7))
                            .addDirection(new Direction<>(SOUTH_EAST, E2, F1))
                            .addDirection(new Direction<>(SOUTH_WEST, C2, B1))
                            .addDirection(new Direction<>(NORTH_WEST, C4, B5, A6))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, F4, G5, H6))
                            .addDirection(new Direction<>(SOUTH_EAST, F2, G1))
                            .addDirection(new Direction<>(SOUTH_WEST, D2, C1))
                            .addDirection(new Direction<>(NORTH_WEST, D4, C5, B6, A7))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, G4, H5))
                            .addDirection(new Direction<>(SOUTH_EAST, G2, H1))
                            .addDirection(new Direction<>(SOUTH_WEST, E2, D1))
                            .addDirection(new Direction<>(NORTH_WEST, E4, D5, C6, B7, A8))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, H4))
                            .addDirection(new Direction<>(SOUTH_EAST, H2))
                            .addDirection(new Direction<>(SOUTH_WEST, F2, E1))
                            .addDirection(new Direction<>(NORTH_WEST, F4, E5, D6, C7, B8))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_WEST, G2, F1))
                            .addDirection(new Direction<>(NORTH_WEST, G4, F5, E6, D7, C8))
                            .build()
                    ).build()
            )
            /* 2nd Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, B3, C4, D5, E6, F7, G8))
                            .addDirection(new Direction<>(SOUTH_EAST, B1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, C3, D4, E5, F6, G7, H8))
                            .addDirection(new Direction<>(SOUTH_EAST, C1))
                            .addDirection(new Direction<>(SOUTH_WEST, A1))
                            .addDirection(new Direction<>(NORTH_WEST, A3))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, D3, E4, F5, G6, H7))
                            .addDirection(new Direction<>(SOUTH_EAST, D1))
                            .addDirection(new Direction<>(SOUTH_WEST, B1))
                            .addDirection(new Direction<>(NORTH_WEST, B3, A4))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, D3, E4, F5, G6, H7))
                            .addDirection(new Direction<>(SOUTH_EAST, E1))
                            .addDirection(new Direction<>(SOUTH_WEST, C1))
                            .addDirection(new Direction<>(NORTH_WEST, C3, B4, A5))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, F3, G4, H5))
                            .addDirection(new Direction<>(SOUTH_EAST, F1))
                            .addDirection(new Direction<>(SOUTH_WEST, D1))
                            .addDirection(new Direction<>(NORTH_WEST, D3, C4, B5, A6))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, G3, H4))
                            .addDirection(new Direction<>(SOUTH_EAST, G1))
                            .addDirection(new Direction<>(SOUTH_WEST, E1))
                            .addDirection(new Direction<>(NORTH_WEST, E3, D4, C5, B6, A7))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, H3))
                            .addDirection(new Direction<>(SOUTH_EAST, H1))
                            .addDirection(new Direction<>(SOUTH_WEST, F1))
                            .addDirection(new Direction<>(NORTH_WEST, F3, E4, D5, C6, B7, A8))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH_WEST, G1))
                            .addDirection(new Direction<>(NORTH_WEST, G3, F4, E5, D6, C7, B8))
                            .build()
                    ).build()
            )
            /* 1st Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, B2, C3, D4, E5, F6, G7, H8))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, C2, D3, E4, F5, G6, H7))
                            .addDirection(new Direction<>(NORTH_WEST, A2))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, D2, E3, F4, G5, H6))
                            .addDirection(new Direction<>(NORTH_WEST, B2, A3))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, E2, F3, G4, H5))
                            .addDirection(new Direction<>(NORTH_WEST, C2, B3, A4))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, F2, G3, H4))
                            .addDirection(new Direction<>(NORTH_WEST, D2, C3, B4, A5))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, G2, H3))
                            .addDirection(new Direction<>(NORTH_WEST, E2, D3, C4, B5, A6))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_EAST, H2))
                            .addDirection(new Direction<>(NORTH_WEST, F2, E3, D4, C5, B6, A7))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH_WEST, G2, F3, E4, D5, C6, B7, A8))
                            .build()
                    ).build()
            )
            .build();
    }

}


