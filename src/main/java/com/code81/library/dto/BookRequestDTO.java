package com.code81.library.dto;

import com.code81.library.Enum.BookStatus;
import lombok.Data;

@Data
public class BookRequestDTO {
    private String title;
    private String language;
    private int publicationYear;
    private String coverImageUrl;
    private String edition;
    private String summary;
    private BookStatus status;
    private int totalCopies;
    private int availableCopies;
    private Long publisherId;
}