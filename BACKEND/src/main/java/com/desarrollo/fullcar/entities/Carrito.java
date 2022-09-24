package com.desarrollo.fullcar.entities;

import java.io.Serializable;
import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cantidadProducto")
    int cantidadProducto;
    @Column(name="precioTotal")
    int precioTotal;
    @Column(name="descuento")
    boolean descuento;

    //Metodos y relaciones.

}
