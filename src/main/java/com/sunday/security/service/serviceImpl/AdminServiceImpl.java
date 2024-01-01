package com.sunday.security.service.serviceImpl;

import com.sunday.security.payload.APIResponse;
import com.sunday.security.payload.request.adminRequest.AdminRequest;
import com.sunday.security.payload.response.adminResponse.AdminResponse;
import com.sunday.security.repository.AdminReposiory;
import com.sunday.security.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class AdminServiceImpl implements AdminService {
    private final AdminReposiory adminReposiory;

    @Autowired
    public AdminServiceImpl(AdminReposiory adminReposiory) {
        this.adminReposiory = adminReposiory;
    }

    @Override
    public ResponseEntity<APIResponse<AdminResponse>> registerAdmin(AdminRequest adminRequest) {


        return null;
    }
}
