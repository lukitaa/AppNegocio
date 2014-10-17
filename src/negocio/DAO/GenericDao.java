/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.DAO;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public interface GenericDao <T, PK extends Serializable> {
    PK add(T newInstance);
    T get(PK id);
    void update(T transientObject);
    void delete(T persistentObject);
}
