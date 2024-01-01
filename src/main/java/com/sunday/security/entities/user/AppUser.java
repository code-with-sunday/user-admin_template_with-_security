package com.sunday.security.entities.user;

import com.sunday.security.entities.base.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

import javax.management.relation.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "admins")
public class AppUser extends Person {
    private String DOB;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
