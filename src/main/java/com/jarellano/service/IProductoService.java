package com.jarellano.service;

import com.jarellano.entity.Producto;
import java.util.*;

public interface IProductoService {
    List<Producto> findAllProductos();
    Optional<Producto> findProductoById(Long idProducto);
    void saveProducto(Producto producto);
    void deleteProductoById(Long idProducto);
}
