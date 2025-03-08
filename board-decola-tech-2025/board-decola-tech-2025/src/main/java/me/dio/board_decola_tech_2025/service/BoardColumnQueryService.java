package me.dio.board_decola_tech_2025.service;

import lombok.AllArgsConstructor;
import me.dio.board_decola_tech_2025.persistence.dao.BoardColumnDAO;
import me.dio.board_decola_tech_2025.persistence.entity.BoardColumnEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class BoardColumnQueryService {

    private final Connection connection;

    public Optional<BoardColumnEntity> findById(final Long id) throws SQLException {
        var dao = new BoardColumnDAO(connection);
        return dao.findById(id);
    }

}
