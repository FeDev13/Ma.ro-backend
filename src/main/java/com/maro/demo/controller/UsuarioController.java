package com.maro.demo.controller;


import com.maro.demo.DTO.UserDTO;
import com.maro.demo.User.UserRequest;
import com.maro.demo.User.UserResponse;
import com.maro.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id){
        UserDTO userDTO = usuarioService.getUser(id);
        if (userDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }
    @PutMapping()
    public ResponseEntity<UserResponse>updateUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(usuarioService.updateUser(userRequest));
    }
}
