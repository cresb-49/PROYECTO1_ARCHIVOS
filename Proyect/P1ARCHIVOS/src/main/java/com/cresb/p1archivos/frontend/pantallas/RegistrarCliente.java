/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.cresb.p1archivos.frontend.pantallas;

import com.cresb.p1archivos.backend.database.repository.ClienteRepository;
import com.cresb.p1archivos.backend.models.Cliente;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author benjamin
 */
public class RegistrarCliente extends javax.swing.JDialog {

    private Cliente cliente;
    private final ClienteRepository clienteRepository = new ClienteRepository();
    
    /**
     * Creates new form RegistrarCliente
     * @param parent
     * @param modal
     * @param nit
     */
    public RegistrarCliente(java.awt.Frame parent, boolean modal,String nit) {
        super(parent, modal);
        initComponents();
        this.setResizable(false);
        this.fieldNit.setText(nit);
        this.cliente = new Cliente(nit, "");
        this.setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldNit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnRegistar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRO DE NUEVO CLIENTE");

        jLabel1.setText("Nombre:");

        jLabel2.setText("NIT:");

        fieldNit.setEnabled(false);

        jLabel3.setText("INFORMACIÓN DEL CLIENTE");

        btnRegistar.setText("Registrar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNombre)
                            .addComponent(fieldNit)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 225, Short.MAX_VALUE))
                    .addComponent(btnRegistar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        // TODO add your handling code here:
        this.cliente.setNit(this.fieldNit.getText());
        this.cliente.setNombre(this.fieldNombre.getText());
        
        if(this.cliente.getNit().isBlank()||this.cliente.getNit().isEmpty()){
            JOptionPane.showMessageDialog(this, "Se debe de ingresar un nit","Error de campo",JOptionPane.ERROR_MESSAGE);
        }else{
            if(this.cliente.getNombre().isBlank()||this.cliente.getNombre().isEmpty()){
                JOptionPane.showMessageDialog(this, "Se debe ingresar el nombre del cliente","Error de campo",JOptionPane.ERROR_MESSAGE);
            }else{
                
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea registrar esta informacion del cliente?\nNombre:"+this.cliente.getNombre()+"\nNIT:"+this.cliente.getNit());
                
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        this.clienteRepository.save(cliente);
                        JOptionPane.showMessageDialog(this, "Se registro con exito la informacion en la base de datos","Registro Correcto",JOptionPane.INFORMATION_MESSAGE);
                    } catch (HeadlessException | SQLException e) {
                        JOptionPane.showMessageDialog(this, "Error al registrar al cliente en la base de datos","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }                
            }
        }        
    }//GEN-LAST:event_btnRegistarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistar;
    private javax.swing.JTextField fieldNit;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
