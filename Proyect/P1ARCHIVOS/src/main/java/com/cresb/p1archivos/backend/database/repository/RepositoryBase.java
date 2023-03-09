package com.cresb.p1archivos.backend.database.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dango
 */
public abstract class RepositoryBase {
    private static final String conectionString = "";
    
    public RepositoryBase(){}
    
    protected Connection GetConnection() throws SQLException{
        return DriverManager.getConnection(conectionString);
    }
}
