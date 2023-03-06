package com.cresb.p1archivos.backend.models;

public class Stock {

    private String productoId;
    private String sucursalId;
    private int cantidad;

    public Stock(String productoId, String sucursalId, int cantidad) {
        this.productoId = productoId;
        this.sucursalId = sucursalId;
        this.cantidad = cantidad;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
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
        return "Stock [productoId=" + productoId + ", sucursalId=" + sucursalId + ", cantidad=" + cantidad + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Stock other = (Stock) obj;
        if (cantidad != other.cantidad)
            return false;
        if (productoId == null) {
            if (other.productoId != null)
                return false;
        } else if (!productoId.equals(other.productoId))
            return false;
        if (sucursalId == null) {
            if (other.sucursalId != null)
                return false;
        } else if (!sucursalId.equals(other.sucursalId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cantidad;
        result = prime * result + ((productoId == null) ? 0 : productoId.hashCode());
        result = prime * result + ((sucursalId == null) ? 0 : sucursalId.hashCode());
        return result;
    }

}
