package com.code81.library.service.impl;

import com.code81.library.dto.AuthorRequestDTO;
import com.code81.library.dto.AuthorResponseDTO;
import com.code81.library.entity.Author;
import com.code81.library.mapper.AuthorMapper;
import com.code81.library.repository.AuthorRepository;
import com.code81.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<AuthorResponseDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.toDTOList(authors);
    }

    @Override
    public AuthorResponseDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        return authorMapper.toDTO(author);
    }

    @Override
    public AuthorResponseDTO createAuthor(AuthorRequestDTO authorRequestDTO) {
        Author author = authorMapper.toEntityFromRequest(authorRequestDTO);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toDTO(savedAuthor);
    }

    @Override
    public AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO authorRequestDTO) {
        Author existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            // Update fields
            existingAuthor.setName(authorRequestDTO.getName());
            
            Author updatedAuthor = authorRepository.save(existingAuthor);
            return authorMapper.toDTO(updatedAuthor);
        }
        return null;
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}