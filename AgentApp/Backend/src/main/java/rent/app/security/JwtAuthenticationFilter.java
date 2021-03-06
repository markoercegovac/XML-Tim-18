package rent.app.security;


import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.Header;
import rent.app.model.security.LoginViewModel;
import rent.app.principal.UserPrincipal;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import java.util.List;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager=authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        // Grab credentials and map them to login viewmodel
        LoginViewModel credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create login token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                new ArrayList<>());

        System.out.println(credentials.getUsername());
        System.out.print(credentials.getPassword());
        // Authenticate user
        Authentication auth=null;
        try{
            auth = authenticationManager.authenticate(authenticationToken);
        }catch (Exception e){
            e.printStackTrace();
        }


        return auth;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // Grab principal
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();

        List<String> claim = new ArrayList<String>();

        principal.getAuthorities().forEach(a -> {
            claim.add(a.getAuthority());
        });

        // Create JWT Token
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withArrayClaim("authorities",
                        claim.toArray(new String[claim.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));

        // Add token in response
        response.addHeader("Access-Control-Expose-Headers", "Authorization"); //da angular moze da procita JWT
        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX +  token);
    }
}
