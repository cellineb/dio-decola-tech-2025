package me.dio.board_decola_tech_2025.persistence.entity;

import java.util.stream.Stream;

public enum BoardColumnKindEnum {
    INITIAL, FINAL, CANCEL, PENDING;

    public static BoardColumnKindEnum findByName(final String name){
        return Stream.of(BoardColumnKindEnum.values())
                .filter(b -> b.name().equals(name))
                .findFirst().orElseThrow();
    }
}
