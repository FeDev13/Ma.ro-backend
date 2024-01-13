package com.maro.demo.repository;

import com.maro.demo.model.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpedienteRepository extends JpaRepository<Expediente, Long> {

}
