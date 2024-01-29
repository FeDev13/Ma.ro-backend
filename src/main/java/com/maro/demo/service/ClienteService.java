package com.maro.demo.service;


import com.maro.demo.model.Cliente;

public interface ClienteService {
    Cliente newClient(Cliente newCliente);
    Iterable<Cliente> getAll();
    Cliente updateClient(Cliente client);
    Boolean deleteClient(Long idClient);
}
