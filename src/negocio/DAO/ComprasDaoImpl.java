/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.DAO;

import java.util.List;
import negocio.Entidades.Compras;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class ComprasDaoImpl extends GenericDaoImpl<Compras, Integer> implements ComprasDao {
    
    public ComprasDaoImpl(Session session) {
        super(session);
    }
    
    @Override
    public List<Compras> fetchAll() {
        String hql = "FROM Compras";
        return session.createQuery(hql).list();
    }
}
