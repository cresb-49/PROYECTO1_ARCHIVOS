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

    /**
     *
     * @param venta
     * @throws SQLException
     */
    public void agregarVenta(Venta venta) throws SQLException {
        String sql = "INSERT INTO comercio.venta(id, fecha, cliente, empleado, descuento,valor) VALUES (?,to_timestamp(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?, ?)";
        try (PreparedStatement statement = GetConnection().prepareStatement(sql)) {
            statement.setString(1, venta.getId());
            statement.setString(2, venta.getFecha());
            statement.setString(3, venta.getCliente().getNit());
            statement.setString(4, venta.getEmpleado().getNickname());
            statement.setDouble(5, venta.getDescuento());
            statement.setDouble(6, venta.getValor());
            statement.executeUpdate();
        }
    }
    
    /**
     *
     * @param nit
     * @return
     * @throws SQLException
     */
    public double obtenerCostoUltimaCompra(String nit) throws SQLException{
        String sql = "select * from comercio.venta as v where v.cliente = ? order by v.fecha desc limit 1;";
        double result = 0;
        try (PreparedStatement ps = GetConnection().prepareStatement(sql);){
           ps.setString(1, nit);
            try(ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    result = resultSet.getDouble("valor");
                }
            }
        }
        return result;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
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
                double valor = resultSet.getDouble("valor");

                Cliente cliente = null;
                Empleado empleado = null;
                List<Descripcion> descripcion = this.descripcionRepository.findByVentaId(id) ;
                Venta venta = new Venta(id, fecha, cliente, empleado, descuento,descripcion,valor);
                ventas.add(venta);
            }
        }
        return ventas;
    }
}