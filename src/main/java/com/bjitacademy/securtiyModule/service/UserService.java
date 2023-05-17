package com.bjitacademy.securtiyModule.service;

import com.bjitacademy.securtiyModule.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> register(UserRequestModel userRequestModel);
}
