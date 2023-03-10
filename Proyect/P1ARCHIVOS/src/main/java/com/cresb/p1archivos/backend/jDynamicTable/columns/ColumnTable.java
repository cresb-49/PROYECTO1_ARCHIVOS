package com.cresb.p1archivos.backend.jDynamicTable.columns;

import java.util.Objects;
import javax.swing.JLabel;

/**
 * Generic column in JDynamicTable for JTable
 * 
 * @author cresb-49
 */
public class ColumnTable {

    private String name;
    private boolean editable = true;
    private int width;
    private int horizontalAligment = JLabel.CENTER;
    private int cellNumber;
    // Access objects
    private String alias;

    /**
     * Main constructor to describe a column in the table
     *
     * @param name       Name of the column in the table
     * @param alias      Name of alias in data types -> example "alias" or "alias.alias"
     * @param editable   Is Editable column, default TRUE
     * @param width      Graphical width in table
     * @param cellNumber
     */
    public ColumnTable(String name, String alias, boolean editable, int width, int cellNumber) {
        this.name = name;
        this.alias = alias;
        this.editable = editable;
        this.width = width;
        this.cellNumber = cellNumber;
    }

    /**
     * 
     * @param name
     * @param alias
     * @param editable
     * @param width
     */
    public ColumnTable(String name, String alias, boolean editable, int width) {
        this.name = name;
        this.alias = alias;
        this.editable = editable;
        this.width = width;
    }

    /**
     *
     * @param name
     * @param editable
     * @param width
     * @param cellNumber
     */
    public ColumnTable(String name, boolean editable, int width, int cellNumber) {
        this.name = name;
        this.editable = editable;
        this.width = width;
        this.cellNumber = cellNumber;
    }

    /**
     *
     * @param name
     * @param editable
     * @param width
     */
    public ColumnTable(String name, boolean editable, int width) {
        this.name = name;
        this.editable = editable;
        this.width = width;
    }

    public ColumnTable() {
    }

    /**
     * Get a name of the column
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set a name of the column
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return true or false if the column is editable
     *
     * @return
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * Set true if the column it will be editable
     *
     * @param editable
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * Get a width of the column
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set a width of the column
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     */
    public int getCellNumber() {
        return cellNumber;
    }

    /**
     *
     * @param cellNumber
     */
    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    /**
     *
     * @return
     */
    public String getAlias() {
        return alias;
    }

    /**
     *
     * @param alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 
     * @return
     */
    public int getHorizontalAligment() {
        return horizontalAligment;
    }

    /**
     * 
     * @param horizontalAligment
     */
    public void setHorizontalAligment(int horizontalAligment) {
        this.horizontalAligment = horizontalAligment;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ColumnTable other = (ColumnTable) obj;
        return Objects.equals(this.name, other.name);
    }
}
