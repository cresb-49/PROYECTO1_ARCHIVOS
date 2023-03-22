package com.cresb.p1archivos.backend.models;

import java.util.Objects;

public class Producto {

    private String id;
    private String nombre;
    private String marca;
    private double valor;
    private String descripcion;

    public Producto(String id, String nombre, String marca, double valor, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public Producto() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", valor=" + valor
                + ", descripcion=" + descripcion + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}