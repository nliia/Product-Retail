package com.pm.productretail.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.productretail.dto.DepartmentDto;
import com.pm.productretail.dto.response.SignInResponseDto;
import com.pm.productretail.entity.AppUser;
import com.pm.productretail.repository.AppUserRepository;
import com.pm.productretail.service.UserService;
import com.pm.productretail.util.BeanUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * @author lnurullina
 */
class TokenAuthenticationService {
    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String HEADER_STRING = "Authorization";

    private AppUserRepository appUserRepository;
    private UserService userService;

    TokenAuthenticationService() {
        appUserRepository = BeanUtil.getBean(AppUserRepository.class);
        userService = BeanUtil.getBean(UserService.class);
    }

    void addAuthentication(HttpServletResponse res, String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        AppUser appUser = appUserRepository.findOneByUsername(username);
        List<DepartmentDto> departments = userService.findUserDepartments(appUser);
        SignInResponseDto signInResponseDto = new SignInResponseDto(appUser, departments, JWT);
        try {
            res.setContentType("application/json");
            res.setCharacterEncoding("UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            res.getWriter().write(objectMapper.writeValueAsString(signInResponseDto));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
                    null;
        }
        return null;
    }
}