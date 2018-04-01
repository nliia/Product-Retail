package com.pm.productretail.service.impl;

import com.pm.productretail.dto.SignInDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.service.SecurityService;
import com.pm.productretail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    UserService userService;

    @Override
    public AppUser getCurrentUser() {
        return userService.findOneByUsername(getCurentUserUsername());
    }

    public String getCurentUserUsername(){
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        return (String) token.getPrincipal();
    }
}
