package com.cresb.p1archivos.frontend.pantallas.admin;

import com.cresb.p1archivos.backend.DateManagment;
import com.cresb.p1archivos.backend.models.Empleado;
import com.cresb.p1archivos.backend.models.Sucursal;
import com.cresb.p1archivos.backend.models.reportes.*;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Dango
 */
public class Reportes {
    
    private final DecimalFormat formato = new DecimalFormat("#.00");
    private final DateManagment dateManagment = new DateManagment();
    
    public Reportes() {

    }
    
    /**
     * Top 10 productos más vendidos
     * @param reporte1
     * @param empleado
     * @return
     * @throws JRException 
     */
    public JasperPrint genReporte1(List<Reporte1> reporte1,Empleado empleado) throws JRException {
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/Reporte10prodcutos.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte1.toArray());
        parametros.put("dt",dataSource);
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
    
    /**
     * Top 10 de clientes que más ganancias generan
     * @param reporte2
     * @param empleado
     * @return
     * @throws JRException 
     */
    public JasperPrint genReporte2(List<Reporte2> reporte2,Empleado empleado) throws JRException {
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/Reporte10clientes.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte2.toArray());
        parametros.put("dt",dataSource);
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
    
    /**
     * Top 3 sucursales con más ventas
     * @param reporte3
     * @param empleado
     * @return
     * @throws JRException 
     */
    public JasperPrint genReporte3(List<Reporte3> reporte3,Empleado empleado) throws JRException {
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/ReporteTop3SucursalesVentasjrxml.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte3.toArray());
        parametros.put("dt",dataSource);
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
    
    /**
     * Top 3 sucursales con más ingresos
     * @param reporte4
     * @param empleado
     * @return
     * @throws JRException 
     */
    public JasperPrint genReporte4(List<Reporte4> reporte4,Empleado empleado) throws JRException {
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/Top3SucursalesMasIngresos.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte4.toArray());
        parametros.put("dt",dataSource);
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
    
    /**
     * Top 3 empleados con más ventas
     * @param reporte5
     * @param empleado
     * @return
     * @throws JRException 
     */
    public JasperPrint genReporte5(List<Reporte5> reporte5,Empleado empleado) throws JRException {
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/Top3EmpleadosMasVentas.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte5.toArray());
        parametros.put("dt",dataSource);
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
    
    /**
     * Top 3 empleados con más ingresos
     * @return 
     */
    public JasperPrint genReporte6(List<Reporte6> reporte6,Empleado empleado) throws JRException{
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/Top3EmpleadosMasIngresos.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte6.toArray());
        parametros.put("dt",dataSource);
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
    
    /**
     * Top 10 productos con más ingresos
     * @return 
     */
    public JasperPrint genReporte7(List<Reporte7> reporte7,Empleado empleado) throws JRException{
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/Top10productosMasIngresos.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte7.toArray());
        parametros.put("dt",dataSource);
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
    
    /**
     * Top 5 productos más vendidos por sucursal
     * @param reporte8
     * @param empleado
     * @param sucursal
     * @return
     * @throws JRException 
     */
    public JasperPrint genReporte8(List<Reporte8> reporte8,Empleado empleado,Sucursal sucursal) throws JRException {
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/Top5ProductosMasVendidosSucursal.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte8.toArray());
        parametros.put("dt",dataSource);
        parametros.put("sucursal",String.format("%s,%s",sucursal.getNombre(),sucursal.getId()));
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
    
    /**
     * Top 5 productos con más ingresos por sucursal
     * @param reporte9
     * @param empleado
     * @param sucursal
     * @return
     * @throws JRException 
     */
    public JasperPrint genReporte9(List<Reporte9> reporte9,Empleado empleado,Sucursal sucursal) throws JRException {
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/Top5ProductosConMasIngresosSucursal.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte9.toArray());
        parametros.put("dt",dataSource);
        parametros.put("sucursal",String.format("%s,%s",sucursal.getNombre(),sucursal.getId()));
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
    
    
}
