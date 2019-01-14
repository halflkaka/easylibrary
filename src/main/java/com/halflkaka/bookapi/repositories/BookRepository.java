package com.halflkaka.bookapi.repositories;

import com.halflkaka.bookapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Canjie on 2019-01-13 19:58
 */

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
