package com.cresb.p1archivos.backend.models;

public class Empleado {

    private String nickname;
    private String passw;
    private String nombre;
    private int rol;

    public Empleado(String nickname, String passw, String nombre, int rol) {
        this.nickname = nickname;
        this.passw = passw;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Empleado [nickname=" + nickname + ", passw=" + passw + ", nombre=" + nombre + ", rol=" + rol + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        if (nickname == null) {
            if (other.nickname != null)
                return false;
        } else if (!nickname.equals(other.nickname))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (passw == null) {
            if (other.passw != null)
                return false;
        } else if (!passw.equals(other.passw))
            return false;
        if (rol != other.rol)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((passw == null) ? 0 : passw.hashCode());
        result = prime * result + rol;
        return result;
    }
}
