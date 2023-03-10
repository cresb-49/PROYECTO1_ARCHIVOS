package com.cresb.p1archivos.backend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Dango
 */
public class DateManagment {
       
    public DateManagment(){
        
    }
    
    /**
     * Retorna un long con el formato de fecha y hora ddMMYYHHmmssSSS
     * 
     * @return
     */
    public String getIdDateTime() {
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMYYHHmmssSSS");
        String result = datetime.format(formatter);
        return result;
    }

    /**
     * Retorna un cadena con el formato de fecha y hora "YYYY-MM-dd HH:mm:ss"
     * 
     * @return
     */
    public String currentDateTime() {
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        return datetime.format(formatter);
    }
    
    public Date currentDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }
}
