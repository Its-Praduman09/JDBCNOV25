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
public class ShowAll 
{
    public static void main(String[] args) 
    {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/nov25","root","Badal@123");
           if(con!=null)
           {
               System.out.println("Connection Done");
               String query="SELECT * FROM STUDENT";
               PreparedStatement pst=con.prepareStatement(query);
               ResultSet rst=pst.executeQuery(query);
               while(rst.next())
               {
                   System.out.println(rst.getInt("sid")+"  "+rst.getString("name")+"  "+rst.getString("enroll"));
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
