package com.code81.library.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MemberRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate membershipDate;
}