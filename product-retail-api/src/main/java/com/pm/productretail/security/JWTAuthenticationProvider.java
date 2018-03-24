package com.pm.productretail.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.PlainJWT;
import com.nimbusds.jwt.ReadOnlyJWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.pm.productretail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author lnurullina
 */
@Component
public class JWTAuthenticationProvider implements AuthenticationProvider {

    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    private final UserService userService;

    private JWSVerifier verifier;

    @Autowired
    public JWTAuthenticationProvider(UserService userService) {
        this.verifier = new MACVerifier("jfodfusdhfiaushfiqwuehfqwuhfsdhflakhewqoifhkadlkahfiqwuehlchushfiuwhuw" +
                "asddddddddddddddddddddddd" +
                "asdasdasdasdasdasdasdadas" +
                "asdasdasdasdasdqwdqdqdqsd" +
                "qsdqsdqsdqsdqdqsdqsdqdqsd");
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JWTToken jwtToken = (JWTToken) authentication;
        JWT jwt = jwtToken.getJwt();

        // Check type of the parsed JOSE object
        if (jwt instanceof PlainJWT) {
            jwtToken.setAuthenticated(false);
            return jwtToken;
        } else if (jwt instanceof SignedJWT) {
            try {
                if (!((SignedJWT) jwt).verify(verifier)) {
                    jwtToken.setAuthenticated(false);
                    return jwtToken;
                }
            } catch (JOSEException e) {
                jwtToken.setAuthenticated(false);
                return jwtToken;
            }
        } else if (jwt instanceof EncryptedJWT) {
            jwtToken.setAuthenticated(false);
            return jwtToken;
        }

        ReadOnlyJWTClaimsSet claims = jwtToken.getClaims();
//        String email = claims.getSubject();
        String email = (String) claims.getClaim("email");
        String password = (String) claims.getClaim("password");
        User user = userService.findOneByEmail(email);
        if (user != null && (ENCODER.matches(password, user.getPassword()))) {
            jwtToken.setAuthenticated(true);
            return jwtToken;
        }
        jwtToken.setAuthenticated(false);
        return jwtToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JWTToken.class.isAssignableFrom(authentication);
    }
}