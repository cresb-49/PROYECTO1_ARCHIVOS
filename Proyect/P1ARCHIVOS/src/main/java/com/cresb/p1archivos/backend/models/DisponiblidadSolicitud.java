package com.cresb.p1archivos.backend.models;

import java.util.Objects;

/**
 *
 * @author Dango
 */
public class DisponiblidadSolicitud {
    private boolean isSucursal;
    private String lugar;
    private String code;
    private int cantidad;
    //variable de control
    private int cantidadSolicitar;

    public DisponiblidadSolicitud(String lugar) {
        this.lugar = lugar;
    }
    
    public DisponiblidadSolicitud(boolean isSucursal, String lugar, String code, int cantidad) {
        this.isSucursal = isSucursal;
        this.lugar = lugar;
        this.code = code;
        this.cantidad = cantidad;
    }
    
    
    public boolean isIsSucursal() {
        return isSucursal;
    }

    public void setIsSucursal(boolean isSucursal) {
        this.isSucursal = isSucursal;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadSolicitar() {
        return cantidadSolicitar;
    }

    public void setCantidadSolicitar(int cantidadSolicitar) {
        this.cantidadSolicitar = cantidadSolicitar;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public String toString() {
        return "DisponiblidadSolicitud{" + "lugar=" + lugar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.lugar);
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
        final DisponiblidadSolicitud other = (DisponiblidadSolicitud) obj;
        return Objects.equals(this.lugar, other.lugar);
    }
}
