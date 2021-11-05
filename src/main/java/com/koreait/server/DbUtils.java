package com.koreait.server;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class DbUtils {

    public static Connection getCon() throws SQLException, ClassNotFoundException {
        final String URL = "jdbc:mysql://localhost:3308/test";
        final String USERNAME = "root";
        final String PASSWORD = "koreait";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        System.out.println("접속성공");
        return con;
    }

    public static void close(Connection con, PreparedStatement ps){
        if(ps!= null){
            try {
                ps.close();
            }catch (Exception e){}
        }
        if(con!= null){
            try {
                con.close();
            }catch (Exception e){}
        }
    }
    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        if(rs!= null){
            try {
                rs.close();
            }catch (Exception e){}
        }
        if(ps!= null){
            try {
                ps.close();
            }catch (Exception e){}
        }
        if(con!= null){
            try {
                con.close();
            }catch (Exception e){}
        }
    }
}
