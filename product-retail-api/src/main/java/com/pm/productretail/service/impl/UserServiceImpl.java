package com.pm.productretail.service.impl;

import com.pm.productretail.SignInJson;
import com.pm.productretail.SignUpJson;
import com.pm.productretail.entity.UserEntity;
import com.pm.productretail.repository.UserRepository;
import com.pm.productretail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(SignUpJson signUpJson) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsename(signUpJson.getUsername());
        userEntity.setPassword(signUpJson.getPassword());
        userRepository.save(userEntity);
    }

    @Override
    public String findUserAndGetUsername(SignInJson signInJson) {
        UserEntity userEntity = userRepository.findOneByUsername(signInJson.getUsername());
        if(userEntity!=null)
            return userEntity.getUsename();
        else
            return "NET USERA TAKOGO";
    }
}
