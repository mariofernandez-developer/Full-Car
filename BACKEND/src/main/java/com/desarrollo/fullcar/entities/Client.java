package com.desarrollo.fullcar.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name= "client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //Variables
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="dni")
    private int dni;
    private Carrito refCarrito; //Agregación de carrito.
    /*
      Falta en la clase main (por hacer en un futuro) culminar todas las relaciones de agregación. Hasta el momento
      solo se han creado las relaciones entre clases por debajo.
     */



    //Metodos.
    public void agregarCarrito(Carrito refCarrito) {
        this.refCarrito = refCarrito;
    }  //Agregación de Carrito.

    public boolean login(){
        boolean prueba = true; //Variable a borrar, solo se creó para que no marque error.
        return prueba;
    }

    public boolean registrarse(){
        boolean prueba = true; //Variable a borrar, solo se creó para que no marque error.
        return prueba;
    }
}
