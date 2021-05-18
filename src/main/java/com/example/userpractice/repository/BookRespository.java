package com.example.userpractice.repository;

import com.example.userpractice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<Book , Long> {
}
