package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Descripcion;
import com.cresb.p1archivos.backend.models.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DescripcionRepository {

    private ProductoRepository productoRepository;
    private Connection conn;

    public DescripcionRepository(Connection conn) {
        this.conn = conn;
        this.productoRepository= new ProductoRepository(conn);
    }

    public List<Descripcion> findAll() throws SQLException {
        List<Descripcion> result = new ArrayList<>();
        String sql = "SELECT * FROM comercio.descripcion";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Producto producto = this.productoRepository.buscarProductoPorId(resultSet.getString("producto"));
                    String ventaId = resultSet.getString("venta");
                    int cantidad = resultSet.getInt("cantidad");
                    Descripcion descripcion = new Descripcion(producto,ventaId,cantidad);
                    result.add(descripcion);
                }
            }
        }
        return result;
    }
    
    public List<Descripcion> findByVentaId(String venta) throws SQLException {
        List<Descripcion> result = new ArrayList<>();
        String sql = "SELECT * FROM comercio.descripcion WHERE venta  = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, venta);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Producto producto = this.productoRepository.buscarProductoPorId(resultSet.getString("producto"));
                    int cantidad = resultSet.getInt("cantidad");
                    Descripcion descripcion = new Descripcion(producto,venta,cantidad);
                    result.add(descripcion);
                }
            }
        }
        return result;
    }

    public void save(Descripcion descripcion) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO comercio.descripcion (producto, venta, cantidad) VALUES (?, ?, ?)")) {
            stmt.setString(1, descripcion.getProducto().getId());
            stmt.setString(2, descripcion.getVenta());
            stmt.setInt(3, descripcion.getCantidad());
            stmt.executeUpdate();
        }
    }
    
    public void save(List<Descripcion> descripcion) throws SQLException {
        for (Descripcion descripcion1 : descripcion) {
            this.save(descripcion1);
        }
    }
}
