package com.cresb.p1archivos.backend.jDynamicTable.columns;

import com.cresb.p1archivos.backend.jDynamicTable.model.ImageColumn;

import javax.swing.*;

/**
 *
 * @author cresb-49
 */
public class ImageColumnTable extends ColumnTable{
    private ImageColumn defaultImage;

    public ImageColumnTable(String name, String alias, int width, int cellNumber) {
        super(name, alias, false, width, cellNumber);
    }

    public ImageColumnTable(String name, String alias, int width) {
        super(name, alias, false, width);
    }

    public ImageColumnTable(String name, int width, int cellNumber) {
        super(name, false, width, cellNumber);
    }

    public ImageColumnTable(String name, int width) {
        super(name, false, width);
    }
    public ImageColumnTable() {

    }

    public ImageColumn getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(ImageColumn defaultImage) {
        this.defaultImage = defaultImage;
    }
}
