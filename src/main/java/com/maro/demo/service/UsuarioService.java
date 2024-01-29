package com.maro.demo.service;


import com.maro.demo.DTO.UserDTO;
import com.maro.demo.User.UserRequest;
import com.maro.demo.User.UserResponse;
import com.maro.demo.model.Role;
import com.maro.demo.model.Usuario;
import com.maro.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public UserResponse updateUser(UserRequest userRequest){
        Usuario user = Usuario.builder()
                .idUser(userRequest.idUser)
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .role(Role.USER)
                .build();
    usuarioRepository.updateUser(user.idUser, user.username, user.password);
    return new UserResponse("usuario registrado con exito");
    }
    public UserDTO getUser(Integer id){
        Usuario user = usuarioRepository.findById(id).orElse(null);
        if (user!= null){
            UserDTO userDTO = UserDTO.builder()
                    .idUser(user.idUser)
                    .username(user.username)
                    .password(user.password)
                    .build();
            return userDTO;
        }
        return null;
    }
}
