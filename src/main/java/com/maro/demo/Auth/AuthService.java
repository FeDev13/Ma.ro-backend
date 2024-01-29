package com.maro.demo.Auth;

import com.maro.demo.Jwt.JwtService;
import com.maro.demo.model.Role;
import com.maro.demo.model.Usuario;
import com.maro.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails usuario = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(usuario);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request){
            Usuario usuario = Usuario.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            usuarioRepository.save(usuario);

            return AuthResponse.builder()
                    .token(jwtService.getToken(usuario))
                    .build();
    }
}
