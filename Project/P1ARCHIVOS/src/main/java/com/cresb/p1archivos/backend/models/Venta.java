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
    private String sucursal;

    public Venta(String id, String fecha, Cliente cliente, Empleado empleado, double descuento, List<Descripcion> descripcion, double valor, String sucursal) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.descuento = descuento;
        this.descripcion = descripcion;
        this.valor = valor;
        this.sucursal = sucursal;
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

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id='" + id + '\'' +
                ", fecha='" + fecha + '\'' +
                ", cliente=" + cliente +
                ", empleado=" + empleado +
                ", descuento=" + descuento +
                ", descripcion=" + descripcion +
                ", valor=" + valor +
                ", sucursal='" + sucursal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return Double.compare(venta.descuento, descuento) == 0 && Double.compare(venta.valor, valor) == 0 && Objects.equals(id, venta.id) && Objects.equals(fecha, venta.fecha) && Objects.equals(cliente, venta.cliente) && Objects.equals(empleado, venta.empleado) && Objects.equals(descripcion, venta.descripcion) && Objects.equals(sucursal, venta.sucursal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, cliente, empleado, descuento, descripcion, valor, sucursal);
    }
}
