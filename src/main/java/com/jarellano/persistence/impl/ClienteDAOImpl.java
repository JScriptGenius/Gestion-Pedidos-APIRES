package com.jarellano.persistence.impl;

import com.jarellano.entity.Cliente;
import com.jarellano.persistence.IClienteDAO;
import com.jarellano.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ClienteDAOImpl implements IClienteDAO{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAllClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findClienteById(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteClienteById(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }
}
