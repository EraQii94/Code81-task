package com.code81.library.mapper;

import com.code81.library.dto.UserRequestDTO;
import com.code81.library.dto.UserResponseDTO;
import com.code81.library.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements GenericMapper<User, UserResponseDTO> {

    @Override
    public UserResponseDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserResponseDTO userDTO = new UserResponseDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());

        return userDTO;
    }

    @Override
    public User toEntity(UserResponseDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());

        return user;
    }

    public User toEntityFromRequest(UserRequestDTO userRequestDTO) {
        if (userRequestDTO == null) {
            return null;
        }

        User user = new User();
        user.setUserName(userRequestDTO.getUserName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(userRequestDTO.getRole());

        return user;
    }

    @Override
    public java.util.List<UserResponseDTO> toDTOList(java.util.List<User> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }

    @Override
    public java.util.List<User> toEntityList(java.util.List<UserResponseDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }
}