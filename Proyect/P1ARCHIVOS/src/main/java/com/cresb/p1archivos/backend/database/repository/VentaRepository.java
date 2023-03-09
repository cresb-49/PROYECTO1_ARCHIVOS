package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Cliente;
import com.cresb.p1archivos.backend.models.Descripcion;
import com.cresb.p1archivos.backend.models.Empleado;
import com.cresb.p1archivos.backend.models.Producto;
import com.cresb.p1archivos.backend.models.Venta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaRepository extends RepositoryBase{
    
    private ClienteRepository clienteRepository;
    private EmpleadoRepository empleadoRepository;
    private DescripcionRepository descripcionRepository;
    
    public VentaRepository() {
        this.clienteRepository = new ClienteRepository();
        this.empleadoRepository = new EmpleadoRepository();
    }

    public void agregarVenta(Venta venta) throws SQLException {
        String sql = "INSERT INTO comercio.venta(id, fecha, cliente, empleado, descuento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = GetConnection().prepareStatement(sql)) {
            statement.setString(1, venta.getId());
            statement.setDate(2, new java.sql.Date(venta.getFecha().getTime()));
            statement.setString(3, venta.getCliente().getNit());
            statement.setString(4, venta.getEmpleado().getNickname());
            statement.setDouble(5, venta.getDescuento());
            statement.executeUpdate();
        }
        this.descripcionRepository.save(venta.getDescripcion());
    }

    public List<Venta> obtenerVentas() throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM comercio.venta";

        try (Statement statement = GetConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                Date fecha = resultSet.getDate("fecha");
                String clienteNit = resultSet.getString("cliente");
                String empleadoNickname = resultSet.getString("empleado");
                double descuento = resultSet.getDouble("descuento");

                Cliente cliente = clienteRepository.findById(clienteNit);
                Empleado empleado = empleadoRepository.findById(empleadoNickname);
                List<Descripcion> descripcion = this.descripcionRepository.findByVentaId(id) ;
                Venta venta = new Venta(id, fecha, cliente, empleado, descuento,descripcion);
                ventas.add(venta);
            }
        }
        return ventas;
    }
}