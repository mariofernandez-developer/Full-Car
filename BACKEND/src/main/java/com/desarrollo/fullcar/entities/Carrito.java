package com.desarrollo.fullcar.entities;

public class Carrito {

    int cantidadProducto, precioTotal;
    boolean descuento;
    private Product refProduct; //Agregación de producto.

    //Constructores.
    public Carrito() {
    }

    public Carrito(int cantidadProducto, int precioTotal, boolean descuento) {
        this.cantidadProducto = cantidadProducto;
        this.precioTotal = precioTotal;
        this.descuento = descuento;
    }

    //Getters y Setters.
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public Product getRefProduct() {
        return refProduct;
    }

    public void setRefProduct(Product refProduct) {
        this.refProduct = refProduct;
    }

    public void agregarProduct(Product refProduct) {
        this.refProduct = refProduct;
    } //Agregación de Producto.
}
