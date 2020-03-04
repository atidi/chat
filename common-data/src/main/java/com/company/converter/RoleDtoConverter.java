package com.company.converter;

import com.company.dto.RoleDto;
import com.company.enums.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleDtoConverter implements Converter<String, RoleDto> {
    @Override
    public RoleDto convert(String s) {
        return new RoleDto(Role.valueOf(s));
    }

}