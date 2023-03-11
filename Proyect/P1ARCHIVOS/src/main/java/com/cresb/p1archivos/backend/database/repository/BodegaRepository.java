package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Bodega;
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

        try (   PreparedStatement statement = GetConnection().prepareStatement("SELECT * FROM mercancia.bodega");
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Bodega bodega = new Bodega(this.productoRepository.buscarProductoPorId(resultSet.getString("producto")),
                        resultSet.getInt("cantidad")
                );

                bodegas.add(bodega);
            }
        }
        return bodegas;
    }
    
    public List<Bodega> findByIdProducto(String producto) throws SQLException {
        List<Bodega> bodegas = new ArrayList<>();

        try (   PreparedStatement statement = GetConnection().prepareStatement("SELECT * FROM mercancia.bodega WHERE producto = ?");
                ResultSet resultSet = statement.executeQuery()) {
            statement.setString(1, producto);
            while (resultSet.next()) {
                Bodega bodega = new Bodega(this.productoRepository.buscarProductoPorId(producto),resultSet.getInt("cantidad"));
                bodegas.add(bodega);
            }
        }
        return bodegas;
    }
    
    public List<Bodega> findByNombreProducto(String nombreProducto) throws SQLException {
        List<Bodega> bodegas = new ArrayList<>();
        try (   PreparedStatement statement = GetConnection().prepareStatement("SELECT b.* FROM mercancia.bodega AS b INNER JOIN mercancia.producto AS p WHERE b.producto = p.id AND p.nombre = ?");
                ResultSet resultSet = statement.executeQuery()) {
            statement.setString(1, nombreProducto);
            while (resultSet.next()) {
                Bodega bodega = new Bodega(this.productoRepository.buscarProductoPorId(resultSet.getString("producto")),resultSet.getInt("cantidad"));
                bodegas.add(bodega);
            }
        }
        return bodegas;
    }
    
    public List<Bodega> findByMarcaProducto(String marcaProducto) throws SQLException {
        List<Bodega> bodegas = new ArrayList<>();
        try (   PreparedStatement statement = GetConnection().prepareStatement("SELECT b.* FROM mercancia.bodega AS b INNER JOIN mercancia.producto AS p WHERE b.producto = p.id AND p.marca = ?");
                ResultSet resultSet = statement.executeQuery()) {
            statement.setString(1, marcaProducto);
            while (resultSet.next()) {
                Bodega bodega = new Bodega(this.productoRepository.buscarProductoPorId(resultSet.getString("producto")),resultSet.getInt("cantidad"));
                bodegas.add(bodega);
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