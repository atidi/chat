package com.company.dto;

import com.company.enums.Role;

import java.util.Objects;

public class RoleDto {

    private Role role;

    public RoleDto() {
    }

    public RoleDto(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDto roleDto = (RoleDto) o;
        return role == roleDto.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}
