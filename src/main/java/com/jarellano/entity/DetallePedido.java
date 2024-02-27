package com.jarellano.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "tbl_detalles_pedido"
)
public class DetallePedido {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_detalle_pedido")
    private Long idDetallePedido;

    @ManyToOne
    @JoinColumn(
            name = "id_pedido",
            nullable = false
    )
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(
            name = "id_producto",
            nullable = false
    )
    private Producto producto;

    private BigDecimal cantidad;
    private BigDecimal precioUnitario;
}
