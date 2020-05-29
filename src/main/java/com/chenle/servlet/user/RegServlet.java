package com.chenle.servlet.user;

import com.chenle.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String faculties = request.getParameter("faculties");
        String dormitory = request.getParameter("dormitory");
        String telephone = request.getParameter("telephone");
        String time = request.getParameter("time");

        //和数据库对比，调用业务层
        UserServiceImpl userService = new UserServiceImpl();
        boolean user = userService.increase(id,username,password,faculties,dormitory,telephone,time);//这里已经验证完成

        if (user != false){

            //代提示转发
            request.setAttribute("yes","注册成功，请登陆！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
            //重定向
            //response.sendRedirect(request.getContextPath()+"login.jsp");
        }else {
            response.sendRedirect(request.getContextPath()+"reg.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
