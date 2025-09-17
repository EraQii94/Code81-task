package com.code81.library.controller;

import com.code81.library.dto.BorrowingTransactionRequestDTO;
import com.code81.library.dto.BorrowingTransactionResponseDTO;
import com.code81.library.service.BorrowingTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:3000")
public class BorrowingTransactionController {

    @Autowired
    private BorrowingTransactionService borrowingTransactionService;

    @GetMapping
    public ResponseEntity<List<BorrowingTransactionResponseDTO>> getAllTransactions() {
        List<BorrowingTransactionResponseDTO> transactions = borrowingTransactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingTransactionResponseDTO> getTransactionById(@PathVariable Long id) {
        BorrowingTransactionResponseDTO transaction = borrowingTransactionService.getTransactionById(id);
        if (transaction != null) {
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BorrowingTransactionResponseDTO> createTransaction(@RequestBody BorrowingTransactionRequestDTO transactionRequestDTO) {
        BorrowingTransactionResponseDTO createdTransaction = borrowingTransactionService.createTransaction(transactionRequestDTO);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowingTransactionResponseDTO> updateTransaction(@PathVariable Long id, @RequestBody BorrowingTransactionRequestDTO transactionRequestDTO) {
        BorrowingTransactionResponseDTO updatedTransaction = borrowingTransactionService.updateTransaction(id, transactionRequestDTO);
        if (updatedTransaction != null) {
            return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        borrowingTransactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}