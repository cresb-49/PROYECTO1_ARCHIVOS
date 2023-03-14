package com.cresb.p1archivos.frontend.pantallas.admin;

import com.cresb.p1archivos.backend.DateManagment;
import com.cresb.p1archivos.backend.models.Empleado;
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

    public JasperPrint genReporte1(List<Reporte1> reporte1,Empleado empleado) throws JRException {
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/Reporte10prodcutos.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte1.toArray());
        parametros.put("dt",dataSource);
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
    
    public JasperPrint genReporte2(List<Reporte2> reporte2,Empleado empleado) throws JRException {
        InputStream inputStream = JRLoader.getInputStream(getClass().getResource("/reports/Reporte10clientes.jasper"));
        HashMap<String,Object> parametros = new HashMap<>();
        JRBeanArrayDataSource dataSource = new JRBeanArrayDataSource(reporte2.toArray());
        parametros.put("dt",dataSource);
        parametros.put("fecha",dateManagment.currentDateTime());
        parametros.put("generador", empleado.getNickname());
        return JasperFillManager.fillReport(inputStream, parametros, new JREmptyDataSource());
    }
}
