/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Forms;

import java.awt.Frame;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import negocio.Controladoras.ControladoraCompras;
import negocio.Controladoras.ControladoraMedia;
import negocio.Controladoras.ControladoraProveedores;
import negocio.Controladoras.StorageException;
import negocio.Entidades.Compras;
import negocio.Entidades.Detalles;
import negocio.Entidades.Productos;
import negocio.Entidades.Proveedores;
import negocio.Hibernate.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class VistaCompras extends javax.swing.JDialog {

    Frame framePrincipal = null;
    boolean alreadyShowed = false;
    /**
     * Creates new form VistaCompras
     */
    public VistaCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setLocationRelativeTo(parent);
        initComponents();
        //Tener al Frame padre guardado para usar.
        framePrincipal = parent;
        //Seteo de los valores de las filas de la tabla en el centro
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i=0; i<form_tablaCompras.getColumnCount();i++){
            form_tablaCompras.setDefaultRenderer(form_tablaCompras.getColumnClass(i),renderer);
        }
        //Seteo de los valores de las cabezeras de la tabla en el centro
        DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer) form_tablaCompras.getTableHeader().getDefaultRenderer();
        renderer2.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        form_tablaCompras = new javax.swing.JTable();
        form_realizarNuevaCompra = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        form_comboVerComprasProducto = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        form_comboVerComprasProveedor = new javax.swing.JComboBox();
        form_verCompraSeleccionada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Sector para observar o realizar compras");

        form_tablaCompras.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        form_tablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Compra", "Fecha", "Proveedor", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(form_tablaCompras);

        form_realizarNuevaCompra.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        form_realizarNuevaCompra.setText("Realizar nueva compra");
        form_realizarNuevaCompra.setToolTipText("<html>\n\t<strong>Realizar una nueva compra.</strong>\n</html>");
        form_realizarNuevaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form_realizarNuevaCompraActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Ver compras de producto:");

        form_comboVerComprasProducto.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        form_comboVerComprasProducto.setToolTipText("<html>\n\t<strong>Mostrar las compras que tengan el producto elegido.</strong>\n</html>");
        form_comboVerComprasProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                form_comboVerComprasProductoItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Ver compras de proveedor:");

        form_comboVerComprasProveedor.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        form_comboVerComprasProveedor.setToolTipText("<html>\n\t<strong>Mostrar las compras que tengan el proveedor elegido.</strong>\n</html>");
        form_comboVerComprasProveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                form_comboVerComprasProveedorItemStateChanged(evt);
            }
        });

        form_verCompraSeleccionada.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        form_verCompraSeleccionada.setText("Ver detalles de la seleccion");
        form_verCompraSeleccionada.setToolTipText("<html>\n\t<strong>Mostrar los detalles de la compra elegida.</strong>\n</html>");
        form_verCompraSeleccionada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form_verCompraSeleccionadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1)
                        .addGap(0, 148, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(form_comboVerComprasProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(form_comboVerComprasProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(form_realizarNuevaCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(form_verCompraSeleccionada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(form_comboVerComprasProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(form_comboVerComprasProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form_realizarNuevaCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(form_verCompraSeleccionada)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Borrar todos los elementos de la tabla
    private void deleteTableElements(){
        DefaultTableModel modelo2 = (DefaultTableModel) form_tablaCompras.getModel();        
        //Borrar los valores que ya existen, para no repetirlos en la tabla.
        if (modelo2.getRowCount() > 0) {
            for (int i = modelo2.getRowCount() - 1; i > -1; i--) {
                modelo2.removeRow(i);
            }
        }
    }
    
    //Evento cuando la ventana gana foco, completar la tabla con compras, el combo de productos y el de proveedores.
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        deleteTableElements();
        //Si no se mostraron los datos, cargarlos. Caso contrario se duplicarian los valores a mostrar cada vez que se gana el foco.
        if(!alreadyShowed){
            //Completar los combos de prod y prov.
            List<Proveedores> prov = null;
            List<Productos> prod = null;
            try {
                prov = ControladoraMedia.getProveedores();
                prod = ControladoraMedia.getProductos();
            } catch (StorageException ex) {
                Logger.getLogger(VistaCompras.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Error al cargar los combos de productos y proveedores.","Error Vista Compras: formWindowGainedFocus!!",JOptionPane.WARNING_MESSAGE);
            }
            if(prov != null && prod != null)
                completarCombo(prov,prod);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    //Funcion para completar los combobox con los valores de proveedores y productos.
    public void completarCombo(List<Proveedores> prov, List<Productos> prod){
        //Si los combos no tienen nada se completan.
        if(form_comboVerComprasProducto.getItemCount() <= 0 && form_comboVerComprasProveedor.getItemCount() <= 0){
            form_comboVerComprasProducto.addItem("Seleccionar...");
            form_comboVerComprasProveedor.addItem("Seleccionar...");
            for(Proveedores p : prov)
                form_comboVerComprasProveedor.addItem(p.getProveedor());
            for(Productos p : prod)
                form_comboVerComprasProducto.addItem(p.getProducto());
        }
        //Si no, se pone el item seleccionado al basico, ya que se activara cuando se gana el foco del form
        //ya sea porque se abrio el form o porque se volvio a este desde otro form.
        else{
            form_comboVerComprasProducto.setSelectedItem("Seleccionar...");
            form_comboVerComprasProveedor.setSelectedItem("Seleccionar...");
        }
    }
    
    //Boton para mostrar el form de agregar compra
    private void form_realizarNuevaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form_realizarNuevaCompraActionPerformed
        //Setear el bool para recargar los datos a falso.
        alreadyShowed = false;
        //Mostrar el nuevo formulario.
        AltaCompra compra = new AltaCompra(framePrincipal, rootPaneCheckingEnabled);
        compra.setVisible(true);
    }//GEN-LAST:event_form_realizarNuevaCompraActionPerformed

    //Boton para mostrar los datos de la compra seleccionada.
    private void form_verCompraSeleccionadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form_verCompraSeleccionadaActionPerformed
        //Setear el bool para recargar los datos a falso.
        alreadyShowed = false;
        if(form_tablaCompras.getSelectedRow() != -1){
            //Obtener el id de la compra seleccionada.
            String tablaID = (String) form_tablaCompras.getValueAt(form_tablaCompras.getSelectedRow(), 0);
            int IdCompraModificar = Integer.valueOf(tablaID);
            //Mostrar el nuevo formulario.
            VistaCompraSeleccionada mostrarCompra = new VistaCompraSeleccionada(framePrincipal, rootPaneCheckingEnabled,IdCompraModificar);
            mostrarCompra.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(null,"Seleccione la compra a mostrar.","Error!",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_form_verCompraSeleccionadaActionPerformed

    //Evento en el que se cambio el item seleccionado del combo producto.
    private void form_comboVerComprasProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_form_comboVerComprasProductoItemStateChanged
        String prodElegido = form_comboVerComprasProducto.getSelectedItem().toString();        
        //Habilitar la opcion de elegir proveedor.
        if(prodElegido.equals("Seleccionar..."))
            form_comboVerComprasProveedor.setEnabled(true);
        //Deshabilitar la opcion de elegir el proveedor si se elegio un producto y mostrar las compras del producto elegido.
        else
            form_comboVerComprasProveedor.setEnabled(false);
        completarTablaSegunProducto(prodElegido);
        
    }//GEN-LAST:event_form_comboVerComprasProductoItemStateChanged

    //Funcion para completar la tabla segun producto o proveedor.
    private void completarTablaSegunProducto(String producto){
        //Eliminar los valores de la tabla.
        deleteTableElements();
        //Obtener todas las compras.
        List<Compras> listaCompras = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            listaCompras = ControladoraCompras.getCompras(session);
        } catch (StorageException ex) {
            Logger.getLogger(VistaCompras.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al cargar las compras segun producto.","Error VistaCompras - completarTablaSegunProducto!",JOptionPane.WARNING_MESSAGE);
        }
        //Agregar los valores a la tabla segun el producto elegido.
        DefaultTableModel modelo = (DefaultTableModel) form_tablaCompras.getModel();
        for(Compras c : listaCompras){
            Iterator it = c.getDetalleses().iterator();
            while(it.hasNext()){
                Detalles d = (Detalles) it.next();
                String[] data = new String[5];
                //Si la compra tiene el producto elegido, agregar los detalles.
                if(d.getProductos().getProducto().equals(producto) || producto.equals("Seleccionar...")){
                    data[0] = c.getIdCompra().toString();
                    data[1] = c.getFecha().toString();
                    try {
                        data[2] = ControladoraProveedores.getProveedor(d.getProductos().getIdProveedor()).getProveedor();
                        } catch (StorageException ex) {
                            Logger.getLogger(VistaCompras.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null,"Error al intentar cargar el nombre del proveedor a la tabla.","Error Vista Compras: completarTablaSegunProducto!",JOptionPane.WARNING_MESSAGE);
                        }
                    data[3] = "$" + String.valueOf(d.getTotal() * d.getCantidad());
                    modelo.addRow(data);
                }
            }
        }
        form_tablaCompras.setModel(modelo);
    }
    
    //Evento en el que se cambio el item seleccionado del combo proveedor-
    private void form_comboVerComprasProveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_form_comboVerComprasProveedorItemStateChanged
        String provElegido = form_comboVerComprasProveedor.getSelectedItem().toString();        
        //Habilitar la opcion de elegir proveedor.
        if(provElegido.equals("Seleccionar..."))
            form_comboVerComprasProducto.setEnabled(true);
        //Deshabilitar la opcion de elegir el proveedor si se elegio un producto y mostrar las compras del producto elegido.
        else
            form_comboVerComprasProducto.setEnabled(false);
        completarTablaSegunProveedor(provElegido);
    }//GEN-LAST:event_form_comboVerComprasProveedorItemStateChanged

    //Funcion para completar la tabla segun producto o proveedor.
    private void completarTablaSegunProveedor(String proveedor){
        //Eliminar los valores de la tabla.
        deleteTableElements();
        //Obtener todas las compras.
        List<Compras> listaCompras = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            listaCompras = ControladoraCompras.getCompras(session);
        } catch (StorageException ex) {
            Logger.getLogger(VistaCompras.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al cargar las compras segun proveedor.","Error VistaCompras - completarTablaSegunProducto!",JOptionPane.WARNING_MESSAGE);
        }
        //Agregar los valores a la tabla segun el producto elegido.
        DefaultTableModel modelo = (DefaultTableModel) form_tablaCompras.getModel();
        for(Compras c : listaCompras){
            Iterator it = c.getDetalleses().iterator();
            while(it.hasNext()){
                Detalles d = (Detalles) it.next();
                String[] data = new String[5];
                //Obtener el proveedor de la compra.
                String proveedorAux = "";
                try {
                    proveedorAux = ControladoraProveedores.getProveedor(d.getProductos().getIdProveedor()).getProveedor();
                } catch (StorageException ex) {
                    Logger.getLogger(VistaCompras.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,"Error al intentar cargar el nombre del proveedor a la tabla.","Error Vista Compras: completarTablaSegunProducto!",JOptionPane.WARNING_MESSAGE);
                }
                //Si la compra es al proveedor elegido, mostrar el detalle.
                if(proveedorAux.equals(proveedor) || proveedor.equals("Seleccionar...")){
                    data[0] = c.getIdCompra().toString();
                    data[1] = c.getFecha().toString();
                    data[2] = proveedorAux;
                    data[3] = "$" + String.valueOf(d.getTotal() * d.getCantidad());
                    modelo.addRow(data);
                }
            }
        }
        form_tablaCompras.setModel(modelo);
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
            java.util.logging.Logger.getLogger(VistaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaCompras dialog = new VistaCompras(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox form_comboVerComprasProducto;
    private javax.swing.JComboBox form_comboVerComprasProveedor;
    private javax.swing.JButton form_realizarNuevaCompra;
    private javax.swing.JTable form_tablaCompras;
    private javax.swing.JButton form_verCompraSeleccionada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
