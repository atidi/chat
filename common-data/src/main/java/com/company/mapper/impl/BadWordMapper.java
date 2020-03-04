package com.company.mapper.impl;

import com.company.dto.BadWordDto;
import com.company.entity.BadWord;
import com.company.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BadWordMapper implements Mapper<BadWordDto, BadWord> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public BadWordDto toDto(BadWord entity) {
        return mapper.map(entity,BadWordDto.class);
    }

    @Override
    public BadWord toEntity(BadWordDto dto) {
        return mapper.map(dto,BadWord.class);
    }

    @Override
    public List<BadWordDto> toDtos(Collection<BadWord> entities) {
        return entities.stream().map(en -> mapper.map(en, BadWordDto.class) ).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<BadWord> toEntities(Collection<BadWordDto> dtos) {
        return dtos.stream().map(dto -> mapper.map(dto, BadWord.class) ).collect(Collectors.toCollection(ArrayList::new));
    }
}
