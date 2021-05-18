package com.example.userpractice.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    private String book_name;

    @Column
    private String author_name;

    @Column
    private String isbn;

    public Book() {
    }

    public Book(String book_name, String author_name, String isbn) {
        this.book_name = book_name;
        this.author_name = author_name;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(book_name, book.book_name) && Objects.equals(author_name, book.author_name) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book_name, author_name, isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", book_name='" + book_name + '\'' +
                ", author_name='" + author_name + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

