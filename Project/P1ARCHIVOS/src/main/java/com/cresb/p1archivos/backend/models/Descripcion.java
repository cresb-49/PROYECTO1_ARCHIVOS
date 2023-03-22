package com.cresb.p1archivos.backend.models;

import java.util.Objects;

public class Descripcion {

    private Producto producto;
    private Venta venta;
    private int cantidad;
    //Variable de control
    private Stock stock;

    public Descripcion(Producto producto, Venta venta, int cantidad) {
        this.producto = producto;
        this.venta = venta;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Descripcion [producto=" + producto.getId() + ", venta=" + venta+ ", cantidad=" + cantidad + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descripcion that = (Descripcion) o;
        return Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto);
    }
}