package com.code81.library.service.impl;

import com.code81.library.dto.BookRequestDTO;
import com.code81.library.dto.BookResponseDTO;
import com.code81.library.entity.Book;
import com.code81.library.mapper.BookMapper;
import com.code81.library.repository.BookRepository;
import com.code81.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.toDTOList(books);
    }

    @Override
    public BookResponseDTO getBookByISBN(Long isbn) {
        Book book = bookRepository.findById(isbn).orElse(null);
        return bookMapper.toDTO(book);
    }

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
        Book book = bookMapper.toEntityFromRequest(bookRequestDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }

    @Override
    public BookResponseDTO updateBook(Long isbn, BookRequestDTO bookRequestDTO) {
        Book existingBook = bookRepository.findById(isbn).orElse(null);
        if (existingBook != null) {
            // Update fields
            existingBook.setTitle(bookRequestDTO.getTitle());
            existingBook.setLanguage(bookRequestDTO.getLanguage());
            existingBook.setPublicationYear(bookRequestDTO.getPublicationYear());
            existingBook.setCoverImageUrl(bookRequestDTO.getCoverImageUrl());
            existingBook.setEdition(bookRequestDTO.getEdition());
            existingBook.setSummary(bookRequestDTO.getSummary());
            existingBook.setStatus(bookRequestDTO.getStatus());
            existingBook.setTotalCopies(bookRequestDTO.getTotalCopies());
            existingBook.setAvailableCopies(bookRequestDTO.getAvailableCopies());
            
            Book updatedBook = bookRepository.save(existingBook);
            return bookMapper.toDTO(updatedBook);
        }
        return null;
    }

    @Override
    public void deleteBook(Long isbn) {
        bookRepository.deleteById(isbn);
    }
}