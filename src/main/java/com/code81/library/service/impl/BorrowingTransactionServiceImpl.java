package com.code81.library.service.impl;

import com.code81.library.dto.BorrowingTransactionRequestDTO;
import com.code81.library.dto.BorrowingTransactionResponseDTO;
import com.code81.library.entity.BorrowingTransaction;
import com.code81.library.mapper.BorrowingTransactionMapper;
import com.code81.library.repository.BorrowingTransactioRepository;
import com.code81.library.service.BorrowingTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BorrowingTransactionServiceImpl implements BorrowingTransactionService {

    @Autowired
    private BorrowingTransactioRepository borrowingTransactionRepository;

    @Autowired
    private BorrowingTransactionMapper borrowingTransactionMapper;

    @Override
    public List<BorrowingTransactionResponseDTO> getAllTransactions() {
        List<BorrowingTransaction> transactions = borrowingTransactionRepository.findAll();
        return borrowingTransactionMapper.toDTOList(transactions);
    }

    @Override
    public BorrowingTransactionResponseDTO getTransactionById(Long id) {
        BorrowingTransaction transaction = borrowingTransactionRepository.findById(id).orElse(null);
        return borrowingTransactionMapper.toDTO(transaction);
    }

    @Override
    public BorrowingTransactionResponseDTO createTransaction(BorrowingTransactionRequestDTO transactionRequestDTO) {
        BorrowingTransaction transaction = borrowingTransactionMapper.toEntityFromRequest(transactionRequestDTO);
        BorrowingTransaction savedTransaction = borrowingTransactionRepository.save(transaction);
        return borrowingTransactionMapper.toDTO(savedTransaction);
    }

    @Override
    public BorrowingTransactionResponseDTO updateTransaction(Long id, BorrowingTransactionRequestDTO transactionRequestDTO) {
        BorrowingTransaction existingTransaction = borrowingTransactionRepository.findById(id).orElse(null);
        if (existingTransaction != null) {
            // Update fields
            existingTransaction.setBorrowDate(transactionRequestDTO.getBorrowDate());
            existingTransaction.setDueDate(transactionRequestDTO.getDueDate());
            existingTransaction.setReturnDate(transactionRequestDTO.getReturnDate());
            
            BorrowingTransaction updatedTransaction = borrowingTransactionRepository.save(existingTransaction);
            return borrowingTransactionMapper.toDTO(updatedTransaction);
        }
        return null;
    }

    @Override
    public void deleteTransaction(Long id) {
        borrowingTransactionRepository.deleteById(id);
    }
}