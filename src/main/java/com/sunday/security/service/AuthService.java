package com.sunday.security.service;

import com.sunday.security.payload.APIResponse;
import com.sunday.security.payload.request.adminRequest.AdminRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<APIResponse<AdminRequest>> registerAdmin(AdminRequest adminRequest);
}
