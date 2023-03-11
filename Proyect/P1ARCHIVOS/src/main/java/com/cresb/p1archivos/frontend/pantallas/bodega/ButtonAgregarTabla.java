package com.cresb.p1archivos.frontend.pantallas.bodega;

import com.cresb.p1archivos.backend.jDynamicTable.columns.ButtonColumnTable;
import com.cresb.p1archivos.backend.models.Bodega;

import java.awt.Component;

/**
 *
 * @author Dango
 */
class ButtonAgregarTabla extends ButtonColumnTable{

    public ButtonAgregarTabla(String text, String nameColumn, int width) {
        super(text, nameColumn, width);
    }

    @Override
    public void clickAction(Object orign, Object selected, Component parent) {
        if(parent instanceof FrameBodega){
            var bodega = (Bodega)orign;
            ((FrameBodega) parent).initFormAgregar(bodega);
        }
    }
    
}
