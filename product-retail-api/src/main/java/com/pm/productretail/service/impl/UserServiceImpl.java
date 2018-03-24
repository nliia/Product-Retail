package com.pm.productretail.service.impl;

import com.pm.productretail.dto.SignInDto;
import com.pm.productretail.dto.SignUpDto;
import com.pm.productretail.entity.User;
import com.pm.productretail.repository.UserRepository;
import com.pm.productretail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(SignUpDto signUpDto) {
        User user = new User();
        user.setUsername(signUpDto.getUsername());
        user.setPassword(signUpDto.getPassword());
        userRepository.save(user);
    }

    @Override
    public String findUserAndGetUsername(SignInDto signInDto) {
        User user = userRepository.findOneByUsername(signInDto.getUsername());
        if(user !=null)
            return user.getUsername();
        else
            return "NET USERA TAKOGO";
    }

    @Override
    public User findOneByEmail(String email) {
        return null;
    }
}
