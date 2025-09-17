package com.code81.library.service.impl;

import com.code81.library.dto.UserRequestDTO;
import com.code81.library.dto.UserResponseDTO;
import com.code81.library.entity.User;
import com.code81.library.mapper.UserMapper;
import com.code81.library.repository.UserRepository;
import com.code81.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTOList(users);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return userMapper.toDTO(user);
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntityFromRequest(userRequestDTO);
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Update fields
            existingUser.setUserName(userRequestDTO.getUserName());
            existingUser.setEmail(userRequestDTO.getEmail());
            existingUser.setRole(userRequestDTO.getRole());
            
            // Only update password if it's provided
            if (userRequestDTO.getPassword() != null && !userRequestDTO.getPassword().isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
            }
            
            User updatedUser = userRepository.save(existingUser);
            return userMapper.toDTO(updatedUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}