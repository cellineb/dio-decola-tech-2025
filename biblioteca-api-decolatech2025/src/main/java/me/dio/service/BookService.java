package me.dio.service;

import me.dio.controller.exception.ResourceNotFoundException;
import me.dio.domain.model.Book;
import me.dio.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    public Book update(int id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setISBN(updatedBook.getISBN());
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setGenre(updatedBook.getGenre());
                    book.setPublicationDate(updatedBook.getPublicationDate());
                    book.setStars(updatedBook.getStars());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }
}