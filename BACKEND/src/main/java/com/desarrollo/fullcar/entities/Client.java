package com.desarrollo.fullcar.entities;

public class Client {

    //Variables
    String apellido, nombre;
    int edad, id;
    private Carrito refCarrito; //Agregación de carrito.
    /*
      Falta en la clase main (por hacer en un futuro) culminar todas las relaciones de agregación. Hasta el momento
      solo se han creado las relaciones entre clases por debajo.
     */

    //Constructores.
    public Client() {
    }

    public Client(String apellido, String nombre, int edad, int id) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }

    //Getters y Setters.
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrito getRefCarrito() {
        return refCarrito;
    }

    public void setRefCarrito(Carrito refCarrito) {
        this.refCarrito = refCarrito;
    }

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
