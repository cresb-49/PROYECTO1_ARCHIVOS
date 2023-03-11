package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Bodega;
import com.cresb.p1archivos.backend.models.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BodegaRepository extends RepositoryBase{
    private ProductoRepository productoRepository;

    public BodegaRepository() {
        this.productoRepository = new ProductoRepository();
    }

    public List<Bodega> findAll() throws SQLException {
        List<Bodega> bodegas = new ArrayList<>();
        try (   PreparedStatement statement = GetConnection().prepareStatement("SELECT p.*, COALESCE(b.cantidad, 0) AS cantidad FROM mercancia.producto p LEFT JOIN mercancia.bodega b ON p.id = b.producto ORDER BY p.id");
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Bodega bodega = new Bodega(new Producto(resultSet.getString("id"), resultSet.getString("nombre"), resultSet.getString("marca"), resultSet.getDouble("valor"), resultSet.getString("descripcion")),resultSet.getInt("cantidad"));
                bodegas.add(bodega);
            }
        }
        return bodegas;
    }
    
    public List<Bodega> findByIdProducto(String producto) throws SQLException {
        List<Bodega> bodegas = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement("SELECT p.*, COALESCE(b.cantidad, 0) AS cantidad FROM mercancia.producto p LEFT JOIN mercancia.bodega b ON p.id = b.producto WHERE p.id = ? ORDER BY p.id")) {
            statement.setString(1, producto);
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    Bodega bodega = new Bodega(new Producto(resultSet.getString("id"), resultSet.getString("nombre"), resultSet.getString("marca"), resultSet.getDouble("valor"), resultSet.getString("descripcion")),resultSet.getInt("cantidad"));
                    bodegas.add(bodega);
                }
            }
        }
        return bodegas;
    }
    
    public List<Bodega> findByNombreProducto(String nombreProducto) throws SQLException {
        List<Bodega> bodegas = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement("SELECT p.*, COALESCE(b.cantidad, 0) AS cantidad FROM mercancia.producto p LEFT JOIN mercancia.bodega b ON p.id = b.producto WHERE p.nombre LIKE ?")) {
            statement.setString(1, "%"+nombreProducto+"%");
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    Bodega bodega = new Bodega(new Producto(resultSet.getString("id"), resultSet.getString("nombre"), resultSet.getString("marca"), resultSet.getDouble("valor"), resultSet.getString("descripcion")),resultSet.getInt("cantidad"));
                    bodegas.add(bodega);
                }
            }
        }
        return bodegas;
    }
    
    public List<Bodega> findByMarcaProducto(String marcaProducto) throws SQLException {
        List<Bodega> bodegas = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement("SELECT p.*, COALESCE(b.cantidad, 0) AS cantidad FROM mercancia.producto p LEFT JOIN mercancia.bodega b ON p.id = b.producto WHERE p.marca LIKE ?")) {
            statement.setString(1, "%"+marcaProducto+"%");
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    Bodega bodega = new Bodega(new Producto(resultSet.getString("id"), resultSet.getString("nombre"), resultSet.getString("marca"), resultSet.getDouble("valor"), resultSet.getString("descripcion")),resultSet.getInt("cantidad"));
                    bodegas.add(bodega);
                }
            }
        }
        return bodegas;
    }
    
    public boolean isExists(String marcaProducto) throws SQLException {
        List<Bodega> bodegas = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement("SELECT p.*, COALESCE(b.cantidad, 0) AS cantidad FROM mercancia.producto p LEFT JOIN mercancia.bodega b ON p.id = b.producto WHERE p.marca LIKE ?")) {
            statement.setString(1, "%"+marcaProducto+"%");
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()) {
                    Bodega bodega = new Bodega(new Producto(resultSet.getString("id"), resultSet.getString("nombre"), resultSet.getString("marca"), resultSet.getDouble("valor"), resultSet.getString("descripcion")),resultSet.getInt("cantidad"));
                    bodegas.add(bodega);
                }
            }
        }
        return bodegas;
    }
    
    public void save(Bodega bodega) throws SQLException {
        try (PreparedStatement statement = GetConnection().prepareStatement("INSERT INTO mercancia.bodega (producto, cantidad) VALUES (?, ?)")){
            statement.setString(1, bodega.getProducto().getId());
            statement.setInt(2, bodega.getCantidad());
            statement.executeUpdate();
        }
    }

    public void update(Bodega bodega) throws SQLException {
        try (PreparedStatement statement = GetConnection().prepareStatement("UPDATE mercancia.bodega SET cantidad = ? WHERE producto = ?")){
            statement.setInt(1, bodega.getCantidad());
            statement.setString(2, bodega.getProducto().getId());
            statement.executeUpdate();
        }
    }

    public void delete(String producto) throws SQLException {
        try (PreparedStatement statement = GetConnection().prepareStatement("DELETE FROM mercancia.bodega WHERE producto = ?")) {
            statement.setString(1, producto);
            statement.executeUpdate();
        }
    }
}