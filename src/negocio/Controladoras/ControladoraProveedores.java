/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Controladoras;

import java.util.Set;
import negocio.DAO.ProveedoresDaoImpl;
import negocio.Entidades.Proveedores;
import negocio.Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class ControladoraProveedores extends ControladoraMedia {
    
    public static Proveedores agregarProveedor(String proveedor,String telefono, String mail,Set productos) throws InvalidParameterException, StorageException {
        if (!validUsername(proveedor))
            throw new InvalidParameterException("El nombre del proveedor ingresado es invalido.");
        if (!validUsername(telefono))
            throw new InvalidParameterException("El numero de telefono ingresado es invalido.");
        if (!validUsername(mail))
            throw new InvalidParameterException("El mail ingresado es invalido.");
        
        Proveedores p = new Proveedores(proveedor, telefono, mail,productos);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            new ProveedoresDaoImpl(session).add(p);
            session.getTransaction().commit();
            session.close();
            return p;
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar guardar el proveedor.");
        }
    }
    
    public static void eliminarProveedor(Proveedores proveedor) throws InvalidParameterException, StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            new ProveedoresDaoImpl(session).delete(proveedor);
            session.getTransaction().commit();
            session.close();
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar eliminar el proveedor.");
        }
    }

    public static Proveedores getProveedor(int proveedorId) throws StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Proveedores p = new ProveedoresDaoImpl(session).get(proveedorId);
            session.getTransaction().commit();
            session.close();
            return p;
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar cargar el proveedor.");
        }
    }
    
    public static void updateProveedor(Proveedores proveedor, String nombre, String telefono, String mail) throws StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            // Update user's attributes
            proveedor.setProveedor(nombre);
            proveedor.setTelefono(telefono);
            proveedor.setMail(mail);
            new ProveedoresDaoImpl(session).update(proveedor);
            session.getTransaction().commit();
            session.close();
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar actualizar el proveedor.");
        }
    }
}
