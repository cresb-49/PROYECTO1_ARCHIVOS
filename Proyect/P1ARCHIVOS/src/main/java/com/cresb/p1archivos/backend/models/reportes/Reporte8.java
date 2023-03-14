package com.cresb.p1archivos.backend.models.reportes;

/**
 * Top 5 productos más vendidos por sucursal
 * @author benjamin
 */
public class Reporte8 {
    private String id;
    private String nombre;
    private String marca;
    private int cantidad;

    public Reporte8(String id, String nombre, String marca, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Reporte9{" + "id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", cantidad=" + cantidad + '}';
    }
}
