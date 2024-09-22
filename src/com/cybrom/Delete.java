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
public class Delete
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
                int sid=25;
                String query="DELETE FROM STUDENT WHERE sid=?";
                PreparedStatement pst=con.prepareStatement(query);
                pst.setInt(1, sid);
                int count=pst.executeUpdate();
                if(count!=0)
                {
                    System.out.println(count+" Row Delete Success.");
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
