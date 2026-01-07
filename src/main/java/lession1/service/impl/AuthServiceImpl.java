package lession1.service.impl;

import lession1.config.JwtUtil;
import lession1.service.AuthService;
import lombok.RequiredArgsConstructor;
import lession1.dto.LoginResponseDto;
import lession1.entity.User;
import lession1.form.LoginForm;
import lession1.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    @Override
    public LoginResponseDto login(LoginForm form) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        form.getUsername(),
                        form.getPassword()
                )
        );

        User user = userRepository.findByUsername(form.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getRole().name()
        );


        return new LoginResponseDto(
                token,
                user.getUsername(),
                user.getRole().name()
        );
    }

}
