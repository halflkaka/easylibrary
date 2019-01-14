package com.halflkaka.bookapi.controllers;

import com.halflkaka.bookapi.models.Book;
import com.halflkaka.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Canjie on 2019-01-13 20:07
 */

@RestController
@RequestMapping(BookController.BASE_URL)
public class BookController {

    public static final String BASE_URL = "/api/book";
    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Get all the books
    @GetMapping
    List<Book> getAllBooks() {
        return bookService.getAll();
    }
}
