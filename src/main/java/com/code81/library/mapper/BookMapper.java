package com.code81.library.mapper;

import com.code81.library.dto.BookRequestDTO;
import com.code81.library.dto.BookResponseDTO;
import com.code81.library.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements GenericMapper<Book, BookResponseDTO> {

    @Override
    public BookResponseDTO toDTO(Book book) {
        if (book == null) {
            return null;
        }

        BookResponseDTO bookDTO = new BookResponseDTO();
        bookDTO.setISBN(book.getISBN());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setPublicationYear(book.getPublicationYear());
        bookDTO.setCoverImageUrl(book.getCoverImageUrl());
        bookDTO.setEdition(book.getEdition());
        bookDTO.setSummary(book.getSummary());
        bookDTO.setStatus(book.getStatus());
        bookDTO.setTotalCopies(book.getTotalCopies());
        bookDTO.setAvailableCopies(book.getAvailableCopies());



        return bookDTO;
    }

    @Override
    public Book toEntity(BookResponseDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        }

        Book book = new Book();
        book.setISBN(bookDTO.getISBN());
        book.setTitle(bookDTO.getTitle());
        book.setLanguage(bookDTO.getLanguage());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setCoverImageUrl(bookDTO.getCoverImageUrl());
        book.setEdition(bookDTO.getEdition());
        book.setSummary(bookDTO.getSummary());
        book.setStatus(bookDTO.getStatus());
        book.setTotalCopies(bookDTO.getTotalCopies());
        book.setAvailableCopies(bookDTO.getAvailableCopies());

        return book;
    }

    public Book toEntityFromRequest(BookRequestDTO bookRequestDTO) {
        if (bookRequestDTO == null) {
            return null;
        }

        Book book = new Book();
        book.setTitle(bookRequestDTO.getTitle());
        book.setLanguage(bookRequestDTO.getLanguage());
        book.setPublicationYear(bookRequestDTO.getPublicationYear());
        book.setCoverImageUrl(bookRequestDTO.getCoverImageUrl());
        book.setEdition(bookRequestDTO.getEdition());
        book.setSummary(bookRequestDTO.getSummary());
        book.setStatus(bookRequestDTO.getStatus());
        book.setTotalCopies(bookRequestDTO.getTotalCopies());
        book.setAvailableCopies(bookRequestDTO.getAvailableCopies());

        return book;
    }

    @Override
    public java.util.List<BookResponseDTO> toDTOList(java.util.List<Book> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }

    @Override
    public java.util.List<Book> toEntityList(java.util.List<BookResponseDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }
}