package com.example.Proxym.dto.AssureDTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssureRequestDTO {

    @Email(message = "Email should be valid")
    @Size(max = 320, message = "Email must be at most 320 characters long")
    private String email;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contain only letters and spaces")
    private String name;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and one special character (@#$%^&+=)")
    private String password;

    @NotBlank(message = "Telephone number cannot be blank")
    @Pattern(regexp = "^(?:\\+216|216)?\\d{8}$", message = "Telephone number must be a valid Tunisian number, e.g., +21612345678 or 12345678")
    private String numTel;


    private Date dateIncrit;
    private Long idAddress ;
}
