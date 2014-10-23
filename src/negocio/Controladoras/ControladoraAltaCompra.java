/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Controladoras;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import negocio.Entidades.Productos;
import negocio.Entidades.Proveedores;
import negocio.Forms.AltaCompra;
import javax.swing.JFormattedTextField;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import negocio.Entidades.Compras;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class ControladoraAltaCompra {
    
    public static boolean validarDatosAltaCompra(JComboBox producto,JComboBox proveedor, JTextField cantidad, JTextField precio){
        //Checkeo de valores correctos de las variables, retorna el boolean
        boolean error = false;
        if(producto.getSelectedItem().toString().equals("Seleccionar...")){
            JOptionPane.showMessageDialog(null,"Por favor, seleccione un producto a agregar en la compra.","Error!",JOptionPane.WARNING_MESSAGE);
            error = true;
        }
        if(proveedor.getSelectedItem().toString().equals("Seleccionar...")){
            JOptionPane.showMessageDialog(null,"Por favor, seleccione el proveedor del producto.","Error!",JOptionPane.WARNING_MESSAGE);
            error = true;
        }
        if(cantidad.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese la cantidad comprada del producto.","Error!",JOptionPane.WARNING_MESSAGE);
            error = true;
        }
        else{
            try{
                Integer.parseInt(cantidad.getText());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Por favor, ingrese un valor valido para la cantidad.","Error!",JOptionPane.WARNING_MESSAGE);
                error = true;
            }
        }
        if(precio.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese el precio del producto.","Error!",JOptionPane.WARNING_MESSAGE);
            error = true;
        }
        else{
            try{
                Float.parseFloat(precio.getText());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Por favor, ingrese un valor valido para el precio.","Error!",JOptionPane.WARNING_MESSAGE);
                error = true;
            }
        }
        return error;
    }
    
    //Funcion para completar los combobox con los valores de proveedores y productos.
    public static void completarComboBoxDeProductosYProveedores(JComboBox producto, JComboBox proveedores) {
        //Obtener todos los productos y proveedores.
        List<Proveedores> listaProveedores = null;
        List<Productos> listaProductos = null;
        try {
            listaProductos = ControladoraMedia.getProductos();
            listaProveedores = ControladoraMedia.getProveedores();
        } catch (StorageException ex) {
            Logger.getLogger(AltaCompra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al completar los combos de productos y proveedores.","Error!",JOptionPane.WARNING_MESSAGE);
        }
        //Completar los comboBox con los valores obtenidos anteriormente.
        producto.addItem("Seleccionar...");
        proveedores.addItem("Seleccionar...");
        for(Proveedores p : listaProveedores)
            proveedores.addItem(p.getProveedor());
        for(Productos p : listaProductos)
            producto.addItem(p.getProducto());
    }
    
    public static Date parsearFecha(JFormattedTextField fecha){
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = formatter.parse(fecha.getText());
        } catch (ParseException ex) {
            Logger.getLogger(AltaCompra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"La fecha ingresada no es valida, esta debe ser del formato: dd/MM/yyyy","Error!",JOptionPane.WARNING_MESSAGE);
        }
        return date;
    }
    
    public static Compras obtenerUltimaCompra(){
        Compras ultimaCompra = null;
        try {
            List<Compras> listaCompras = ControladoraCompras.getCompras();
            int ultimoAux = listaCompras.size() - 1;
            ultimaCompra = listaCompras.get(ultimoAux);
        } catch (StorageException ex) {
            JOptionPane.showMessageDialog(null,"Error al intentar obtener la ultima compra.","Error!",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(AltaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimaCompra;
    }
    
    public static Compras obtenerUltimaCompra(Session session){
        Compras ultimaCompra = null;
        try {
            List<Compras> listaCompras = ControladoraCompras.getCompras(session);
            int ultimoAux = listaCompras.size() - 1;
            ultimaCompra = listaCompras.get(ultimoAux);
        } catch (StorageException ex) {
            JOptionPane.showMessageDialog(null,"Error al intentar obtener la ultima compra.","Error!",JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(AltaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimaCompra;
    }
    
    public static void completarComboProductosSegunProveedor(JComboBox comboProductos,String proveedorACorroborar){
        //DefaultComboBoxModel model = (DefaultComboBoxModel) comboProductos.getModel();
        //model.removeAllElements();
        comboProductos.removeAllItems();
        try {
            List<Proveedores> listaProv = ControladoraMedia.getProveedores();
            List<Productos> listaProd = ControladoraMedia.getProductos();
            Proveedores auxProv = null;
            if(!proveedorACorroborar.equals("Seleccionar...")){
                for(Proveedores prov : listaProv){
                    if(prov.getProveedor().equals(proveedorACorroborar))
                        auxProv = prov;
                }
                for(Productos prod : listaProd){
                    if(auxProv.getIdProveedor() == prod.getIdProveedor())
                        comboProductos.addItem(prod.getProducto());
                }
            }
            else{
                comboProductos.addItem("Seleccionar...");
                for(Productos prod : listaProd)
                        comboProductos.addItem(prod.getProducto());
            }
        } catch (StorageException ex) {
            Logger.getLogger(ControladoraAltaCompra.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error al intentar completar el combo de productos segun el proveedor elegido.","Error!",JOptionPane.WARNING_MESSAGE);
        }
    }
}
