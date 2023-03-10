package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.Empleado;
import com.cresb.p1archivos.backend.models.Sucursal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dango
 */
public class PlanillaRepository extends RepositoryBase {
    
    public PlanillaRepository(){
        
    }
    
    /*
    public void buscarPorEmpleado(String empleado) throws SQLException {
        
        Planilla planilla = null;
        String query = "SELECT sucursal FROM colaborador.planilla WHERE empleado = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, empleado);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String sucursal = result.getString("sucursal");
                planilla = new Planilla(empleado, sucursal);
            }
        } 
        
        return planilla;
    }*/
    
    public void insertarPlanilla(Empleado empleado, Sucursal sucursal) throws SQLException {
        String query = "INSERT INTO colaborador.planilla (empleado, sucursal) VALUES (?, ?)";
        try (PreparedStatement statement = GetConnection().prepareStatement(query)) {
            statement.setString(1, empleado.getNickname());
            statement.setString(2, sucursal.getId());
            statement.executeUpdate();
        }
    }
}
