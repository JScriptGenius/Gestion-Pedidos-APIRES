package com.jarellano.service.impl;

import com.jarellano.entity.Pedido;
import com.jarellano.persistence.IPedidoDAO;
import com.jarellano.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoDAO pedidoDAO;

    @Override
    public List<Pedido> findAllPedidos() {
        return pedidoDAO.findAllPedidos();
    }

    @Override
    public Optional<Pedido> findPedidoById(Long idPedido) {
        return pedidoDAO.findPedidoById(idPedido);
    }

    @Override
    public void savePedido(Pedido pedido) {
        pedidoDAO.savePedido(pedido);
    }

    @Override
    public void deletePedidoById(Long idPedido) {
        pedidoDAO.deletePedidoById(idPedido);
    }
}
