package com.cresb.p1archivos.backend.models.reportes;

/**
 * Top 10 productos con más ingresos
 * @author benjamin
 */
public class Reporte7 {
    
    private String id;
    private String nombre;
    private String marca;
    private double valor;

    public Reporte7(String id, String nombre, String marca, double valor) {
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
    public String toString() {
        return "Reporte7{" + "id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", valor=" + valor + '}';
    }
}
