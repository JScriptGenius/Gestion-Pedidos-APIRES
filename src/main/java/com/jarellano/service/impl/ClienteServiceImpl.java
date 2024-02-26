package com.jarellano.service.impl;

import com.jarellano.entity.Cliente;
import com.jarellano.persistence.IClienteDAO;
import com.jarellano.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    public List<Cliente> findAllClientes() {
        return clienteDAO.findAllClientes();
    }

    @Override
    public Optional<Cliente> findClienteById(Long idCliente) {
        return clienteDAO.findClienteById(idCliente);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteDAO.saveCliente(cliente);
    }

    @Override
    public void deleteClienteById(Long idCliente) {
        clienteDAO.deleteClienteById(idCliente);
    }
}
