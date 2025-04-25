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

import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;
import static eu.oberon.oss.chess.base.enums.ChessField.*;
import static eu.oberon.oss.chess.base.enums.MoveDirection.*;
import static eu.oberon.oss.chess.base.enums.PieceType.PAWN;

/**
 * @author Fabien H. Dumay
 */
class BlackPawnMoveTable implements MoveTable<Field> {
    private final MoveTable<Field> moveTable;

    @Override
    public @Nullable TargetFieldMapping<Field> getFieldMapping(Field field) {
        return moveTable.getFieldMapping(field);
    }

    @Override
    public PieceType getPiece() {
        return PieceType.PAWN;
    }

    @Override
    public @Nullable ChessColor getColor() {
        return BLACK;
    }

    BlackPawnMoveTable() {
        moveTable = new MoveTableImpl.MoveTableBuilder<>()
                .setPiece(PAWN)
                .setColor(WHITE)
                /* 7th RANK */
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(A7)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, A6, A5))
                                                .addDirection(new Direction<>(SOUTH_EAST, B6))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(B7)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, B6, B5))
                                                .addDirection(new Direction<>(SOUTH_EAST, C6))
                                                .addDirection(new Direction<>(SOUTH_WEST, A6))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(C7)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, C6, C5))
                                                .addDirection(new Direction<>(SOUTH_EAST, D6))
                                                .addDirection(new Direction<>(SOUTH_WEST, B6))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(D7)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, D6, D5))
                                                .addDirection(new Direction<>(SOUTH_EAST, E6))
                                                .addDirection(new Direction<>(SOUTH_WEST, C6))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(E7)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, E6, E5))
                                                .addDirection(new Direction<>(SOUTH_EAST, F6))
                                                .addDirection(new Direction<>(SOUTH_WEST, D6))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(F7)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, F6, F5))
                                                .addDirection(new Direction<>(SOUTH_EAST, G6))
                                                .addDirection(new Direction<>(SOUTH_WEST, E6))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(G7)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, G6, G5))
                                                .addDirection(new Direction<>(SOUTH_EAST, H6))
                                                .addDirection(new Direction<>(SOUTH_WEST, F6))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(H7)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, H6, H5))
                                                .addDirection(new Direction<>(SOUTH_WEST, G6))
                                                .build())
                                .build()
                )
                /* 6th Rank*/
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(A6)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, A5))
                                                .addDirection(new Direction<>(SOUTH_EAST, B5))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(B6)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, B5))
                                                .addDirection(new Direction<>(SOUTH_EAST, C5))
                                                .addDirection(new Direction<>(SOUTH_WEST, A5))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(C6)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, C5))
                                                .addDirection(new Direction<>(SOUTH_EAST, D5))
                                                .addDirection(new Direction<>(SOUTH_WEST, B5))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(D6)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, D5))
                                                .addDirection(new Direction<>(SOUTH_EAST, E5))
                                                .addDirection(new Direction<>(SOUTH_WEST, C5))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(E6)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, E5))
                                                .addDirection(new Direction<>(SOUTH_EAST, F5))
                                                .addDirection(new Direction<>(SOUTH_WEST, D5))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(F6)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, F5))
                                                .addDirection(new Direction<>(SOUTH_EAST, G5))
                                                .addDirection(new Direction<>(SOUTH_WEST, E5))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(G6)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, G5))
                                                .addDirection(new Direction<>(SOUTH_EAST, H5))
                                                .addDirection(new Direction<>(SOUTH_WEST, F5))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(H6)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, H5))
                                                .addDirection(new Direction<>(SOUTH_WEST, G5))
                                                .build())
                                .build()
                )
                /* 5th Rank */
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(A5)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, A4))
                                                .addDirection(new Direction<>(SOUTH_EAST, B4))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(B5)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, B4))
                                                .addDirection(new Direction<>(SOUTH_EAST, C4))
                                                .addDirection(new Direction<>(SOUTH_WEST, A4))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(C5)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, C4))
                                                .addDirection(new Direction<>(SOUTH_EAST, D4))
                                                .addDirection(new Direction<>(SOUTH_WEST, B4))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(D5)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, D4))
                                                .addDirection(new Direction<>(SOUTH_EAST, E4))
                                                .addDirection(new Direction<>(SOUTH_WEST, C4))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(E5)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, E4))
                                                .addDirection(new Direction<>(SOUTH_EAST, F4))
                                                .addDirection(new Direction<>(SOUTH_WEST, D4))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(F5)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, F4))
                                                .addDirection(new Direction<>(SOUTH_EAST, G4))
                                                .addDirection(new Direction<>(SOUTH_WEST, E4))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(G5)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, G4))
                                                .addDirection(new Direction<>(SOUTH_EAST, H4))
                                                .addDirection(new Direction<>(SOUTH_WEST, F4))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(H5)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, H4))
                                                .addDirection(new Direction<>(SOUTH_WEST, G4))
                                                .build())
                                .build()
                )
                /* 4th Rank */
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(A4)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, A3))
                                                .addDirection(new Direction<>(SOUTH_EAST, B3))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(B4)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, B3))
                                                .addDirection(new Direction<>(SOUTH_EAST, C3))
                                                .addDirection(new Direction<>(SOUTH_WEST, A3))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(C4)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, C3))
                                                .addDirection(new Direction<>(SOUTH_EAST, D3))
                                                .addDirection(new Direction<>(SOUTH_WEST, B3))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(D4)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, D3))
                                                .addDirection(new Direction<>(SOUTH_EAST, E3))
                                                .addDirection(new Direction<>(SOUTH_WEST, C3))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(E4)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, E3))
                                                .addDirection(new Direction<>(SOUTH_EAST, F3))
                                                .addDirection(new Direction<>(SOUTH_WEST, D3))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(F4)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, F3))
                                                .addDirection(new Direction<>(SOUTH_EAST, G3))
                                                .addDirection(new Direction<>(SOUTH_WEST, E3))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(G4)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, G3))
                                                .addDirection(new Direction<>(SOUTH_EAST, H3))
                                                .addDirection(new Direction<>(SOUTH_WEST, F3))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(H4)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, H3))
                                                .addDirection(new Direction<>(SOUTH_WEST, G3))
                                                .build())
                                .build()
                )
                /* 3rd Rank*/
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(A3)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, A2))
                                                .addDirection(new Direction<>(SOUTH_EAST, B2))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(B3)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, B2))
                                                .addDirection(new Direction<>(SOUTH_EAST, C2))
                                                .addDirection(new Direction<>(SOUTH_WEST, A2))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(C3)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, C2))
                                                .addDirection(new Direction<>(SOUTH_EAST, D2))
                                                .addDirection(new Direction<>(SOUTH_WEST, B2))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(D3)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, D2))
                                                .addDirection(new Direction<>(SOUTH_EAST, E2))
                                                .addDirection(new Direction<>(SOUTH_WEST, C2))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(E3)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, E2))
                                                .addDirection(new Direction<>(SOUTH_EAST, F2))
                                                .addDirection(new Direction<>(SOUTH_WEST, D2))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(F3)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, F2))
                                                .addDirection(new Direction<>(SOUTH_EAST, G2))
                                                .addDirection(new Direction<>(SOUTH_WEST, E2))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(G3)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, G2))
                                                .addDirection(new Direction<>(SOUTH_EAST, H2))
                                                .addDirection(new Direction<>(SOUTH_WEST, F2))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(H3)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, H2))
                                                .addDirection(new Direction<>(SOUTH_WEST, G2))
                                                .build())
                                .build()
                )
                /* 2nd Rank */
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(A2)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, A1))
                                                .addDirection(new Direction<>(SOUTH_EAST, B1))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(B2)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, B1))
                                                .addDirection(new Direction<>(SOUTH_EAST, C1))
                                                .addDirection(new Direction<>(SOUTH_WEST, A1))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(C2)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, C1))
                                                .addDirection(new Direction<>(SOUTH_EAST, D1))
                                                .addDirection(new Direction<>(SOUTH_WEST, B1))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(D2)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, C1))
                                                .addDirection(new Direction<>(SOUTH_EAST, E1))
                                                .addDirection(new Direction<>(SOUTH_WEST, C1))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(E2)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, E1))
                                                .addDirection(new Direction<>(SOUTH_EAST, F1))
                                                .addDirection(new Direction<>(SOUTH_WEST, D1))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(F2)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, F1))
                                                .addDirection(new Direction<>(SOUTH_EAST, G1))
                                                .addDirection(new Direction<>(SOUTH_WEST, E1))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(G2)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, G1))
                                                .addDirection(new Direction<>(SOUTH_EAST, H1))
                                                .addDirection(new Direction<>(SOUTH_WEST, F1))
                                                .build())
                                .build()
                )
                .addTargetFieldMapping(
                        new TargetFieldMapping.TargetFieldMapBuilder<>()
                                .setFromField(H2)
                                .setDirectionMap(
                                        new DirectionMap.DirectionMapBuilder<>()
                                                .addDirection(new Direction<>(SOUTH, H1))
                                                .addDirection(new Direction<>(SOUTH_WEST, G1))
                                                .build())
                                .build()
                )
                .build();
    }
}
