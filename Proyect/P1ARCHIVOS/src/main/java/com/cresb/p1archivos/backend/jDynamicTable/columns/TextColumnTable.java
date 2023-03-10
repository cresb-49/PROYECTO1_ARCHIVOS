package com.cresb.p1archivos.backend.jDynamicTable.columns;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author cresb-49
 */
public class TextColumnTable extends ColumnTable {

    private Color foreground = Color.BLACK;
    private Font font = new Font("Verdana", Font.PLAIN, 12);

    /**
     *
     * @param name
     * @param alias
     * @param editable
     * @param width
     */
    public TextColumnTable(String name, String alias, boolean editable, int width) {
        super(name, alias, editable, width);
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
