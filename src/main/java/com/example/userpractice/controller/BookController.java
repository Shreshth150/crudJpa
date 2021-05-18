package com.example.userpractice.controller;

import com.example.userpractice.model.Book;
import com.example.userpractice.service.BookRespositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRespositoryImpl bookRespository ;

    @Autowired
    public BookController(BookRespositoryImpl bookRespository) {
        this.bookRespository = bookRespository;
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookRespository.getAllBooks();

        return new ResponseEntity<>(books , HttpStatus.OK);
    }

    @GetMapping("/getBookbyId/{id}")
    public ResponseEntity<Optional<Book>> getbookById(@PathVariable(value = "id") Long id){
        Optional<Book> book = bookRespository.BookById(id);

        return new ResponseEntity<>(book , HttpStatus.OK);
    }

    @PostMapping("/addBook")
    public Book addbook(@RequestBody Book book){
        return bookRespository.addBook(book);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable(value = "id") Long id , @RequestBody Book book){
        return bookRespository.updateBook(id , book);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable(value = "id") Long id){
        return bookRespository.deleteBook(id);
    }

}
