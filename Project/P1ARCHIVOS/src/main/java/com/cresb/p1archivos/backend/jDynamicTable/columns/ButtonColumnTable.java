package com.cresb.p1archivos.backend.jDynamicTable.columns;

import com.cresb.p1archivos.backend.jDynamicTable.managments.images.ImageRescaling;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Class to implements a button in column JTable
 * 
 * @author cresb-49
 */
public class ButtonColumnTable extends ColumnTable {

    private String text;
    private ImageIcon imageIcon;
    private JButton button = null;
    private boolean transparency;

    private int size;
    private int option_resize;
    private final ImageRescaling imageRescaling = new ImageRescaling();

    /**
     *
     * @param text
     * @param imageIcon
     * @param nameColumn
     * @param width
     */
    public ButtonColumnTable(String text, ImageIcon imageIcon, int sizeIcon, int RELATION_SIDE, String nameColumn, int width) {
        super(nameColumn, false, width);
        this.text = text;
        this.imageIcon = imageIcon;
        this.size = sizeIcon;
        this.option_resize = RELATION_SIDE;
    }

    /**
     * 
     * @param text
     * @param imageIcon
     * @param nameColumn
     * @param width
     */
    public ButtonColumnTable(String text, ImageIcon imageIcon, String nameColumn, int width) {
        super(nameColumn, false, width);
        this.text = text;
        this.imageIcon = imageIcon;
        this.size = 25;
        this.option_resize = ImageRescaling.RELATION_HEIGTH;
    }

    /**
     *
     * @param text
     * @param nameColumn
     * @param width
     */
    public ButtonColumnTable(String text, String nameColumn, int width) {
        super(nameColumn, false, width);
        this.text = text;
        this.imageIcon = null;
        this.size = 25;
        this.option_resize = ImageRescaling.RELATION_HEIGTH;
    }

    /**
     *
     * @param imageIcon
     * @param sizeIcon
     * @param RELATION_SIDE
     * @param nameColumn
     * @param width
     */
    public ButtonColumnTable(ImageIcon imageIcon, int sizeIcon, int RELATION_SIDE, String nameColumn, int width) {
        super(nameColumn, false, width);
        this.text = null;
        this.imageIcon = imageIcon;
        this.size = sizeIcon;
        this.option_resize = RELATION_SIDE;
    }

    /**
     *
     * @param imageIcon
     * @param nameColumn
     * @param width
     */
    public ButtonColumnTable(ImageIcon imageIcon, String nameColumn, int width) {
        super(nameColumn, false, width);
        this.text = null;
        this.imageIcon = imageIcon;
        this.size = 25;
        this.option_resize = ImageRescaling.RELATION_HEIGTH;
    }

    /**
     *
     * @param text
     * @param imageIcon
     * @param sizeIcon
     * @param RELATION_SIDE
     * @param nameColumn
     * @param width
     * @param cellNumber
     */
    public ButtonColumnTable(String text, ImageIcon imageIcon, int sizeIcon, int RELATION_SIDE, String nameColumn,
            int width, int cellNumber) {
        super(nameColumn, false, width, cellNumber);
        this.text = text;
        this.imageIcon = imageIcon;
        this.size = sizeIcon;
        this.option_resize = RELATION_SIDE;
    }

    /**
     * 
     * @param text
     * @param imageIcon
     * @param nameColumn
     * @param width
     * @param cellNumber
     */
    public ButtonColumnTable(String text, ImageIcon imageIcon, String nameColumn, int width, int cellNumber) {
        super(nameColumn, false, width, cellNumber);
        this.text = text;
        this.imageIcon = imageIcon;
        this.size = 25;
        this.option_resize = ImageRescaling.RELATION_HEIGTH;
    }

    /**
     *
     * @param text
     * @param nameColumn
     * @param width
     * @param cellNumber
     */
    public ButtonColumnTable(String text, String nameColumn, int width, int cellNumber) {
        super(nameColumn, false, width, cellNumber);
        this.text = text;
        this.imageIcon = null;
        this.size = 25;
        this.option_resize = ImageRescaling.RELATION_HEIGTH;
    }

    /**
     *
     * @param imageIcon
     * @param sizeIcon
     * @param RELATION_SIDE
     * @param nameColumn
     * @param width
     * @param cellNumber
     */
    public ButtonColumnTable(ImageIcon imageIcon, int sizeIcon, int RELATION_SIDE, String nameColumn, int width,
            int cellNumber) {
        super(nameColumn, false, width, cellNumber);
        this.text = null;
        this.imageIcon = imageIcon;
        this.size = sizeIcon;
        this.option_resize = RELATION_SIDE;
    }

    /**
     *
     * @param imageIcon
     * @param nameColumn
     * @param width
     * @param cellNumber
     */
    public ButtonColumnTable(ImageIcon imageIcon, String nameColumn, int width, int cellNumber) {
        super(nameColumn, false, width, cellNumber);
        this.text = null;
        this.imageIcon = imageIcon;
        this.size = 25;
        this.option_resize = ImageRescaling.RELATION_HEIGTH;
    }

    /**
     * Get a button text
     * 
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Set a button text
     * 
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get a image icon
     * 
     * @return the imageIcon
     */
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    /**
     * Set a image icon
     * 
     * @param imageIcon the imageIcon to set
     */
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    /**
     *
     * @return
     */
    public boolean isTransparency() {
        return transparency;
    }

    /**
     *
     * @param transparency
     */
    public void setTransparency(boolean transparency) {
        this.transparency = transparency;
    }

    public JButton getButton(){
        if(button == null)
            this.initButton();
        return this.button;
    }

    private void initButton() {
        //this.button = new JButton(this.text, this.imageIcon);
        if(imageIcon != null){
            this.button = new JButton(this.text,new ImageIcon(imageRescaling.rescale(this.imageIcon,this.size,this.option_resize)));
        }else{
            this.button = new JButton(this.text,null);
        }
        this.button.setFocusPainted(!this.transparency);
        this.button.setBorderPainted(!this.transparency);
        this.button.setContentAreaFilled(!this.transparency);
    }

    /**
     * Click action in the button
     * 
     * @param orign
     * @param selected
     * @param parent
     */
    public void clickAction(Object orign, Object selected, Component parent) {

    }
}
