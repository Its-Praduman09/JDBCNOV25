/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybrom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL
 */
public class Update 
{
    public static void main(String[] args) 
    {
       
        try // it take exception ClassNotFountException
       {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/nov25","root","Badal@123");
           if(con!=null)
           {
               System.out.println("Connection Done");
               int sid=103;
               int ssid=101;
               String name="Amarjeet Kumar";
               String query="UPDATE STUDENT SET sid=?,name=? WHERE sid=?";
               PreparedStatement pst=con.prepareStatement(query);
               pst.setInt(1, sid);
               pst.setString(2, name);
               pst.setInt(3, ssid);
               int count=pst.executeUpdate();
               if(count!=0)
               {
                   System.out.println(count+" Row Updated Success.");
               }
               else
               {
                   System.out.println(count+" Row Updated Faield.");
               }
               
           }
           else
           {
               System.out.println("Conection Failed");
           }
       }
        catch(Exception e)
        {
            e.getStackTrace();
        }
    }
}
