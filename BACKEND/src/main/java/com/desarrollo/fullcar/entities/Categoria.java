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
@Table(name= "categoria")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Categoria implements Serializable{
    //Variables.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private boolean activo = true;

    //Metodos y relaciones.
    @OneToMany(mappedBy = "categoria")
    private List<Product> products;
    String accesorios, respuestosGenericos, repuestosOriginales;

    @Override
    public String toString() {
        return "Categoria{" + "accesorios=" + accesorios + ", respuestosGenericos=" + respuestosGenericos + ", repuestosOriginales=" + repuestosOriginales + '}';
    }

}