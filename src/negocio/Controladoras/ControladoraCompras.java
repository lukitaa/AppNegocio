/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Controladoras;

import java.util.Date;
import java.util.List;
import java.util.Set;
import negocio.DAO.ComprasDaoImpl;
import negocio.Entidades.Compras;
import negocio.Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class ControladoraCompras extends ControladoraMedia {
    
    public static Compras agregarCompra(Date fecha, Set detalles) throws InvalidParameterException, StorageException {
        
        Compras p = new Compras(fecha, detalles);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            new ComprasDaoImpl(session).add(p);
            session.getTransaction().commit();
            session.close();
            return p;
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar guardar la compra.");
        }
    }
    
    public static Compras getCompra(int compraID) throws StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Compras p = new ComprasDaoImpl(session).get(compraID);
            session.getTransaction().commit();
            session.close();
            return p;
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar cargar la compra.");
        }
    }
    
    public static List<Compras> getCompras(Session session) throws StorageException{
        try {
            session.beginTransaction();
            List<Compras> l = new ComprasDaoImpl(session).fetchAll();
            session.getTransaction().commit();
            return l;
        } catch (HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error al intentar cargar las compras.");
        }
    }
    
    public static Compras getCompra(int compraID,Session session) throws StorageException {
        try {
            session.beginTransaction();
            Compras p = new ComprasDaoImpl(session).get(compraID);
            session.getTransaction().commit();
            return p;
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar cargar la compra.");
        }
    }
    
    public static void updateCompra(Compras compraModificar) throws StorageException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            // And now update the DB one
            new ComprasDaoImpl(session).update(compraModificar);
            session.getTransaction().commit();
            session.close();
        } catch(HibernateException e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
            }
            throw new StorageException("Error interno al intentar actualizar la compra.");
        }
    }
}




//ESTO VA A SER USADO PARA MOSTRAR LAS COMPRAS DE TAL FECHA A TAL OTRA
//from Compras where Fecha > '2014-10-19'   -> HQL QUERY 
//select compras0_.IdCompra as col_0_0_ from testing.compras compras0_ where (Fecha>'2014-10-19') -> SQL QUERY