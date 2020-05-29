package com.chenle.servlet.user;

import com.chenle.pojo.User;
import com.chenle.service.user.UserServiceImpl;
import com.chenle.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    //servlet控制层，调用业务层代码
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取用户名和密码
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        //和数据库对比，调用业务层
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(id, password);//这里已经验证完成

        if (user != null){
            //将用户放入session中
            request.getSession().setAttribute(Constants.USER_SESSION,user);
            //重定向
            response.sendRedirect(request.getContextPath()+"jsp/frame.jsp");
        }else {
            //转发回登陆页面，并提示 error
            request.setAttribute("error","学号或密码错误！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
