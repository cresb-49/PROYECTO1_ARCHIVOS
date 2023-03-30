package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Rol;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RolRepository extends RepositoryBase {

    public RolRepository() {
    }

    public void insert(Rol rol) throws SQLException {
        String query = "INSERT INTO colaboradores.rol (id, nombre) VALUES (?, ?)";
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setInt(1, rol.getId());
            statement.setString(2, rol.getNombre());
            statement.executeUpdate();
        }
    }

    public Rol findById(int id) throws SQLException {
        String query = "SELECT * FROM colaboradores.rol WHERE id = ?";
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setInt(1, id);
            try ( ResultSet rs = statement.executeQuery();) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    return new Rol(id, nombre);
                }
            }
        }
        return null;
    }

    public List<Rol> findAll() throws SQLException {
        List<Rol> roles = new ArrayList<>();
        String query = "SELECT * FROM colaboradores.rol";
        try ( Statement statement = GetConnection().createStatement();  ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                roles.add(new Rol(id, nombre));
            }
        }
        return roles;
    }

    public void update(Rol rol) throws SQLException {
        String query = "UPDATE colaboradores.rol SET nombre = ? WHERE id = ?";
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, rol.getNombre());
            statement.setInt(2, rol.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM colaboradores.rol WHERE id = ?";
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
