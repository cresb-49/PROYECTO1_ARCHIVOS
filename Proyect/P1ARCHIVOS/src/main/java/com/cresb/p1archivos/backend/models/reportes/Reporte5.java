package com.cresb.p1archivos.backend.models.reportes;

import java.util.Objects;

/**
 * Top 3 empleados con más ventas
 * @author benjamin
 */
public class Reporte5 {
    private String id;
    private String nombre;
    private int cantidad;

    public Reporte5(String id, String nombre, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Reporte5{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reporte5 reporte5 = (Reporte5) o;
        return cantidad == reporte5.cantidad && Objects.equals(id, reporte5.id) && Objects.equals(nombre, reporte5.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, cantidad);
    }
}
