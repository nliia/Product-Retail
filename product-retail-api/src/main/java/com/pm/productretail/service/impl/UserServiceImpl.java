package com.pm.productretail.service.impl;

import com.pm.productretail.dto.SignUpDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.repository.UserRepository;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.Errors;
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
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void createUser(SignUpDto signUpDto) throws Exception {
        if (userRepository.findOneByUsername(signUpDto.getUsername()) != null) {
            throw new Exception(Errors.USER_ALREADY_EXISTS);
        }

        AppUser user = new AppUser();
        user.setUsername(signUpDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(signUpDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public AppUser findOneByEmail(String email) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findOneByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }
}
