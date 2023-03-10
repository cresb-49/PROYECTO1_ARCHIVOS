package com.cresb.p1archivos.backend.database.repository;

import static com.cresb.p1archivos.backend.database.repository.RepositoryBase.GetConnection;
import com.cresb.p1archivos.backend.models.Cliente;
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
    
    public StockRepository(){
        
    }
    
    public List<Stock> findAllBySucursal(String sucursal) throws SQLException {
        String query = "SELECT p.*,s.cantidad from mercancia.stock as s inner join mercancia.producto as p on p.id = s.producto where s.sucursal = ?";
        List<Stock> stocks = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String des = rs.getString("descripcion");
                int cantidad = rs.getInt("cantidad");
                stocks.add(new Stock(new Producto(id, nombre, marca, valor, des),sucursal,cantidad));
            }
            return stocks;
        }
    }
    
    public List<Stock> findAllBySucursalAndNomnbreProducto(String sucursal,String name) throws SQLException {
        String query = "SELECT p.*,s.cantidad,s.sucursal from mercancia.stock as s inner join mercancia.producto as p on p.id = s.producto where s.sucursal = ? and p.nombre like ?";
        List<Stock> stocks = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            statement.setString(2, "%"+name+"%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String des = rs.getString("descripcion");
                int cantidad = rs.getInt("cantidad");
                stocks.add(new Stock(new Producto(id, nombre, marca, valor, des),sucursal,cantidad));
            }
            return stocks;
        }
    }
    
    public List<Stock> findAllBySucursalAndcodigoProducto(String sucursal,String code) throws SQLException {
        String query = "SELECT p.*,s.cantidad from mercancia.stock as s inner join mercancia.producto as p on p.id = s.producto where s.sucursal = ? and p.id = ?";
        List<Stock> stocks = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, sucursal);
            statement.setString(2, code);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String des = rs.getString("descripcion");
                int cantidad = rs.getInt("cantidad");
                stocks.add(new Stock(new Producto(id, nombre, marca, valor, des),sucursal,cantidad));
            }
            return stocks;
        }
    }
}
