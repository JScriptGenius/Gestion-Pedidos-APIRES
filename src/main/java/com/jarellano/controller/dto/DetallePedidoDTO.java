package com.jarellano.controller.dto;

import com.jarellano.entity.Pedido;
import com.jarellano.entity.Producto;
import lombok.*;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedidoDTO {
    private Long idDetallePedido;
    private Pedido pedido;
    private Producto producto;
    private BigDecimal cantidad;
    private BigDecimal precioUnitario;
}
