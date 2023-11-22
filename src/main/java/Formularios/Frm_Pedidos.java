package Formularios;

import Logica.Cliente;
//import Clases.Cls_Productos;
import Logica.Local;
import Logica.Pedido;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Frm_Pedidos extends javax.swing.JInternalFrame {
    //private final Cls_Productos CP;
    private final Local auxLocal;
    public int row;
    TableColumnModel columnModel;
    int num = 0;
    
    public Frm_Pedidos() {
        initComponents();
        //CP = new Cls_Productos();
        auxLocal = new Local();
        columnModel = jtb_productos.getColumnModel();
        listar();
        iniciar();
        bt_actualizar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_guardar.setEnabled(false);
    }

    private void listar(){
        DefaultTableModel DT = new DefaultTableModel();
        
        DT.addColumn("Numero de pedido");
        DT.addColumn("id_cliente");
        DT.addColumn("id_domiciliario");
        DT.addColumn("ids_productos");
        DT.addColumn("Costo de domicilio");
        
        Object[] fila = new Object[5];
        
        for(Pedido pedido:auxLocal.getPedidos()){
            fila[0] = pedido.getNumeroPedido();
            fila[1] = pedido.getId_cliente();
            fila[2] = pedido.getId_domiciliario();
            fila[3] = pedido.getIds_productos();
            fila[4] = pedido.getCostoDomicilio();
            DT.addRow(fila);
        }
        
        jtb_productos.setModel(DT);
        
        //columnModel.getColumn(1).setPreferredWidth(600);
    }
    
    private void iniciar(){
        txt_numeroPedido.setEnabled(false);
        txt_id_domiciliario.setEnabled(false);
        txt_id_cliente.setEnabled(false);
        txt_id_productos.setEnabled(false);
        txt_costo_domicilio.setEnabled(false);
    }
    
    private void activar(){
        txt_numeroPedido.setEnabled(true);
        txt_id_domiciliario.setEnabled(true);
        txt_id_cliente.setEnabled(true);
        txt_id_productos.setEnabled(true);
        txt_costo_domicilio.setEnabled(true);
        txt_numeroPedido.requestFocus();
    }
    
    private void limpiar(){
        txt_numeroPedido.setText("");
        txt_id_domiciliario.setText("");
        txt_id_cliente.setText("");
        txt_id_productos.setText("");
        txt_costo_domicilio.setText("");
        txt_numeroPedido.requestFocus();
        jtb_productos.clearSelection();
    }
    
    private void guardar(){

        String numeroPedido = txt_numeroPedido.getText();
        String id_domiciliario = txt_id_domiciliario.getText();
        String id_cliente = txt_id_cliente.getText();
        String ids_productos = txt_id_productos.getText();
        String costoDomicilio = txt_costo_domicilio.getText();

        Pedido nuevoCliente = new Pedido(Integer.parseInt(numeroPedido), Integer.parseInt(id_cliente), ids_productos, Integer.parseInt(id_domiciliario), Double.parseDouble(costoDomicilio));

        auxLocal.getPedidos().add(nuevoCliente);

        auxLocal.savePedidos();

        listar();

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_numeroPedido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_productos = new javax.swing.JTable();
        bt_guardar = new javax.swing.JButton();
        bt_actualizar = new javax.swing.JButton();
        bt_eliminar = new javax.swing.JButton();
        bt_nuevo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_id_domiciliario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_id_cliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_id_productos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_costo_domicilio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Productos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Numero del pedido*");

        jtb_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jtb_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_productos);

        bt_guardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_grabar.png"))); // NOI18N
        bt_guardar.setText("Guardar");
        bt_guardar.setBorderPainted(false);
        bt_guardar.setContentAreaFilled(false);
        bt_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });

        bt_actualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_modificar.png"))); // NOI18N
        bt_actualizar.setText("Modificar");
        bt_actualizar.setBorderPainted(false);
        bt_actualizar.setContentAreaFilled(false);
        bt_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_actualizarActionPerformed(evt);
            }
        });

        bt_eliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_eliminar.png"))); // NOI18N
        bt_eliminar.setText("Eliminar");
        bt_eliminar.setBorderPainted(false);
        bt_eliminar.setContentAreaFilled(false);
        bt_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarActionPerformed(evt);
            }
        });

        bt_nuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bt_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ic_nuevo.png"))); // NOI18N
        bt_nuevo.setText("Nuevo");
        bt_nuevo.setBorderPainted(false);
        bt_nuevo.setContentAreaFilled(false);
        bt_nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nuevoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Id del domiciliario*");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Manejo de Pedidos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setText("Llene y maneje la información respectiva de los pedidos.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Id del Cliente");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Ids de los productos");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Costo del domicilio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_nuevo)
                .addGap(62, 62, 62)
                .addComponent(bt_guardar)
                .addGap(75, 75, 75)
                .addComponent(bt_actualizar)
                .addGap(86, 86, 86)
                .addComponent(bt_eliminar)
                .addGap(160, 160, 160))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2)
                        .addGap(0, 763, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txt_numeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_domiciliario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_id_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txt_costo_domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_numeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id_domiciliario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_id_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_costo_domicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_guardar)
                    .addComponent(bt_actualizar)
                    .addComponent(bt_eliminar)
                    .addComponent(bt_nuevo))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_productosMouseClicked
        activar();
        bt_actualizar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        
        row = jtb_productos.getSelectedRow();
        System.out.println(row);
        txt_numeroPedido.setText(jtb_productos.getValueAt(row, 0).toString());
        txt_id_cliente.setText(jtb_productos.getValueAt(row, 1).toString());
        txt_id_productos.setText(jtb_productos.getValueAt(row, 3).toString());
        txt_id_domiciliario.setText(jtb_productos.getValueAt(row, 2).toString());
        txt_costo_domicilio.setText(jtb_productos.getValueAt(row, 4).toString());
    }//GEN-LAST:event_jtb_productosMouseClicked

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        
        if (row < 1){
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }
        else{
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?","Eliminar Pedido", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(resp==0){
                auxLocal.getPedidos().remove(row);
                auxLocal.savePedidos();
                listar();
                limpiar();
                bt_eliminar.setEnabled(false);
                bt_actualizar.setEnabled(false);
                bt_guardar.setEnabled(false);
                /*if (CP.eliminarProducto(jtb_productos.getValueAt(jtb_productos.getSelectedRow(), 0).toString()) > 0){
                    listar();
                    limpiar();
                    bt_eliminar.setEnabled(false);
                    bt_actualizar.setEnabled(false);
                    bt_guardar.setEnabled(false);
                }*/
            }
        }
    }//GEN-LAST:event_bt_eliminarActionPerformed

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        activar();
        limpiar();
        bt_guardar.setEnabled(true);

    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void bt_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualizarActionPerformed
        //int fila = jtb_productos.getSelectedRowCount();

        String nuevoNumeroPedido = txt_numeroPedido.getText();
        String nuevoDomiciliario = txt_id_domiciliario.getText();
        String nuevoCliente = txt_id_cliente.getText();
        String nuevoProductos = txt_id_productos.getText();
        String nuevoCostoDomicilio = txt_costo_domicilio.getText();
        
        Pedido pedidoActual = auxLocal.getPedidos().get(row);
       
        pedidoActual.setNumeroPedido(Integer.parseInt(nuevoNumeroPedido));
        pedidoActual.setId_cliente(Integer.parseInt(nuevoCliente));
        pedidoActual.setIds_productos(nuevoProductos);
        pedidoActual.setId_domiciliario(Integer.parseInt(nuevoDomiciliario));
        pedidoActual.setCostoDomicilio(Double.parseDouble(nuevoCostoDomicilio));

        auxLocal.savePedidos();
        listar();

        activar();
        bt_actualizar.setEnabled(false);
        bt_guardar.setEnabled(true);
        bt_eliminar.setEnabled(false);

    }//GEN-LAST:event_bt_actualizarActionPerformed

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
        
        guardar();

    }//GEN-LAST:event_bt_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_actualizar;
    private javax.swing.JButton bt_eliminar;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JButton bt_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_productos;
    private javax.swing.JTextField txt_costo_domicilio;
    private javax.swing.JTextField txt_id_cliente;
    private javax.swing.JTextField txt_id_domiciliario;
    private javax.swing.JTextField txt_id_productos;
    private javax.swing.JTextField txt_numeroPedido;
    // End of variables declaration//GEN-END:variables
}
