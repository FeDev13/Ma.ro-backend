package com.maro.demo.service;

import com.maro.demo.model.Cliente;
import com.maro.demo.model.Expediente;
import com.maro.demo.repository.ClienteRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente newClient(Cliente newClient) {
        return clienteRepository.save(newClient);
    }

    @Override
    public Iterable<Cliente> getAll() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente updateClient(Cliente cliente) {
        Optional<Cliente> clienteEncontrado = this.clienteRepository.findById(cliente.getId()); //puede o no encontrar algo en la DB
        if (clienteEncontrado.get() != null) {
            clienteEncontrado.get().setId(cliente.getId());//asigna al num de expte del expte encontrado lo q trae el num de expte por parametro
            clienteEncontrado.get().setNombre(cliente.getNombre());
            clienteEncontrado.get().setApellido(cliente.getApellido());
            clienteEncontrado.get().setTelefono(cliente.getTelefono());
            clienteEncontrado.get().setDireccion(cliente.getDireccion());
            clienteEncontrado.get().setCausa(cliente.getCausa());
            return this.newClient(clienteEncontrado.get());
        }
        return null;
    }
    @Override
    public Boolean deleteClient(Long id){
        this.clienteRepository.deleteById(id);
        return true;
    }
}
