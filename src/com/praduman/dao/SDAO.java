/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.praduman.dao;

import com.praduman.bean.StudentBean;
import com.praduman.utility.ConnectionDone;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL
 */
public class SDAO 
{
    Connection conn=null;
    public int insertData(StudentBean sb)
    {
        int r=0;
        try
        {
            conn=ConnectionDone.connectDB();
            int Total_Marks=sb.getM()+sb.getH()+sb.getE()+sb.getP()+sb.getC();
            float Per=Total_Marks/5.0f;
            String query="INSERT INTO STUDENT(sid,name,enroll,m,h,e,p,c,per,total)VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setInt(1,sb.getSid());
            pst.setString(2,sb.getName());
            pst.setString(3,sb.getEnroll());
            pst.setInt(4,sb.getM());
            pst.setInt(5,sb.getH());
            pst.setInt(6,sb.getE());
            pst.setInt(7,sb.getP());
            pst.setInt(8,sb.getC());
            pst.setFloat(9,Per);
            pst.setInt(10, Total_Marks);
            r=pst.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return r; 
    }
    public static void main(String[] args) 
    {
        StudentBean s=new StudentBean();
        s.setSid(106);
        s.setName("Bablu Kumar");
        s.setEnroll("0128CS213D69");
        s.setM(45);
        s.setH(88);
        s.setE(55);
        s.setP(91);
        s.setC(95);
        SDAO sd=new SDAO();
        int x=sd.insertData(s);
        if(x!=0)
        {
            System.out.println(x+" Row Inserted Success.");
        }
        else
        {
            System.out.println(x+" Row Inserted Failed");
        }
    }
}
