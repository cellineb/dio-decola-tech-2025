# Decola Tech Avanade 2025
## Projeto 1 - API REST - Biblioteca 
<p>O projeto consiste em uma API RESTful desenvolvida em Java com o framework Spring Boot. A aplicação tem como objetivo gerenciar um acervo pessoal de livros, onde os usuários podem manter uma lista de livros favoritos e outra lista de livros que desejam comprar (wishlist). Os usuários podem adicionar os livros que leram e darem uma nota de 1 a 5 (estrelas). A API oferece operações completas de CRUD (Create, Read, Update e Delete) para as duas entidades principais: User e Book. 
<br>Para auxiliar na abstração e melhor entendimento do projeto foram desenvolvidos um protótipo e um digrama de classes. O protótipo foi feito pelo Figma e o diagrama foi feito com base na sintaxe mermaid</p>
<a href="https://drive.google.com/file/d/1ROQKl-DViSmt8UlK6o8ymMHjD2BxGrDO/view?usp=sharing">Link do Protótipo</a> 

```mermaid
classDiagram
    class Book {
        -int id
        -long ISBN
        -String title
        -String author
        -String genre
        -LocalDate publicationDate
        -int stars
    }

    class User {
        -int id
        -String name
        -String CPF
        -List~Book~ favorites
        -List~Book~ wishlist
    }

    User "1" *-- "0..*" Book : favorites
    User "1" *-- "0..*" Book : wishlist
````

## Projeto 2 - Board de Tarefas 
No segundo projeto o desafio era desenvolver um board de tarefas. Cada board possui suas colunas sendo 3 obrigatórias (inicial, final e cancelada) e podendo existir colunas não obrigatórias também. Nas colunas dos boards podem existir cards, sendo possivel mudar o status (bloqueado e desbloqueado) e mudar de coluna, além do usuário receber uma descrição de quantas vezes já foi bloqueado e o motivo. Para a conexão com o Banco de Dados utilizei o MySQLWorkbench. Para a abstração do projeto foi desenvolvido um diagrama de classes na sintaxe mermaid.

```mermaid
classDiagram
    Board "1" -- "*" BoardColumn : contains
    BoardColumn "1" -- "*" Card : contains
    Block "1" -- "*" Card : blocks
    
    class Board {
        +id: long
        +name: string
    }
    
    class BoardColumn {
        +id: long
        +name: string
        +kind: string
        +order: int
    }
    
    class Block {
        +id: long
        +blockCause: string
        +blockIn: OffsetDateTime
        +unblockCause: string
        +unblockIn: OffsetDateTime
    }
    
    class Card {
        +id: long
        +title: string
        +description: string
        +createdAt: OffsetDateTime
    }
```

## Projeto 3 - Blog com Angular
Crie uma aplicação de blog funcional, construa componentes inteligentes e aprenda como organizar seu projeto Angular utilizando as ferramentas que o próprio framework Oferece.

## Projeto 4 - APP Full Stack Barbearia
O projeto 5 consiste na criação de um app de agendamento para uma barbearia, tendo os CRUD's para a entidade cliente e agendamentos. O back-end foi desenvolvido em Java e Gradle, enquanto o front-end foi desenvolvido em TypeScript com Angular.

## Projeto 5 - Clone do BuzzFeed
