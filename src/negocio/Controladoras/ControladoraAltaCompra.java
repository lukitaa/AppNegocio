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
import negocio.Entidades.Compras;

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
    public static void completarComboBoxDeProductosYProveedores(JComboBox producto, JComboBox proveedores) throws StorageException{
        //Obtener todos los productos y proveedores.
        List<Proveedores> listaProveedores = null;
        List<Productos> listaProductos = null;
        try {
            listaProductos = ControladoraMedia.getProductos();
            listaProveedores = ControladoraMedia.getProveedores();
        } catch (StorageException ex) {
            throw new StorageException("Error al intentar cargar los productos y proveedores en el combo.");
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
            int ultimoAux = listaCompras.lastIndexOf(listaCompras);
            ultimaCompra = listaCompras.get(ultimoAux);
        } catch (StorageException ex) {
            Logger.getLogger(AltaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimaCompra;
    }
    
    public static void completarComboProveedoresSegunProducto(JComboBox comboProveedores,String productoACorroborar){
        comboProveedores.removeAllItems();
        try {
            List<Proveedores> listaProv = ControladoraMedia.getProveedores();
            List<Productos> listaProd = ControladoraMedia.getProductos();
            Productos auxProd = null;
            for(Productos prod : listaProd){
                if(prod.getProducto().equals(productoACorroborar))
                    auxProd = prod;
            }
            for(Proveedores prov : listaProv){
                if(auxProd.getIdProveedor() == prov.getIdProveedor())
                    comboProveedores.addItem(prov.getProveedor());
            }
        } catch (StorageException ex) {
            Logger.getLogger(ControladoraAltaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void completarComboProductosSegunProveedor(JComboBox comboProductos,String proveedorACorroborar){
        comboProductos.removeAllItems();
        try {
            List<Proveedores> listaProv = ControladoraMedia.getProveedores();
            List<Productos> listaProd = ControladoraMedia.getProductos();
            Proveedores auxProv = null;
            for(Proveedores prov : listaProv){
                if(prov.getProveedor().equals(proveedorACorroborar))
                    auxProv = prov;
            }
            for(Productos prod : listaProd){
                if(auxProv.getIdProveedor() == prod.getIdProveedor())
                    comboProductos.addItem(prod.getProducto());
            }
        } catch (StorageException ex) {
            Logger.getLogger(ControladoraAltaCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
