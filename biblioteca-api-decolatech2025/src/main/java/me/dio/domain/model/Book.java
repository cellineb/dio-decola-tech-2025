package me.dio.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "tb_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private long ISBN;

    private String title;
    private String author;
    private String genre;
    private LocalDate publicationDate;
    private int stars;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}