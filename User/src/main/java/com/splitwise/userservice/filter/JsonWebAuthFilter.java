package com.splitwise.userservice.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.splitwise.userservice.pojo.LoginRequestDTO;
import com.splitwise.userservice.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonWebAuthFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private JwtService jwtService;

    public JsonWebAuthFilter(AuthenticationManager authenticationManager){
        super.setAuthenticationManager(authenticationManager);
        setFilterProcessesUrl("/api/v1/user/login");

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            LoginRequestDTO loginRequest =objectMapper.readValue(request.getInputStream(), LoginRequestDTO.class);
            UsernamePasswordAuthenticationToken  authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());
            System.out.println(getAuthenticationManager().authenticate(authToken));
            return getAuthenticationManager().authenticate(authToken);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
            String token = jwtService.getJwtToken(authResult.getName());

        response.setHeader("Authorization", "Bearer " + token);
        response.setContentType("application/json");
        response.getWriter().write("{\"token\": \"" + token + "\"}");
        response.getWriter().flush();
    }
}
