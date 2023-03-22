package com.cresb.p1archivos.backend.jDynamicTable.managments;

import com.cresb.p1archivos.backend.jDynamicTable.columns.ButtonColumnTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.ColumnTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.ImageColumnTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.NumberColumnTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.TextColumnTable;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author cresb-49
 */
public class CellManagment extends DefaultTableCellRenderer {

    private ColumnTable type = new ColumnTable();

    //etiqueta que almacenará el icono a mostrar
    private JLabel label = new JLabel();

    private Color tableBackgroundColor;
    private Color selectedRowbackgroundColor;
    private Color selectedCellBackgroundColor;

    /**
     * 
     * @param tableBackgroundColor
     * @param selectedRowbackgroundColor
     * @param selectedCellBackgroundColor
     * @param type
     */
    public CellManagment(Color tableBackgroundColor, Color selectedRowbackgroundColor, Color selectedCellBackgroundColor, ColumnTable type) {
        this.type = type;
        this.tableBackgroundColor = tableBackgroundColor;
        this.selectedRowbackgroundColor = selectedRowbackgroundColor;
        this.selectedCellBackgroundColor = selectedCellBackgroundColor;
    }

    /**
     * Constructor with type of data
     *
     * @param type
     */
    public CellManagment(ColumnTable type) {
        this.type = type;
        this.tableBackgroundColor = Color.white;
        this.selectedRowbackgroundColor = new Color(192, 192, 192);
        this.selectedCellBackgroundColor = new Color(140, 140, 140);
    }

    /**
     * Get the value of backgroundColor
     *
     * @return the value of backgroundColor
     */
    public Color getSelectedRowbackgroundColor() {
        return selectedRowbackgroundColor;
    }

    /**
     * Set the value of backgroundColor
     *
     * @param backgroundColor new value of backgroundColor
     */
    public void setSelectedRowbackgroundColor(Color backgroundColor) {
        this.selectedRowbackgroundColor = backgroundColor;
    }

    /**
     * Get the value of selectedBackgroundColor
     *
     * @return the value of selectedBackgroundColor
     */
    public Color getSelectedCellBackgroundColor() {
        return selectedCellBackgroundColor;
    }

    /**
     * Set the value of selectedBackgroundColor
     *
     * @param selectedBackgroundColor new value of selectedBackgroundColor
     */
    public void setSelectedCellBackgroundColor(Color selectedBackgroundColor) {
        this.selectedCellBackgroundColor = selectedBackgroundColor;
    }

    /**
     *
     * @return
     */
    public Color getTableBackgroundColor() {
        return tableBackgroundColor;
    }

    /**
     *
     * @param tableBackgroundColor
     */
    public void setTableBackgroundColor(Color tableBackgroundColor) {
        this.tableBackgroundColor = tableBackgroundColor;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        Color background = null;
        //Si la celda del evento es la seleccionada se asigna el fondo por defecto para la selección
        if (selected) {
            this.setBackground(this.selectedRowbackgroundColor);
        } else {
            //Para las que no están seleccionadas se pinta el fondo de las celdas de blanco
            this.setBackground(this.tableBackgroundColor);
        }

        if (this.type instanceof TextColumnTable) {
            if (focused) {
                background = this.selectedCellBackgroundColor;
            } else {
                background = this.selectedRowbackgroundColor;
            }
            this.setHorizontalAlignment(this.type.getHorizontalAligment());
            this.setText(String.valueOf(value));
            this.setBackground((selected) ? background : this.tableBackgroundColor);
            this.setFont(((TextColumnTable) this.type).getFont());
            //this.setFont(bold);
            return this;
        } else if (this.type instanceof NumberColumnTable) {
            if (focused) {
                background = this.selectedCellBackgroundColor;
            } else {
                background = this.selectedRowbackgroundColor;
            }
            this.setHorizontalAlignment(this.type.getHorizontalAligment());
            this.setText(String.valueOf(value));
            this.setForeground((selected) ? new Color(255, 255, 255) : new Color(32, 117, 32));
            this.setBackground((selected) ? background : this.tableBackgroundColor);
            this.setFont(((NumberColumnTable) this.type).getFont());
            return this;
        } else if (this.type instanceof ButtonColumnTable) {
            return ((ButtonColumnTable)this.type).getButton();
        } else if (this.type instanceof ImageColumnTable) {
            label.setIcon((ImageIcon) value);
            label.setHorizontalAlignment(this.type.getHorizontalAligment());
            label.setVerticalAlignment(JLabel.CENTER);
            return label;
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}
