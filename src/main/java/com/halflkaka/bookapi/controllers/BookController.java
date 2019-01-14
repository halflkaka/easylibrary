package com.halflkaka.bookapi.controllers;

import com.halflkaka.bookapi.models.Book;
import com.halflkaka.bookapi.models.ProjectStatus;
import com.halflkaka.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Canjie on 2019-01-13 20:07
 */

@CrossOrigin("*")
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
    @GetMapping()
    List<Book> getAllBooks() {
        return bookService.getAll();
    }

    //Get book by Id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.get(id);
    }

    //Create book
    @PostMapping
    public ResponseEntity<ProjectStatus> saveBook(@RequestBody Book book) {
        long id = bookService.save(book);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Book with id: " + id + " has been saved."), HttpStatus.OK);
    }

    //Update book info by Id
    @PutMapping("/{id}")
    public ResponseEntity<ProjectStatus> updateBook(@PathVariable long id, @RequestBody Book book) {
        bookService.update(id, book);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Book with id: " + id + " has been updated."), HttpStatus.OK);
    }

    //Delete book by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ProjectStatus> deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return new ResponseEntity<ProjectStatus>(new ProjectStatus("Book with id: " + id + " has been deleted."), HttpStatus.OK);
    }
}
