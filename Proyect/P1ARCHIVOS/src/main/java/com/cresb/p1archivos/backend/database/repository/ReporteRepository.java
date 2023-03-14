package com.cresb.p1archivos.backend.database.repository;

import com.cresb.p1archivos.backend.models.reportes.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dango
 */
public class ReporteRepository extends RepositoryBase{
        
    public List<Reporte1> getReporte1() throws SQLException{
        String query = "select p.*,SUM(d.cantidad) as cantidad from comercio.descripcion as d inner join mercancia.producto as p on p.id= d.producto group by p.id order by cantidad desc limit 10";
        List<Reporte1> reporte1 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(query);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                var r = new Reporte1(rs.getString("id"), rs.getString("nombre"), rs.getString("marca"), rs.getDouble("valor"), rs.getInt("cantidad"));
                reporte1.add(r);
            }    
        }
        return reporte1;
    }
    
    public List<Reporte2>getReporte2() throws SQLException{
        String sql = "select c.nit,c.nombre,sum(valor) as gastado from comercio.venta as v inner join consumidor.cliente as c on c.nit = v.cliente GROUP BY c.nit  ORDER BY gastado desc limit 10";
        List<Reporte2> reporte2 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                var r = new Reporte2(rs.getString("nit"), rs.getString("nombre"), rs.getDouble("gastado"));
                reporte2.add(r);
            }    
        }
        return reporte2;
    }
    
    public List<Reporte3>getReporte3() throws SQLException{
        String sql = "select s.id,s.nombre,count(pla.sucursal) as cantidad from comercio.venta as v inner join colaborador.planilla as pla on pla.empleado = v.empleado inner join infraestructura.sucursal as s on s.id = pla.sucursal GROUP BY s.id order by cantidad desc";
        List<Reporte3> reporte3 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                var r = new Reporte3(rs.getString("id"), rs.getString("nombre"), rs.getInt("cantidad"));
                reporte3.add(r);
            }    
        }
        return reporte3;
    }
    
    public List<Reporte4>getReporte4() throws SQLException{
        String sql = "select s.id,s.nombre,sum(v.valor) as vendido from colaborador.planilla as p inner join comercio.venta as v on v.empleado = p.empleado inner join infraestructura.sucursal as s on p.sucursal = s.id group by s.id order by vendido desc";
        List<Reporte4> reporte4 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                //var r = new Reporte4(rs.getString("id"), rs.getString("nombre"), rs.getInt("cantidad"));
                //reporte4.add(r);
            }    
        }
        return reporte4;
    }

    public List<Reporte5>getReporte5() throws SQLException{
        String sql = "";
        List<Reporte5> reporte5 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                var r = new Reporte5(rs.getString("nickname"),rs.getString("nombre"),rs.getInt("cantidad"));
                reporte5.add(r);
            }
        }
        return reporte5;
    }

    public List<Reporte6>getReporte6() throws SQLException{
        String sql = "";
        List<Reporte6> reporte6 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                //var r = new Reporte6(rs.getString("nickname"),rs.getString("nombre"),rs.getInt("cantidad"));
                //reporte6.add(r);
            }
        }
        return reporte6;
    }
}
