package com.jarellano.controller.dto;

import com.jarellano.entity.Cliente;
import com.jarellano.entity.DetallePedido;
import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDTO {
    private Long idPedido;
    private String numeroPedido;
    private Cliente cliente;
    private List<DetallePedido> detallesPedido = new ArrayList<>();
}
