/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author DELL
 */
public class DBHelper {
     public static Connection makeConnection() throws /*ClassNotFoundException*/ NamingException, SQLException {
        
        //1. Get Context ở phía Server- JNDI(java naming directory interface)
        Context serverContext = new InitialContext();
        //2. Look up DataSource of Container\
        Context tomcatContext = (Context)serverContext.lookup("java:comp/env");
        //3. Look up Defined DS
        DataSource ds = (DataSource)tomcatContext.lookup("DB");
        //4. Open Connection
        Connection con = ds.getConnection();
        
        return con;
        
    }
    
}

