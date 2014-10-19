/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Controladoras;

import negocio.DAO.DetallesDaoImpl;
import negocio.Entidades.Compras;
import negocio.Entidades.Detalles;
import negocio.Entidades.Productos;
import negocio.Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class ControladoraDetalles extends ControladoraMedia {
    
    public static Detalles agregarDetalle(Compras compras, Productos producto, float total, int cantidad) throws InvalidParameterException, StorageException {
        
        Detalles p = new Detalles(compras, producto, total, cantidad);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            new DetallesDaoImpl(session).add(p);
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
    
}
