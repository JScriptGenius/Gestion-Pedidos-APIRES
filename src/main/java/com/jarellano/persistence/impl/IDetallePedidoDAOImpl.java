package com.jarellano.persistence.impl;

import com.jarellano.entity.DetallePedido;
import com.jarellano.persistence.IDetallePedidoDAO;
import com.jarellano.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class IDetallePedidoDAOImpl implements IDetallePedidoDAO {

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
}
