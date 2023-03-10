package com.cresb.p1archivos.frontend.pantallas.ventas;


import com.cresb.p1archivos.backend.jDynamicTable.columns.ButtonColumnTable;
import java.awt.Component;

/**
 *
 * @author benjamin
 */
public class ButtonDelTabla extends ButtonColumnTable {
    
    public ButtonDelTabla(String text, String nameColumn, int width) {
        super(text, nameColumn, width);
    }

    @Override
    public void clickAction(Object orign, Object selected, Component parent) {
        
    }
}
