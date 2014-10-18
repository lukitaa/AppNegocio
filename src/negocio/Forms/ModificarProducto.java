/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Forms;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.Controladoras.ControladoraProductos;
import negocio.Controladoras.ControladoraProveedores;
import negocio.Controladoras.StorageException;
import negocio.Entidades.Proveedores;
import negocio.Entidades.Productos;
import negocio.Hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class ModificarProducto extends javax.swing.JDialog {

    Productos productoModificar = null;
    /**
     * Creates new form ModificarProducto
     */
    public ModificarProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setLocationRelativeTo(parent);
        initComponents();
        try {
            productoModificar = ControladoraProductos.getProduct(ABMProductos.productoModificar.getIdProducto());
        } catch (StorageException ex) {
            Logger.getLogger(ModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form_stock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        form_precio = new javax.swing.JTextField();
        form_modificarDatos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        form_producto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        form_proveedor = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        form_stock.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Precio:");

        form_precio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        form_modificarDatos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        form_modificarDatos.setText("Modificar datos");
        form_modificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form_modificarDatosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Modificacion de producto");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Producto:");

        form_producto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Stock:");

        form_proveedor.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Proveedor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(form_modificarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(form_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(form_stock)
                            .addComponent(form_precio)
                            .addComponent(form_proveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {form_precio, form_producto, form_stock});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(form_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(form_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(form_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(form_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form_modificarDatos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento cuando el form gana el foco para rellenar los campos con los datos del producto seleccionado.
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        form_producto.setText(productoModificar.getProducto());
        form_stock.setText(String.valueOf(productoModificar.getStock()));
        form_precio.setText(String.valueOf(productoModificar.getPrecio()));
        completarCombo();
    }//GEN-LAST:event_formWindowGainedFocus
    
    //Funcion para rellenar el combobox de proveedores.
    public void completarCombo(){
        List<Proveedores> prov = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Productos productoMod = null;
        try {
            prov = ControladoraProveedores.getProveedores(session);
            productoMod = ControladoraProductos.getProduct(productoModificar.getIdProducto(),session);
            for(Proveedores p : prov){
                form_proveedor.addItem(p.getProveedor());
                if(p.getProveedor().equals(productoMod.getProveedores().getProveedor()))
                    form_proveedor.setSelectedItem(p.getProveedor());
            }
            session.close();
        } catch (StorageException ex) {
            Logger.getLogger(ModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Boton de modificar los datos del producto.
    private void form_modificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form_modificarDatosActionPerformed
        //Obtener los datos ingresados para modificar.
        String nombreProd = form_producto.getText(),
               proveedor = form_proveedor.getSelectedItem().toString();
        int stock = Integer.valueOf(form_stock.getText());
        float precio = Float.valueOf(form_precio.getText());
        //Obtener el proveedor elegido.
        Proveedores prov = obtenerProveedorSeleccionado(proveedor);
        try {
            ControladoraProductos.updateProducto(productoModificar,nombreProd,stock,precio,prov);
            JOptionPane.showMessageDialog(null,"El producto se ha modificado correctamente.","Modificar producto",JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
        } catch (StorageException ex) {
            Logger.getLogger(ModificarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_form_modificarDatosActionPerformed

    //Funcion para obtener el proveedor seleccionado del combobox
    public Proveedores obtenerProveedorSeleccionado(String proveedor){
        Proveedores prov = null;
        List<Proveedores> listaProv = null;
        try {
            listaProv = ControladoraProductos.getProveedores();
            for(Proveedores auxProveedor : listaProv){
                if(auxProveedor.getProveedor().equals(proveedor))
                    prov = auxProveedor;
            }
        } catch (StorageException ex) {
            Logger.getLogger(ModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prov;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarProducto dialog = new ModificarProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton form_modificarDatos;
    private javax.swing.JTextField form_precio;
    private javax.swing.JTextField form_producto;
    private javax.swing.JComboBox form_proveedor;
    private javax.swing.JTextField form_stock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
