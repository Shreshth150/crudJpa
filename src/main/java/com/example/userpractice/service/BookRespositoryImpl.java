package com.example.userpractice.service;

import com.example.userpractice.model.Book;
import com.example.userpractice.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookRespositoryImpl {

    @Autowired
    private BookRespository bookrespository;

    public List<Book> getAllBooks(){
        return bookrespository.findAll();
    }

    public Optional<Book> BookById(Long id){
        Optional<Book> book = bookrespository.findById(id);
        return book;
    }

    public Book addBook(Book book){
        Book savedBook = bookrespository.save(book);
        return savedBook;
    }

    public Book updateBook(Long id , Book book){
        Optional<Book> bookFromDb = bookrespository.findById(id);
        Book book_new = bookFromDb.get();
        book_new.setBook_name(book.getBook_name());
        book_new.setAuthor_name(book.getAuthor_name());
        book_new.setIsbn(book.getIsbn());

        return bookrespository.save(book_new);
    }

    public Boolean deleteBook(Long id){
        Optional<Book> book = bookrespository.findById(id);

        Book book_new = book.get();
        if (book_new == null){
            return false;
        }
        bookrespository.delete(book_new);
        return true;
    }


}
