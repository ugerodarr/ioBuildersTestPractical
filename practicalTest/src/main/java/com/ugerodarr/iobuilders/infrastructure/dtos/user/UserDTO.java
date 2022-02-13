package com.ugerodarr.iobuilders.infrastructure.dtos.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO {

    @NotBlank(message = "Name can not be blank")
    public String name;

    @NotBlank(message = "Lastname can not be blank")
    public String lastName;

    @NotBlank(message = "Password can not be blank")
    public String password;

    @NotBlank(message = "Email can not be blank")
    @Email(message = "Incorrect email format")
    public String email;

    public UserDTO() {
    }

    public UserDTO(String name, String lastName, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
