/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.praduman.dao;

import com.praduman.bean.StudentBean;
import com.praduman.utility.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class StudentDAO 
{
    Connection conn=null;
    public int addStudent(StudentBean sb)
    {
        int r=0;
        try
        {
            conn=ConnectionPool.connectDB();
            int TotalMarks=sb.getM()+sb.getH()+sb.getE()+sb.getP()+sb.getC();
            float Per=TotalMarks/5.0f;
            String query="INSERT INTO STUDENT(sid,name,enroll,m,h,e,p,c,per,total)VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setInt(1, sb.getSid());
            pst.setString(2,sb.getName());
            pst.setString(3,sb.getEnroll());
            pst.setInt(4,sb.getM());
            pst.setInt(5,sb.getH());
            pst.setInt(6,sb.getE());
            pst.setInt(7,sb.getP());
            pst.setInt(8,sb.getC());
            pst.setFloat(9,Per);
            pst.setInt(10,TotalMarks);
            r=pst.executeUpdate();
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
        return r;
    }
    
    // Here Code for data update Update
    public int updateStudent(StudentBean sb)
    {
        int r=0;
        try
        {
            conn=ConnectionPool.connectDB();
            int TotalMarks=sb.getM()+sb.getH()+sb.getE()+sb.getP()+sb.getC();
            float Per=TotalMarks/5.0f;
            String query="UPDATE STUDENT SET name=?,enroll=?,m=?,h=?,e=?,p=?,c=?,per=?,total=? WHERE sid=?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1,sb.getName());
            pst.setString(2,sb.getEnroll());
            pst.setInt(3,sb.getM());
            pst.setInt(4,sb.getH());
            pst.setInt(5,sb.getE());
            pst.setInt(6,sb.getP());
            pst.setInt(7,sb.getC());
            pst.setFloat(8,Per);
            pst.setInt(9,TotalMarks);
            pst.setInt(10,sb.getSid());
            r=pst.executeUpdate();
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
        return r;
    }
    
    // Here Code For Delete 
    public int deleteStudent(int sid)
    {
        int r=0;
        try
        {
            conn=ConnectionPool.connectDB();
            String query="DELETE FROM STUDENT WHERE sid=?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setInt(1,sid);
            r=pst.executeUpdate();
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
        return r;
    }
    
    // Here code for show all
    public ArrayList<StudentBean>findAll()
    {
        ArrayList<StudentBean> al=new ArrayList<>();
        try
        {
            conn=ConnectionPool.connectDB();
            String query="SELECT * FROM STUDENT";
            PreparedStatement pst=conn.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                StudentBean sbean=new StudentBean();
                sbean.setSid(rs.getInt("sid"));
                sbean.setName(rs.getString("name"));
                sbean.setEnroll(rs.getString("enroll"));
                sbean.setM(rs.getInt("m"));
                sbean.setH(rs.getInt("h"));
                sbean.setE(rs.getInt("e"));
                sbean.setP(rs.getInt("p"));
                sbean.setC(rs.getInt("c"));
                sbean.setPer(rs.getFloat("per"));
                sbean.setTotal(rs.getInt("total"));
                al.add(sbean);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return al;
    }
    // Find By Enroll
    public StudentBean findByEnroll(String enroll)
    {
        StudentBean sbean=new StudentBean();
        try
        {
            conn=ConnectionPool.connectDB();
            String query="SELECT * FROM STUDENT WHERE enroll=?";
            PreparedStatement pst=conn.prepareStatement(query);
            pst.setString(1,enroll);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                sbean.setSid(rs.getInt("sid"));
                sbean.setName(rs.getString("name"));
                sbean.setEnroll(rs.getString("enroll"));
                sbean.setM(rs.getInt("m"));
                sbean.setH(rs.getInt("h"));
                sbean.setE(rs.getInt("e"));
                sbean.setP(rs.getInt("p"));
                sbean.setC(rs.getInt("c"));
                sbean.setPer(rs.getFloat("per"));
                sbean.setTotal(rs.getInt("total"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sbean;
    }
    public static void main(String[] args)
    {
        StudentBean S=new StudentBean();
        S.setSid(106);
        S.setName("Rohan");
        S.setEnroll("0128CS213D01");
        S.setM(412);
        S.setH(822);
        S.setE(652);
        S.setP(452);
        S.setC(732);
        StudentDAO sd=new StudentDAO();
//        int x=sd.addStudent(S);
//        if(x!=0)
//        {
//            System.out.println(x+" Row Inserted Success.");
//        }
//        else
//        {
//           System.out.println(x+" Row Inserted Faield");
//        }
//           int x=sd.updateStudent(S);
//           if(x!=0)
//           {
//               System.out.println(x+" Row Updated Success.");
//           }
//           else
//           {
//               System.out.println(x+" Row Updated Faield.");
//           }
//             int x=sd.deleteStudent(106);
//             if(x!=0)
//             {
//                 System.out.println(x+" Row Deleted Success.");
//             }
//             else
//             {
//                 System.out.println(x+" Row Deleted Failed.");
//             }

//         Find All
         /*  ArrayList<StudentBean>all=sd.findAll();
           for(StudentBean x:all)
           {
               System.out.println(" "+x.getSid()+" "+x.getName()+" "+x.getEnroll()+" "+x.getM()+" "+x.getH()
               +" "+x.getE()+" "+x.getE()+" "+x.getP()+" "+x.getC()+" "+x.getPer()+" "+x.getTotal());
           }*/
          
           StudentBean sb=sd.findByEnroll("0128CS213D25");  
          System.out.println(sb.getSid()+" "+sb.getName()+" "+sb.getEnroll()+" "+
                sb.getM()+" "+sb.getH()+" "+sb.getE()+" "+sb.getP()+" "+sb.getC()+" "+
                sb.getPer()+" "+sb.getTotal());
          
    }
}
