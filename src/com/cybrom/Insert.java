/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybrom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Insert 
{
    public static void main(String[] args)
    {
        Scanner sobjr=new Scanner(System.in);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/nov25","root","Badal@123");
            if(con!=null)
            {
                System.out.println("Connection Done");
                System.out.println("Enter Student id:-");
                int sid=sobjr.nextInt();
                sobjr.nextLine();
                System.out.println("Enter Student Name:-");
                String name=sobjr.nextLine();
                System.out.println("Enter Student Enroll:-");
                String enroll=sobjr.nextLine();
                System.out.println("Enter Student Hindi Marks:-");
                int h=sobjr.nextInt();
                System.out.println("Enter Student English Marks:-");
                int e=sobjr.nextInt();
                System.out.println("Enter Student Chemistry Marks:-");
                int c=sobjr.nextInt();
                System.out.println("Enter Student Physics Marks:-");
                int p=sobjr.nextInt();
                System.out.println("Enter Student Math Marks:-");
                int m=sobjr.nextInt();
                int total=h+e+c+p+m;
                float per=total/5.0f;
                String query="INSERT INTO student(sid,name,enroll,h,e,c,p,m,per,total)VALUES(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst=con.prepareStatement(query);
                pst.setInt(1,sid);
                pst.setString(2, name);
                pst.setString(3,enroll);
                pst.setInt(4, h);
                pst.setInt(5, e);
                pst.setInt(6, c);
                pst.setInt(7, p);
                pst.setInt(8, m);
                pst.setFloat(9, per);
                pst.setInt(10, total);
                int count=pst.executeUpdate();
                if(count!=0)
                {
                    System.out.println(count+" value Inserted");
                }
                else
                {
                    System.out.println("Faield To Insert");
                }
            }
            else
            {
                System.out.println("Connection Faield");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
