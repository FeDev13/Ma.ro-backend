package com.maro.demo.repository;

import com.maro.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
    @Modifying()
    @Query("update Usuario u set u.username=:username, u.password=:password where u.idUser = :idUser")


    void updateUser(@Param(value = "idUser") Integer idUser, @Param(value = "username") String username, @Param(value = "password") String password);


}
