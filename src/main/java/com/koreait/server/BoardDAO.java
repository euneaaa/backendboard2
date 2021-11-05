package com.koreait.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    public static List<BoardVO> selBoardList(){
        List<BoardVO> list = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_board ORDER BY iboard DESC";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                BoardVO vo = new BoardVO();
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setRdt(rs.getString("rdt"));
                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        }return list;
    }

    public static int insBoard(BoardVO vo){
       int result = 0;
       Connection con = null;
       PreparedStatement ps = null;
       String sql = "INSERT INTO t_board (title, ctnt, writer) VALUES (?,?,?)";
       try {
           con= DbUtils.getCon();
           ps = con.prepareStatement(sql);
           ps.setString(1,vo.getTitle());
           ps.setString(2,vo.getCtnt());
           ps.setString(3,vo.getWriter());
           result = ps.executeUpdate();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           DbUtils.close(con, ps);
       }return result;
    }

    public static BoardVO selBoard(BoardVO vo){
        BoardVO param = new BoardVO();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_board WHERE iboard = ?";
        try {
            con= DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,vo.getIboard());
            rs = ps.executeQuery();
            if(rs.next()){
                param.setIboard(rs.getInt("iboard"));
                param.setTitle(rs.getString("title"));
                param.setCtnt(rs.getString("ctnt"));
                param.setWriter(rs.getString("writer"));
                param.setRdt(rs.getString("rdt"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con,ps,rs);
        }
        return param;
    }
}
