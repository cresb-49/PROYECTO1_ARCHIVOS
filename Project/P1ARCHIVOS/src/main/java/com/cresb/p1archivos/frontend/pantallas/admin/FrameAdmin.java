package com.cresb.p1archivos.frontend.pantallas.admin;

import com.cresb.p1archivos.backend.database.repository.EmpleadoRepository;
import com.cresb.p1archivos.backend.database.repository.PlanillaRepository;
import com.cresb.p1archivos.backend.database.repository.ReporteRepository;
import com.cresb.p1archivos.backend.database.repository.SucursalRepository;
import com.cresb.p1archivos.backend.models.Empleado;
import com.cresb.p1archivos.backend.models.Rol;
import com.cresb.p1archivos.backend.models.Sucursal;
import com.cresb.p1archivos.backend.security.Encriptar;
import java.awt.Dialog.ModalExclusionType;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dango
 */
public class FrameAdmin extends javax.swing.JFrame {
    
    private Empleado empleado;
    private int selectRol = Rol.VENDEDOR;
    
    private final SucursalRepository sucursalRepository = new SucursalRepository();
    private final PlanillaRepository planillaRepository = new PlanillaRepository();
    private final EmpleadoRepository empleadoRepository = new EmpleadoRepository();
    private final ReporteRepository reporteRepository = new ReporteRepository();
    private final Reportes reportes = new Reportes();
    
