package com.cresb.p1archivos.backend.models;

import java.util.Objects;

/**
 *
 * @author Dango
 */
public class DisponiblidadSolicitud {
    private boolean isSucursal;
    private int cantidad;
    private String lugar;
    //variable de control
    private Stock stockOrigen;
    private Stock stockDestino;
    
    public DisponiblidadSolicitud(boolean isSucursal,String lugar,Stock origen ,Stock destino ,int cantidad) {
        this.isSucursal = isSucursal;
        this.lugar = lugar;
        this.stockOrigen = origen;
        this.stockDestino = destino;
        this.cantidad = cantidad;
    }
    
    public boolean isIsSucursal() {
        return isSucursal;
    }

    public void setIsSucursal(boolean isSucursal) {
        this.isSucursal = isSucursal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Stock getStockDestino() {
        return stockDestino;
    }

    public void setStockDestino(Stock stockDestino) {
        this.stockDestino = stockDestino;
    }

    public Stock getStockOrigen() {
        return stockOrigen;
    }

    public void setStockOrigen(Stock stockOrigen) {
        this.stockOrigen = stockOrigen;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "DisponiblidadSolicitud{" + "isSucursal=" + isSucursal + ", cantidad=" + cantidad + ", lugar=" + lugar + ", stockOrigen=" + stockOrigen + ", stockDestino=" + stockDestino + '}';
    }
    
}
