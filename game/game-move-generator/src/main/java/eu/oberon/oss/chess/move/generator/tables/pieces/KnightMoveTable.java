package eu.oberon.oss.chess.move.generator.tables.pieces;

import org.jetbrains.annotations.Nullable;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.enums.PieceType;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.move.generator.MoveTable;
import eu.oberon.oss.chess.move.generator.tables.Direction;
import eu.oberon.oss.chess.move.generator.tables.DirectionMap.DirectionMapBuilder;
import eu.oberon.oss.chess.move.generator.tables.MoveTableImpl;
import eu.oberon.oss.chess.move.generator.tables.TargetFieldMapping;

import static eu.oberon.oss.chess.base.enums.ChessField.*;
import static eu.oberon.oss.chess.base.enums.MoveDirection.NONE;
import static eu.oberon.oss.chess.base.enums.PieceType.KNIGHT;

/**
 * @author Fabien H. Dumay
 */
class KnightMoveTable implements MoveTable<Field> {
    private final MoveTable<Field> moveTable;

    @Override
    public @Nullable TargetFieldMapping<Field> getFieldMapping(Field field) {
        return moveTable.getFieldMapping(field);
    }

    @Override
    public PieceType getPiece() {
        return PieceType.KNIGHT;
    }

    @Override
    public @Nullable ChessColor getColor() {
        return null;
    }

    KnightMoveTable() {
        moveTable = new MoveTableImpl.MoveTableBuilder<>()
            .setPiece(KNIGHT)
            /* 8th Rank */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, C7, B6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, D7, C6, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, E7, D6, B6, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, F7, E6, C6, B7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G7, F6, D6, C7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, H7, G6, E6, D7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, H6, F6, E7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H8)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G6, F7))
                            .build()
                    )
                    .build()
            )
            /* 7th Rank*/
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, C8, C6, B5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, D8, D6, C5, A5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, E8, E6, D5, B5, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, F8, F6, E5, C5, B6, B8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G8, G6, F5, D5, C6, C8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, H8, H6, G5, E5, D6, D8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, H5, F5, E6, E8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H7)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G5, F6, F8))
                            .build()
                    )
                    .build()
            )
            /* 6th Rank */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, B8, C7, C5, B4))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, C8, D7, D5, C4, A4, A8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, D8, E7, E5, D4, B4, A5, A7, B8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, E8, F7, F5, E4, C4, B5, B7, C8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, F8, G7, G5, F4, D4, C5, C7, D8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G8, H7, H5, G4, E4, D5, D7, E8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, H8, H4, F4, E5, E7, F8))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H6)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G4, D5, D7, G8))
                            .build()
                    )
                    .build()
            )
            /* 5th Rank */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, B7, C6, C4, B3))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, C7, D6, D4, C3, A3, A7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, D7, E6, E4, D3, B3, A4, A6, B7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, E7, F6, F4, E3, C3, B4, B6, C7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, F7, G6, G4, F3, D3, C4, C6, D7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G7, H6, H4, G3, E3, D4, D6, E7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, H7, H3, F3, E4, E6, F7))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H5)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G3, F4, F6, G7))
                            .build()
                    )
                    .build()
            )
            /* 4th Rank */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, B6, C5, C3, B2))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, C6, D5, D3, C2, A2, A6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, D6, E5, E3, D2, B2, A3, A5, B6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, E6, F5, F3, E2, C2, B3, B5, C6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, F6, G5, G3, F2, D2, C3, C5, D6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G6, H5, H3, G2, E2, D3, D5, E6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, H6, H2, F2, E3, E5, F6))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H4)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G2, F3, F5, G6))
                            .build()
                    )
                    .build()
            )
            /* 3rd Rank */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, B5, C4, C2, B1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, C5, D4, D2, C1, A1, A5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, D5, E4, E2, D1, B1, A2, A4, B5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, E5, F4, F2, E1, C1, B2, B4, C5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, F5, G4, G2, F1, D1, C2, C4, D5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G5, H4, H2, G1, E1, D2, D4, E5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, H5, H1, F1, E2, E4, F5))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H3)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G1, F2, F4, G5))
                            .build()
                    )
                    .build()
            )
            /* 2nd Rank */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, B4, C3, C1))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, C4, D3, D1, A4))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, D4, E3, E1, A1, A3, B4))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, E4, F3, F1, B1, B3, C4))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, F4, G3, G1, C1, C3, D4))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G4, H3, H1, D1, D3, E4))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, H4, E1, E3, F4))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H2)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, F1, F3, G4))
                            .build()
                    )
                    .build()
            )
            /* 1st Rank */
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(A1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, B3, C2))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(B1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, C3, D2, A3))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(C1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, D3, E2, A2, B3))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(D1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, E3, F2, B2, C3))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(E1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, F3, G2, C2, D3))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(F1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, G3, H2, D2, E3))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(G1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, H3, E2, F3))
                            .build()
                    )
                    .build()
            )
            .addTargetFieldMapping(
                new TargetFieldMapping.TargetFieldMapBuilder<>()
                    .setFromField(H1)
                    .setDirectionMap(
                        new DirectionMapBuilder<>()
                            .addDirection(new Direction<>(NONE, F2, G3))
                            .build()
                    )
                    .build()
            )
            .build();
    }
}
