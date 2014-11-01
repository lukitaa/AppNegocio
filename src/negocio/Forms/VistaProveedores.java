/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Forms;

import java.awt.Frame;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import negocio.Controladoras.ControladoraProveedores;
import negocio.Controladoras.InvalidParameterException;
import negocio.Controladoras.StorageException;
import negocio.Entidades.Proveedores;

/**
 *
 * @author usuario
 */
public class VistaProveedores extends javax.swing.JDialog {

    Frame framePrincipal = null;
    static Proveedores proveedorModificar = null;
    /**
     * Creates new form ABMProveedores
     */
    public VistaProveedores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //Centrar el form en la pantalla.
        this.setLocationRelativeTo(null);
        
        //Tener al Frame padre guardado para usar.
        framePrincipal = parent;
        
        //Seteo de los valores de las filas de la tabla en el centro
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i=0; i<form_tablaProveedores.getColumnCount();i++){
            form_tablaProveedores.setDefaultRenderer(form_tablaProveedores.getColumnClass(i),renderer);
        }
        //Seteo de los valores de las cabezeras de la tabla en el centro
        DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer) form_tablaProveedores.getTableHeader().getDefaultRenderer();
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
        form_botonAgregar = new javax.swing.JButton();
        form_botonModificar = new javax.swing.JButton();
        form_botonEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        form_tablaProveedores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Alta - Baja - Modificacion de Proveedores");

        form_botonAgregar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        form_botonAgregar.setText("Agregar proveedor");
        form_botonAgregar.setToolTipText("<html> \t\n\t<strong>Realizar el alta de un proveedor.</strong> \n</html>");
        form_botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form_botonAgregarActionPerformed(evt);
            }
        });

        form_botonModificar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        form_botonModificar.setText("Modificar proveedor");
        form_botonModificar.setToolTipText("<html>\n\t<strong>Modificar los datos de un proveedor.</strong>\n</html>");
        form_botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form_botonModificarActionPerformed(evt);
            }
        });

        form_botonEliminar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        form_botonEliminar.setText("Eliminar proveedor");
        form_botonEliminar.setToolTipText("<html>\n\t<strong>Eliminar el proveedor elegido.</strong>\n</html>");
        form_botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                form_botonEliminarActionPerformed(evt);
            }
        });

        form_tablaProveedores.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        form_tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Proveedor", "Proveedor", "Telefono", "Mail"
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
        jScrollPane1.setViewportView(form_tablaProveedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(form_botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(form_botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(form_botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(form_botonModificar)
                    .addComponent(form_botonEliminar)
                    .addComponent(form_botonAgregar))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Boton para abrir el form de alta de proveedores
    private void form_botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form_botonAgregarActionPerformed
        AltaProveedor alta = new AltaProveedor(framePrincipal, rootPaneCheckingEnabled);
        alta.setVisible(true);
    }//GEN-LAST:event_form_botonAgregarActionPerformed
    
    //Boton para eliminar el proveedor seleccionado
    private void form_botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form_botonEliminarActionPerformed
        Proveedores p = obtenerProveedorSeleccionado(form_tablaProveedores);
        if(p != null){
            try {
                ControladoraProveedores.eliminarProveedor(p);
                JOptionPane.showMessageDialog(null,"El proveedor ha sido eliminado correctamente.","Eliminar proveedor",JOptionPane.PLAIN_MESSAGE);
            } catch (InvalidParameterException | StorageException ex) {
                Logger.getLogger(VistaProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            JOptionPane.showMessageDialog(null,"Debes seleccionar el proveedor a eliminar.","Alerta error",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_form_botonEliminarActionPerformed
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        refreshDataTable();
    }//GEN-LAST:event_formWindowGainedFocus

    //Boton para modificar el proveedor seleccionado.
    private void form_botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_form_botonModificarActionPerformed
        proveedorModificar = obtenerProveedorSeleccionado(form_tablaProveedores);
        if(proveedorModificar != null){
            ModificarProveedor modificar = new ModificarProveedor(framePrincipal, rootPaneCheckingEnabled);
            modificar.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(null,"Debes seleccionar el proveedor a modificar.","Alerta error",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_form_botonModificarActionPerformed

    //Funcion para obtener el proveedor seleccionado de la tabla.
    public Proveedores obtenerProveedorSeleccionado(JTable tabla){
        Proveedores p = null;
        if(form_tablaProveedores.getSelectedRow() != -1){
            try {
                List<Proveedores> prov = null;
                int filaElegida = form_tablaProveedores.getSelectedRow();
                prov = ControladoraProveedores.getProveedores();
                p = prov.get(filaElegida);
            } catch (StorageException ex) {
                Logger.getLogger(VistaProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p;
    }
    
    public void refreshDataTable(){
        //Borrar los valores que ya existen, para no repetirlos en la tabla.
        DefaultTableModel modelo = (DefaultTableModel) form_tablaProveedores.getModel();
        if (modelo.getRowCount() > 0) {
            for (int i = modelo.getRowCount() - 1; i > -1; i--) {
                modelo.removeRow(i);
            }
        }
        //Volver a imprimir todos los datos en la tabla.
        List<Proveedores> prov = null;
        try {
            prov = ControladoraProveedores.getProveedores();
            for(Proveedores p : prov){
                String[] data = new String[4];
                data[0] = p.getIdProveedor().toString();
                data[1] = p.getProveedor();
                data[2] = p.getTelefono();
                data[3] = p.getMail();
                modelo.addRow(data);
            }
            form_tablaProveedores.setModel(modelo);
        } catch (StorageException ex) {
            Logger.getLogger(VistaProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(VistaProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaProveedores dialog = new VistaProveedores(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton form_botonAgregar;
    private javax.swing.JButton form_botonEliminar;
    private javax.swing.JButton form_botonModificar;
    private javax.swing.JTable form_tablaProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
