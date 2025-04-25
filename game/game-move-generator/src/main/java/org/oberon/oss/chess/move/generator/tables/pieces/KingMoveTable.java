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
import static org.oberon.oss.chess.base.enums.MoveDirection.NONE;
import static org.oberon.oss.chess.base.enums.PieceType.KING;

/**
 * @author Fabien H. Dumay
 */
@SuppressWarnings("java:S6548")
class KingMoveTable<F extends Field> implements MoveTable<F> {
    private final MoveTable<F> moveTable;

    @Override
    public @Nullable TargetFieldMapping<F> getFieldMapping(F field) {
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

    KingMoveTable() {
        //noinspection unchecked
        moveTable = (MoveTable<F>) new MoveTableBuilder<>()
                .setPiece(KING)
                /* 8th RANK */
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(A8)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, B8, B7, A7)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(B8)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, C8, C7, B7, A7, A8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(C8)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, D8, D7, C7, B7, B8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(D8)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, E8, E7, D7, C7, C8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(E8)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, F8, F7, E7, D7, D8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(F8)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, G8, G7, F7, E7, E8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(G8)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, H8, H7, G7, F7, F8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(H8)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, H7, G7, G8)).build()
                                )
                                .build()
                )
                /* 7th Rank*/
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(A7)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, A8, B8, B7, B6, A6)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(B7)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, B8, C8, C7, C6, B6, A6, A7, A8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(C7)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, C8, D8, D7, D6, C6, B6, B7, B8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(D7)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, D8, E8, E7, E6, D6, C6, C7, C8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(E7)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, E8, F8, F7, F6, E6, D6, D7, D8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(F7)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, F8, G8, G7, G6, F6, E6, E7, E8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(G7)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, G8, H8, H7, H6, G6, F6, F7, F8)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(H7)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, H8, H6, G6, G7, G8)).build()
                                )
                                .build()
                )
                /* 6th Rank */
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(A6)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, A7, B7, B6, B5, A5)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(B6)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, B7, C7, C6, C5, B5, A5, A6, A7)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(C6)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, C7, D7, D6, D5, C5, B5, B6, B7)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(D6)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, D7, E7, E6, E5, D5, C5, C6, C7)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(E6)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, E7, F7, F6, F5, E5, D5, D6, D7)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(F6)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, F7, G7, G6, G5, F5, E5, E6, E7)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(G6)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, G7, H7, H6, H5, G5, F5, F6, F7)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(H6)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, H7, H5, G5, G6, G7)).build()
                                )
                                .build()
                )
                /* 5th Rank */
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(A5)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, A6, B6, B5, B4, A4)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(B5)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, B6, C6, C5, C4, B4, A4, A5, A6)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(C5)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, C6, D6, D5, D4, C4, B4, B5, B6)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(D5)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, D6, E6, E5, E4, D4, C4, C5, C6)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(E5)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, E6, F6, F5, F4, E4, D4, D5, D6)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(F5)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, F6, G6, G5, G4, F4, E4, E5, E6)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(G5)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, G6, H6, H5, H4, G4, F4, F5, F6)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(H5)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, H6, H4, G4, G5, G6)).build()
                                )
                                .build()
                )
                /* 4th Rank */
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(A4)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, A5, B5, B4, B3, A3)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(B4)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, B5, C5, C4, C3, B3, A3, A4, A5)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(C4)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, C5, D5, D4, D3, C3, B3, B4, B5)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(D4)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, D5, E5, E4, E3, D3, C3, C4, C5)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(E4)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, E5, F5, F4, F3, E3, D3, D4, D5)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(F4)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, F5, G5, G4, G3, F3, E3, E4, E5)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(G4)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, G5, H5, H4, H3, G3, F3, F4, F5)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(H4)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, H5, H3, G3, G4, G5)).build()
                                )
                                .build()
                )
                /* 3rd Rank */
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(A3)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, A4, B4, B3, B2, A2)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(B3)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, B4, C4, C3, C2, B2, A2, A3, A4)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(C3)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, C4, D4, D3, D2, C2, B2, B3, B4)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(D3)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, D4, E4, E3, E2, D2, C2, C3, C4)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(E3)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, E4, F4, F3, F2, E2, D2, D3, D4)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(F3)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, F4, G4, G3, G2, F2, E2, E3, E4)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(G3)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, G4, H4, H3, H2, G2, F2, F3, F4)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(H3)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, H4, H2, G2, G3, G4)).build()
                                )
                                .build()
                )
                /* 2nd Rank */
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(A2)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, A3, B3, B2, B1, A1)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(B2)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, B3, C3, C2, C1, B1, A1, A2, A3)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(C2)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, C3, D3, D2, D1, C1, B1, B2, B3)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(D2)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, D3, E3, E2, E1, D1, C1, C2, C3)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(E2)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, E3, F3, F2, F1, E1, D1, D2, D3)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(F2)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, F3, G3, G2, G1, F1, E1, E2, E3)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(G2)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, G8, H3, H7, H1, G1, F1, F2, F3)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(H2)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, H3, H1, G1, G2, G3)).build()
                                )
                                .build()
                )
                /* 1st Rank*/
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(A1)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, A2, B2, B1)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(B1)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, B2, C2, C1, A1, A2)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(C1)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, C2, D2, D1, B1, B2)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(D1)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, D2, E2, E1, C1, C2)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(E1)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, E2, F2, F1, D1, D2)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(F1)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, F2, G2, G1, E1, E2)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(G1)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, G2, H2, H1, F1, F2)).build()
                                )
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapBuilder<>()
                                .setFromField(H1)
                                .setDirectionMap(
                                        new DirectionMapBuilder<>().addDirection(new Direction<>(NONE, H2, G1, G2)).build()
                                )
                                .build()
                )
                .build();
    }
}


