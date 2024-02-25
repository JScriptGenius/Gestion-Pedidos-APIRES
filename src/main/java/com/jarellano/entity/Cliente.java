package com.jarellano.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "tbl_clientes"
)
public class Cliente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_cliente")
    private Long idcliente;
    private String nombre;
    private String email;

    @OneToMany(
            mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Pedido> pedidos = new ArrayList<>();
}
