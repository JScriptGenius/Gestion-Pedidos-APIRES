package com.jarellano.persistence;

import com.jarellano.entity.DetallePedido;
import java.util.*;

public interface IDetallePedido {
    List<DetallePedido> findAllDetallePedidos();
    Optional<DetallePedido> findDetallePedidoById(Long idDetallePedido);
    void saveDetallePedido(DetallePedido detallePedido);
    void deteleDetallePedidoById(Long idDetallePedido);
}
