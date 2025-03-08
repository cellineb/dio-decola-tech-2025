package me.dio.board_decola_tech_2025.dto;

import me.dio.board_decola_tech_2025.persistence.entity.BoardColumnKindEnum;

public record BoardColumnDTO(Long id, String name, BoardColumnKindEnum kind, int cardsAmount) {
}
