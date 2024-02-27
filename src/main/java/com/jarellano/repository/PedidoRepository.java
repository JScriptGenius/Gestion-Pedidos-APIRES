package com.jarellano.repository;

import com.jarellano.entity.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
    Optional<Pedido> findPedidoByNumeroPedido(String numeroPedido);
}
