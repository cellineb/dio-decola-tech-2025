package me.dio.board_decola_tech_2025.service;

import lombok.AllArgsConstructor;
import me.dio.board_decola_tech_2025.dto.CardDetailsDTO;
import me.dio.board_decola_tech_2025.persistence.dao.CardDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class CardQueryService {

    private final Connection connection;

    public Optional<CardDetailsDTO> findById(final Long id) throws SQLException {
        var dao = new CardDAO(connection);
        return dao.findById(id);
    }

}