package com.sunday.security.security;

import com.sunday.security.entities.admin.Admin;
import com.sunday.security.entities.user.AppUser;
import com.sunday.security.repository.AdminReposiory;
import com.sunday.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class CustomUserDetailsService implements UserDetailsService {
    private final AdminReposiory adminReposiory;
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(AdminReposiory adminReposiory, UserRepository userRepository) {
        this.adminReposiory = adminReposiory;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (adminReposiory.existsByEmail(email)){
            Admin admin = adminReposiory.findUsersByEmail(email).get();

            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(admin.getRole().toString()));

            return new User(
                    admin.getEmail(),
                    admin.getPassword(),
                    authorities
            );
        } else if (userRepository.existsByEmail(email)) {
            AppUser appUser = userRepository.findUsersByEmail(email).get();

            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(appUser.getRole().toString()));

            return new User(
                    appUser.getEmail(),
                    appUser.getPassword(),
                    authorities
            );

        }
        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
