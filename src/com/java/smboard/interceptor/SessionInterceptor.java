package com.java.smboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SessionInterceptor extends HandlerInterceptorAdapter{   
	@Override
	public boolean preHandle(HttpServletRequest request , HttpServletResponse response, Object handler) throws Exception {  
		// check variable
		Object userId = request.getSession().getAttribute("userId");  
		
		// pass through when access login.do, join.do
		if(request.getRequestURI().equals("/Spring_Board/login.do") || request.getRequestURI().equals("/Spring_Board/member/join.do")){
			if(userId != null){  
				response.sendRedirect(request.getContextPath() + "/board/list.do");
				return true;
			} else {
				return true;
			}
		}
	
		// where other pages		
		if(userId == null){  
			response.sendRedirect(request.getContextPath() + "/login.do");
			return false;
		} else {
			return true;
		}
		//		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}