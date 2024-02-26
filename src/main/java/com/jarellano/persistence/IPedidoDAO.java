package com.jarellano.persistence;

import com.jarellano.entity.Pedido;
import java.util.*;

public interface IPedidoDAO {
    List<Pedido> findAllPedidos();
    Optional<Pedido> findPedidoById(Long idPedido);
    void savePedido(Pedido pedido);
    void deletePedidoById(Long idPedido);
}
