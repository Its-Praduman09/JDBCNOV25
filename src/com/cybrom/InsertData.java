/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybrom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class InsertData 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        // Register The Driver
        Class.forName("com.mysql.jdbc.Driver"); // cj
        // create the connection
        /*
        String url="jdbc:mysql://localhost/nov25"
;        */
 
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nov25","root","Badal@123");
        int sid=26;
        String name="Praduman Kumar";
        String enroll="0128CS213D26";
        int m=78;
        int h=56;
        int e=45;
        int p=98;
        int c=56;
        int total=m+h+e+p+c;
        float per=total/5.0f;
       String sql="INSERT INTO STUDENT VALUES('"+sid+"','"+name+"','"+enroll+"','"+m+"','"+h+"','"+e+"','"+p+"','"+c+"','"+per+"','"+total+"')";
        Statement stmt=con.createStatement();
        int count=stmt.executeUpdate(sql);
        if(count!=0)
        {
            System.out.println("Insert SuccessFully");
        }
        else
        {
            System.out.println("Insert Faield");
        }
        
    }
 
}
