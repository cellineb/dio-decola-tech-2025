package me.dio.board_decola_tech_2025.dto;

import me.dio.board_decola_tech_2025.persistence.entity.BoardColumnKindEnum;

public record BoardColumnInfoDTO(Long id, int order, BoardColumnKindEnum kind) {
}
