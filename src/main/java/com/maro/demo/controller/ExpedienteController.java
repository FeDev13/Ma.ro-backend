package com.maro.demo.controller;

import com.maro.demo.model.Expediente;
import com.maro.demo.service.ExpedienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expediente")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080" })

public class ExpedienteController {
    @Autowired
    private ExpedienteService expedienteService;

    @PostMapping ("/nuevo")
    public Expediente newFile(@RequestBody Expediente newFile){
        return this.expedienteService.newFile(newFile);
    }
    @GetMapping("/todos")
    public Iterable<Expediente> getAll(){
        return expedienteService.getAll();
    }
    @PostMapping("/actualizar")
    public Expediente updateFile(@RequestBody Expediente file){
        return this.expedienteService.updateFile(file);
    }
    @DeleteMapping(value="/{id}")
    public Boolean deleteFile(@PathVariable(value = "id") Long id){
        return this.expedienteService.deleteFile(id);
    }
}

