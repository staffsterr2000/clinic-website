package com.stasroshchenko.diploma.entity;

import com.stasroshchenko.diploma.constraint.DateOfBirthConstraint;
import com.stasroshchenko.diploma.constraint.EmailConstraint;
import com.stasroshchenko.diploma.constraint.PasswordMatchConstraint;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@PasswordMatchConstraint
public class RegistrationRequest {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(RegistrationRequest.class);

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String dateOfBirthInput;

    @DateOfBirthConstraint
    private LocalDate dateOfBirth;

    @Size(min = 3, max = 24, message = "Username must have from 3 to 24 symbols")
    private String username;

    @NotBlank
    @EmailConstraint
    private String email;

    @Size(min = 8, max = 24, message = "Password must have from 8 to 24 symbols")
    private String password;

    @Size(min = 8, max = 24, message = "Password must have from 8 to 24 symbols")
    private String repeatedPassword;

    public void setDateOfBirthInput(String dateOfBirthInput) {
        this.dateOfBirthInput = dateOfBirthInput;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            this.dateOfBirth = LocalDate.parse(dateOfBirthInput, formatter);

        } catch (DateTimeParseException ex) {

            LOGGER.error(ex.getMessage());
            this.dateOfBirth = LocalDate.MIN;

        }
    }

}
