package com.sunday.security.service;

import com.sunday.security.payload.APIResponse;
import com.sunday.security.payload.request.adminRequest.AdminRequest;
import com.sunday.security.payload.response.adminResponse.AdminResponse;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<APIResponse<AdminResponse>> registerAdmin (AdminRequest adminRequest);

}
