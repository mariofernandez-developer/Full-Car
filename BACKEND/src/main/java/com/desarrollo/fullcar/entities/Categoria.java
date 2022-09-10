package com.desarrollo.fullcar.entities;

public class Categoria {
    String accesorios, respuestosGenericos, repuestosOriginales;


    public Categoria() {
    }


    public Categoria(String accesorios, String respuestosGenericos, String repuestosOriginales) {
        this.accesorios = accesorios;
        this.respuestosGenericos = respuestosGenericos;
        this.repuestosOriginales = repuestosOriginales;
    }


    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    public String getRespuestosGenericos() {
        return respuestosGenericos;
    }

    public void setRespuestosGenericos(String respuestosGenericos) {
        this.respuestosGenericos = respuestosGenericos;
    }

    public String getRepuestosOriginales() {
        return repuestosOriginales;
    }

    public void setRepuestosOriginales(String repuestosOriginales) {
        this.repuestosOriginales = repuestosOriginales;
    }

    @Override
    public String toString() {
        return "Categoria{" + "accesorios=" + accesorios + ", respuestosGenericos=" + respuestosGenericos + ", repuestosOriginales=" + repuestosOriginales + '}';
    }

}