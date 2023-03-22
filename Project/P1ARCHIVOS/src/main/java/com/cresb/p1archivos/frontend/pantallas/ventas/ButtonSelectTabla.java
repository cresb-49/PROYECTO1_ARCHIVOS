package com.cresb.p1archivos.frontend.pantallas.ventas;

import com.cresb.p1archivos.backend.jDynamicTable.columns.ButtonColumnTable;
import com.cresb.p1archivos.backend.models.Stock;
import java.awt.Component;

/**
 *
 * @author Dango
 */
class ButtonSelectTabla extends ButtonColumnTable{
    
     public ButtonSelectTabla(String text, String nameColumn, int width) {
        super(text, nameColumn, width);
    }

    @Override
    public void clickAction(Object orign, Object selected, Component parent) {
        if(parent instanceof SeleccionarProducto){
            ((SeleccionarProducto)parent).setSelectedStok((Stock) orign);
        }
        
    }
}
