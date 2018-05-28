package com.cr.insurance.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminLoginInterceptor implements HandlerInterceptor{

	 private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	        // TODO Auto-generated method stub

	        // 获取session
	        HttpSession session = request.getSession(true);
	        // 判断用户ID是否存在，不存在就跳转到登录界面
	        if (session.getAttribute("adminUser") == null) {
	            response.sendRedirect("/insurance/admin/index");
	            return false;
	        } else {
	            return true;
	        }
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	        // TODO Auto-generated method stub
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	        // TODO Auto-generated method stub
	    }

}
