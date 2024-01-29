package com.maro.demo.controller;

import com.maro.demo.model.Cliente;
import com.maro.demo.model.Expediente;
import com.maro.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@CrossOrigin (origins = {"http://localhost:4200", "http://localhost:8080" })

public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/nuevo")
    public Cliente newClient(@RequestBody Cliente newClient){
        return this.clienteService.newClient(newClient);
    }
    @GetMapping("/todos")
    public Iterable<Cliente> getAll(){
        return clienteService.getAll();
    }
    @PostMapping("/actualizar")
    public Cliente updateClient(@RequestBody Cliente cliente){
        return this.clienteService.updateClient(cliente);
    }
    @DeleteMapping(value="/{id}")
    public Boolean deleteClient(@PathVariable(value = "id") Long id){
        return this.clienteService.deleteClient(id);
    }
}
