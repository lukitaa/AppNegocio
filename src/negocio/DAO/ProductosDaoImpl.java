/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.DAO;

import java.util.List;
import negocio.Entidades.Productos;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class ProductosDaoImpl extends GenericDaoImpl<Productos, Integer> implements ProductosDao {

    public ProductosDaoImpl(Session session) {
        super(session);
    }

    @Override
    public List<Productos> fetchAll() {
        String hql = "FROM Productos";
        return session.createQuery(hql).list();
    }
    
}
