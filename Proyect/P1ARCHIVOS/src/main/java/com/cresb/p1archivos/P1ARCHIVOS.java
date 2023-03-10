package com.cresb.p1archivos;

import com.cresb.p1archivos.backend.database.repository.SucursalRepository;
import com.cresb.p1archivos.backend.models.Empleado;
import com.cresb.p1archivos.backend.models.Rol;
import com.cresb.p1archivos.frontend.LoginFrame;
import com.cresb.p1archivos.frontend.pantallas.FrameAdmin;
import com.cresb.p1archivos.frontend.pantallas.bodega.FrameBodega;
import com.cresb.p1archivos.frontend.pantallas.inventario.FrameInventario;
import com.cresb.p1archivos.frontend.pantallas.ventas.FrameVentas;

import javax.swing.*;
import java.sql.SQLException;

/**
 *
 * @author Dango
 */
public class P1ARCHIVOS {

    public static void main(String[] args) {
        
        /*for (int i = 1; i <= 17; i++) {
            String val = "password"+i;
            System.out.println(val+" -> "+Encriptar.encriptar(val));
        }*/
        SucursalRepository sucursalRepository = new SucursalRepository();
        LoginFrame loginFrame = new LoginFrame(null, true);
        loginFrame.setVisible(true);
        //Recuperacion y limpieza del empleado recuperado
        Empleado empleado = loginFrame.getEmpleado();
        loginFrame.clearOption();
        //Inicio segun el tipo de rol
        switch (empleado.getRol().getId()) {
            case Rol.VENDEDOR:
                //Recuperar la sucursal a la cual eesta enlazado el empleado
                try {
                    var sucursal = sucursalRepository.findByIdEmpleado(empleado.getNickname());

                    if(sucursal == null)
                        throw new NullPointerException();

                    FrameVentas frameVentas = new FrameVentas(empleado,sucursal);
                    frameVentas.setVisible(true);
                    frameVentas = null;
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,"Error con la base de datos", "Error",JOptionPane.ERROR_MESSAGE);
                }catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(null,"El empleado no esta enlazado con una sucursal", "Error",JOptionPane.ERROR_MESSAGE);
                }
                break;
            case Rol.INVENTARIO:
                //Recuperar la sucursal a la cual eesta enlazado el empleado
                try {
                    var sucursal = sucursalRepository.findByIdEmpleado(empleado.getNickname());

                    if(sucursal == null)
                        throw new NullPointerException();

                    FrameInventario frameInventario = new FrameInventario(empleado,sucursal);
                    frameInventario.setVisible(true);
                    frameInventario = null;
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,"Error con la base de datos", "Error",JOptionPane.ERROR_MESSAGE);
                }catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(null,"El empleado no esta enlazado con una sucursal", "Error",JOptionPane.ERROR_MESSAGE);
                }
                break;
            case Rol.BODEGA:
                FrameBodega frameBodega = new FrameBodega(empleado);
                frameBodega.setVisible(true);
                frameBodega= null;
                break;
            case Rol.ADMIN:
                FrameAdmin frameAdmin = new FrameAdmin(empleado);
                frameAdmin.setVisible(true);
                frameAdmin = null;
                break;
            default:
                System.out.println("Salida del programa :)");
        }
    }
}
