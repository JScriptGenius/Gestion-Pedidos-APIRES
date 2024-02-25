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
    private Long iddetallepedido;

    @ManyToOne
    @JoinColumn(
            name = "pedido_id",
            nullable = false
    )
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(
            name = "producto_id",
            nullable = false
    )
    private Producto producto;

    private BigDecimal cantidad;
    private BigDecimal precioUnitario;
}
