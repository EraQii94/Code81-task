package com.code81.library.service.impl;

import com.code81.library.dto.PublisherRequestDTO;
import com.code81.library.dto.PublisherResponseDTO;
import com.code81.library.entity.Publisher;
import com.code81.library.mapper.PublisherMapper;
import com.code81.library.repository.PublisherRepository;
import com.code81.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public List<PublisherResponseDTO> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publisherMapper.toDTOList(publishers);
    }

    @Override
    public PublisherResponseDTO getPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElse(null);
        return publisherMapper.toDTO(publisher);
    }

    @Override
    public PublisherResponseDTO createPublisher(PublisherRequestDTO publisherRequestDTO) {
        Publisher publisher = publisherMapper.toEntityFromRequest(publisherRequestDTO);
        Publisher savedPublisher = publisherRepository.save(publisher);
        return publisherMapper.toDTO(savedPublisher);
    }

    @Override
    public PublisherResponseDTO updatePublisher(Long id, PublisherRequestDTO publisherRequestDTO) {
        Publisher existingPublisher = publisherRepository.findById(id).orElse(null);
        if (existingPublisher != null) {
            // Update fields
            existingPublisher.setName(publisherRequestDTO.getName());
            existingPublisher.setAddress(publisherRequestDTO.getAddress());
            existingPublisher.setPhoneNumber(publisherRequestDTO.getPhoneNumber());
            
            Publisher updatedPublisher = publisherRepository.save(existingPublisher);
            return publisherMapper.toDTO(updatedPublisher);
        }
        return null;
    }

    @Override
    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}