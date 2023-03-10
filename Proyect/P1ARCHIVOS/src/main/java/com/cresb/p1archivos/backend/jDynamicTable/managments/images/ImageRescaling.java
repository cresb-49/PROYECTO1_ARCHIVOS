package com.cresb.p1archivos.backend.jDynamicTable.managments.images;

import java.awt.Image;
import java.math.BigDecimal;
import javax.swing.ImageIcon;

/**
 *
 * @author cresb-49
 */
public class ImageRescaling {

    public static final int RELATION_WIDTH = 1;
    public static final int RELATION_HEIGTH = 2;

    public Image rescale(Image img, int sideSize, int side) {
        return this.action(img, sideSize, side);
    }

    public Image rescale(ImageIcon img, int sideSize, int side) {
        return this.action(img.getImage(), sideSize, side);
    }

    private Image action(Image img, int sideSize, int side) {
        BigDecimal old_width = new BigDecimal(img.getHeight(null));
        BigDecimal old_heigth = new BigDecimal(img.getWidth(null));
        BigDecimal size = new BigDecimal(sideSize);
        BigDecimal new_width, new_heigth,aspectRatio;
        switch (side) {
            case RELATION_WIDTH:
                aspectRatio = (size.compareTo(BigDecimal.ZERO)<=0 ? old_width : size.divide(old_width));
                new_heigth = old_heigth.multiply(aspectRatio);
                new_width = old_width.multiply(aspectRatio);
                return img.getScaledInstance(new_width.intValue(), new_heigth.intValue(), Image.SCALE_DEFAULT);
            case RELATION_HEIGTH:
                aspectRatio = (size.compareTo(BigDecimal.ZERO)<=0 ? old_heigth : size.divide(old_heigth));
                new_heigth = old_heigth.multiply(aspectRatio);
                new_width = old_width.multiply(aspectRatio);
                return img.getScaledInstance(new_width.intValue(), new_heigth.intValue(), Image.SCALE_DEFAULT);
            default:
                return img;
        }
    }
}
