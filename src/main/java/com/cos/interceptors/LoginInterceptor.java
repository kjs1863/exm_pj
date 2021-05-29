package com.cos.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor, SessionNames {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if (session.getAttribute(LOGIN) != null) {
			session.removeAttribute(LOGIN);
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		
		Object user = modelAndView.getModelMap().get("user");
		if (user != null) {
			session.setAttribute(LOGIN, user);
			
			Cookie loginCookie = new Cookie(LOGIN_COOKIE,session.getId());
			loginCookie.setPath("/");
			loginCookie.setMaxAge(7*24*60*60);
			
			response.addCookie(loginCookie);
		}
		 
		String attempted = (String) session.getAttribute(ATTEMPTED);
		if ("".equals(attempted)) {
			response.sendRedirect(attempted);
			session.removeAttribute(ATTEMPTED);
		}
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
	}
}
