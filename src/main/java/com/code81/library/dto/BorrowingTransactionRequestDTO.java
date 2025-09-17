package com.code81.library.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BorrowingTransactionRequestDTO {
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private Long bookISBN;
    private Long memberId;
}