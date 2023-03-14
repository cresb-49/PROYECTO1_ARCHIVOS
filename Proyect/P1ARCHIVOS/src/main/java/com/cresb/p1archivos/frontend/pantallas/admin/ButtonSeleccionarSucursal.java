package com.cresb.p1archivos.frontend.pantallas.admin;

import com.cresb.p1archivos.backend.jDynamicTable.columns.ButtonColumnTable;
import com.cresb.p1archivos.backend.models.Sucursal;
import java.awt.Component;

/**
 *
 * @author benjamin
 */
class ButtonSeleccionarSucursal extends ButtonColumnTable{

    public ButtonSeleccionarSucursal(String text, String nameColumn, int width) {
        super(text, nameColumn, width);
    }
    @Override
    public void clickAction(Object orign, Object selected, Component parent) {
        if(parent instanceof SeleccionSucursal){
            ((SeleccionSucursal) parent).setSucursal((Sucursal) orign);
        }
    }
}
