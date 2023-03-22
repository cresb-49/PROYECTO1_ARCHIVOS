package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository extends RepositoryBase{
    
    public ProductoRepository() {
    }
    
    public void guardarProducto(Producto producto) throws SQLException {
        String sql = "INSERT INTO mercancia.producto (id, nombre, marca, valor, descripcion) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement pst = GetConnection().prepareStatement(sql)) {
            pst.setString(1, producto.getId());
            pst.setString(2, producto.getNombre());
            pst.setString(3, producto.getMarca());
            pst.setDouble(4, producto.getValor());
            pst.setString(5, producto.getDescripcion());
            pst.executeUpdate();
        }
    }
    
    public Producto buscarProductoPorId(String id) throws SQLException {
        Producto producto = null;
        String sql = "SELECT id, nombre, marca, valor, descripcion FROM mercancia.producto WHERE id = ?;";
        try (PreparedStatement pst = GetConnection().prepareStatement(sql)) {
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getString("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setValor(rs.getDouble("valor"));
                producto.setDescripcion(rs.getString("descripcion"));
            }
        }
        return producto;
    }
    
    public List<Producto> buscarTodosLosProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT id, nombre, marca, valor, descripcion FROM mercancia.producto;";
        try (Statement st = GetConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getString("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setValor(rs.getDouble("valor"));
                producto.setDescripcion(rs.getString("descripcion"));
                productos.add(producto);
            }
        }
        return productos;
    }
    
    public void actualizarProducto(Producto producto) throws SQLException {
        String sql = "UPDATE mercancia.producto SET nombre = ?, marca = ?, valor = ?, descripcion = ? WHERE id = ?;";
        try (PreparedStatement pst = GetConnection().prepareStatement(sql)) {
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getMarca());
            pst.setDouble(3, producto.getValor());
            pst.setString(4, producto.getDescripcion());
            pst.setString(5, producto.getId());
            pst.executeUpdate();
        }
    }
    
    public void eliminarProducto(String id) throws SQLException{
        try (PreparedStatement stmt = GetConnection().prepareStatement("DELETE FROM mercancia.producto WHERE id = ?")) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
    
    public String lastId() throws SQLException{
        String result = "P0000";
        String sql = "select p.id from mercancia.producto as p order by p.id desc limit 1";
        try (Statement st = GetConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getString("id");
            }
        }
        return result;
    }
}