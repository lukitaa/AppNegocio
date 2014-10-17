/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.DAO;

import java.util.List;
import negocio.Entidades.Detalles;

/**
 *
 * @author usuario
 */
public interface DetallesDao extends GenericDao<Detalles, Integer> {
    List<Detalles> fetchAll();
}