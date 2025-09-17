package com.code81.library.service;

import com.code81.library.dto.AuthorRequestDTO;
import com.code81.library.dto.AuthorResponseDTO;
import java.util.List;

public interface AuthorService {
    List<AuthorResponseDTO> getAllAuthors();
    AuthorResponseDTO getAuthorById(Long id);
    AuthorResponseDTO createAuthor(AuthorRequestDTO authorRequestDTO);
    AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO authorRequestDTO);
    void deleteAuthor(Long id);
}