package com.mytracker.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotEmpty(message = "Username can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String username;

    @Size(min = 3, max = 30, message = "The length of the first name should be between 3 and 30")
    private String firstName;

    @Size(min = 3, max = 30, message = "The length of the first name should be between 3 and 30")
    private String lastName;

    @Past(message = "Birth date should be in the past")
    private LocalDate birthDate;

    private String currency;
}