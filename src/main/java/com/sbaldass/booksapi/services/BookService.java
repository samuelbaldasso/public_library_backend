package com.sbaldass.booksapi.services;

import com.sbaldass.booksapi.domain.Book;
import com.sbaldass.booksapi.domain.User;
import com.sbaldass.booksapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book create(Book book){
        book.setAuthor(book.getAuthor());
        book.setIsbn(book.getIsbn());
        book.setGenre(book.getGenre());
        book.setNumberAvailable(book.getNumberAvailable());
        book.setPublisher(book.getPublisher());
        book.setTitle(book.getTitle());
        book.setYearPublished(book.getYearPublished());
        bookRepository.save(book);
        return book;
    }

    public Book update(Book book, Long id){
        Book book1 = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book1.setAuthor(book.getAuthor());
        book1.setIsbn(book.getIsbn());
        book1.setGenre(book.getGenre());
        book1.setNumberAvailable(book.getNumberAvailable());
        book1.setPublisher(book.getPublisher());
        book1.setTitle(book.getTitle());
        book1.setYearPublished(book.getYearPublished());
        bookRepository.save(book1);
        return book1;
    }

    public List<Book> booksList() {
        return bookRepository.findAll();
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }
}
