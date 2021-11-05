package com.koreait.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ins")
public class InsBoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String json = Utils.getJson(req);
        Gson gson = new Gson();
        BoardVO param = gson.fromJson(json,BoardVO.class);

        int result = BoardDAO.insBoard(param);
        String resultJson = String.format("{\"result\":%d}");

//        ResultVO resultVO = new ResultVO();
//        resultVO.setResult(result);
//        String resultJson = gson.toJson(resultVO);

        PrintWriter out = res.getWriter();
        out.print(resultJson);
    }
}
