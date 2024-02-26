package com.jarellano.service;

import com.jarellano.entity.Cliente;
import java.util.*;

public interface IClienteService {
    List<Cliente> findAllClientes();
    Optional<Cliente> findClienteById(Long idCliente);
    void saveCliente(Cliente cliente);
    void deleteClienteById(Long idCliente);;
}
