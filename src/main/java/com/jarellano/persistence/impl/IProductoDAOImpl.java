package com.jarellano.persistence.impl;

import com.jarellano.entity.Producto;
import com.jarellano.persistence.IProductoDAO;
import com.jarellano.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class IProductoDAOImpl implements IProductoDAO {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAllProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findProductoById(Long idProducto) {
        return productoRepository.findById(idProducto);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProductoById(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }
}
