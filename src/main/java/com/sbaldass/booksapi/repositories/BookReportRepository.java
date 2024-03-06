package com.sbaldass.booksapi.repositories;

import com.sbaldass.booksapi.domain.Book;
import com.sbaldass.booksapi.domain.BookReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReportRepository extends JpaRepository<BookReport, Long> {

}

