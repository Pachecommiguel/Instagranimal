package org.academiadecodigo.asciimos.instagranimal.controller.dto;

import javax.validation.constraints.*;

public class UserDto {

    @NotNull
    @NotBlank
    @Size(min=3, max=64)
    private String username;

    @NotNull
    @NotBlank
    @Size(min=3, max=64)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min=3, max=64)
    private String lastName;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]*$")
    @Size(min=9, max=16)
    private String phone;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
