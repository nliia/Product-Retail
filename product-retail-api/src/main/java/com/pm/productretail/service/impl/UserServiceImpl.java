package com.pm.productretail.service.impl;

import com.pm.productretail.dto.SignUpDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.repository.AppUserRepository;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.Errors;
import com.pm.productretail.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private Validator validator;

    @Override
    public void createUser(SignUpDto signUpDto) throws Exception {
        if (validator.isValidSignUpData(signUpDto)) {
            if (appUserRepository.findOneByUsername(signUpDto.getUsername()) != null)
                throw new Exception(Errors.USER_ALREADY_EXISTS);
            AppUser user = new AppUser();
            user.setUsername(signUpDto.getUsername());
            user.setPassword(bCryptPasswordEncoder.encode(signUpDto.getPassword()));
            appUserRepository.save(user);
        }
    }

    @Override
    public AppUser findOneByPhoneNumber(String phone) {
        return appUserRepository.findOneByPhoneNumber(phone);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findOneByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }
}
