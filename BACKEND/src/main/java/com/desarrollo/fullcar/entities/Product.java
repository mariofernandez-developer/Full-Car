
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
@Table(name= "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product implements Serializable{
        //Variables.
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(name="nombre")
        private String nombre;
        @Column(name="descripcion")
        private String descripcion;
        @Column(name="importado")
        private boolean importado;
        @Column(name="marca")
        private String marca;
        @Column(name="modelo")
        private int modelo;
        @Column(name="precio")
        private float precio;
        @Column(name="cantidad")
        private Long cantidad;
        //Metodos y relaciones.
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "fk_categoria", nullable = false)
        private Categoria categoria;




}

