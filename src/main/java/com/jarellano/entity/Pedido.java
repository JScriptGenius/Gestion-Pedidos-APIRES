package com.jarellano.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "tbl_pedidos"
)
public class Pedido {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_pedido")
    private Long idpedido;
    private String numeroPedido;

    @ManyToOne
    @JoinColumn(
            name = "id_cliente",
            nullable = false
    )
    private Cliente cliente;

    @OneToMany(
            mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<DetallePedido> detallesPedido = new ArrayList<>();
}
