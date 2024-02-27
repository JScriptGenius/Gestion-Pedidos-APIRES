package com.jarellano.persistence;

import com.jarellano.entity.Producto;
import java.util.*;

public interface IProductoDAO {
    List<Producto> findAllProductos();
    Optional<Producto> findProductoById(Long idProducto);
    void saveProducto(Producto producto);
    void deleteProductoById(Long idProducto);
}
