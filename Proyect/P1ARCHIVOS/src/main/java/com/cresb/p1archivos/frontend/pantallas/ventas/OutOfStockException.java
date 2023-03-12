package com.cresb.p1archivos.frontend.pantallas.ventas;

/**
 *
 * @author benjamin
 */
public class OutOfStockException extends Exception {
    
    public OutOfStockException(){
        
    }
    
    public OutOfStockException(String format) {
        super(format);
    }
}
