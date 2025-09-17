package com.code81.library.service;

import com.code81.library.dto.PublisherRequestDTO;
import com.code81.library.dto.PublisherResponseDTO;
import java.util.List;

public interface PublisherService {
    List<PublisherResponseDTO> getAllPublishers();
    PublisherResponseDTO getPublisherById(Long id);
    PublisherResponseDTO createPublisher(PublisherRequestDTO publisherRequestDTO);
    PublisherResponseDTO updatePublisher(Long id, PublisherRequestDTO publisherRequestDTO);
    void deletePublisher(Long id);
}