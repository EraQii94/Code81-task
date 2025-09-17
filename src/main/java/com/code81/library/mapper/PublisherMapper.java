package com.code81.library.mapper;

import com.code81.library.dto.PublisherRequestDTO;
import com.code81.library.dto.PublisherResponseDTO;
import com.code81.library.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper implements GenericMapper<Publisher, PublisherResponseDTO> {

    @Override
    public PublisherResponseDTO toDTO(Publisher publisher) {
        if (publisher == null) {
            return null;
        }

        PublisherResponseDTO publisherDTO = new PublisherResponseDTO();
        publisherDTO.setId(publisher.getId());
        publisherDTO.setName(publisher.getName());
        publisherDTO.setAddress(publisher.getAddress());
        publisherDTO.setPhoneNumber(publisher.getPhoneNumber());

        return publisherDTO;
    }

    @Override
    public Publisher toEntity(PublisherResponseDTO publisherDTO) {
        if (publisherDTO == null) {
            return null;
        }

        Publisher publisher = new Publisher();
        publisher.setId(publisherDTO.getId());
        publisher.setName(publisherDTO.getName());
        publisher.setAddress(publisherDTO.getAddress());
        publisher.setPhoneNumber(publisherDTO.getPhoneNumber());

        return publisher;
    }

    public Publisher toEntityFromRequest(PublisherRequestDTO publisherRequestDTO) {
        if (publisherRequestDTO == null) {
            return null;
        }

        Publisher publisher = new Publisher();
        publisher.setName(publisherRequestDTO.getName());
        publisher.setAddress(publisherRequestDTO.getAddress());
        publisher.setPhoneNumber(publisherRequestDTO.getPhoneNumber());

        return publisher;
    }

    @Override
    public java.util.List<PublisherResponseDTO> toDTOList(java.util.List<Publisher> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }

    @Override
    public java.util.List<Publisher> toEntityList(java.util.List<PublisherResponseDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }
}