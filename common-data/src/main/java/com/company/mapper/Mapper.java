package com.company.mapper;

import java.util.Collection;
import java.util.List;

public interface Mapper<D,E> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDtos(Collection<E> entities);

    List<E> toEntities(Collection<D> dtos);
}