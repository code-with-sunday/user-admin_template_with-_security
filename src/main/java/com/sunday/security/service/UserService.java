package com.sunday.security.service;

import com.sunday.security.payload.APIResponse;
import com.sunday.security.payload.request.user.UserResquest;
import com.sunday.security.payload.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<APIResponse<UserResponse>> cretaeUser(UserResquest userResquest);
}
