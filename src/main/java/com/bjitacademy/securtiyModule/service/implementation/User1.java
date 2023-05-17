package com.bjitacademy.securtiyModule.service.implementation;

import com.bjitacademy.securtiyModule.entity.UserEntity;
import com.bjitacademy.securtiyModule.model.UserResponseModel;
import com.bjitacademy.securtiyModule.model.UserRequestModel;
import com.bjitacademy.securtiyModule.repository.UserRepository;
import com.bjitacademy.securtiyModule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class User1 implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Object> register(UserRequestModel userRequestModel) {
        UserEntity userEntity = UserEntity.builder()
                .email(userRequestModel.getEmail())
                .username(userRequestModel.getUsername())
                .firstName(userRequestModel.getFirstName())
                .lastName(userRequestModel.getLastName())
                .password(userRequestModel.getPassword())
                .build();
        UserEntity savedUserEntity = userRepository.save(userEntity);
        UserResponseModel userResponseModel = UserResponseModel.builder()
                .email(userRequestModel.getEmail())
                .username(userRequestModel.getUsername())
                .firstName(userRequestModel.getFirstName())
//                .lastName(userRequestModel.getLastName())
                .build();
        return new ResponseEntity<>(userResponseModel, HttpStatus.CREATED);
    }
}
