# Decola Tech Avanade 2025
Diagrama de classes Projeto 1 API REST - Biblioteca 

```mermaid
classDiagram
    class Usuario {
        +String id
        +String nome
        +String CPF
        +List<Livro> favoritos
        +List<Livro> wishlist
    }
    
    class Livro {
        +String id
        +String titulo
        +String autor
        +String genero
        +String dataPublicacao
        +int estrelas
    }
    
    Usuario "1" --* "*" Livro : Favoritos
    Usuario "1" --* "*" Livro : Wishlist
    
    class Biblioteca {
        +List<Usuario> usuarios
        +List<Livro> livros
    }
    
    Biblioteca "1" --* "*" Usuario
    Biblioteca "1" --* "*" Livro
````
