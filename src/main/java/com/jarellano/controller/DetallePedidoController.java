package com.jarellano.controller;

import com.jarellano.controller.dto.DetallePedidoDTO;
import com.jarellano.entity.DetallePedido;
import com.jarellano.service.IDetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/detallePedido")
public class DetallePedidoController {

    @Autowired
    private IDetallePedidoService detallePedidoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<DetallePedido> detallePedidoOptional = detallePedidoService.findDetallePedidoById(id);

        return detallePedidoOptional.map(detallePedido -> {
            DetallePedidoDTO detallePedidoDTO = DetallePedidoDTO.builder()
                    .idDetallePedido(detallePedido.getIdDetallePedido())
                    .pedido(detallePedido.getPedido())
                    .producto(detallePedido.getProducto())
                    .cantidad(detallePedido.getCantidad())
                    .precioUnitario(detallePedido.getPrecioUnitario())
                    .build();
            return ResponseEntity.ok(detallePedidoDTO);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<DetallePedidoDTO> detallePedidoDTOList = detallePedidoService.findAllDetallePedidos()
                .stream()
                .map(detallePedido -> DetallePedidoDTO.builder()
                        .idDetallePedido(detallePedido.getIdDetallePedido())
                        .pedido(detallePedido.getPedido())
                        .producto(detallePedido.getProducto())
                        .cantidad(detallePedido.getCantidad())
                        .precioUnitario(detallePedido.getPrecioUnitario())
                        .build())
                .toList();
        return ResponseEntity.ok(detallePedidoDTOList);
    }
}
