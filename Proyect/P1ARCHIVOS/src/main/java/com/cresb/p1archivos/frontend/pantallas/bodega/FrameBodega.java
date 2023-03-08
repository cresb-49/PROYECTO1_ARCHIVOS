package com.cresb.p1archivos.frontend.pantallas.bodega;

import com.cresb.p1archivos.backend.database.repository.BodegaRepository;
import com.cresb.p1archivos.backend.models.Bodega;
import com.cresb.p1archivos.backend.models.Empleado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dango
 */
public class FrameBodega extends javax.swing.JFrame {

    private Empleado empleado;
    private BodegaRepository bodegaRepository;
    
    /**
     * Creates new form FrameBodega
     * @param empleado
     */
    public FrameBodega(Empleado empleado) {
        initComponents();
        this.empleado = empleado;
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
        jLabel1 = new javax.swing.JLabel();
        fieldParametro = new javax.swing.JTextField();
        RadioNombre = new javax.swing.JRadioButton();
        RadioCodigo = new javax.swing.JRadioButton();
        RadioMarca = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        LabelUsuario = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setText("Buscar");

        buttonGroup1.add(RadioNombre);
        RadioNombre.setSelected(true);
        RadioNombre.setText("Nombre Producto");

        buttonGroup1.add(RadioCodigo);
        RadioCodigo.setText("Codigo");

        buttonGroup1.add(RadioMarca);
        RadioMarca.setText("Marca");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Productos");

        jMenuItem1.setText("Agregar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        LabelUsuario.setText("Usuario: User");
        LabelUsuario.setEnabled(false);
        jMenuBar1.add(LabelUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(fieldParametro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RadioNombre)
                        .addGap(18, 18, 18)
                        .addComponent(RadioCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(RadioMarca)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioNombre)
                    .addComponent(RadioCodigo)
                    .addComponent(RadioMarca)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Codigo para agregar un producto a la bodega:
        AgregarProducto agregarProducto = new AgregarProducto(this, true);
        agregarProducto.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Seleccion del tipo de parametro a buscar:
        String parametro = this.fieldParametro.getText();
        try {
            if(this.RadioCodigo.isSelected()){
                this.actualizarTabla(this.bodegaRepository.findByIdProducto(parametro));
            }else if(this.RadioMarca.isSelected()){
                this.actualizarTabla(this.bodegaRepository.findByMarcaProducto(parametro));
            }else if(this.RadioNombre.isSelected()){
                this.actualizarTabla(this.bodegaRepository.findByNombreProducto(parametro));
            }
        } catch (SQLException e) {
            System.out.println("adshjkdgashjdgjasghd");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu LabelUsuario;
    private javax.swing.JRadioButton RadioCodigo;
    private javax.swing.JRadioButton RadioMarca;
    private javax.swing.JRadioButton RadioNombre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fieldParametro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla(List<Bodega> data) {
        //TODO: Generar la accion del metodo
        
    }
}
