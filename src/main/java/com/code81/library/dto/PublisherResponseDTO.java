package com.code81.library.dto;

import lombok.Data;
import java.util.Set;

@Data
public class PublisherResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private Set<BookResponseDTO> books;
}