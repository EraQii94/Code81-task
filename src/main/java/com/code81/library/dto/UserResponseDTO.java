package com.code81.library.dto;

import com.code81.library.Enum.Role;
import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String userName;
    private String email;
    private Role role;
}