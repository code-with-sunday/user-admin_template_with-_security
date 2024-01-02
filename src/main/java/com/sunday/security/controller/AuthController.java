package com.sunday.security.controller;

import com.sunday.security.payload.APIResponse;
import com.sunday.security.payload.request.adminRequest.AdminRequest;
import com.sunday.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping("/register")
    public ResponseEntity<APIResponse<AdminRequest>> registerAdmin(AdminRequest adminRequest){
        return authService.registerAdmin(adminRequest);
    }
}
