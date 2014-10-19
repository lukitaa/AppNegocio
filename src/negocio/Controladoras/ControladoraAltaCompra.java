/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Controladoras;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import negocio.Entidades.Productos;
import negocio.Entidades.Proveedores;

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
}
