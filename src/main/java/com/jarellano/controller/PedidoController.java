package com.jarellano.controller;

import com.jarellano.controller.dto.PedidoDTO;
import com.jarellano.entity.*;
import com.jarellano.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.*;
import java.util.*;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IProductoService productoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Pedido> pedidoOptional = pedidoService.findPedidoById(id);

        return pedidoOptional.map(pedido -> {
            PedidoDTO pedidoDTO = PedidoDTO.builder()
                    .idPedido(pedido.getIdPedido())
                    .numeroPedido(pedido.getNumeroPedido())
                    .cliente(pedido.getCliente())
                    .detallesPedido(pedido.getDetallesPedido())
                    .build();
            return ResponseEntity.ok(pedidoDTO);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<PedidoDTO> pedidoDTOList = pedidoService.findAllPedidos()
                .stream()
                .map(pedido -> PedidoDTO.builder()
                        .idPedido(pedido.getIdPedido())
                        .numeroPedido(pedido.getNumeroPedido())
                        .cliente(pedido.getCliente())
                        .detallesPedido(pedido.getDetallesPedido())
                        .build())
                .toList();
        return ResponseEntity.ok(pedidoDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PedidoDTO pedidoDTO) throws URISyntaxException {
        if (pedidoDTO.getNumeroPedido().isBlank() || pedidoDTO.getCliente() == null || pedidoDTO.getDetallesPedido() == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Cliente> clienteOptional = clienteService.findClienteById(pedidoDTO.getCliente().getIdCliente());
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Cliente no encontrado");
        }

        Pedido pedido = Pedido.builder()
                .numeroPedido(pedidoDTO.getNumeroPedido())
                .cliente(clienteOptional.get())
                .detallesPedido(new ArrayList<>())
                .build();

        for (DetallePedido detalleDTO : pedidoDTO.getDetallesPedido()) {
            Optional<Producto> productoOptional = productoService.findProductoById(detalleDTO.getProducto().getIdProducto());
            if (productoOptional.isEmpty()) {
                throw new RuntimeException("Producto no encontrado");
            }

            DetallePedido detallePedido = DetallePedido.builder()
                    .pedido(pedido)
                    .producto(productoOptional.get())
                    .cantidad(detalleDTO.getCantidad())
                    .precioUnitario(detalleDTO.getPrecioUnitario())
                    .build();

            pedido.getDetallesPedido().add(detallePedido);
        }

        pedidoService.savePedido(pedido);
        return ResponseEntity.created(new URI("/api/pedido/save")).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            pedidoService.deletePedidoById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
