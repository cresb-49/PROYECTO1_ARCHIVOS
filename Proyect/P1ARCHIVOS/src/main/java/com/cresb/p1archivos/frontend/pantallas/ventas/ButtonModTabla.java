package com.cresb.p1archivos.frontend.pantallas.ventas;


import com.cresb.p1archivos.backend.jDynamicTable.columns.ButtonColumnTable;
import java.awt.Component;
import javax.swing.ImageIcon;

/**
 *
 * @author benjamin
 */
public class ButtonModTabla extends ButtonColumnTable {
    
    public ButtonModTabla(String text, String nameColumn, int width) {
        super(text, nameColumn, width);
    }

    @Override
    public void clickAction(Object orign, Object selected, Component parent) {
        
    }
}
