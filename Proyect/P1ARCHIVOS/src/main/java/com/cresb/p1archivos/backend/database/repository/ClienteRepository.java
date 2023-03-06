package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private Connection conn;

    public ClienteRepository(Connection conn) {
        this.conn = conn;
    }

    public void save(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO consumidores.cliente(nit, nombre) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNit());
            pstmt.setString(2, cliente.getNombre());
            pstmt.executeUpdate();
        }
    }

    public Cliente findById(String nit) throws SQLException {
        String sql = "SELECT nit, nombre FROM consumidores.cliente WHERE nit = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nit);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    return new Cliente(nit, nombre);
                } else {
                    return null;
                }
            }
        }
    }

    public List<Cliente> findAll() throws SQLException {
        String sql = "SELECT nit, nombre FROM consumidores.cliente";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                String nit = rs.getString("nit");
                String nombre = rs.getString("nombre");
                clientes.add(new Cliente(nit, nombre));
            }
            return clientes;
        }
    }

    public void update(Cliente cliente) throws SQLException {
        String sql = "UPDATE consumidores.cliente SET nombre = ? WHERE nit = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getNit());
            pstmt.executeUpdate();
        }
    }

    public void delete(String nit) throws SQLException {
        String sql = "DELETE FROM consumidores.cliente WHERE nit = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nit);
            pstmt.executeUpdate();
        }
    }
}