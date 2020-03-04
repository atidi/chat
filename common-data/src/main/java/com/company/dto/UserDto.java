package com.company.dto;

import java.util.List;
import java.util.Objects;

public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String imagePath;

    private String email;

    private String password;

    private String confirmPassword;

    private List<RoleDto> roles;

    public UserDto() {

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto dto = (UserDto) o;
        return Objects.equals(id, dto.id) &&
                Objects.equals(firstName, dto.firstName) &&
                Objects.equals(lastName, dto.lastName) &&
                Objects.equals(imagePath, dto.imagePath) &&
                Objects.equals(email, dto.email) &&
                Objects.equals(password, dto.password) &&
                Objects.equals(confirmPassword, dto.confirmPassword) &&
                Objects.equals(roles, dto.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, imagePath, email, password, confirmPassword, roles);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", roles=" + roles +
                '}';
    }
}
