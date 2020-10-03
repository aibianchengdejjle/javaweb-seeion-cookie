package com.jjl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class sessiondemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这个是用来手动注销session的过期时间的
        HttpSession session = req.getSession();
        //讲名字为name的注销
        session.removeAttribute("name");
        session.invalidate();
    }
}
