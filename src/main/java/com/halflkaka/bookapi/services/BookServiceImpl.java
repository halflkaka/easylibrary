package com.halflkaka.bookapi.services;

import com.halflkaka.bookapi.models.Book;
import com.halflkaka.bookapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Canjie on 2019-01-13 19:55
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public long save(Book book) {
        return bookRepository.save(book).getId();
    }

    @Override
    public Book get(long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void update(long id, Book book) {
    }

    @Override
    public void delete(long id) {

    }
}
