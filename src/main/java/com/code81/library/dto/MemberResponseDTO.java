package com.code81.library.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
public class MemberResponseDTO {
    private Long NID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate membershipDate;
    private Set<BorrowingTransactionResponseDTO> borrowingTransactions;
}