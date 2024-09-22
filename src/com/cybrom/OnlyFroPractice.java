/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybrom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class OnlyFroPractice 
{
    public static void main(String[] args)
    {
        try
        {// step 1:- Register The Driver
            Class.forName("com.mysql.jdbc.Driver");// java.lang.ClassNotFoundException
            // Create The Connection
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/nov25","root","Badal@123");
            if(con!=null)
            {
                System.out.println("Connection Done");
                int sid=102;
                String query="DELETE FROM student WHERE sid=?";
                PreparedStatement pst=con.prepareStatement(query);
                pst.setInt(1, sid);
                int count=pst.executeUpdate();
                if(count!=0)
                {
                    System.out.println(count+" Row Deleted Success");
                }
                else
                {
                    System.out.println(count+" Row Deleted Failed");
                }
                
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
    }
}
