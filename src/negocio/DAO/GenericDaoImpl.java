/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public abstract class GenericDaoImpl <T, PK extends Serializable> implements GenericDao <T, PK> {
    private final Class<T> type;
    protected final Session session;
    
    public Class<T> getType() {
        return type;
    }
    
    public GenericDaoImpl(Session session) {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.session = session;
    }
    
    @Override
    public PK add(T newInstance) {
        return (PK) session.save(newInstance);
    }
    
    @Override
    public T get(PK id) {
        return (T) session.get(getType(), id);
    }
    
    @Override
    public void update(T transientObject) {
        session.update(transientObject);
    }
    
    @Override
    public void delete(T persistentObject) {
        session.delete(persistentObject);
    }
}