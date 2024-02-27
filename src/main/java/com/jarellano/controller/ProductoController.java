package com.jarellano.controller;

import com.jarellano.controller.dto.ProductoDTO;
import com.jarellano.entity.Producto;
import com.jarellano.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.*;
import java.util.*;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.findProductoById(id);

        return productoOptional.map(producto -> {
            ProductoDTO productoDTO = ProductoDTO.builder()
                    .idProducto(producto.getIdProducto())
                    .nombre(producto.getNombre())
                    .precio(producto.getPrecio())
                    .build();
            return ResponseEntity.ok(productoDTO);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<ProductoDTO> productoDTOList = productoService.findAllProductos()
                .stream()
                .map(producto -> ProductoDTO.builder()
                        .idProducto(producto.getIdProducto())
                        .nombre(producto.getNombre())
                        .precio(producto.getPrecio())
                        .build())
                .toList();
        return ResponseEntity.ok(productoDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO) throws URISyntaxException {
        if (productoDTO.getNombre().isBlank() || productoDTO.getPrecio() == null) {
            return ResponseEntity.badRequest().build();
        }
        Producto producto = Producto.builder()
                .nombre(productoDTO.getNombre())
                .precio(productoDTO.getPrecio())
                .build();
        productoService.saveProducto(producto);
        return ResponseEntity.created(new URI("/api/producto/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        Optional<Producto> productoOptional = productoService.findProductoById(id);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            producto.setNombre(productoDTO.getNombre());
            producto.setPrecio(productoDTO.getPrecio());
            productoService.saveProducto(producto);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            productoService.deleteProductoById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
