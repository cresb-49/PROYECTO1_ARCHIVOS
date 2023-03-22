package com.cresb.p1archivos.frontend.pantallas.admin;

/**
 *
 * @author benjamin
 */
public class EmptyDataException extends Exception {
    
    public EmptyDataException(){
        
    }
    
    public EmptyDataException(String mensaje) {
        super(mensaje);
    }
    
}
