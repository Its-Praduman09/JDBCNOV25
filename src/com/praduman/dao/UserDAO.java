/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.praduman.dao;

import com.praduman.bean.UserBean;
import com.praduman.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class UserDAO 
{
    // User Registration 
   Connection conn; 
   public int registerUser(UserBean ub)
   {
       int r=0;
       try
       {
           conn=ConnectionPool.connectDB();
           String query="INSERT INTO USER(uid,name,email,username,password)VALUES(?,?,?,?,?)";
           PreparedStatement pst=conn.prepareStatement(query);
           pst.setInt(1,ub.getUid());
           pst.setString(2,ub.getName());
           pst.setString(3,ub.getEmail());
           pst.setString(4,ub.getUsername());
           pst.setString(5,ub.getPassword());
           r=pst.executeUpdate();
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       return r;
   }
   //  User Login
   
   public int loginCheck(String username,String password)
   {
       int id=0;
       try
       {
           conn=ConnectionPool.connectDB();
           String query="Select uid from user WHERE username='"+username+"' and password='"+password+"'";
           PreparedStatement pst=conn.prepareStatement(query);
           ResultSet rs=pst.executeQuery();
           if(rs.next())
           {
               id=rs.getInt("uid");
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       return id;
   }
    public static void main(String[] args) 
    {
        /*UserBean ub=new UserBean();
        ub.setUid(101);
        ub.setName("Praduman Kumar");
        ub.setEmail("praduman802213@gmail.com");
        ub.setUsername("Praduman@123");
        ub.setPassword("Badal@123");*/
        UserDAO ud=new UserDAO();
        /*int x=ud.registerUser(ub);
        if(x!=0)
        {
            System.out.println(x+" Row Inserted Success.");
        }
        else
        {
            System.out.println(x+" Row Inserted Faield.");
        }*/
        int x=ud.loginCheck("Praduman@123","Badal@123");
        if(x!=0)
        {
            System.out.println("Login Successfully");
        }
        else
        {
            System.out.println("Login Faield");
        }
    }
}
