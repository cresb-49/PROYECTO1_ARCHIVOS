package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.DisponiblidadSolicitud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dango
 */
public class DisponiblidadSolicitudRepository extends RepositoryBase {
    
    public List<DisponiblidadSolicitud> disponibilidad(String producto,String sucursal) throws SQLException {
        List<DisponiblidadSolicitud> dis = new ArrayList<>();
        String sql1 = "SELECT s.*,su.nombre FROM mercancia.stock as s inner join infraestructura.sucursal as su on su.id = s.sucursal where s.producto = ? and s.sucursal != ?";
        try (PreparedStatement statement = GetConnection().prepareStatement(sql1); ) {
            statement.setString(1, producto);
            statement.setString(2,sucursal);
            try(ResultSet rs = statement.executeQuery()){
                while (rs.next()) {        
                    dis.add(new DisponiblidadSolicitud(true, rs.getString("nombre"), rs.getString("sucursal"),rs.getInt("cantidad")));
                }
            }
        }
        String sql2 = "select * from mercancia.bodega where producto = ?";
        try (PreparedStatement statement = GetConnection().prepareStatement(sql2);) {
            statement.setString(1, producto);
            try(ResultSet rs = statement.executeQuery()){
                if (rs.next()) {        
                    dis.add(new DisponiblidadSolicitud(false, "Bodega","Bodega",rs.getInt("cantidad")));
                }
            }
        }
        return dis;
    }
    
    
}
