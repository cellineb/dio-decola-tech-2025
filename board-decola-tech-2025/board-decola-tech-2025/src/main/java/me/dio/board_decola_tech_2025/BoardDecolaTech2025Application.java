package me.dio.board_decola_tech_2025;

import me.dio.board_decola_tech_2025.persistence.migration.MigrationStrategy;
import me.dio.board_decola_tech_2025.ui.MainMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

import static me.dio.board_decola_tech_2025.persistence.config.ConnectionConfig.getConnection;


public class BoardDecolaTech2025Application {

	public static void main(String[] args) throws SQLException {

		try (var connection = getConnection()) {
			new MigrationStrategy(connection).executeMigration();
		}
		new MainMenu().execute();
	}
}
