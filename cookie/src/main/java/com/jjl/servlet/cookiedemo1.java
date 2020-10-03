package com.jjl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
//cookie 可以保存用户上一次访问的时间

public class cookiedemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 这样才能解决中文的乱码问题
        req.setCharacterEncoding("UTF-8");
        //这个很重要
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //cookie 从服务器拿到 服务器告诉客户端说我来过了
        Cookie[] cookies = req.getCookies();//说明可能有多个
        if(cookies.length>0){
            out.write("上一次的访问时间是");
            for (Cookie c:cookies
                 ) {
                //获取cookie的具体信息
                if(c.getName().equals("lastlogin")){
                    //获取cookid 的值 c.getValue() 是一长串的数字
                    long l = Long.parseLong(c.getValue());
                    Date date = new Date(l);
                    out.write(date.toLocaleString());

                }
            }
        }else {
            out.write("这是第一次访问");
        }
        //服务器给客户端一个cookie
        Cookie cookie = new Cookie("lastlogin",System.currentTimeMillis()+"");
        resp.addCookie(cookie);
    }
}
