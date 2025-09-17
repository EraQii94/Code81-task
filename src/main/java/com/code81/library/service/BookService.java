package com.code81.library.service;

import com.code81.library.dto.BookRequestDTO;
import com.code81.library.dto.BookResponseDTO;
import java.util.List;

public interface BookService {
    List<BookResponseDTO> getAllBooks();
    BookResponseDTO getBookByISBN(Long isbn);
    BookResponseDTO createBook(BookRequestDTO bookRequestDTO);
    BookResponseDTO updateBook(Long isbn, BookRequestDTO bookRequestDTO);
    void deleteBook(Long isbn);
}