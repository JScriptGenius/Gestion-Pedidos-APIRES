package com.jarellano.persistence;

import com.jarellano.entity.Cliente;
import java.util.*;

public interface IClienteDAO {
    List<Cliente> findAllClientes();
    Optional<Cliente> findClienteById(Long idCliente);
    void saveCliente(Cliente cliente);
    void deleteClienteById(Long idCliente);
}
