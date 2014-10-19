/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Controladoras;


/**
 *
 * @author usuario
 */
public abstract class Controladora {
    
    static boolean emptyOrWhiteSpace(String s) {
        return (s == null || s.trim().isEmpty());
    }
    
    protected static boolean validName(String name) {
        final int minL = 3,
        maxL = 200,
        l = (name != null) ? name.length() : 0;
        return (!emptyOrWhiteSpace(name) && l >= minL && l <= maxL);
    }
    
    protected static boolean validUsername(String username) {
        final int minL = 3,
        maxL = 50,
        l = (username != null) ? username.length() : 0;
        return (!emptyOrWhiteSpace(username) && l >= minL && l <= maxL);
    }
    
    protected static boolean validPassword(String password) {
        final int minL = 3,
        maxL = 64500,
        l = (password != null) ? password.length() : 0;
        return (!emptyOrWhiteSpace(password) && l >= minL && l <= maxL);
    }
    
}
