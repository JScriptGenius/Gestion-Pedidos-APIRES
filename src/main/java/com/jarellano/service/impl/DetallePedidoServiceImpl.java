package com.jarellano.service.impl;

import com.jarellano.entity.DetallePedido;
import com.jarellano.persistence.IDetallePedidoDAO;
import com.jarellano.service.IDetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DetallePedidoServiceImpl implements IDetallePedidoService {

    @Autowired
    private IDetallePedidoDAO detallePedidoDAO;

    @Override
    public List<DetallePedido> findAllDetallePedidos() {
        return detallePedidoDAO.findAllDetallePedidos();
    }

    @Override
    public Optional<DetallePedido> findDetallePedidoById(Long idDetallePedido) {
        return detallePedidoDAO.findDetallePedidoById(idDetallePedido);
    }
}
