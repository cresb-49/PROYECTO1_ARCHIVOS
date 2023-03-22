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
    
    /**
     * Top 10 productos más vendidos
     * @return
     * @throws SQLException 
     */
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
    
    /**
     * Top 10 de clientes que más ganancias generan
     * @return
     * @throws SQLException 
     */
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
    
    /**
     * Top 3 sucursales con más ventas
     * @return
     * @throws SQLException 
     */
    public List<Reporte3>getReporte3() throws SQLException{
        String sql = "select s.id,s.nombre,count(v.sucursal) as cantidad from comercio.venta as v inner join infraestructura.sucursal as s on s.id = v.sucursal GROUP BY s.id ORDER by cantidad desc";
        List<Reporte3> reporte3 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                var r = new Reporte3(rs.getString("id"), rs.getString("nombre"), rs.getInt("cantidad"));
                reporte3.add(r);
            }    
        }
        return reporte3;
    }
    
    /**
     * Top 3 sucursales con más ingresos
     * @return
     * @throws SQLException 
     */
    public List<Reporte4>getReporte4() throws SQLException{
        String sql = "select s.id,s.nombre,sum(v.valor) as vendido from comercio.venta as v inner join infraestructura.sucursal as s on s.id = v.sucursal group by s.id order by vendido desc";
        List<Reporte4> reporte4 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                var r = new Reporte4(rs.getString("id"), rs.getString("nombre"), rs.getInt("vendido"));
                reporte4.add(r);
            }    
        }
        return reporte4;
    }
    
    /**
     * Top 3 empleados con más ventas
     * @return
     * @throws SQLException 
     */
    public List<Reporte5>getReporte5() throws SQLException{
        String sql = "select e.nickname,e.nombre,count(v.empleado) as cantidad from comercio.venta as v inner join colaborador.empleado as e on e.nickname = v.empleado group by e.nickname order by cantidad desc limit 3";
        List<Reporte5> reporte5 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                var r = new Reporte5(rs.getString("nickname"),rs.getString("nombre"),rs.getInt("cantidad"));
                reporte5.add(r);
            }
        }
        return reporte5;
    }
    
    /**
     * Top 3 empleados con más ingresos
     * @return
     * @throws SQLException 
     */
    public List<Reporte6>getReporte6() throws SQLException{
        String sql = "select e.nickname,e.nombre,sum(valor) as venta from comercio.venta as v inner join colaborador.empleado as e on e.nickname = v.empleado GROUP BY e.nickname order by venta desc limit 3";
        List<Reporte6> reporte6 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                var r = new Reporte6(rs.getString("nickname"), rs.getString("nombre"), rs.getDouble("venta"));
                reporte6.add(r);
            }
        }
        return reporte6;
    }
    
    /**
     * Top 10 productos con más ingresos
     * @return
     * @throws SQLException 
     */
    public List<Reporte7>getReporte7() throws SQLException{
        String sql = "select p.id,p.nombre,p.marca,sum(d.cantidad*p.valor*(1-v.descuento)) as valor from comercio.venta as v inner join comercio.descripcion as d on d.venta = v.id inner join mercancia.producto as p on p.id = d.producto group by p.id order by valor desc limit 10;";
        List<Reporte7> reporte7 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);ResultSet rs = statement.executeQuery();) {
            while (rs.next()) {
                var r = new Reporte7(rs.getString("id"),rs.getString("nombre"),rs.getString("marca"),rs.getDouble("valor"));
                reporte7.add(r);
            }
        }
        return reporte7;
    }
    
    /**
     * Top 5 productos más vendidos por sucursal
     * @return
     * @throws SQLException 
     */
    public List<Reporte8>getReporte8(String sucursal) throws SQLException{
        String sql = "select p.id,p.nombre,p.marca,sum(d.cantidad) as cantidad from comercio.venta as v inner join comercio.descripcion as d on v.id = d.venta inner join mercancia.producto as p on p.id = d.producto where v.sucursal = ? group by p.id order by cantidad desc limit 5";
        List<Reporte8> reporte8 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);) {
            statement.setString(1, sucursal);
            try(ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    var r = new Reporte8(rs.getString("id"),rs.getString("nombre"),rs.getString("marca"),rs.getInt("cantidad"));
                    reporte8.add(r);
                }
            }
        }
        return reporte8;
    }
    
    /**
     * Top 5 productos con más ingresos por sucursal
     * @return
     * @throws SQLException 
     */
    public List<Reporte9>getReporte9(String sucursal) throws SQLException{
        String sql = "select p.id,p.nombre,p.marca,sum(d.cantidad*p.valor*(1-v.descuento)) as valor from comercio.venta as v inner join comercio.descripcion as d on v.id = d.venta inner join mercancia.producto as p on p.id = d.producto where v.sucursal = ? group by p.id order by valor desc limit 5";
        List<Reporte9> reporte9 = new ArrayList<>();
        try (PreparedStatement statement = GetConnection().prepareStatement(sql);) {
            statement.setString(1, sucursal);
            try(ResultSet rs = statement.executeQuery();) {
                while (rs.next()) {
                    var r = new Reporte9(rs.getString("id"),rs.getString("nombre"),rs.getString("marca"),rs.getInt("valor"));
                    reporte9.add(r);
                }
            }
        }
        return reporte9;
    }
}
