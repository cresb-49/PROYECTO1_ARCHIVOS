package com.cresb.p1archivos.backend.models.reportes;

/**
 *
 * @author benjamin
 */
public class Reporte9 {
    private String id;
    private String nombre;
    private String marca;
    private double ingreso;

    public Reporte9(String id, String nombre, String marca, double ingreso) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getingreso() {
        return ingreso;
    }

    public void setingreso(double ingreso) {
        this.ingreso = ingreso;
    }

    @Override
    public String toString() {
        return "Reporte9{" + "id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", ingreso=" + ingreso + '}';
    }
    
}
