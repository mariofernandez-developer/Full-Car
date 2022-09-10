package com.desarrollo.fullcar.entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

public class Product {
    private String descripcion,marca,modelo,nombre;
    private int precio,id;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "fk_carrito", nullable = false)

    private List<Categoria> categorias;
    public Product() {
    }

    public Product(String descripcion, String marca, String modelo, String nombre, int precio, int id) {
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
        this.precio = precio;
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}

