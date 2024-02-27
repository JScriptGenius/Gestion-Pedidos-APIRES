package com.jarellano.service;

import com.jarellano.entity.Pedido;
import java.util.*;

public interface IPedidoService {
    List<Pedido> findAllPedidos();
    Optional<Pedido> findPedidoById(Long idPedido);
    void savePedido(Pedido pedido);
    void deletePedidoById(Long idPedido);
    Optional<Pedido> findPedidoByNumeroPedido(String numPedido);
}
