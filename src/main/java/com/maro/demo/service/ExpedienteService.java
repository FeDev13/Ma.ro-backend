package com.maro.demo.service;

import com.maro.demo.model.Expediente;

public interface ExpedienteService {
    Expediente newFile(Expediente newFile);

    Iterable<Expediente> getAll();

    Expediente updateFile(Expediente file);

    Boolean deleteFile(Long idExpediente);
}
