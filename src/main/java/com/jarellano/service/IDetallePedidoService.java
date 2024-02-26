package com.jarellano.service;

import com.jarellano.entity.DetallePedido;
import java.util.*;

public interface IDetallePedidoService {
    List<DetallePedido> findAllDetallePedidos();
    Optional<DetallePedido> findDetallePedidoById(Long idDetallePedido);
    void saveDetallePedido(DetallePedido detallePedido);
    void deteleDetallePedidoById(Long idDetallePedido);
}
