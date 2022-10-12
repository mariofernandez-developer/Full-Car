
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
import javax.validation.constraints.*;


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

        @NotEmpty(message = "{NotEmpty.Product.nombre}")
        @Column(name="nombre")
        private String nombre;

        @Size(min=5,max=100,message= "La descripcion debe ser entre 5 y 100 caracteres")
        @Column(name="descripcion")
        private String descripcion;

        @Column(name="importado")
        private boolean importado;

        @NotNull(message="Es requerida la marca")
        @Column(name="marca")
        private String marca;

        @NotNull(message="Es requerida el modelo")
        @Column(name="modelo")
        private int modelo;

        @Min(value = 5,message="El precio debe tener un minimo de 5")
        @Max(value = 10000, message="El precio debe ser menor a 1000")
        @Column(name="precio")
        private float precio;

        @Min(value = 1,message="El stock debe tener un minimo de 5")
        @Max(value = 10000, message="El stock debe ser menor a 1000")
        @Column(name="cantidad")
        private Long cantidad;
        //Metodos y relaciones.
        @NotNull(message="Es requerida la categoria")
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "fk_categoria", nullable = false)
        private Categoria categoria;




}

