package org.oberon.oss.chess.move.generator.tables.pieces;

import org.jetbrains.annotations.Nullable;
import org.oberon.oss.chess.base.enums.ChessColor;
import org.oberon.oss.chess.base.enums.PieceType;
import org.oberon.oss.chess.base.interfaces.Field;
import org.oberon.oss.chess.move.generator.MoveTable;
import org.oberon.oss.chess.move.generator.tables.Direction;
import org.oberon.oss.chess.move.generator.tables.DirectionMap.DirectionMapBuilder;
import org.oberon.oss.chess.move.generator.tables.MoveTableImpl.MoveTableBuilder;
import org.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import org.oberon.oss.chess.move.generator.tables.TargetFieldMapping.TargetFieldMapBuilder;

import static org.oberon.oss.chess.base.enums.ChessField.*;
import static org.oberon.oss.chess.base.enums.MoveDirection.*;
import static org.oberon.oss.chess.base.enums.PieceType.ROOK;

/**
 * @author Fabien H. Dumay
 */
class RookMoveTable implements MoveTable<Field> {
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


    RookMoveTable() {
        moveTable = new MoveTableBuilder<>()
            .setPiece(ROOK)
            /* 8th Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(EAST, B8, C8, D8, E8, F8, G8, H8))
                            .addDirection(new Direction<>(SOUTH, A7, A6, A5, A4, A3, A2, A1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(EAST, C8, D8, E8, F8, G8, H8))
                            .addDirection(new Direction<>(SOUTH, B7, B6, B5, B4, B3, B2, B1))
                            .addDirection(new Direction<>(WEST, A8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(EAST, D8, E8, F8, G8, H8))
                            .addDirection(new Direction<>(SOUTH, C7, C6, C5, C4, C3, C2, C1))
                            .addDirection(new Direction<>(WEST, B8, A8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(EAST, E8, F8, G8, H8))
                            .addDirection(new Direction<>(SOUTH, D7, D6, D5, D4, D3, D2, D1))
                            .addDirection(new Direction<>(WEST, C8, B8, A8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(EAST, F8, G8, H8))
                            .addDirection(new Direction<>(SOUTH, E7, E6, E5, E4, E3, E2, E1))
                            .addDirection(new Direction<>(WEST, D8, C8, B8, A8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(EAST, G8, H8))
                            .addDirection(new Direction<>(SOUTH, F7, F6, F5, F4, F3, F2, F1))
                            .addDirection(new Direction<>(WEST, E8, D8, C8, B8, A8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(EAST, H8))
                            .addDirection(new Direction<>(SOUTH, G7, G6, G5, G4, G3, G2, G1))
                            .addDirection(new Direction<>(WEST, F8, E8, D8, C8, B8, A8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(SOUTH, H7, H6, H5, H4, H3, H2, H1))
                            .addDirection(new Direction<>(WEST, G8, F8, E8, D8, C8, B8, A8))
                            .build()
                    )
                    .build()
            )
            /* 8th Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A8))
                            .addDirection(new Direction<>(EAST, B7, C7, C7, E7, F7, G7, H7))
                            .addDirection(new Direction<>(SOUTH, A6, A5, A4, A3, A2, A1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, B8))
                            .addDirection(new Direction<>(EAST, C7, C7, E7, F7, G7, H7))
                            .addDirection(new Direction<>(SOUTH, B6, B5, B4, B3, B2, B1))
                            .addDirection(new Direction<>(WEST, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, C8))
                            .addDirection(new Direction<>(EAST, D7, E7, F7, G7, H7))
                            .addDirection(new Direction<>(SOUTH, C6, C5, C4, C3, C2, C1))
                            .addDirection(new Direction<>(WEST, B7, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, D8))
                            .addDirection(new Direction<>(EAST, E7, F7, G7, H7))
                            .addDirection(new Direction<>(SOUTH, D6, D5, D4, D3, D2, D1))
                            .addDirection(new Direction<>(WEST, C7, B7, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, E8))
                            .addDirection(new Direction<>(EAST, F7, G7, H7))
                            .addDirection(new Direction<>(SOUTH, E6, E5, E4, E3, E2, E1))
                            .addDirection(new Direction<>(WEST, D7, C7, B7, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, F8))
                            .addDirection(new Direction<>(EAST, G7, H7))
                            .addDirection(new Direction<>(SOUTH, F6, F5, F4, F3, F2, F1))
                            .addDirection(new Direction<>(WEST, E7, D7, C7, B7, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, G8))
                            .addDirection(new Direction<>(EAST, H7))
                            .addDirection(new Direction<>(SOUTH, G6, G5, G4, G3, G2, G1))
                            .addDirection(new Direction<>(WEST, F7, E7, D7, C7, B7, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, H8))
                            .addDirection(new Direction<>(SOUTH, H6, H5, H4, H3, H2, H1))
                            .addDirection(new Direction<>(WEST, G7, F7, E7, D7, C7, B7, A7))
                            .build()
                    )
                    .build()
            )
            /* 8th Rank*/
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A7, A8))
                            .addDirection(new Direction<>(EAST, B6, C6, D6, E6, F6, G6, H6))
                            .addDirection(new Direction<>(SOUTH, A5, A4, A3, A2, A1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, B7, B8))
                            .addDirection(new Direction<>(EAST, C6, D6, E6, F6, G6, H6))
                            .addDirection(new Direction<>(SOUTH, B5, B4, B3, B2, B1))
                            .addDirection(new Direction<>(WEST, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, C7, C8))
                            .addDirection(new Direction<>(EAST, D6, E6, F6, G6, H6))
                            .addDirection(new Direction<>(SOUTH, C5, C4, C3, C2, C1))
                            .addDirection(new Direction<>(WEST, B6, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, D7, D8))
                            .addDirection(new Direction<>(EAST, E6, F6, G6, H6))
                            .addDirection(new Direction<>(SOUTH, D5, D4, D3, D2, D1))
                            .addDirection(new Direction<>(WEST, C6, B6, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, E7, E8))
                            .addDirection(new Direction<>(EAST, F6, G6, H6))
                            .addDirection(new Direction<>(SOUTH, E5, E4, E3, E2, E1))
                            .addDirection(new Direction<>(WEST, D6, C6, B6, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, F7, F8))
                            .addDirection(new Direction<>(EAST, G6, H6))
                            .addDirection(new Direction<>(SOUTH, F5, F4, F3, F2, F1))
                            .addDirection(new Direction<>(WEST, E6, D6, C6, B6, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, G7, G8))
                            .addDirection(new Direction<>(EAST, H6))
                            .addDirection(new Direction<>(SOUTH, G5, G4, G3, G2, G1))
                            .addDirection(new Direction<>(WEST, F6, E6, D6, C6, B6, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, H7, H8))
                            .addDirection(new Direction<>(SOUTH, H5, H4, H3, H2, H1))
                            .addDirection(new Direction<>(WEST, G6, F6, E6, D6, C6, B6, A6))
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
                            .addDirection(new Direction<>(NORTH, A6, A7, A8))
                            .addDirection(new Direction<>(EAST, B5, C5, D5, E5, F5, G5, H5))
                            .addDirection(new Direction<>(SOUTH, A4, A3, A2, A1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, B6, B7, B8))
                            .addDirection(new Direction<>(EAST, C5, D5, E5, F5, G5, H5))
                            .addDirection(new Direction<>(SOUTH, B4, B3, B2, B1))
                            .addDirection(new Direction<>(WEST, A5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, C6, C7, C8))
                            .addDirection(new Direction<>(EAST, D5, E5, F5, G5, H5))
                            .addDirection(new Direction<>(SOUTH, C4, C3, C2, C1))
                            .addDirection(new Direction<>(WEST, B5, A5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, D6, D7, D8))
                            .addDirection(new Direction<>(EAST, E5, F5, G5, H5))
                            .addDirection(new Direction<>(SOUTH, D4, D3, D2, D1))
                            .addDirection(new Direction<>(WEST, C5, B5, A5))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, E6, E7, E8))
                            .addDirection(new Direction<>(EAST, F5, G5, H5))
                            .addDirection(new Direction<>(SOUTH, E4, E3, E2, E1))
                            .addDirection(new Direction<>(WEST, D5, C5, B5, A5))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, F6, F7, F8))
                            .addDirection(new Direction<>(EAST, G5, H5))
                            .addDirection(new Direction<>(SOUTH, F4, F3, F2, F1))
                            .addDirection(new Direction<>(WEST, E5, D5, C5, B5, A5))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, G6, G7, G8))
                            .addDirection(new Direction<>(EAST, H5))
                            .addDirection(new Direction<>(SOUTH, G4, G3, G2, G1))
                            .addDirection(new Direction<>(WEST, F5, E5, D5, C5, B5, A5))
                            .build()
                    )
                    .build()
            ).addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, H6, H7, H8))
                            .addDirection(new Direction<>(SOUTH, H4, H3, H2, H1))
                            .addDirection(new Direction<>(WEST, G5, F5, E5, D5, C5, B5, A5))
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
                            .addDirection(new Direction<>(NORTH, A5, A6, A7, A8))
                            .addDirection(new Direction<>(EAST, B4, C4, D4, E4, F4, G4, H4))
                            .addDirection(new Direction<>(SOUTH, A3, A2, A1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, B5, B6, B7, B8))
                            .addDirection(new Direction<>(EAST, C4, D4, E4, F4, G4, H4))
                            .addDirection(new Direction<>(SOUTH, B3, B2, B1))
                            .addDirection(new Direction<>(WEST, A4))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, C5, C6, C7, C8))
                            .addDirection(new Direction<>(EAST, D4, E4, F4, G4, H4))
                            .addDirection(new Direction<>(SOUTH, C3, C2, C1))
                            .addDirection(new Direction<>(WEST, B4, A4))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, D5, D6, D7, D8))
                            .addDirection(new Direction<>(EAST, E4, F4, G4, H4))
                            .addDirection(new Direction<>(SOUTH, D3, D2, D1))
                            .addDirection(new Direction<>(WEST, C4, B4, A4))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, E5, E6, E7, E8))
                            .addDirection(new Direction<>(EAST, F4, G4, H4))
                            .addDirection(new Direction<>(SOUTH, E3, E2, E1))
                            .addDirection(new Direction<>(WEST, D4, C4, B4, A4))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, F5, F6, F7, F8))
                            .addDirection(new Direction<>(EAST, G4, H4))
                            .addDirection(new Direction<>(SOUTH, F3, F2, F1))
                            .addDirection(new Direction<>(WEST, E4, D4, C4, B4, A4))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, G5, G6, G7, G8))
                            .addDirection(new Direction<>(EAST, H4))
                            .addDirection(new Direction<>(SOUTH, G3, G2, G1))
                            .addDirection(new Direction<>(WEST, F4, E4, D4, C4, B4, A4))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, H5, H6, H7, H8))
                            .addDirection(new Direction<>(SOUTH, H3, H2, H1))
                            .addDirection(new Direction<>(WEST, G4, F4, E4, D4, C4, B4, A4))
                            .build()
                    ).build()
            )
            /* 3rd Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A4, A5, A6, A7, A8))
                            .addDirection(new Direction<>(EAST, B3, C3, D3, E3, F3, G3, H3))
                            .addDirection(new Direction<>(SOUTH, A2, A1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, B4, B5, B6, B7, B8))
                            .addDirection(new Direction<>(EAST, C3, D3, E3, F3, G3, H3))
                            .addDirection(new Direction<>(SOUTH, B2, B1))
                            .addDirection(new Direction<>(WEST, A3))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, C4, C5, C6, C7, C8))
                            .addDirection(new Direction<>(EAST, D3, E3, F3, G3, H3))
                            .addDirection(new Direction<>(SOUTH, C2, C1))
                            .addDirection(new Direction<>(WEST, B3, A3))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, D4, D5, D6, D7, D8))
                            .addDirection(new Direction<>(EAST, E3, F3, G3, H3))
                            .addDirection(new Direction<>(SOUTH, D2, D1))
                            .addDirection(new Direction<>(WEST, C3, B3, A3))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, E4, E5, E6, E7, E8))
                            .addDirection(new Direction<>(EAST, F3, G3, H3))
                            .addDirection(new Direction<>(SOUTH, E2, E1))
                            .addDirection(new Direction<>(WEST, D3, C3, B3, A3))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, F4, F5, F6, F7, F8))
                            .addDirection(new Direction<>(EAST, G3, H3))
                            .addDirection(new Direction<>(SOUTH, F2, F1))
                            .addDirection(new Direction<>(WEST, E3, D3, C3, B3, A3))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, G4, G5, G6, G7, G8))
                            .addDirection(new Direction<>(EAST, H3))
                            .addDirection(new Direction<>(SOUTH, G2, G1))
                            .addDirection(new Direction<>(WEST, F3, E3, D3, C3, B3, A3))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, H4, H5, H6, H7, H8))
                            .addDirection(new Direction<>(SOUTH, H2, H1))
                            .addDirection(new Direction<>(WEST, G3, F3, E3, D3, C3, B3, A3))
                            .build()
                    ).build()
            )
            /* 2nd Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A3, A4, A5, A6, A7, A8))
                            .addDirection(new Direction<>(EAST, B2, C2, D2, E2, F2, G2, H2))
                            .addDirection(new Direction<>(SOUTH, A1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, B3, B4, B5, B6, B7, B8))
                            .addDirection(new Direction<>(EAST, C2, D2, E2, F2, G2, H2))
                            .addDirection(new Direction<>(SOUTH, B1))
                            .addDirection(new Direction<>(WEST, A2))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, C3, C4, C5, C6, C7, C8))
                            .addDirection(new Direction<>(EAST, D2, E2, F2, G2, H2))
                            .addDirection(new Direction<>(SOUTH, C1))
                            .addDirection(new Direction<>(WEST, B2, A2))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, D3, D4, D5, D6, D7, D8))
                            .addDirection(new Direction<>(EAST, E2, F2, G2, H2))
                            .addDirection(new Direction<>(SOUTH, D1))
                            .addDirection(new Direction<>(WEST, C2, B2, A2))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, E3, E4, E5, E6, E7, E8))
                            .addDirection(new Direction<>(EAST, F2, G2, H2))
                            .addDirection(new Direction<>(SOUTH, E1))
                            .addDirection(new Direction<>(WEST, D2, C2, B2, A2))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, F3, F4, F5, F6, F7, F8))
                            .addDirection(new Direction<>(EAST, G2, H2))
                            .addDirection(new Direction<>(SOUTH, F1))
                            .addDirection(new Direction<>(WEST, E2, D2, C2, B2, A2))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, G3, G4, G5, G6, G7, G8))
                            .addDirection(new Direction<>(EAST, H2))
                            .addDirection(new Direction<>(SOUTH, G1))
                            .addDirection(new Direction<>(WEST, F2, E2, D2, C2, B2, A2))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, H3, H4, H5, H6, H7, H8))
                            .addDirection(new Direction<>(SOUTH, H1))
                            .addDirection(new Direction<>(WEST, G2, F2, E2, D2, C2, B2, A2))
                            .build()
                    ).build()
            )
            /* 1st Rank */
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(A1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, A2, A3, A4, A5, A6, A7, A8))
                            .addDirection(new Direction<>(EAST, B1, C1, D1, E1, F1, G1, H1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(B1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, B2, B3, B4, B5, B6, B7, B8))
                            .addDirection(new Direction<>(EAST, C1, D1, E1, F1, G1, H1))
                            .addDirection(new Direction<>(WEST, A1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(C1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, C2, C3, C4, C5, C6, C7, C8))
                            .addDirection(new Direction<>(EAST, D1, E1, F1, G1, H1))
                            .addDirection(new Direction<>(WEST, B1, A1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(D1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, D2, D3, D4, D5, D6, D7, D8))
                            .addDirection(new Direction<>(EAST, E1, F1, G1, H1))
                            .addDirection(new Direction<>(WEST, C1, B1, A1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(E1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, E2, E3, E4, E5, E6, E7, E8))
                            .addDirection(new Direction<>(EAST, F1, G1, H1))
                            .addDirection(new Direction<>(WEST, D1, C1, B1, A1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(F1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, F2, F3, F4, F5, F6, F7, F8))
                            .addDirection(new Direction<>(EAST, G1, H1))
                            .addDirection(new Direction<>(WEST, E1, D1, C1, B1, A1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(G1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, G2, G3, G4, G5, G6, G7, G8))
                            .addDirection(new Direction<>(EAST, H1))
                            .addDirection(new Direction<>(WEST, F1, E1, D1, C1, B1, A1))
                            .build()
                    ).build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapBuilder<>()
                    .setFromField(H1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NORTH, H2, H3, H4, H5, H6, H7, H8))
                            .addDirection(new Direction<>(WEST, G1, F1, E1, D1, C1, B1, A1))
                            .build()
                    ).build()
            )
            .build();
    }

}


