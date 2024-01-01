package com.sunday.security.payload.response.adminResponse;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    private boolean isEnabled;
    private String country;
    private String role;
}
