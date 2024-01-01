package com.sunday.security.service.serviceImpl;

import com.sunday.security.payload.APIResponse;
import com.sunday.security.payload.request.UserResquest;
import com.sunday.security.payload.response.UserResponse;
import com.sunday.security.repository.UserRepository;
import com.sunday.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<APIResponse<UserResponse>> cretaeUser(UserResquest userResquest) {
        return null;
    }
}
