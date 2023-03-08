package com.cresb.p1archivos.backend.models.tableModels;

import com.cresb.p1archivos.backend.models.Descripcion;
import java.util.Objects;

/**
 *
 * @author benjamin
 */
public class TableDescripcion {
    private String codigo;
    private String nombre;
    private double valor;
    private int cantidad;
    private Descripcion descripcion;

    public TableDescripcion(String codigo, String nombre, double valor, int cantidad, Descripcion descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }
    
    public TableDescripcion(String codigo, String nombre, double valor, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TableDescripcion{" + "codigo=" + codigo + ", nombre=" + nombre + ", valor=" + valor + ", cantidad=" + cantidad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 97 * hash + this.cantidad;
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
        final TableDescripcion other = (TableDescripcion) obj;
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
}
