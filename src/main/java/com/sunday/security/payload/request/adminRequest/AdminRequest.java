package com.sunday.security.payload.request.adminRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequest {

    @Size(min = 2, max = 25, message = "name must be at least 2 characters")
    @NotBlank(message = "name must not be blank")
    private String firstName;

    @Size(min = 2, max = 25, message = "name must be at least 2 characters")
    @NotBlank(message = "name must not be blank")
    private String lastName;

    @Size(min = 6, max = 15, message = "password must be at least 6 characters")
    @NotBlank(message = "password must not be blank")
    private String password;

    @Size(min = 8, max = 50)
    @Email(message = "E-mail must be valid")
    @NotBlank(message = "E-mail required")
    private String email;

    @Size(min = 6, max = 15, message = "phone number must be at least 6 characters")
    @NotBlank(message = "Please input a valid number")
    private String phoneNumber;

    @NotBlank(message = "Location required")
    private String address;

    @NotBlank(message = "Input valid country")
    private String country;

}
