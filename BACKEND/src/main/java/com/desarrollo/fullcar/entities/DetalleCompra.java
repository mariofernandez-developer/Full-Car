package com.desarrollo.fullcar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "detalle_compra")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;
    private Long cantidad;
    private Double precio;
    private Double total;

    @ManyToOne
    private Product producto;

    @JsonIgnore
    @ManyToOne
    private Carrito carrito;
}
