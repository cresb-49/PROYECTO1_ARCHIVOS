package com.cresb.p1archivos.backend.jDynamicTable.model;

import com.cresb.p1archivos.backend.jDynamicTable.model.HeaderList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cresb-49
 */
public class JDynamicTableModel extends DefaultTableModel {

    private HeaderList titles;
    private Object[][] data;

    public JDynamicTableModel(HeaderList titles, Object[][] data) {
        super();
        this.titles = titles;
        this.data = data;
        setDataVector(data, titles.getTitles());
    }

    public JDynamicTableModel() {
    }

    /**
     * Get a titles of the table
     *
     * @return the value of titles
     */
    public HeaderList getTitles() {
        return titles;
    }

    /**
     * Set a titles of the table
     *
     * @param titles new value of titles
     */
    public void setTitles(HeaderList titles) {
        this.titles = titles;
    }

    /**
     * Get a data matrix of the table
     *
     * @return the value of data
     */
    public Object[][] getData() {
        return data;
    }

    /**
     * Set a data matrix of the table
     *
     * @param data new value of data
     */
    public void setData(Object[][] data) {
        this.data = data;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return this.titles.get(column).isEditable();
    }
}
