package com.jarellano.persistence.impl;

import com.jarellano.entity.Pedido;
import com.jarellano.persistence.IPedidoDAO;
import com.jarellano.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class IPedidoDAOImpl implements IPedidoDAO {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> findAllPedidos() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> findPedidoById(Long idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    @Override
    public void savePedido(Pedido pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void deletePedidoById(Long idPedido) {
        pedidoRepository.deleteById(idPedido);
    }
}
