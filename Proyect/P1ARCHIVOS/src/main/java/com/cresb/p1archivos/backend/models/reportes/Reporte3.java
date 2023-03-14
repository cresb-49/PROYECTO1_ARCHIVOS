package com.cresb.p1archivos.backend.models.reportes;

import java.util.Objects;

/**
 *
 * @author Dango
 */
public class Reporte3 {
    
    private String id;
    private String nombre;
    private int cantidad;

    public Reporte3(String id, String nombre, int cantidad) {
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
        return "Reporte3{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reporte3 other = (Reporte3) obj;
        return Objects.equals(this.id, other.id);
    }
}
