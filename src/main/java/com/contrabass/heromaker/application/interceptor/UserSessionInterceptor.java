package com.contrabass.heromaker.application.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserSessionInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session =request.getSession();
        Object obj=session.getAttribute("loginCheck");

        if(obj ==null){
            response.sendRedirect("content/login"); //로그인 할수 있는 페이지로 이동
            return false;
        }

        return true;
    }
}
