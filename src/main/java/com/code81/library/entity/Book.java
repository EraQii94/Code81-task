package com.code81.library.entity;


import com.code81.library.Enum.BookStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ISBN;

    @Column(nullable = false)
    private String title;

    private String language;
    private int publicationYear;
    private String coverImageUrl;
    private String edition;
    private String summary;
    private BookStatus status;
    private int totalCopies;
    private int availableCopies;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_isbn"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<BorrowingTransaction> borrowingTransactions = new HashSet<>();


}
