package me.dio.board_decola_tech_2025.ui;

import me.dio.board_decola_tech_2025.persistence.entity.BoardColumnEntity;
import me.dio.board_decola_tech_2025.persistence.entity.BoardColumnKindEnum;
import me.dio.board_decola_tech_2025.persistence.entity.BoardEntity;
import me.dio.board_decola_tech_2025.service.BoardQueryService;
import me.dio.board_decola_tech_2025.service.BoardService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static me.dio.board_decola_tech_2025.persistence.config.ConnectionConfig.getConnection;
import static me.dio.board_decola_tech_2025.persistence.entity.BoardColumnKindEnum.*;

public class MainMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void execute() throws SQLException{
        System.out.println("Bem vindo ao gerenciador de Boards! Escolha uma das opções do menu: ");
        var option = -1;
        while (true){
            System.out.println("1 - Criar um novo Board");
            System.out.println("2 - Selecionar um Board existente");
            System.out.println("3 - Excluir um Board");
            System.out.println("4 - Sair");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> createBoard();
                case 2 -> selectBoard();
                case 3 -> deleteBoard();
                case 4 -> System.exit(0);
                default -> System.out.println("Opção inválida! Tente novamente!");
            }
        }
    }

    private void createBoard() throws SQLException{
        var entity = new BoardEntity();
        System.out.println("Informe o nome que deseja colocar no Board");
        entity.setName(scanner.next());

        System.out.println("O Board terá colunas adicionais além das 3 padrões? Se sim informe quantas colunas a mais serão, se não digite '0'");
        var additionalColumns = scanner.nextInt();

        List<BoardColumnEntity> columns = new ArrayList<>();

        System.out.println("Informe o nome da coluna inicial do Board");
        var initialColumnName = scanner.next();
        var initialColumn = createColumn(initialColumnName, INITIAL, 0);
        columns.add(initialColumn);

        for (int i = 0; i < additionalColumns; i++) {
            System.out.println("Informe o nome da coluna de tarefa pendente do Board");
            var pendingColumnName = scanner.next();
            var pendingColumn = createColumn(pendingColumnName, PENDING, i + 1);
            columns.add(pendingColumn);
        }

        System.out.println("Informe o nome da coluna final do Board");
        var finalColumnName = scanner.next();
        var finalColumn = createColumn(finalColumnName, FINAL, additionalColumns + 1);
        columns.add(finalColumn);

        System.out.println("Informe o nome da coluna de cancelamento do Board");
        var cancelColumnName = scanner.next();
        var cancelColumn = createColumn(cancelColumnName, CANCEL, additionalColumns + 2);
        columns.add(cancelColumn);

        entity.setBoardColumns(columns);
        try(var connection = getConnection()){
            var service = new BoardService(connection);
            service.insert(entity);
        }
    }

    private void selectBoard() throws SQLException {
        System.out.println("Informe o id do board que deseja selecionar");
        var id = scanner.nextLong();
        try(var connection = getConnection()){
            var queryService = new BoardQueryService(connection);
            var optional = queryService.findById(id);
            optional.ifPresentOrElse(
                    b -> new BoardMenu(b).execute(),
                    () -> System.out.printf("O Board de id %s não foi encontrado\n", id)
            );
        }
    }

    private void deleteBoard() throws SQLException {
        System.out.println("Informe o id do Board que deseja excluir");
        var id = scanner.nextLong();
        try(var connection = getConnection()){
            var service = new BoardService(connection);
            if (service.delete(id)) {
                System.out.printf("O Board de id %s foi excluído comsucesso!\n", id);
            } else {
                System.out.printf("O Board de id %s não foi encontrado\n", id);
            }
        }
    }

    private BoardColumnEntity createColumn(final String name, final BoardColumnKindEnum kind, final int order){
        var boardColumn = new BoardColumnEntity();
        boardColumn.setName(name);
        boardColumn.setKind(kind);
        boardColumn.setOrder(order);
        return boardColumn;
    }

}
