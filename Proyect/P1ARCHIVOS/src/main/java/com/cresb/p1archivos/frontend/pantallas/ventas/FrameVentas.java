package com.cresb.p1archivos.frontend.pantallas.ventas;


import com.cresb.p1archivos.backend.DateManagment;
import com.cresb.p1archivos.backend.database.repository.ClienteRepository;
import com.cresb.p1archivos.backend.jDynamicTable.JDynamicTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.NumberColumnTable;
import com.cresb.p1archivos.backend.jDynamicTable.columns.TextColumnTable;
import com.cresb.p1archivos.backend.models.Cliente;
import com.cresb.p1archivos.backend.models.Descripcion;
import com.cresb.p1archivos.backend.models.Empleado;
import com.cresb.p1archivos.backend.models.Stock;
import com.cresb.p1archivos.backend.models.Sucursal;
import com.cresb.p1archivos.backend.models.Venta;
import com.cresb.p1archivos.frontend.pantallas.RegistrarCliente;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class FrameVentas extends javax.swing.JFrame {
    
    private final  ClienteRepository clienteRepository = new ClienteRepository();
    private Empleado empleado = null;
    private final DateManagment dateManagment = new DateManagment();
    
    private JDynamicTable<Descripcion> dt;
    
    //Variables donde se guardan el producto sobre el cual se esta trabajando
    private Stock currentWork = null;
    
    
    //Variable para el momento de la venta
    private Cliente cliente = null;
    private Sucursal sucursal = null;
    
    //Descripcion de la venta
    private ArrayList<Descripcion> descripcion = new ArrayList<>();
    private Venta venta;
    
    /**
     * Creates new form FrameVentas
     * @param empleado
     */
    public FrameVentas(Empleado empleado, Sucursal sucursal) {
        initComponents();
        this.empleado = empleado;
        this.sucursal = sucursal;
        this.dt = new JDynamicTable<>(this.jTable1,this);
        this.inicializarTabla();
        this.setLocationRelativeTo(null);
        this.jMenu1.setText("Empleado: "+empleado.getNombre());
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
        fieldNit = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        fieldProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VENTAS");

        jLabel1.setText("Cliente:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        fieldNombre.setEditable(false);

        jLabel3.setText("BÚSQUEDA DE CLIENTE");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("DESCRIPCION:");

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

        jLabel6.setText("PRODUCTO:");

        fieldProducto.setEditable(false);

        btnBuscarProducto.setText("buscar");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        jLabel7.setText("CANTIDAD: ");

        jSpinner1.setValue(1);

        jButton2.setText("Agregar al Carrito");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(fieldProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto)
                    .addComponent(jLabel7)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("procesar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("TOTAL:");

        jTextField2.setEditable(false);

        jMenu1.setText("Empleado: ");
        jMenu1.setEnabled(false);
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(fieldNit)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldNombre))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nit = this.fieldNit.getText();
        
        if(nit.isBlank()||nit.isEmpty()){
            JOptionPane.showMessageDialog(this, "Se debe de ingrear un nit","Error de campo",JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                var cliente = this.clienteRepository.findById(nit);
                if(cliente == null){
                    this.fieldNombre.setText("");
                    this.generarInfoCliente(nit);
                    this.verificacionDeCliente();
                }else{
                    this.cliente = cliente;
                    this.mostrarInfoCliente();
                    this.generarObjetoVenta();
                }
            } catch (SQLException e) {
                System.out.println("Error al recuperar la informacion del cliente");
                this.fieldNombre.setText("");
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        SeleccionarProducto seleccionarProducto = new SeleccionarProducto(this, true, sucursal);
        seleccionarProducto.setVisible(true);
        this.currentWork = seleccionarProducto.getSelectedStok();
        if(this.currentWork!= null ){
            this.fieldProducto.setText(this.currentWork.getProductoId().getNombre());
        }else{
            this.fieldProducto.setText(null);
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Verificamos primero que haya un cliente
        if(this.cliente != null){
            if(this.venta != null){
                //Verificamos que haya un producto
                if(this.currentWork != null){
                    //Verificamos la cantidad de elementos y si esta disponible para agregar al carrito
                    int cantidad = (int) jSpinner1.getValue();
                    if(cantidad >= 1){
                        if(cantidad <= this.currentWork.getCantidad()){
                            var des = new Descripcion(this.currentWork.getProductoId(), this.venta, cantidad);
                            des.setStock(currentWork);
                            descripcion.add(des);
                            this.actulizarInfoTabla();
                            //Fin del proceso limpiar las variables auxiliares
                            this.currentWork = null;
                            this.fieldProducto.setText(null);
                            this.jSpinner1.setValue(1);
                        }else{
                            JOptionPane.showMessageDialog(this, "La unidades disponibles del porducto son: "+this.currentWork.getCantidad(), "Error de stock", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Se debe de seleccionar una cantidad mayor o igual a 1", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Primero debe de seleccionar un producto", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(this, "Se debe de iniciar una venta primero, ingrese un cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Primero debe de asignar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO: ultima modificacion
        if(this.venta!=null){
            this.venta.setId(dateManagment.getIdDateTime());
            this.venta.setFecha(dateManagment.currentDate());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JTextField fieldNit;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    
    public void clearEmpleado(){
        this.empleado = null;
    }

    private void generarInfoCliente(String nit) {
        RegistrarCliente registrarCliente = new RegistrarCliente(this, true, nit);
        registrarCliente.setVisible(true);
    }
    
    private void verificacionDeCliente(){
        try {
            var result = this.clienteRepository.findById(this.fieldNit.getText());
            if(result == null){
                this.cliente = null;
                this.fieldNombre.setText("");
                JOptionPane.showMessageDialog(this, "No existe informacion de un cliente con NIT: "+this.fieldNit.getText(),"Cliente no encontrado",JOptionPane.ERROR_MESSAGE);
            }else{
                this.cliente = result;
                this.mostrarInfoCliente();
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error al recuperar la informacion del cliente");
            this.fieldNombre.setText("");
        }
    }

    private void mostrarInfoCliente() {
        this.fieldNit.setText(this.cliente.getNit());
        this.fieldNombre.setText(cliente.getNombre());
    }

    private void inicializarTabla() {
        dt.addColumn(new TextColumnTable("Codigo", "producto.id", true, 100));
        dt.addColumn(new TextColumnTable("Nombre", "producto.nombre", false, 100));
        dt.addColumn(new NumberColumnTable("Valor", "producto.valor", false, 100));
        dt.addColumn(new NumberColumnTable("Cantidad", "cantidad", false, 100));
        ButtonModTabla btnMod = new ButtonModTabla("Modificar", "Modificar", 50);
        //btnMod.setTransparency(true);
        ButtonDelTabla btnDel = new ButtonDelTabla("Eliminar", "Eliminar", 50);
        //btnMod.setTransparency(true);
        dt.addColumn(btnMod);
        dt.addColumn(btnDel);
        dt.apply();
    }
    
    private void actulizarInfoTabla(){
        this.dt.setData(this.descripcion);
        this.dt.apply();
        this.mostrarValor();
    }

    private void generarObjetoVenta() {
        venta = new Venta(this.generarIdVenta(), this.getFecha(), this.cliente, this.empleado, 0, descripcion);
    }
    
    private String generarIdVenta(){   
        return null;   
    }
    private Date getFecha(){
        return null;
    }

    private void mostrarValor() {
        double valor = 0;
        for (Descripcion descripcion1 : descripcion) {
            valor = valor +  (descripcion1.getProducto().getValor()*descripcion1.getCantidad());
        }
        this.jTextField2.setText("Q."+valor);
    }
}
