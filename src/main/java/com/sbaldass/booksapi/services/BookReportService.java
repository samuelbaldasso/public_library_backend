package com.sbaldass.booksapi.services;

import com.sbaldass.booksapi.domain.Book;
import com.sbaldass.booksapi.domain.BookReport;
import com.sbaldass.booksapi.domain.User;
import com.sbaldass.booksapi.repositories.BookReportRepository;
import com.sbaldass.booksapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookReportService {
    @Autowired
    private BookReportRepository bookReportRepository;

    public BookReport createReport(BookReport bookReport){
        bookReport.setBookStatus(bookReport.getBookStatus());
        bookReport.setBookId(bookReport.getBookId());
        bookReport.setUserId(bookReport.getUserId());
        bookReportRepository.save(bookReport);
        return bookReport;
    }
    public List<BookReport> booksReportsList() {
        return bookReportRepository.findAll();
    }

    public BookReport updateReport(BookReport bookReport, Long id){
        BookReport bookReport1 = bookReportRepository.findById(id).orElseThrow(() -> new RuntimeException("Book report not found"));
        bookReport1.setBookStatus(bookReport.getBookStatus());
        bookReport1.setBookId(bookReport.getBookId());
        bookReport1.setUserId(bookReport.getUserId());
        bookReportRepository.save(bookReport1);
        return bookReport1;
    }
    public void delete(Long id) {
        bookReportRepository.deleteById(id);
    }

}
