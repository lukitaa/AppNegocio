/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Controladoras;

import java.util.List;
import negocio.DAO.ProductosDaoImpl;
import negocio.Entidades.Productos;
import negocio.Entidades.Proveedores;
import negocio.Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class ControladoraProductos extends ControladoraMedia {

    public static Productos agregarProducto(Proveedores proveedor,String producto,int stock, float precio) throws InvalidParameterException, StorageException {
        if (!validUsername(producto))
            throw new InvalidParameterException("El nombre del producto ingresado es invalido.");
        
        Productos p = new Productos(producto, stock,proveedor.getIdProveedor());
        p.setPrecio(precio);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            new ProductosDaoImpl(session).add(p);
            session.getTransaction().commit();
            session.close();
            return p;
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar guardar el producto.");
        }
    }
    
    public static void eliminarProducto(Productos proveedor) throws InvalidParameterException, StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            new ProductosDaoImpl(session).delete(proveedor);
            session.getTransaction().commit();
            session.close();
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar eliminar el producto.");
        }
    }
    
    public static Productos getProduct(int productoId) throws StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Productos p = new ProductosDaoImpl(session).get(productoId);
            session.getTransaction().commit();
            session.close();
            return p;
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar cargar el producto.");
        }
    }
    
    public static void updateProducto(Productos producto, String prod, int stock, float precio, Proveedores proveedor) throws StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            // Update user's attributes locally
            producto.setProducto(prod);
            producto.setStock(stock);
            producto.setPrecio(precio);
            producto.setIdProveedor(proveedor.getIdProveedor());
            // And now update the DB one
            new ProductosDaoImpl(session).update(producto);
            session.getTransaction().commit();
            session.close();
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar actualizar el producto.");
        }
    }
    
    //Estos metodos necesitan la session de hibernate como parametro
    //Utilizados para cuando es necesario acceder a cadenas de objetos
    public static List<Productos> getProductos(Session session) throws StorageException {
        try {
            session.beginTransaction();
            List<Productos> l = new ProductosDaoImpl(session).fetchAll();
            session.getTransaction().commit();
            return l;
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
        }
            throw new StorageException("Error al intentar cargar los productos.");
        }
    }
    
    public static Productos getProduct(int productoId,Session session) throws StorageException {
        try {
            session.beginTransaction();
            Productos p = new ProductosDaoImpl(session).get(productoId);
            session.getTransaction().commit();
            return p;
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar cargar el producto.");
        }
    }
}
