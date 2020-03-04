package com.company.mapper.impl;

import com.company.dto.UserDto;
import com.company.entity.User;
import com.company.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper implements Mapper<UserDto, User> {

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserDto toDto(User entity) {
        return mapper.map(entity,UserDto.class);
    }

    @Override
    public User toEntity(UserDto dto) {
        return mapper.map(dto,User.class);
    }

    @Override
    public List<UserDto> toDtos(Collection<User> entities) {
        return entities.stream().map(en -> mapper.map(en,UserDto.class) ).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<User> toEntities(Collection<UserDto> dtos) {
        return dtos.stream().map(dto -> mapper.map(dto,User.class) ).collect(Collectors.toCollection(ArrayList::new));
    }
}
