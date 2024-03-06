package com.sbaldass.booksapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books_reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long bookId;
    private BookStatus bookStatus;

}
