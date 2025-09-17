package com.code81.library.service;

import com.code81.library.dto.BorrowingTransactionRequestDTO;
import com.code81.library.dto.BorrowingTransactionResponseDTO;
import java.util.List;

public interface BorrowingTransactionService {
    List<BorrowingTransactionResponseDTO> getAllTransactions();
    BorrowingTransactionResponseDTO getTransactionById(Long id);
    BorrowingTransactionResponseDTO createTransaction(BorrowingTransactionRequestDTO transactionRequestDTO);
    BorrowingTransactionResponseDTO updateTransaction(Long id, BorrowingTransactionRequestDTO transactionRequestDTO);
    void deleteTransaction(Long id);
}