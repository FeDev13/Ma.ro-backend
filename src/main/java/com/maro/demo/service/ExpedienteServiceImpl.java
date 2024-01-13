package com.maro.demo.service;

import com.maro.demo.model.Expediente;
import com.maro.demo.repository.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class ExpedienteServiceImpl implements ExpedienteService{
    @Autowired //inyecta repositorio
    private ExpedienteRepository expedienteRepository;

    @Override
    public Expediente newFile(Expediente newFile) {
        return expedienteRepository.save(newFile);
    }

    @Override
    public Iterable<Expediente> getAll() {
        return this.expedienteRepository.findAll();
    }

    @Override
    public Expediente updateFile(Expediente file) {
        Optional<Expediente> expedienteEncontrado = this.expedienteRepository.findById(file.getNumExpediente()); //puede o no encontrar algo en la DB
        if (expedienteEncontrado.get() != null){
            expedienteEncontrado.get().setNumExpediente(file.getNumExpediente());//asigna al num de expte del expte encontrado lo q trae el num de expte por parametro
            expedienteEncontrado.get().setActor(file.getActor());
            expedienteEncontrado.get().setDemandado(file.getDemandado());
            expedienteEncontrado.get().setEstado(file.getEstado());
            return this.newFile(expedienteEncontrado.get());
        }
        return null;
    }

    @Override
    public Boolean deleteFile(Long idExpediente) {
         this.expedienteRepository.deleteById(idExpediente);
         return true;
    }
}
