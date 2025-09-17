package com.code81.library.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BorrowingTransactionResponseDTO {
    private Long id;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private BookResponseDTO book;
    private MemberResponseDTO member;
}