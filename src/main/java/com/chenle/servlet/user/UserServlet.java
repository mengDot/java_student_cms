package com.chenle.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.chenle.pojo.User;
import com.chenle.service.user.UserService;
import com.chenle.service.user.UserServiceImpl;
import com.chenle.util.Constants;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method.equals("savepwd") && method!=null){
            this.gaim(request,response);
        }else if (method.equals("pwdmodify") && method!=null){
            this.pwdModify(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    //修改密码
    public void gaim(HttpServletRequest request, HttpServletResponse response){
        //从session中拿id；
        Object attribute = request.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = request.getParameter("newpassword");

        boolean flag = false;

        if (attribute != null && !StringUtils.isNullOrEmpty(newpassword)){
            UserService userService = new UserServiceImpl();
            flag = userService.gaimi(((User) attribute).getId(), newpassword);
            if (flag){
                request.setAttribute("message","修改密码成功！请重新登陆！");
                //密码修改完毕，移除当前session
                request.getSession().removeAttribute(Constants.USER_SESSION);
            }else {
                request.setAttribute("message","密码修改失败！");

            }
        }else {
            request.setAttribute("message","新密码设置有误！");
        }
        //转发
        try {
            request.getRequestDispatcher("pwdmodify.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //验证旧密码
    public void pwdModify(HttpServletRequest request, HttpServletResponse response){
        //从session中拿id；
        Object attribute = request.getSession().getAttribute(Constants.USER_SESSION);

        String oldpassword = request.getParameter("oldpassword");


        HashMap<String, String> resultMap = new HashMap<String, String>();

        if (attribute == null){  //session失效、过期等
            resultMap.put("result","sessionerror");
        }else if (StringUtils.isNullOrEmpty(oldpassword)){ //输入的密码为空
            resultMap.put("result","error");
        }else {
            String password = ((User) attribute).getPassword();
            if (oldpassword.equals(password)){
                resultMap.put("result","true");
            }else {
                resultMap.put("result","false");
            }
        }
        try {
            response.setContentType("application/json");
            PrintWriter writer = response.getWriter();
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
