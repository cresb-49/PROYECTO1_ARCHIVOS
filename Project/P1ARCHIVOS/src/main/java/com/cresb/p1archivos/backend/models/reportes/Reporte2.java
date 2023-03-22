package com.cresb.p1archivos.backend.models.reportes;

import java.util.Objects;
/**
 * Top 10 de clientes que más ganancias generan
 * @author benjamin
 */
public class Reporte2 {
    private String nit;
    private String nombre;
    private double gastado;

    public Reporte2(String nit, String nombre, double gastado) {
        this.nit = nit;
        this.nombre = nombre;
        this.gastado = gastado;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getGastado() {
        return gastado;
    }

    public void setGastado(double gastado) {
        this.gastado = gastado;
    }

    @Override
    public String toString() {
        return "Reporte2{" + "nit=" + nit + ", nombre=" + nombre + ", valor=" + gastado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nit);
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.gastado) ^ (Double.doubleToLongBits(this.gastado) >>> 32));
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
        final Reporte2 other = (Reporte2) obj;
        if (Double.doubleToLongBits(this.gastado) != Double.doubleToLongBits(other.gastado)) {
            return false;
        }
        if (!Objects.equals(this.nit, other.nit)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
    
}
