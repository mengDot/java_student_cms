package com.chenle.filter;

import com.chenle.pojo.User;
import com.chenle.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //过滤器，从session中获取用户
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);

        if (user == null){ //已被移除/未登录/注销
            response.sendRedirect("/error.jsp");
        }else {
            chain.doFilter(req,resp);
        }

    }

    public void destroy() {

    }
}
