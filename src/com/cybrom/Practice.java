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
public class Practice 
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
                int sid=102;
                String name="Ankit Kumar";
                String enroll="0128CS213D05";
                int m=64;
                int h=66;
                int e=61;
                int p=89; 
                int c=49;
                int total=m+h+e+p+c;
                float per=total/5.0f;
                String query="INSERT INTO STUDENT(sid,name,enroll,m,h,e,p,c,per,total)VALUES(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst=con.prepareStatement(query);
                pst.setInt(1, sid);
                pst.setString(2, name);
                pst.setString(3, enroll);
                pst.setInt(4, m);
                pst.setInt(5, h);
                pst.setInt(6, e);
                pst.setInt(7, p);
                pst.setInt(8, c);
                pst.setFloat(9, per);
                pst.setInt(10, total);
                int count=pst.executeUpdate();
                if(count!=0)
                {
                    System.out.println(count+" Value Inserted Success.");
                }
                else
                {
                    System.out.println(count+" Value Inserted Faield.");
                }
            }
            else
            {
                System.out.println("Connection Failed");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
