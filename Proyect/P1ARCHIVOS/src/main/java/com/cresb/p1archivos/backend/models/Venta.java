package com.cresb.p1archivos.backend.models;

import java.util.List;
import java.util.Objects;

public class Venta {

    private String id;
    private String fecha;
    private Cliente cliente;
    private Empleado empleado;
    private double descuento;
    private List<Descripcion> descripcion;
    private double valor;

    public Venta(String id, String fecha, Cliente cliente, Empleado empleado, double descuento, List<Descripcion> descripcion, double valor) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.descuento = descuento;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public List<Descripcion> getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(List<Descripcion> descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.fecha);
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
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }
}
