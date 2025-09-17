package com.code81.library.dto;

import com.code81.library.Enum.Role;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String userName;
    private String email;
    private String password;
    private Role role;
}