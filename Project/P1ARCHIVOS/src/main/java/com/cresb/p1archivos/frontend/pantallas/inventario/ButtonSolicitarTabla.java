package com.cresb.p1archivos.frontend.pantallas.inventario;

import com.cresb.p1archivos.backend.jDynamicTable.columns.ButtonColumnTable;
import com.cresb.p1archivos.backend.models.Stock;
import java.awt.Component;

/**
 *
 * @author Dango
 */
public class ButtonSolicitarTabla extends ButtonColumnTable {

    public ButtonSolicitarTabla(String text, String nameColumn, int width) {
        super(text, nameColumn, width);
    }
    
    @Override
    public void clickAction(Object orign, Object selected, Component parent) {
        if(parent instanceof FrameInventario){
            ((FrameInventario) parent).initFormSolicitud((Stock)orign);
        }
    }
    
    
}
