package com.jarellano.service.impl;

import com.jarellano.entity.Producto;
import com.jarellano.persistence.IProductoDAO;
import com.jarellano.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public List<Producto> findAlProductos() {
        return productoDAO.findAlProductos();
    }

    @Override
    public Optional<Producto> findProductoById(Long idProducto) {
        return productoDAO.findProductoById(idProducto);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoDAO.saveProducto(producto);
    }

    @Override
    public void deleteProductoById(Long idProducto) {
        productoDAO.deleteProductoById(idProducto);
    }
}
