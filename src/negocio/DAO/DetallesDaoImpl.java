/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.DAO;

import java.util.List;
import negocio.Entidades.Detalles;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class DetallesDaoImpl extends GenericDaoImpl<Detalles, Integer> implements DetallesDao {

    public DetallesDaoImpl(Session session) {
        super(session);
    }
    
    @Override
    public List<Detalles> fetchAll() {
        String hql = "FROM Detalles";
        return session.createQuery(hql).list();
    }
    
    public void add(List<Detalles> details) {
        for (Detalles d : details)
        session.save(d);
    }
}