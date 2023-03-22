package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Sucursal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalRepository extends RepositoryBase {

    public SucursalRepository(){

    }

    public List<Sucursal> getAll() throws SQLException {
        List<Sucursal> sucursal = new ArrayList<>();
        String query = "SELECT * FROM infraestructura.sucursal";
        try (PreparedStatement statement = GetConnection().prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("nombre");
                sucursal.add(new Sucursal(id,name));
            }
        }
        return sucursal;
    }

    public Sucursal findByNombre(String nombre) throws SQLException {
        String query = "SELECT * FROM infraestructura.sucursal WHERE nombre = ?";
        try (PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, nombre);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                return new Sucursal(id,nombre);
            }
        }
        return null;
    }
    
    public Sucursal findById(String id) throws SQLException {
        String query = "SELECT * FROM infraestructura.sucursal WHERE id = ?";
        try (PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("nombre");
                return new Sucursal(id,name);
            }
        }
        return null;
    }

    public Sucursal findByIdEmpleado(String nickname) throws SQLException {
        String query = "SELECT s.* FROM infraestructura.sucursal AS s INNER JOIN colaborador.planilla AS p ON p.sucursal = s.id WHERE p.empleado = ?;";
        try (PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, nickname);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("nombre");
                return new Sucursal(id,name);
            }
        }
        return null;
    }

}