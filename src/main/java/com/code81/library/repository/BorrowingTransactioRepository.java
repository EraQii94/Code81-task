package com.code81.library.repository;

import com.code81.library.entity.BorrowingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingTransactioRepository extends JpaRepository<BorrowingTransaction,Long> {
}
