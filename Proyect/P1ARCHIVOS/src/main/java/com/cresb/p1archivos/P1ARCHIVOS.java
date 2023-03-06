package com.cresb.p1archivos;

import com.cresb.p1archivos.backend.models.Empleado;
import com.cresb.p1archivos.backend.models.Rol;
import com.cresb.p1archivos.frontend.LoginFrame;
import com.cresb.p1archivos.frontend.pantallas.FrameAdmin;
import com.cresb.p1archivos.frontend.pantallas.FrameBodega;
import com.cresb.p1archivos.frontend.pantallas.FrameInventario;
import com.cresb.p1archivos.frontend.pantallas.FrameVentas;

/**
 *
 * @author Dango
 */
public class P1ARCHIVOS {

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame(null, true);
        loginFrame.setVisible(true);
        //Recuperacion y limpieza del empleado recuperado
        Empleado empleado = loginFrame.getEmpleado();
        loginFrame.clearOption();
        //Inicio segun el tipo de rol
        switch (empleado.getRol().getId()) {
            case Rol.VENDEDOR:
                FrameVentas frameVentas = new FrameVentas(empleado);
                frameVentas.setVisible(true);
                frameVentas = null;
                break;
            case Rol.INVENTARIO:
                FrameInventario frameInventario = new FrameInventario(empleado);
                frameInventario.setVisible(true);
                frameInventario = null;
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
                throw new AssertionError();
        }
    }
}
