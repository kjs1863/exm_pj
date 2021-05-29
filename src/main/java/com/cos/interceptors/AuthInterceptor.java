package com.cos.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor, SessionNames {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if (session.getAttribute(LOGIN) == null) {
			String uri = request.getRequestURI();   	// /board/register
			String query = request.getQueryString();	// dfd=123
			
			if (!"".equals(query))
				uri += "?"+ query;
			
			session.setAttribute(ATTEMPTED, uri);
		}
		
		return true;
	}
}
