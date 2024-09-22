/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.praduman.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ConnectionPool {
    static Connection conn;
    public static Connection connectDB() throws SQLException{
        try {
            //1. register the Driver
            Class.forName("com.mysql.jdbc.Driver");
            //2. Create the Connection
            String user="root";
            String password="Badal@123";
            String url="jdbc:mysql://localhost/nov25";
            conn=DriverManager.getConnection(url, user, password);
            System.out.println("Database connection success");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    public static void main(String[] args) throws SQLException {
        connectDB();
    }
}
