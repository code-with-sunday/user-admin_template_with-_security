package com.sunday.security.entities.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class Person extends Base {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "phone",nullable = false)
    private String phoneNumber;

    private String profilePicture;

    private boolean isEnabled;

    private String country;

    private String state;

    private String city;

    private String address;

    private String postalCode;

    private String facebook;

    private String twitter;

    private String instagram;
}

