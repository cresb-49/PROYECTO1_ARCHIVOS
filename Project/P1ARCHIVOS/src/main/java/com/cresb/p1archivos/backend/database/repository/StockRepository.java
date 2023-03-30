package com.cresb.p1archivos.backend.database.repository;

import static com.cresb.p1archivos.backend.database.repository.RepositoryBase.GetConnection;
import com.cresb.p1archivos.backend.models.Producto;
import com.cresb.p1archivos.backend.models.Stock;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dango
 */
public class StockRepository extends RepositoryBase {

    public StockRepository() {

    }

    public List<Stock> findStockBySucursal(String sucursal) throws SQLException {
        String query = "SELECT producto.*,COALESCE(stock.cantidad, 0) AS cantidad FROM mercancia.producto LEFT JOIN mercancia.stock ON producto.id = stock.producto AND stock.sucursal = ?";
        List<Stock> stocks = new ArrayList<>();
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            try ( ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    String marca = rs.getString("marca");
                    double valor = rs.getDouble("valor");
                    String des = rs.getString("descripcion");
                    int cantidad = rs.getInt("cantidad");
                    stocks.add(new Stock(new Producto(id, nombre, marca, valor, des), sucursal, cantidad));
                }
            }
        }
        return stocks;
    }

    public List<Stock> findStockBySucursalAndName(String sucursal, String name) throws SQLException {
        String query = "SELECT producto.*,COALESCE(stock.cantidad, 0) AS cantidad FROM mercancia.producto LEFT JOIN mercancia.stock ON producto.id = stock.producto AND stock.sucursal = ? WHERE producto.nombre LIKE ?";
        List<Stock> stocks = new ArrayList<>();
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            statement.setString(2, "%" + name + "%");
            try ( ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    String marca = rs.getString("marca");
                    double valor = rs.getDouble("valor");
                    String des = rs.getString("descripcion");
                    int cantidad = rs.getInt("cantidad");
                    stocks.add(new Stock(new Producto(id, nombre, marca, valor, des), sucursal, cantidad));
                }
            }
        }
        return stocks;
    }

    public List<Stock> findStockBySucursalAndMarca(String sucursal, String marca) throws SQLException {
        String query = "SELECT producto.*,COALESCE(stock.cantidad, 0) AS cantidad FROM mercancia.producto LEFT JOIN mercancia.stock ON producto.id = stock.producto AND stock.sucursal = ? WHERE producto.marca LIKE ?";
        List<Stock> stocks = new ArrayList<>();
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            statement.setString(2, "%" + marca + "%");
            try ( ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    String marc = rs.getString("marca");
                    double valor = rs.getDouble("valor");
                    String des = rs.getString("descripcion");
                    int cantidad = rs.getInt("cantidad");
                    stocks.add(new Stock(new Producto(id, nombre, marc, valor, des), sucursal, cantidad));
                }
            }
        }
        return stocks;
    }

    public List<Stock> findStockBySucursalAndCode(String sucursal, String codigo) throws SQLException {
        String query = "SELECT producto.*,COALESCE(stock.cantidad, 0) AS cantidad FROM mercancia.producto LEFT JOIN mercancia.stock ON producto.id = stock.producto AND stock.sucursal = ? WHERE producto.id = ?";
        List<Stock> stocks = new ArrayList<>();
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            statement.setString(2, codigo);
            try ( ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    double valor = rs.getDouble("valor");
                    String marca = rs.getString("marca");
                    String des = rs.getString("descripcion");
                    int cantidad = rs.getInt("cantidad");
                    stocks.add(new Stock(new Producto(id, nombre, marca, valor, des), sucursal, cantidad));
                }
            }
        }
        return stocks;
    }

    public List<Stock> findStockBySucursalAndExistencia(String sucursal, int parseInt) throws SQLException {
        String query = "SELECT producto.*,COALESCE(stock.cantidad, 0) AS cantidad FROM mercancia.producto LEFT JOIN mercancia.stock ON producto.id = stock.producto AND stock.sucursal = ? WHERE cantidad = ? ";
        List<Stock> stocks = new ArrayList<>();
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            statement.setInt(2, parseInt);
            try ( ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    double valor = rs.getDouble("valor");
                    String marca = rs.getString("marca");
                    String des = rs.getString("descripcion");
                    int cantidad = rs.getInt("cantidad");
                    stocks.add(new Stock(new Producto(id, nombre, marca, valor, des), sucursal, cantidad));
                }
            }
        }
        return stocks;
    }

    public List<Stock> findAllBySucursalAndNomnbreProducto(String sucursal, String name) throws SQLException {
        String query = "SELECT p.*,s.cantidad,s.sucursal from mercancia.stock as s inner join mercancia.producto as p on p.id = s.producto where s.sucursal = ? and p.nombre like ?";
        List<Stock> stocks = new ArrayList<>();
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            statement.setString(2, "%" + name + "%");
            try ( ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    String marca = rs.getString("marca");
                    double valor = rs.getDouble("valor");
                    String des = rs.getString("descripcion");
                    int cantidad = rs.getInt("cantidad");
                    stocks.add(new Stock(new Producto(id, nombre, marca, valor, des), sucursal, cantidad));
                }
            }
        }
        return stocks;
    }

    public List<Stock> findAllBySucursalAndCodigoProducto(String sucursal, String code) throws SQLException {
        String query = "SELECT p.*,s.cantidad from mercancia.stock as s inner join mercancia.producto as p on p.id = s.producto where s.sucursal = ? and p.id = ?";
        List<Stock> stocks = new ArrayList<>();
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            statement.setString(2, code);
            try ( ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    String marca = rs.getString("marca");
                    double valor = rs.getDouble("valor");
                    String des = rs.getString("descripcion");
                    int cantidad = rs.getInt("cantidad");
                    stocks.add(new Stock(new Producto(id, nombre, marca, valor, des), sucursal, cantidad));
                }
            }
        }
        return stocks;
    }

    public List<Stock> findAllBySucursal(String sucursal) throws SQLException {
        String query = "SELECT p.*,s.cantidad from mercancia.stock as s inner join mercancia.producto as p on p.id = s.producto where s.sucursal = ?";
        List<Stock> stocks = new ArrayList<>();
        try ( PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            try ( ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    String marca = rs.getString("marca");
                    double valor = rs.getDouble("valor");
                    String des = rs.getString("descripcion");
                    int cantidad = rs.getInt("cantidad");
                    stocks.add(new Stock(new Producto(id, nombre, marca, valor, des), sucursal, cantidad));
                }
            }
        }
        return stocks;
    }

    public Stock findStockBySucursalAndCodigoProducto(String sucursal, String codigoProducto) throws SQLException {
        String query = "SELECT p.*,s.cantidad from mercancia.stock as s inner join mercancia.producto as p on p.id = s.producto where s.sucursal = ? and s.producto = ?";
        Stock result = null;
        try ( PreparedStatement ps = GetConnection().prepareStatement(query)) {
            ps.setString(1, sucursal);
            ps.setString(2, codigoProducto);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String id = rs.getString("id");
                    String nombre = rs.getString("nombre");
                    String marca = rs.getString("marca");
                    double valor = rs.getDouble("valor");
                    String des = rs.getString("descripcion");
                    int cantidad = rs.getInt("cantidad");
                    result = new Stock(new Producto(id, nombre, marca, valor, des), sucursal, cantidad);
                }
            }
        }
        return result;
    }

    public boolean isStockExists(Stock stock) throws SQLException {
        String query = "SELECT p.*,s.cantidad from mercancia.stock as s inner join mercancia.producto as p on p.id = s.producto where s.sucursal = ? and s.producto = ?";
        try ( PreparedStatement ps = GetConnection().prepareStatement(query)) {
            ps.setString(1, stock.getSucursal());
            ps.setString(2, stock.getProducto().getId());
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void update(Stock stock) throws SQLException {
        try ( PreparedStatement statement = GetConnection().prepareStatement("UPDATE mercancia.stock SET cantidad = ? WHERE producto = ? AND sucursal = ?")) {
            statement.setInt(1, stock.getCantidad());
            statement.setString(2, stock.getProducto().getId());
            statement.setString(3, stock.getSucursal());
            statement.executeUpdate();
        }
    }

    public void save(Stock stock) throws SQLException {
        try ( PreparedStatement stmt = GetConnection().prepareStatement("INSERT INTO mercancia.stock (producto, sucursal, cantidad) VALUES (?, ?, ?)")) {
            stmt.setString(1, stock.getProducto().getId());
            stmt.setString(2, stock.getSucursal());
            stmt.setInt(3, stock.getCantidad());
            stmt.executeUpdate();
        }
    }
}
