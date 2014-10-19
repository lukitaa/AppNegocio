/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Controladoras;

import java.util.Date;
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
}
