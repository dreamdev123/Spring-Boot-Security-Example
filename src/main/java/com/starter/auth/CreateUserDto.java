package com.starter.auth;

import com.starter.utils.DtoEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CreateUserDto implements DtoEntity {
    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;

    @NotEmpty(message = "Role is required")
    @Enumerated(EnumType.STRING)
    private Role role;

    public CreateUserDto(Role role, String email, String password) {
        super();
        this.role = role;
        this.email = email;
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
