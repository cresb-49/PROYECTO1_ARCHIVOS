package com.cresb.p1archivos.backend.database.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Abstract class to connect a database
 * @author Dango
 */
public abstract class RepositoryBase {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/electronichomes";
    private static final String USER = "postgres";
    private static final String PASS = "201931012";
    
    protected static Connection GetConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);
    }
}
