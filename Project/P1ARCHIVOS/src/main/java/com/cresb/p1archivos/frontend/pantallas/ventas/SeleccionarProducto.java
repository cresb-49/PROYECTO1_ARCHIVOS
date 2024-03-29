/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.cresb.p1archivos.frontend.pantallas.ventas;

import com.cresb.p1archivos.backend.database.repository.StockRepository;
import com.cresb.p1archivos.backend.jDynamicTable.JDynamicTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.NumberColumnTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.TextColumnTable;
import com.cresb.p1archivos.backend.models.Stock;
import com.cresb.p1archivos.backend.models.Sucursal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dango
 */
public class SeleccionarProducto extends javax.swing.JDialog {

    private Stock selectedStok = null;
    private Sucursal sucursal;
    private final StockRepository stockRepository = new StockRepository();
    private JDynamicTable<Object> dt;
    
    /**
     * Creates new form SeleccionarProducto
     * @param parent
     * @param modal
     * @param sucursal
     */
    public SeleccionarProducto(java.awt.Frame parent, boolean modal,Sucursal sucursal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.sucursal = sucursal;
        this.dt = new JDynamicTable<>(this.jTable1,this);
        this.inicializarTabla();
        this.initDatos();
        this.jMenu1.setText("Sucursal: "+sucursal.getNombre());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SELECCION DE PRODUCTO");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Codigo");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Nombre");

        jLabel1.setText("Parametro:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Sucursal");
        jMenu1.setEnabled(false);
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if(this.jRadioButton1.isSelected()){
                this.agregarDatos(new ArrayList<>(this.stockRepository.findAllBySucursalAndCodigoProducto(sucursal.getId(), this.jTextField1.getText())));
            }else{
                this.agregarDatos(new ArrayList<>(this.stockRepository.findAllBySucursalAndNomnbreProducto(sucursal.getId(), this.jTextField1.getText())));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void inicializarTabla() {
        dt.addColumn(new TextColumnTable("Codigo", "producto.id", true, 30));
        dt.addColumn(new TextColumnTable("Nombre", "producto.nombre", false, 150));
        dt.addColumn(new NumberColumnTable("Valor", "producto.valor", false, 50));
        dt.addColumn(new NumberColumnTable("Cantidad", "cantidad", false, 100));
        ButtonSelectTabla btnSel = new ButtonSelectTabla("Seleccionar", "Seleccionar", 50);
        btnSel.setTransparency(false);
        dt.addColumn(btnSel);
        dt.apply();
    }

    public Stock getSelectedStok() {
        return selectedStok;
    }

    public void setSelectedStok(Stock selectedStok) {
        this.selectedStok = selectedStok;
        this.dispose();
    }
    
    private void agregarDatos(ArrayList<Object> datos ) {
        dt.setData(datos);
        dt.apply();
    }

    private void initDatos() {
        try {
            this.agregarDatos(new ArrayList<>(this.stockRepository.findAllBySucursal(sucursal.getId())));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
