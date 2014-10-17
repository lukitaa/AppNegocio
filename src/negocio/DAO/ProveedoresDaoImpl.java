/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.DAO;

import java.util.List;
import negocio.Entidades.Proveedores;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class ProveedoresDaoImpl extends GenericDaoImpl<Proveedores, Integer> implements ProveedoresDao {
    
    public ProveedoresDaoImpl(Session session) {
        super(session);
    }
    
    @Override
    public List<Proveedores> fetchAll() {
        String hql = "FROM Proveedores";
        return session.createQuery(hql).list();
    }
}
