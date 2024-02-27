package com.jarellano.controller;

import com.jarellano.controller.dto.ClienteDTO;
import com.jarellano.entity.Cliente;
import com.jarellano.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.*;
import java.util.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findClienteById(id);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            ClienteDTO clienteDTO = ClienteDTO.builder()
                    .idCliente(cliente.getIdCliente())
                    .nombre(cliente.getNombre())
                    .email(cliente.getEmail())
                    .pedidos(cliente.getPedidos())
                    .build();
            return ResponseEntity.ok(clienteDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ClienteDTO> clienteDTOList = clienteService.findAllClientes()
                .stream()
                .map(cliente -> ClienteDTO.builder()
                        .idCliente(cliente.getIdCliente())
                        .nombre(cliente.getNombre())
                        .email(cliente.getEmail())
                        .build())
                .toList();
        return ResponseEntity.ok(clienteDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException {
        if (clienteDTO.getNombre().isBlank() || clienteDTO.getEmail().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        clienteService.saveCliente(Cliente.builder()
                .nombre(clienteDTO.getNombre())
                .email(clienteDTO.getEmail())
                .build());
        return ResponseEntity.created(new URI("/api/cliente/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = clienteService.findClienteById(id);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setNombre(clienteDTO.getNombre());
            cliente.setEmail(clienteDTO.getEmail());
            clienteService.saveCliente(cliente);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            clienteService.deleteClienteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
