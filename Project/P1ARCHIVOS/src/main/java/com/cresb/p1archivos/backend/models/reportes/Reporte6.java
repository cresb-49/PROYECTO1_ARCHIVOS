package com.cresb.p1archivos.backend.models.reportes;

import java.util.Objects;


/**
 * Top 3 empleados con más ingresos
 * @author benjamin
 */
public class Reporte6 {
    private String id;
    private String nombre;
    private double valor;

    public Reporte6(String id, String nombre, double valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Reporte6{" + "id=" + id + ", nombre=" + nombre + ", valor=" + valor + '}';
    }
}
