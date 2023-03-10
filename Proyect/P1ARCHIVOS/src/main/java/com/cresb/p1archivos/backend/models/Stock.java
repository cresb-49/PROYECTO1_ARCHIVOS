package com.cresb.p1archivos.backend.models;

import java.util.Objects;

public class Stock {

    private Producto producto;
    private String sucursalId;
    private int cantidad;

    public Stock(Producto producto, String sucursalId, int cantidad) {
        this.producto = producto;
        this.sucursalId = sucursalId;
        this.cantidad = cantidad;
    }

    public Producto getProductoId() {
        return producto;
    }

    public void setProductoId(Producto producto) {
        this.producto = producto;
    }

    public String getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(String sucursalId) {
        this.sucursalId = sucursalId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Stock [producto=" + producto.getId() + ", sucursalId=" + sucursalId + ", cantidad=" + cantidad + "]";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.producto);
        hash = 47 * hash + Objects.hashCode(this.sucursalId);
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
        if (!Objects.equals(this.sucursalId, other.sucursalId)) {
            return false;
        }
        return Objects.equals(this.producto, other.producto);
    }
}
