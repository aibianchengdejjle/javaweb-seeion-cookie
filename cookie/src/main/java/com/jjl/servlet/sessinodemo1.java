package com.jjl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class sessinodemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码问题

        req.setCharacterEncoding("UTF-8");
        //这个很重要
        resp.setContentType("text/html;charset=utf-8");
        //得到session
        HttpSession session = req.getSession();
        //存东西
        session.setAttribute("name","梁家杰");
        //获取session的id
        String id = session.getId();
        if(session.isNew()){
            resp.getWriter().write("sessino 创建成功");
        }else{
            resp.getWriter().write("已经存在"+id);
        }
    }
}
