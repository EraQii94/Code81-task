package com.code81.library.mapper;

import java.util.List;

public interface GenericMapper<E, D> {
    D toDTO(E entity);
    E toEntity(D dto);
    List<D> toDTOList(List<E> entityList);
    List<E> toEntityList(List<D> dtoList);
}