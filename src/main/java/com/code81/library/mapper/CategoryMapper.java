package com.code81.library.mapper;

import com.code81.library.dto.CategoryRequestDTO;
import com.code81.library.dto.CategoryResponseDTO;
import com.code81.library.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements GenericMapper<Category, CategoryResponseDTO> {

    @Override
    public CategoryResponseDTO toDTO(Category category) {
        if (category == null) {
            return null;
        }

        CategoryResponseDTO categoryDTO = new CategoryResponseDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }

    @Override
    public Category toEntity(CategoryResponseDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());

        return category;
    }

    public Category toEntityFromRequest(CategoryRequestDTO categoryRequestDTO) {
        if (categoryRequestDTO == null) {
            return null;
        }

        Category category = new Category();
        category.setName(categoryRequestDTO.getName());

        return category;
    }

    @Override
    public java.util.List<CategoryResponseDTO> toDTOList(java.util.List<Category> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }

    @Override
    public java.util.List<Category> toEntityList(java.util.List<CategoryResponseDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }
}