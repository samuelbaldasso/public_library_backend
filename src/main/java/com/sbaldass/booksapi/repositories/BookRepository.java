package com.sbaldass.booksapi.repositories;

import com.sbaldass.booksapi.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
