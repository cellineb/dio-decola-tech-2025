# Decola Tech Avanade 2025
## Projeto 1 - API REST - Biblioteca 
O Projeto consiste em uma API REST que utiliza Java e Spring Boot. A aplicação é um acervo pessoal de livros, contendo os usuarios que podem ter a lista de livros favoritos e a lista de desejo, as duas entidades (User e Book) possuem as 4 operações CRUD (Create, Read, Update e Delete). 
Foi desenvolvido para ajudar na abstração do projeto, um protótipo e um diagrama de classes. O protótipo foi feito pelo Figma e o diagrama de classes foi feito usando a sintaxe mermaid. 

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
