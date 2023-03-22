package com.cresb.p1archivos.backend.models;

public class Cliente {

    private String nit;
    private String nombre;

    public Cliente(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente [nit=" + nit + ", nombre=" + nombre + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (nit == null) {
            if (other.nit != null)
                return false;
        } else if (!nit.equals(other.nit))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nit == null) ? 0 : nit.hashCode());
        return result;
    }

}
