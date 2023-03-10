package com.cresb.p1archivos.backend.jDynamicTable;

import com.cresb.p1archivos.backend.jDynamicTable.columns.ButtonColumnTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.ColumnTable;
import com.cresb.p1archivos.backend.jDynamicTable.exceptions.NotRenderImageColumnException;
import com.cresb.p1archivos.backend.jDynamicTable.model.HeaderList;
import com.cresb.p1archivos.backend.jDynamicTable.columns.ImageColumnTable;
import com.cresb.p1archivos.backend.jDynamicTable.managments.CellManagment;
import com.cresb.p1archivos.backend.jDynamicTable.managments.HeaderManagment;
import com.cresb.p1archivos.backend.jDynamicTable.managments.images.ImageRescaling;
import com.cresb.p1archivos.backend.jDynamicTable.model.ImageColumn;
import com.cresb.p1archivos.backend.jDynamicTable.model.JDynamicTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;

/**
 *
 * @author cresb-49
 * @param <T>
 */
public class JDynamicTable<T> {

    //Content values
    private ArrayList<T> data = new ArrayList<>();
    private HeaderList columns = new HeaderList();

    //setter style objects
    private HeaderManagment headerManagment;
    private JDynamicTableModel model;

    
    //Header parameters
    private Color headerBackground = new Color(65, 65, 65);
    private Color headerForeground = Color.white;
    private int headerHorizontalAlignment = SwingConstants.CENTER;
    private Border border = javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255));
    private boolean opaque = true;
    private String toolTipText;
    //Table parameters
    private JTable table;
    private Component parent;
    private Color tableBackgroundColor = Color.WHITE;
    private Color selectedRowBackgroundColor = new Color(192, 192, 192);
    private Color selectedCellBackgroundColor = new Color(140, 140, 140);
    private Color gridColor = new java.awt.Color(0, 0, 0);

    //Table options
    private boolean reorderingTable = false;
    private int heightCell = 25;

    /**
     * Principal constructor gets a JTable object and parent Component
     *
     * @param table
     * @param parent
     */
    public JDynamicTable(JTable table, Component parent) {
        this.table = table;
        this.parent = parent;
        this.table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                try {
                    processMauseClick(evt);
                } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | NotRenderImageColumnException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    /**
     * Apply data in JTable
     */
    public void apply() {
        this.headerManagment = (headerManagment == null ? new HeaderManagment(headerHorizontalAlignment, opaque, border, headerBackground, headerForeground, toolTipText) : this.headerManagment);
        Object[][] localData = this.getDataMatrix();
        this.buildTable(this.columns, localData);
    }

    /**
     * Get a data matrix, based on data array
     *
     * @return Object[][]
     */
    private Object[][] getDataMatrix() {
        Object informacion[][] = new Object[this.data.size()][this.columns.size()];
        for (int x = 0; x < informacion.length; x++) {
            for (ColumnTable column : this.columns) {
                try {
                    informacion[x][column.getCellNumber()] = this.dataGetter(this.data.get(x), column);
                } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException |NotRenderImageColumnException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return informacion;
    }

    /**
     * Build table with titles and data content
     *
     * @param tittles
     * @param data
     */
    private void buildTable(HeaderList tittles, Object[][] data) {
        this.model = new JDynamicTableModel(tittles, data);

        this.table.setModel(this.model);

        //Set columns data types
        for (ColumnTable column : this.columns) {
            this.table.getColumnModel().getColumn(column.getCellNumber()).setCellRenderer(new CellManagment(tableBackgroundColor, selectedRowBackgroundColor, selectedCellBackgroundColor, column));
        }

        this.table.getTableHeader().setReorderingAllowed(this.reorderingTable);
        this.table.setRowHeight(this.heightCell);
        this.table.setGridColor(this.gridColor);

        //Set Width of column in JTable
        for (ColumnTable column : this.columns) {
            this.table.getColumnModel().getColumn(column.getCellNumber()).setPreferredWidth(column.getWidth());
        }

        //Header customization
        JTableHeader jtableHeader = this.table.getTableHeader();
        jtableHeader.setDefaultRenderer(this.headerManagment);
        this.table.setTableHeader(jtableHeader);
    }

    /**
     * Get the value of parent
     *
     * @return the value of parent
     */
    public Component getParent() {
        return parent;
    }

    /**
     * Set the value of parent
     *
     * @param parent new value of parent
     */
    public void setParent(Component parent) {
        this.parent = parent;
    }

    /**
     * Set a header background color, default value RGB (65,65,65)
     *
     * @param headerBackground
     */
    public void setHeaderBackground(Color headerBackground) {
        this.headerBackground = headerBackground;
    }

    /**
     * Set a JTable object
     *
     * @param table
     */
    public void setTable(JTable table) {
        this.table = table;
    }

    /**
     * Get a JTable object
     *
     * @return
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Set a Foreground color, default value Color.white
     *
     * @param headerForefround
     */
    public void setHeaderForefround(Color headerForefround) {
        this.headerForeground = headerForefround;
    }

    /**
     * Set a horizontal alignment in the header, "USE SwingConstants values"
     *
     * @param setHeaderHorizontalAlignment
     */
    public void setSetHeaderHorizontalAlignment(int setHeaderHorizontalAlignment) {
        this.headerHorizontalAlignment = setHeaderHorizontalAlignment;
    }

    /**
     * Get a header managment
     *
     * @return headerManagment
     */
    public HeaderManagment getHeaderManagment() {
        return headerManagment;
    }

    /**
     * Set a header managment
     *
     * @param headerManagment
     */
    public void setHeaderManagment(HeaderManagment headerManagment) {
        this.headerManagment = headerManagment;
    }

    /**
     * Get a header horizontal alignment text
     *
     * @return
     */
    public int getHeaderHorizontalAlignment() {
        return headerHorizontalAlignment;
    }

    /**
     * Set a header horizontal alignment
     *
     * @param headerHorizontalAlignment
     */
    public void setHeaderHorizontalAlignment(int headerHorizontalAlignment) {
        this.headerHorizontalAlignment = headerHorizontalAlignment;
    }

    /**
     * get a Jtable border
     *
     * @return border
     */
    public Border getBorder() {
        return border;
    }

    /**
     * Set a Jtable border
     *
     * @param border
     */
    public void setBorder(Border border) {
        this.border = border;
    }

    /**
     * Get a opaque value
     *
     * @return opaque
     */
    public boolean isOpaque() {
        return opaque;
    }

    /**
     * Set a opaque value
     *
     * @param opaque
     */
    public void setOpaque(boolean opaque) {
        this.opaque = opaque;
    }

    /**
     * Get a tool tip text
     *
     * @return
     */
    public String getToolTipText() {
        return toolTipText;
    }

    /**
     * Set a tool tip text
     *
     * @param toolTipText
     */
    public void setToolTipText(String toolTipText) {
        this.toolTipText = toolTipText;
    }

    /**
     * Is enable a reodering data in Jtable
     *
     * @return reorderingTable
     */
    public boolean isReorderingTable() {
        return reorderingTable;
    }

    /**
     * Enable a reodering data in Jtable
     *
     * @param reorderingTable
     */
    public void setReorderingTable(boolean reorderingTable) {
        this.reorderingTable = reorderingTable;
    }

    /**
     * Get a table grid color
     *
     * @return gridColor
     */
    public Color getGridColor() {
        return gridColor;
    }

    /**
     * Set a table grid color
     *
     * @param gridColor
     */
    public void setGridColor(Color gridColor) {
        this.gridColor = gridColor;
    }

    /**
     * Get a table heigth cell
     *
     * @return heigthCell
     */
    public int getHeigthCell() {
        return heightCell;
    }

    /**
     * Set a table heigth cell
     *
     * @param heigthCell
     */
    public void setHeigthCell(int heigthCell) {
        this.heightCell = heigthCell;
    }

    /**
     * Get a data in JTable
     *
     * @return data
     */
    public ArrayList<T> getData() {
        return data;
    }

    /**
     * Set a data in JDynamicTable,if you want see the changes execute method
     * "apply"
     *
     * @param data
     */
    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    /**
     * Set a table background color
     *
     * @return tableBackgroundColor
     */
    public Color getTableBackgroundColor() {
        return tableBackgroundColor;
    }

    /**
     * Set a table background color
     *
     * @param tableBackgroundColor
     */
    public void setTableBackgroundColor(Color tableBackgroundColor) {
        this.tableBackgroundColor = tableBackgroundColor;
    }

    /**
     * Get a selected row background color
     *
     * @return selectedRowbackgroundColor
     */
    public Color getSelectedRowbackgroundColor() {
        return selectedRowBackgroundColor;
    }

    /**
     * Set a selected row background color
     *
     * @param selectedRowbackgroundColor
     */
    public void setSelectedRowbackgroundColor(Color selectedRowbackgroundColor) {
        this.selectedRowBackgroundColor = selectedRowbackgroundColor;
    }

    /**
     * Get a selected cell background color
     *
     * @return selectedCellBackgroundColor
     */
    public Color getSelectedCellBackgroundColor() {
        return selectedCellBackgroundColor;
    }

    /**
     * Set a selected cell background color
     *
     * @param selectedCellBackgroundColor
     */
    public void setSelectedCellBackgroundColor(Color selectedCellBackgroundColor) {
        this.selectedCellBackgroundColor = selectedCellBackgroundColor;
    }

    /**
     * Add a column in the JTable,if you want see the changes execute method
     * "apply"
     *
     * @param columnTable
     */
    public void addColumn(ColumnTable columnTable) {
        if (this.columns == null) {
            this.columns = new HeaderList();
        }
        this.columns.add(columnTable);
        this.columns.asignCellNumber();
    }

    /**
     * Get a specific button
     *
     * @param column
     * @return
     */
    private Object getButton(ButtonColumnTable column) {
        //return new ImageIcon(column.getImageIcon().getImage().getScaledInstance(column.getIconWidth(), column.getIconHeigth(), Image.SCALE_DEFAULT));
        //return new ImageIcon(this.imageRescaling.rescale(column.getImageIcon(), column.getIconHeigth(), ImageRescaling.RELATION_HEIGTH));
        return column.getButton();
    }

    /**
     * Get an image to put in the cell
     *
     * @param column
     * @param data
     * @return
     */
    private Object getImageData(ImageColumnTable column, T data) throws NoSuchFieldException, IllegalAccessException,NotRenderImageColumnException {
        if(column.getAlias() == null){
            if(column.getDefaultImage() != null){
                return column.getDefaultImage().getResizeImage(this.heightCell,ImageRescaling.RELATION_HEIGTH);
            }
        }else{
            Object result = this.getDataObject(data,column.getAlias());
            if(result instanceof ImageColumn){
                return ((ImageColumn)result).getResizeImage(this.heightCell,ImageRescaling.RELATION_HEIGTH);
            }else{
                throw new NotRenderImageColumnException("That object isn't render, object class : "+result.getClass().getName() + ", the correct class is : "+ImageColumn.class.getName()+" to render a image");
            }
        }
        return null;
    }

    /**
     * Get a specific value in JTable with object
     *
     * @param value
     * @return
     */
    public T get(T value) {
        int index = this.data.indexOf(value);
        return this.data.get(index);
    }

    /**
     * Get a specific value in JTable with row index
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return this.data.get(index);
    }

    /**
     * Delete a specific value in JTable with object
     *
     * @param value
     */
    public void delete(T value) {
        int index = this.data.indexOf(value);
        if (index != -1) {
            this.data.remove(value);
            this.model.removeRow(index);
        }
    }

    /**
     * Delete a specific value in JTable with row index
     *
     * @param index
     */
    public void delete(int index) {
        if (this.data.remove(index) != null) {
            this.model.removeRow(index);
        }
    }

    /**
     * Linked method to manipulated a Mause Event in JTable, that execute an
     * action in ColumnTable
     *
     * @param evt
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private void processMauseClick(MouseEvent evt) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NotRenderImageColumnException {
        int row = this.table.rowAtPoint(evt.getPoint());
        int column = this.table.columnAtPoint(evt.getPoint());
        ColumnTable columnTable = this.columns.getColumnTable(column);
        if (columnTable instanceof ButtonColumnTable) {
            ((ButtonColumnTable) columnTable).clickAction(this.data.get(row), this.dataGetter(this.data.get(row), columnTable), this.parent);
        }
    }

    /**
     * Method to add data object in JTable, this action it updates in real time
     *
     * @param data
     */
    public void addRow(T data) {
        try {
            if (data != null) {
                this.data.add(data);
                this.model.addRow(this.dataSetter(data));
            }
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | NotRenderImageColumnException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Get an Object Array, according in alisases of each column in the table
     *
     * @param data
     * @return
     */
    private Object[] dataSetter(T data) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NotRenderImageColumnException {
        ArrayList<Object> result = new ArrayList<>();
        for (ColumnTable column : this.columns) {
            result.add(this.dataGetter(data, column));
        }
        return result.toArray();
    }

    /**
     * Get a data according to a sending column
     *
     * @param data
     * @param column
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private Object dataGetter(T data, ColumnTable column) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NotRenderImageColumnException {
    
        if (column instanceof ButtonColumnTable) {
            return this.getButton((ButtonColumnTable) column);
        } else if (column instanceof ImageColumnTable) {
            return this.getImageData((ImageColumnTable)column,data);
        } else {
            return this.getDataObject(data, column.getAlias());
        }
    }

    /**
     * Get an information of object by alias to describe in the column
     * @param data
     * @param alias
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private Object getDataObject(T data,String alias) throws NoSuchFieldException, IllegalAccessException {
        Field field = data.getClass().getDeclaredField(alias);
        if (!field.canAccess(data)) {
            field.setAccessible(true);
        }
        Object result = field.get(data);
        field = null;
        return result;
    }
}
