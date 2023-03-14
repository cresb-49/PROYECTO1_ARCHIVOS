package com.cresb.p1archivos.backend.models.reportes;

import java.util.Objects;


/**
 * Top 3 empleados con más ingresos
 * @author benjamin
 */
public class Reporte6 {
    private String id;
    private String nombre;
    private String marca;
    private double valor;

    public Reporte6(String id, String nombre, String marca, double valor) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reporte6 reporte6 = (Reporte6) o;
        return Double.compare(reporte6.valor, valor) == 0 && Objects.equals(id, reporte6.id) && Objects.equals(nombre, reporte6.nombre) && Objects.equals(marca, reporte6.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, marca, valor);
    }
}
