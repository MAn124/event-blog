package com.ttma.eventBlog.Service;

import com.ttma.eventBlog.dto.request.LoginRequest;
import com.ttma.eventBlog.dto.response.ResponseToken;
import com.ttma.eventBlog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public ResponseToken authenticate(LoginRequest request){
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        String accessToken = jwtService.generateToken(user);
        String freshToken = jwtService.generateRefreshToken(user);
        return ResponseToken.builder()
                .accessToken(accessToken)
                .freshToken(freshToken)
                .id(user.getId())
                .build();
    }
}
