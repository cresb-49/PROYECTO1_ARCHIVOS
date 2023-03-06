package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository {
    
    private Connection conn;
    private RolRepository rolRepository;
    
    public EmpleadoRepository(Connection conn) {
        this.conn = conn;
        this.rolRepository = new RolRepository(conn);
    }
    
    public Empleado findById(String nickname) throws SQLException{
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM colaboradores.empleado WHERE nickname = ?")) {
            stmt.setString(1, nickname);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Empleado empleado = new Empleado();
                    empleado.setNickname(rs.getString("nickname"));
                    empleado.setPassw(null);
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setRol(rolRepository.findById(rs.getInt("rol")));
                    return empleado;
                }
            }
        }
        return null;
    }
    
    public Empleado login(String nickname,String password) throws SQLException{
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM colaboradores.empleado WHERE nickname = ? AND passw = ?")) {
            stmt.setString(1, nickname);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Empleado empleado = new Empleado();
                    empleado.setNickname(rs.getString("nickname"));
                    empleado.setPassw(null);
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setRol(rolRepository.findById(rs.getInt("rol")));
                    return empleado;
                }
            }
        }
        return null;
    }

    public List<Empleado> findAll() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM colaboradores.empleado")) {
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setNickname(rs.getString("nickname"));
                empleado.setPassw(rs.getString("passw"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setRol(rolRepository.findById(rs.getInt("rol")));
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    public void save(Empleado empleado) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO colaboradores.empleado VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, empleado.getNickname());
            stmt.setString(2, empleado.getPassw());
            stmt.setString(3, empleado.getNombre());
            stmt.setInt(4, empleado.getRol().getId());
            stmt.executeUpdate();
        }
    }

    public void update(Empleado empleado) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE colaboradores.empleado SET passw = ?, nombre = ?, rol = ? WHERE nickname = ?")) {
            stmt.setString(1, empleado.getPassw());
            stmt.setString(2, empleado.getNombre());
            stmt.setInt(3, empleado.getRol().getId());
            stmt.setString(4, empleado.getNickname());
            stmt.executeUpdate();
        }
    }

    public void deleteById(String nickname) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM colaboradores.empleado WHERE nickname = ?")) {
            stmt.setString(1, nickname);
            stmt.executeUpdate();
        }
    }
}