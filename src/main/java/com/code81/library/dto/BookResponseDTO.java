package com.code81.library.dto;

import com.code81.library.Enum.BookStatus;
import lombok.Data;
import java.util.Set;

@Data
public class BookResponseDTO {
    private Long ISBN;
    private String title;
    private String language;
    private int publicationYear;
    private String coverImageUrl;
    private int edition;
    private String summary;
    private BookStatus status;
    private int totalCopies;
    private int availableCopies;
    private PublisherResponseDTO publisher;
    private Set<AuthorResponseDTO> authors;
    private Set<CategoryResponseDTO> categories;
}