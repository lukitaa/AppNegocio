/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Controladoras;

import java.util.List;
import negocio.DAO.ComprasDaoImpl;
import negocio.DAO.DetallesDaoImpl;
import negocio.DAO.ProductosDaoImpl;
import negocio.DAO.ProveedoresDaoImpl;
import negocio.Entidades.Compras;
import negocio.Entidades.Detalles;
import negocio.Entidades.Productos;
import negocio.Entidades.Proveedores;
import negocio.Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public abstract class ControladoraMedia extends Controladora {
    
    public static List<Productos> getProductos() throws StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Productos> l = new ProductosDaoImpl(session).fetchAll();
            session.getTransaction().commit();
            session.close();
            return l;
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
        }
            throw new StorageException("Error al intentar cargar los productos.");
        }
    }
   
    public static List<Proveedores> getProveedores() throws StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Proveedores> l = new ProveedoresDaoImpl(session).fetchAll();
            session.getTransaction().commit();
            session.close();
            return l;
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
        }
        throw new StorageException("Error al intentar cargar los proveedores.");
        }
    }
    
    public static List<Compras> getCompras() throws StorageException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Compras> l = new ComprasDaoImpl(session).fetchAll();
            session.getTransaction().commit();
            session.close();
            return l;
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
        }
        throw new StorageException("Error al intentar cargar las compras.");
        }
    }
    
    public static List<Detalles> getDetalles() throws StorageException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<Detalles> l = new DetallesDaoImpl(session).fetchAll();
            session.getTransaction().commit();
            session.close();
            return l;
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
        }
        throw new StorageException("Error al intentar cargar los detalles.");
        }
    }
}
