package com.cresb.p1archivos.backend.jDynamicTable.model;

import com.cresb.p1archivos.backend.jDynamicTable.columns.ColumnTable;
import java.util.ArrayList;

/**
 * Class inherited of ArrayList to describe a header of JTable
 * 
 * @author cresb-49
 */
public class HeaderList extends ArrayList<ColumnTable> {
    /**
     * Constructor of HeaderList
     */
    public HeaderList() {
    }

    /**
     * Get an Array names of JTable
     * 
     * @return Object[] titles array
     */
    public Object[] getTitles() {
        ArrayList<String> titles = new ArrayList<>();
        for (ColumnTable thi : this) {
            titles.add(thi.getName());
        }
        return titles.toArray();
    }

    /**
     * Loop to set number of column
     */
    public void asignCellNumber() {
        for (int i = 0; i < this.size(); i++) {
            this.get(i).setCellNumber(i);
        }
    }

    /**
     * Get a column of the Table with column index
     * 
     * @param columnNumber
     * @return
     */
    public ColumnTable getColumnTable(int columnNumber) {
        return this.get(columnNumber);
    }

    /**
     * Get a column with name of column
     * 
     * @param name
     * @return
     */
    public ColumnTable getColumnTable(String name) {
        for (ColumnTable thi : this) {
            if (thi.getName().equals(name))
                return thi;
        }
        return null;
    }
}
