package com.jjl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class sessiondemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        //这个很重要
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        System.out.println(name);
    }
}
