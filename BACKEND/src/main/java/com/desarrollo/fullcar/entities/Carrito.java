package com.desarrollo.fullcar.entities;

import java.io.Serializable;
import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name= "carrito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Carrito implements Serializable {
    //Variables
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;
    private Date fecha;
    private Double total;

    @ManyToOne
    private Client cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrito")
    private List<DetalleCompra> listaDetalleCompra;
    //Metodos y relaciones.

}
