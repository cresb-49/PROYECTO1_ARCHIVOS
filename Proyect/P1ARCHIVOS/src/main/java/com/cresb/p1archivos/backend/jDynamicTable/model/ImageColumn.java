package com.cresb.p1archivos.backend.jDynamicTable.model;

import com.cresb.p1archivos.backend.jDynamicTable.managments.images.ImageRescaling;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageColumn extends ImageIcon {
    public ImageColumn(String filename, String description) {
        super(filename, description);
    }

    public ImageColumn(String filename) {
        super(filename);
    }

    public ImageColumn(URL location, String description) {
        super(location, description);
    }

    public ImageColumn(URL location) {
        super(location);
    }

    public ImageColumn(Image image, String description) {
        super(image, description);
    }

    public ImageColumn(Image image) {
        super(image);
    }

    public ImageColumn(byte[] imageData, String description) {
        super(imageData, description);
    }

    public ImageColumn(byte[] imageData) {
        super(imageData);
    }

    public ImageColumn() {
    }

    public ImageColumn getResizeImage(int size,int RELATION_SIDE){
        ImageRescaling imageRescaling = new ImageRescaling();
        ImageColumn ic= new ImageColumn(imageRescaling.rescale(this,size,RELATION_SIDE));
        imageRescaling = null;
        return ic;
    }
}
