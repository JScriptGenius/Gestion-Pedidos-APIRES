package com.jarellano.controller.dto;

import com.jarellano.entity.Pedido;
import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {
    private Long idCliente;
    private String nombre;
    private String email;
    private List<Pedido> pedidos = new ArrayList<>();
}
