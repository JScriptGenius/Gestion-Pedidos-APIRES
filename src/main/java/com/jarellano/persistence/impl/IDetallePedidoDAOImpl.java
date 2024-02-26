package com.jarellano.persistence.impl;

import com.jarellano.entity.DetallePedido;
import com.jarellano.persistence.IDetallePedido;
import com.jarellano.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class IDetallePedidoDAOImpl implements IDetallePedido {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    public List<DetallePedido> findAllDetallePedidos() {
        return (List<DetallePedido>) detallePedidoRepository.findAll();
    }

    @Override
    public Optional<DetallePedido> findDetallePedidoById(Long idDetallePedido) {
        return detallePedidoRepository.findById(idDetallePedido);
    }

    @Override
    public void saveDetallePedido(DetallePedido detallePedido) {
        detallePedidoRepository.save(detallePedido);
    }

    @Override
    public void deteleDetallePedidoById(Long idDetallePedido) {
        detallePedidoRepository.deleteById(idDetallePedido);
    }
}
