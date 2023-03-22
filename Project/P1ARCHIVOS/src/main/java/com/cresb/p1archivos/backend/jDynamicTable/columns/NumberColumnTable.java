package com.cresb.p1archivos.backend.jDynamicTable.columns;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;

/**
 *
 * @author cresb-49
 */
public class NumberColumnTable extends ColumnTable {

    private NumberFormat numberFormat;
    private Font font = new Font("Verdana", Font.PLAIN, 12);
    
    private Color foreground = Color.GREEN;

    /**
     * 
     * @param name
     * @param alias
     * @param editable
     * @param width
     */
    public NumberColumnTable(String name, String alias, boolean editable, int width) {
        super(name, alias, editable, width);
    }

    /**
     * 
     * @param name
     * @param alias
     * @param editable
     * @param width
     * @param numberFormat
     */
    public NumberColumnTable(String name, String alias, boolean editable, int width, NumberFormat numberFormat) {
        super(name, alias, editable, width);
    }
    
    /**
     * 
     */
    public NumberColumnTable() {
    }

    /**
     * Get the value of numberFormat
     *
     * @return the value of numberFormat
     */
    public NumberFormat getNumberFormat() {
        return numberFormat;
    }

    /**
     * Set the value of numberFormat
     *
     * @param numberFormat new value of numberFormat
     */
    public void setNumberFormat(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }
    
    /**
     * Get the value of font
     *
     * @return the value of font
     */
    public Font getFont() {
        return font;
    }

    /**
     * Set the value of font
     *
     * @param font new value of font
     */
    public void setFont(Font font) {
        this.font = font;
    }
    
    /**
     * Get the value of foreground
     *
     * @return the value of foreground
     */
    public Color getForeground() {
        return foreground;
    }

    /**
     * Set the value of foreground
     *
     * @param foreground new value of foreground
     */
    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }
}