    /**
     * Creates new form FrameAdmin
     * @param empleado
     */
    public FrameAdmin(Empleado empleado) {
        initComponents();
        this.empleado = empleado;
        this.cargarComboBox();
        this.jMenu2.setText("Usuario: "+empleado.getNickname());
        this.setLocationRelativeTo(null);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldNickname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        RadioAdmin = new javax.swing.JRadioButton();
        RadioVendedor = new javax.swing.JRadioButton();
        RadioInventario = new javax.swing.JRadioButton();
        RadioBodega = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        ComboSucursales = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setResizable(false);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Password:");

        buttonGroup1.add(RadioAdmin);
        RadioAdmin.setText("Administrador");
        RadioAdmin.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RadioAdminStateChanged(evt);
            }
        });

        buttonGroup1.add(RadioVendedor);
        RadioVendedor.setSelected(true);
        RadioVendedor.setText("Vendedor");
        RadioVendedor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RadioVendedorStateChanged(evt);
            }
        });

        buttonGroup1.add(RadioInventario);
        RadioInventario.setText("Inventario");
        RadioInventario.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RadioInventarioStateChanged(evt);
            }
        });

        buttonGroup1.add(RadioBodega);
        RadioBodega.setText("Bodega");
        RadioBodega.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RadioBodegaStateChanged(evt);
            }
        });

        jLabel4.setText("Sucursal:");

        jLabel15.setText("Datos del Empleado:");

        jLabel16.setText("Rol del empleado:");

        jLabel17.setText("Sucursal del Empleado:");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel18.setText("Confirmar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel18))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField2)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldNickname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FieldNombre, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RadioVendedor)
                                .addGap(18, 18, 18)
                                .addComponent(RadioInventario)
                                .addGap(18, 18, 18)
                                .addComponent(RadioBodega)
                                .addGap(18, 18, 18)
                                .addComponent(RadioAdmin)))
                        .addGap(0, 200, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboSucursales, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioVendedor)
                    .addComponent(RadioInventario)
                    .addComponent(RadioBodega)
                    .addComponent(RadioAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ComboSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro Empleado", jPanel1);

        jLabel5.setText("Top 10 productos más vendidos");

        jLabel6.setText("Top 10 de clientes que más ganancias generan");

        jLabel7.setText("Top 3 sucursales con más ventas");

        jLabel8.setText("Top 3 sucursales con más ingresos");

        jLabel9.setText("Top 3 empleados con más ventas");

        jLabel10.setText("Top 3 empleados con más ingresos");

        jLabel12.setText("Top 10 productos con más ingresos");

        jLabel13.setText("Top 5 productos más vendidos por sucursal");

        jLabel14.setText("Top 5 productos con más ingresos por sucursal");

        jButton2.setText("Generar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Generar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Generar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Generar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Generar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Generar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Generar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Generar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Generar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11)
                    .addComponent(jButton10)
                    .addComponent(jButton9)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jButton11))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reportes", jPanel2);

        jMenu2.setText("Usuario: User");
        jMenu2.setEnabled(false);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.verificarEmpleado();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RadioBodegaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RadioBodegaStateChanged
        if(this.RadioBodega.isSelected()){
            this.ComboSucursales.setEnabled(false);
            this.selectRol = Rol.BODEGA;
        }
    }//GEN-LAST:event_RadioBodegaStateChanged

    private void RadioInventarioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RadioInventarioStateChanged
        if(this.RadioInventario.isSelected()){
            this.ComboSucursales.setEnabled(true);
            this.selectRol = Rol.INVENTARIO;
        }
    }//GEN-LAST:event_RadioInventarioStateChanged

    private void RadioVendedorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RadioVendedorStateChanged
        if(this.RadioVendedor.isSelected()){
            this.ComboSucursales.setEnabled(true);
            this.selectRol = Rol.VENDEDOR;
        }
    }//GEN-LAST:event_RadioVendedorStateChanged

    private void RadioAdminStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RadioAdminStateChanged
        if(this.RadioAdmin.isSelected()){
            this.ComboSucursales.setEnabled(false);
            this.selectRol = Rol.ADMIN;
        }
    }//GEN-LAST:event_RadioAdminStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.generarreporte1();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.generarreporte2();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.generarReporte3();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.generarReporte4();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.generarReporte5();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.generarReporte8();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.generarReporte9();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.generarReporte6();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.generarReporte7();
    }//GEN-LAST:event_jButton9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboSucursales;
    private javax.swing.JTextField FieldNombre;
    private javax.swing.JRadioButton RadioAdmin;
    private javax.swing.JRadioButton RadioBodega;
    private javax.swing.JRadioButton RadioInventario;
    private javax.swing.JRadioButton RadioVendedor;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fieldNickname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private void cargarComboBox() {
        try {
            var result = this.sucursalRepository.getAll();
            for (Sucursal sucursal : result) {
                this.ComboSucursales.addItem(sucursal.getNombre());
            }
        } catch (SQLException ex) {
            System.err.println("No se pueden recuperar las sucrusales");
        }
    }

    private void verificarEmpleado() {
        String pass1,pass2,nombre,nickname,sucursalNombre;
        nombre = this.FieldNombre.getText();
        nickname = this.fieldNickname.getText();
        pass1 = new String(this.jPasswordField1.getPassword());
        pass2 = new String(this.jPasswordField2.getPassword());
        sucursalNombre = this.ComboSucursales.getSelectedItem().toString();
        try {
            this.verificarCampos(nombre,nickname,pass1,pass2,sucursalNombre);
            var result = this.empleadoRepository.findById(nickname);
            if(result == null){
                //Se verifica la sucursal de trabajo
                var sucursal = this.sucursalRepository.findByNombre(sucursalNombre);
                if(sucursal == null)
                    throw new NullPointerException();
                //Se descarta el nombre del rol ya que solo se utliza el id para registar al empleado
                var empleado = new Empleado(nickname, Encriptar.encriptar(pass2), nombre, new Rol(this.selectRol, null));
                this.empleadoRepository.save(empleado);
                //Si el empleado es de rol vendedor o invetario se le asigna la sucursal de trabajo de lo contrario no
                if(selectRol == Rol.VENDEDOR || selectRol == Rol.INVENTARIO){
                    this.planillaRepository.insertarPlanilla(empleado, sucursal);
                }
                JOptionPane.showMessageDialog(this, "El usuario \""+nickname+"\" se registro con exito en el sistema","Registro completado",JOptionPane.INFORMATION_MESSAGE);
                this.limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(this, "El usuario \""+nickname+"\" ya existe en el sistema","Informacion Duplicada",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se puede conectar a la base de datos","Error de conexion",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(this, "No se recuperar la sucursal","Error de conexion",JOptionPane.ERROR_MESSAGE);
        } catch (EmptyDataException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Error de datos",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generarreporte1() {
        try {
            var reporte1 = this.reporteRepository.getReporte1();
            var jp = this.reportes.genReporte1(reporte1, empleado);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle(String.valueOf("TOP 10 PORDUCTOS MAS VENDIDOS"));
            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error no se puede generar el recibo: "+e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void generarreporte2() {
        try {
            var reporte2 = this.reporteRepository.getReporte2();
            var jp = this.reportes.genReporte2(reporte2, empleado);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle(String.valueOf("TOP 10 CLIENTES QUE MAS GANANCIAS GENERAN"));
            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error no se puede generar el recibo: "+e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void generarReporte3() {
        try {
            var reporte3= this.reporteRepository.getReporte3();
            var jp = this.reportes.genReporte3(reporte3, empleado);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle(String.valueOf("TOP 3 SUCURSALES CON MAS VENTAS"));
            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error no se puede generar el recibo: "+e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void generarReporte4() {
        try {
            var reporte4= this.reporteRepository.getReporte4();
            var jp = this.reportes.genReporte4(reporte4, empleado);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle(String.valueOf("TOP 3 SUCURSALES CON MAS INGRESOS"));
            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error no se puede generar el recibo: "+e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void generarReporte5() {
        try {
            var reporte5= this.reporteRepository.getReporte5();
            var jp = this.reportes.genReporte5(reporte5, empleado);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle(String.valueOf("TOP 3 EMPLEADOS CON MAS VENTAS"));
            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error no se puede generar el recibo: "+e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void generarReporte8() {
        try {
            SeleccionSucursal seleccionSucursal = new SeleccionSucursal(this, true);
            seleccionSucursal.setVisible(true);
            var sucursal = seleccionSucursal.getSucursal();
            seleccionSucursal.setSucursal(null);
            seleccionSucursal = null;
            
            var reporte8= this.reporteRepository.getReporte8(sucursal.getId());
            var jp = this.reportes.genReporte8(reporte8, empleado,sucursal);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle(String.valueOf("TOP 5 PRODUCTOS MAS VENDIDOS POR SUCURSAL"));
            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error no se puede generar el recibo: "+e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void generarReporte9() {
        try {
            SeleccionSucursal seleccionSucursal = new SeleccionSucursal(this, true);
            seleccionSucursal.setVisible(true);
            var sucursal = seleccionSucursal.getSucursal();
            seleccionSucursal.setSucursal(null);
            seleccionSucursal = null;
            
            var reporte9= this.reporteRepository.getReporte9(sucursal.getId());
            var jp = this.reportes.genReporte9(reporte9, empleado,sucursal);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle(String.valueOf("TOP 5 PRODUCTOS MAS VENDIDOS POR SUCURSAL"));
            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error no se puede generar el recibo: "+e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void generarReporte6() {
        try {
            var reporte6= this.reporteRepository.getReporte6();
            var jp = this.reportes.genReporte6(reporte6, empleado);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle(String.valueOf("TOP 3 EMPLEADOS CON MAS INGRESOS"));
            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error no se puede generar el recibo: "+e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void generarReporte7() {
        try {
            var reporte7= this.reporteRepository.getReporte7();
            var jp = this.reportes.genReporte7(reporte7, empleado);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle(String.valueOf("TOP 3 EMPLEADOS CON MAS INGRESOS"));
            jv.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error no se puede generar el recibo: "+e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(FrameAdmin.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    private void verificarCampos(String nombre, String nickname, String pass1, String pass2, String sucursalNombre) throws EmptyDataException {
        StringBuilder sb = new StringBuilder();
        if(nombre.isEmpty() || nombre.isBlank()){
            sb.append("- Se debe de agregar el nombre del empleado\n");
        }
        if(nickname.isEmpty()||nickname.isBlank()){
            sb.append("- Se debe de agregar un nombre de usuario\n");
        }
        if(pass1.isEmpty()||pass1.isBlank()){
            sb.append("- Debe de agregar un password\n");
        }
        if(pass2.isEmpty()||pass2.isBlank()){
            sb.append("- Debe de agregar un password para realizar la verficacion\n");
        }
        if(sucursalNombre.isEmpty()||sucursalNombre.isBlank()){
            sb.append("- Debe de agregar una sucursal de trabajo\n");
        }
        var result = sb.toString();
        if(!(result.isBlank()||result.isBlank())){
            throw new EmptyDataException(result);
        }   
    }

    private void limpiarCampos() {
        this.fieldNickname.setText(null);
        this.FieldNombre.setText(null);
        this.jPasswordField1.setText(null);
        this.jPasswordField2.setText(null);
    }
    
}
