package com.pm.productretail.security;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.text.ParseException;

/**
 * @author lnurullina
 */
public class JWTFilter extends GenericFilterBean {

    private JWTAuthenticationProvider authenticationManager;

    @Autowired
    public JWTFilter(JWTAuthenticationProvider authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void afterPropertiesSet() throws ServletException {
        Assert.notNull(authenticationManager);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            String stringToken = req.getHeader("Authorization");
            if (stringToken == null) {
                ((HttpServletResponse) response).sendError(913, "Authorization header not found");
                throw new InsufficientAuthenticationException("Authorization header not found");
            }
            try {
                JWT jwt = JWTParser.parse(stringToken);
                JWTToken token = new JWTToken(jwt);
                Authentication auth = authenticationManager.authenticate(token);
                if (!auth.isAuthenticated()) {
                    ((HttpServletResponse) response).sendError(913, "Wrong token");
                } else {
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    chain.doFilter(request, response);
                }
            } catch (ParseException e) {
                ((HttpServletResponse) response).sendError(914, "Wrong token");
            }
        } catch (AuthenticationException e) {
            SecurityContextHolder.clearContext();
        }
    }
}