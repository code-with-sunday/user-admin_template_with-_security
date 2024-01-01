package com.sunday.security.service.serviceImpl;

import com.sunday.security.entities.admin.Admin;
import com.sunday.security.entities.enums.Role;
import com.sunday.security.events.eventPublisher.EventPublisher;
import com.sunday.security.exceptions.ApplicationException;
import com.sunday.security.payload.APIResponse;
import com.sunday.security.payload.request.adminRequest.AdminRequest;
import com.sunday.security.repository.AdminReposiory;
import com.sunday.security.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AdminReposiory adminReposiory;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final HttpServletRequest request;
    private final EventPublisher eventPublisher;

    @Override
    public ResponseEntity<APIResponse<AdminRequest>> registerAdmin(AdminRequest adminRequest) {
        if (adminReposiory.existsByEmail(adminRequest.getEmail())){
            throw new ApplicationException("User with this e-mail already exist");
        }

        Admin newAdmin = modelMapper.map(adminRequest, Admin.class);

        newAdmin.setEnabled(false);

       newAdmin.setRole(Role.ADMIN);

       newAdmin.setPassword(passwordEncoder.encode(newAdmin.getPassword()));

       Admin savedAdmin = adminReposiory.save(newAdmin);

       eventPublisher.completeRegistrationEventPublisher(adminRequest.getEmail(), adminRequest.getFirstName(), request);

       AdminRequest responseRequest = modelMapper.map(savedAdmin, AdminRequest.class);

        return ResponseEntity.ok(
                new APIResponse<AdminRequest>("Account Created Successfully")
        );
    }
}
