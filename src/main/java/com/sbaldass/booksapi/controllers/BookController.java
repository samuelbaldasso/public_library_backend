package com.sbaldass.booksapi.controllers;

import com.sbaldass.booksapi.domain.Book;
import com.sbaldass.booksapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/add")
    public Book add(@RequestBody Book book) {
        return service.create(book);
    }

    @GetMapping("/books")
    public List<Book> listBooks() {
        return service.booksList();
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        return service.update(book, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
