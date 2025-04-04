# API REST - Biblioteca 
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
