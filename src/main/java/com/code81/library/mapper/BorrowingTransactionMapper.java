package com.code81.library.mapper;

import com.code81.library.dto.BorrowingTransactionRequestDTO;
import com.code81.library.dto.BorrowingTransactionResponseDTO;
import com.code81.library.entity.BorrowingTransaction;
import org.springframework.stereotype.Component;

@Component
public class BorrowingTransactionMapper implements GenericMapper<BorrowingTransaction, BorrowingTransactionResponseDTO> {

    @Override
    public BorrowingTransactionResponseDTO toDTO(BorrowingTransaction transaction) {
        if (transaction == null) {
            return null;
        }

        BorrowingTransactionResponseDTO transactionDTO = new BorrowingTransactionResponseDTO();
        transactionDTO.setId(transaction.getId());
        transactionDTO.setBorrowDate(transaction.getBorrowDate());
        transactionDTO.setDueDate(transaction.getDueDate());
        transactionDTO.setReturnDate(transaction.getReturnDate());

        return transactionDTO;
    }

    @Override
    public BorrowingTransaction toEntity(BorrowingTransactionResponseDTO transactionDTO) {
        if (transactionDTO == null) {
            return null;
        }

        BorrowingTransaction transaction = new BorrowingTransaction();
        transaction.setId(transactionDTO.getId());
        transaction.setBorrowDate(transactionDTO.getBorrowDate());
        transaction.setDueDate(transactionDTO.getDueDate());
        transaction.setReturnDate(transactionDTO.getReturnDate());

        return transaction;
    }

    public BorrowingTransaction toEntityFromRequest(BorrowingTransactionRequestDTO transactionRequestDTO) {
        if (transactionRequestDTO == null) {
            return null;
        }

        BorrowingTransaction transaction = new BorrowingTransaction();
        transaction.setBorrowDate(transactionRequestDTO.getBorrowDate());
        transaction.setDueDate(transactionRequestDTO.getDueDate());
        transaction.setReturnDate(transactionRequestDTO.getReturnDate());

        return transaction;
    }

    @Override
    public java.util.List<BorrowingTransactionResponseDTO> toDTOList(java.util.List<BorrowingTransaction> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }

    @Override
    public java.util.List<BorrowingTransaction> toEntityList(java.util.List<BorrowingTransactionResponseDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }
}