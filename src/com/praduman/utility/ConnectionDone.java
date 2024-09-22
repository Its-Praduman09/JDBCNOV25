/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.praduman.utility;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class ConnectionDone 
{
    static Connection con;
    public static Connection connectDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/nov25","root","Badal@123");
            if(con!=null)
            {
                System.out.println("Connection Done");
            }
            else
            {
                System.out.println("Connection Faield");
            }
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
        return con;
    }
    public static void main(String[] args)
    {
        connectDB();
    }
}
