package com.code81.library.mapper;

import com.code81.library.dto.AuthorRequestDTO;
import com.code81.library.dto.AuthorResponseDTO;
import com.code81.library.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements GenericMapper<Author, AuthorResponseDTO> {

    @Override
    public AuthorResponseDTO toDTO(Author author) {
        if (author == null) {
            return null;
        }

        AuthorResponseDTO authorDTO = new AuthorResponseDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());

        return authorDTO;
    }

    @Override
    public Author toEntity(AuthorResponseDTO authorDTO) {
        if (authorDTO == null) {
            return null;
        }

        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());

        return author;
    }

    public Author toEntityFromRequest(AuthorRequestDTO authorRequestDTO) {
        if (authorRequestDTO == null) {
            return null;
        }

        Author author = new Author();
        author.setName(authorRequestDTO.getName());

        return author;
    }

    @Override
    public java.util.List<AuthorResponseDTO> toDTOList(java.util.List<Author> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }

    @Override
    public java.util.List<Author> toEntityList(java.util.List<AuthorResponseDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }
}