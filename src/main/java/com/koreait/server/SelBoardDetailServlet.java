package com.koreait.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/one")
public class SelBoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String sIboard = req.getParameter("iboard");
        int iboard = Integer.parseInt(sIboard);

        Gson gson = new Gson();
        BoardVO vo = new BoardVO();
        vo.setIboard(iboard);
        BoardVO result = BoardDAO.selBoard(vo);
        String json = gson.toJson(result);
        res.setContentType("text/plain;charset=UTF-8");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.print(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
