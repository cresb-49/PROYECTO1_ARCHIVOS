package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Cliente;
import com.cresb.p1archivos.backend.models.Descripcion;
import com.cresb.p1archivos.backend.models.Empleado;
import com.cresb.p1archivos.backend.models.Venta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaRepository extends RepositoryBase{
    
    
    private DescripcionRepository descripcionRepository;
    
    public VentaRepository() {
        
    }

    public void agregarVenta(Venta venta) throws SQLException {
        String sql = "INSERT INTO comercio.venta(id, fecha, cliente, empleado, descuento) VALUES (?,to_timestamp(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?)";
        try (PreparedStatement statement = GetConnection().prepareStatement(sql)) {
            statement.setString(1, venta.getId());
            statement.setString(2, venta.getFecha());
            statement.setString(3, venta.getCliente().getNit());
            statement.setString(4, venta.getEmpleado().getNickname());
            statement.setDouble(5, venta.getDescuento());
            statement.executeUpdate();
        }
    }
    
    public double obtenerCostoUltimaCompra(String nit) throws SQLException{
        String sql = "select SUM(p.valor * d.cantidad *(1 - v.descuento)) as costo,v.id,v.fecha from comercio.descripcion as d inner join comercio.venta as v on d.venta = v.id inner join consumidor.cliente as c on c.nit = v.cliente inner join mercancia.producto as p on d.producto = p.id where c.nit = ? group by v.id order by v.fecha desc limit 1;";
        double result = 0;
        try (PreparedStatement ps = GetConnection().prepareStatement(sql);){
           ps.setString(1, nit);
            try(ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    result = resultSet.getDouble("costo");
                }
            }
        }
        return result;
    }

    public List<Venta> obtenerVentas() throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM comercio.venta";

        try (Statement statement = GetConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String fecha = resultSet.getString("fecha");
                String clienteNit = resultSet.getString("cliente");
                String empleadoNickname = resultSet.getString("empleado");
                double descuento = resultSet.getDouble("descuento");

                Cliente cliente = null;
                Empleado empleado = null;
                List<Descripcion> descripcion = this.descripcionRepository.findByVentaId(id) ;
                Venta venta = new Venta(id, fecha, cliente, empleado, descuento,descripcion);
                ventas.add(venta);
            }
        }
        return ventas;
    }
}