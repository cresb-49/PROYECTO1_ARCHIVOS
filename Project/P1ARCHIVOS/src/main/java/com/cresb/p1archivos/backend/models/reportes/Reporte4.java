package com.cresb.p1archivos.backend.models.reportes;

/**
 * Top 3 sucursales con más ingresos
 * @author Dango
 */
public class Reporte4 {
    
    private String id;
    private String nombre;
    private double ingreso;

    public Reporte4(String id, String nombre, double ingreso) {
        this.id = id;
        this.nombre = nombre;
        this.ingreso = ingreso;
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

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    @Override
    public String toString() {
        return "Reporte4{" + "id=" + id + ", nombre=" + nombre + ", ingreso=" + ingreso + '}';
    }
}
