package com.cresb.p1archivos.backend.models;

import java.util.Objects;

public class Stock {

    private Producto producto;
    private String sucursal;
    private int cantidad;

    public Stock(Producto producto, String sucursal, int cantidad) {
        this.producto = producto;
        this.sucursal = sucursal;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Stock [producto=" + producto.getId() + ", sucursal=" + sucursal + ", cantidad=" + cantidad + "]";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.producto);
        hash = 47 * hash + Objects.hashCode(this.sucursal);
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
        final Stock other = (Stock) obj;
        if (!Objects.equals(this.sucursal, other.sucursal)) {
            return false;
        }
        return Objects.equals(this.producto, other.producto);
    }
}
