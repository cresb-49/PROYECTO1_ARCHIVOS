package com.cresb.p1archivos.frontend.pantallas.inventario;

import com.cresb.p1archivos.backend.database.repository.StockRepository;
import com.cresb.p1archivos.backend.jDynamicTable.JDynamicTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.NumberColumnTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.TextColumnTable;
import com.cresb.p1archivos.backend.models.Empleado;
import com.cresb.p1archivos.backend.models.Stock;
import com.cresb.p1archivos.backend.models.Sucursal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dango
 */
public class FrameInventario extends javax.swing.JFrame {
    
    private Empleado empleado = null;
    private Sucursal sucursal = null;
    
    private final StockRepository stockRepository = new StockRepository();
    
    private JDynamicTable<Object> dt;
    
    /**
     * Creates new form FrameInventario
     * @param empleado
     */
    public FrameInventario(Empleado empleado,Sucursal sucursal) {
        initComponents();
        this.empleado = empleado;
        this.sucursal = sucursal;
        this.dt = new JDynamicTable<>(this.jTable1,this);
        this.inicializarTabla();
        this.setLocationRelativeTo(null);
        this.jMenu2.setText("Empleado: "+empleado.getNombre());
        
        this.aplicarInformacion();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INVENTARIO");

        jLabel1.setText("PRODUCTOS DE LA SUCURSAL");

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

        jLabel2.setText("Parametro:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Marca");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Codigo");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Nombre");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu2.setText("Empleado: empleado");
        jMenu2.setEnabled(false);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String parametro = jTextField1.getText();
        
        if(parametro.isBlank()|| parametro.isEmpty()){
            this.aplicarInformacion();
        }else{
            try {
                if(jRadioButton3.isSelected()){
                    //por nombre
                    this.setInformaciondt(this.stockRepository.findStockBySucursalAndName(sucursal.getId(),parametro));
                }else if(jRadioButton1.isSelected()){
                    //por marca
                    this.setInformaciondt(this.stockRepository.findStockBySucursalAndMarca(sucursal.getId(),parametro));
                }else if(jRadioButton2.isSelected()){
                    //por codigo
                    this.setInformaciondt(this.stockRepository.findStockBySucursalAndCode(sucursal.getId(),parametro));
                }
                /*else if(jRadioButton4.isSelected()){
                    //por existencia
                    this.setInformaciondt(this.stockRepository.findStockBySucursalAndExistencia(sucursal.getId(),Integer.parseInt(parametro)));
                }*/
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void inicializarTabla() {
        dt.addColumn(new TextColumnTable("Codigo", "producto.id", true, 100));
        dt.addColumn(new TextColumnTable("Nombre", "producto.nombre", false, 100));
        dt.addColumn(new TextColumnTable("Marca", "producto.marca", false, 100));
        dt.addColumn(new NumberColumnTable("Valor", "producto.valor", false, 100));
        dt.addColumn(new NumberColumnTable("Cantidad", "cantidad", false, 100));
        ButtonSolicitarTabla bstSoli = new ButtonSolicitarTabla("Solicitar", "Solicitar", 50);
        dt.addColumn(bstSoli);
        dt.apply();
    }
    
    public void initFormSolicitud(Stock stock){
        if(stock != null){
           FormularioSolicitud formularioSolicitud = new FormularioSolicitud(this, true, stock);
           formularioSolicitud.setVisible(true);
           this.aplicarInformacion();
        }
    }

    private void aplicarInformacion() {
        try {
            this.dt.setData(new ArrayList<>(this.stockRepository.findStockBySucursal(sucursal.getId())));
            this.dt.apply();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void setInformaciondt(List<Stock> findAllBySucursalAndNomnbreProducto) {
        this.dt.setData(new ArrayList<>(findAllBySucursalAndNomnbreProducto));
        this.dt.apply();
    }
}
