package com.sbaldass.booksapi.controllers;

import com.sbaldass.booksapi.domain.Book;
import com.sbaldass.booksapi.domain.BookReport;
import com.sbaldass.booksapi.services.BookReportService;
import com.sbaldass.booksapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookReport")
public class BookReportController {

    @Autowired
    private BookReportService service;

    @PostMapping("/add")
    public BookReport add(@RequestBody BookReport book) {
        return service.createReport(book);
    }

    @GetMapping("/books")
    public List<BookReport> listBooksReports() {
        return service.booksReportsList();
    }

    @PutMapping("/{id}")
    public BookReport update(@PathVariable Long id, @RequestBody BookReport book) {
        return service.updateReport(book, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
