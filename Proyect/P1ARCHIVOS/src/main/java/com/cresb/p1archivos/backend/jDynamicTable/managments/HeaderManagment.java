package com.cresb.p1archivos.backend.jDynamicTable.managments;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author cresb-49
 */
public class HeaderManagment implements TableCellRenderer{
    private int horinzontalAligment;
    private boolean opaque;
    private Border border;
    private Color background;
    private Color foreground;
    private String toolTipText;
    
    /**
     * 
     * @param horinzontalAligment
     * @param opaque
     * @param border
     * @param background
     * @param foreground
     * @param toolTipText 
     */
    public HeaderManagment(int horinzontalAligment, boolean opaque, Border border, Color background, Color foreground, String toolTipText) {
        this.horinzontalAligment = horinzontalAligment;
        this.opaque = opaque;
        this.border = border;
        this.background = background;
        this.foreground = foreground;
        this.toolTipText = toolTipText;
    }
    /**
     * 
     */
    public HeaderManagment() {
    }
    
    /**
     * 
     * @return 
     */
    public int getHorinzontalAligment() {
        return horinzontalAligment;
    }
    
    /**
     * 
     * @param horinzontalAligment 
     */
    public void setHorinzontalAligment(int horinzontalAligment) {
        this.horinzontalAligment = horinzontalAligment;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isOpaque() {
        return opaque;
    }
    /**
     * 
     * @param opaque 
     */
    public void setOpaque(boolean opaque) {
        this.opaque = opaque;
    }
    /**
     * 
     * @return 
     */
    public Border getBorder() {
        return border;
    }
    /**
     * 
     * @param border 
     */
    public void setBorder(Border border) {
        this.border = border;
    }
    /**
     * 
     * @return 
     */
    public Color getBackground() {
        return background;
    }
    
    /**
     * 
     * @param background 
     */
    public void setBackground(Color background) {
        this.background = background;
    }
    /**
     * 
     * @return 
     */
    public Color getForeground() {
        return foreground;
    }
    /**
     * 
     * @param foreground 
     */
    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }
    /**
     * 
     * @return 
     */
    public String getToolTipText() {
        return toolTipText;
    }
    /**
     * 
     * @param toolTipText 
     */
    public void setToolTipText(String toolTipText) {
        this.toolTipText = toolTipText;
    }
    
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int i, int i1) {
        JComponent jcomponent = null;

        if (value instanceof String) {
            jcomponent = new JLabel((String)value);
            ((JLabel) jcomponent).setHorizontalAlignment(horinzontalAligment);
            ((JLabel) jcomponent).setSize(30, jcomponent.getWidth());
            ((JLabel) jcomponent).setPreferredSize(new Dimension(6, jcomponent.getWidth()));
        }
        jcomponent.setBorder(border);
        jcomponent.setOpaque(opaque);
        jcomponent.setBackground(background);
        jcomponent.setToolTipText(toolTipText);
        jcomponent.setForeground(foreground);
        return jcomponent;
    }
    
}
