package com.code81.library.controller;

import com.code81.library.dto.AuthorRequestDTO;
import com.code81.library.dto.AuthorResponseDTO;
import com.code81.library.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Authors", description = "Author management APIs")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Operation(summary = "Get all authors", description = "Returns a list of all authors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved authors",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthorResponseDTO.class)))
    })
    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> getAllAuthors() {
        List<AuthorResponseDTO> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @Operation(summary = "Get an author by ID", description = "Returns a single author identified by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved author",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthorResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(
            @Parameter(description = "ID of the author to be retrieved") @PathVariable Long id) {
        AuthorResponseDTO author = authorService.getAuthorById(id);
        if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Create a new author", description = "Adds a new author to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Author created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthorResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid author data provided")
    })
    @PostMapping
    public ResponseEntity<AuthorResponseDTO> createAuthor(
            @Parameter(description = "Author object to be created") @RequestBody AuthorRequestDTO authorRequestDTO) {
        AuthorResponseDTO createdAuthor = authorService.createAuthor(authorRequestDTO);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @Operation(summary = "Update an author", description = "Updates an existing author identified by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthorResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Author not found"),
            @ApiResponse(responseCode = "400", description = "Invalid author data provided")
    })
    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor(
            @Parameter(description = "ID of the author to be updated") @PathVariable Long id,
            @Parameter(description = "Updated author object") @RequestBody AuthorRequestDTO authorRequestDTO) {
        AuthorResponseDTO updatedAuthor = authorService.updateAuthor(id, authorRequestDTO);
        if (updatedAuthor != null) {
            return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Delete an author", description = "Deletes an author identified by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Author deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Author not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(
            @Parameter(description = "ID of the author to be deleted") @PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}