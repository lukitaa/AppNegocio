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
public class InvalidParameterException extends Exception {
    private Object parameter;
    
    public Object getParameter() {
        return this.parameter;
    }
    
    public InvalidParameterException(String message) {
        super(message);
    }
    
    public InvalidParameterException(String message, Object parameter) {
        this(message);
        this.parameter = parameter;
    }
}

