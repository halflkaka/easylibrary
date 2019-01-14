package com.halflkaka.bookapi.services;

import com.halflkaka.bookapi.models.Book;

import java.util.List;

/**
 * Created by Canjie on 2019-01-13 19:54
 */
public interface BookService {

    //Save the record
    long save(Book book);

    //Get a single record;
    Book get(long id);

    //Get all records
    List<Book> getAll();

    //Update
    void update(long id, Book book);

    //Delete
    void delete(long id);
}
