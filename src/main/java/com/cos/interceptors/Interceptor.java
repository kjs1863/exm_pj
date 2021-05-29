package com.cos.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cos.vo.Board;

public class Interceptor implements HandlerInterceptor  {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인터셉터 시작- preHandle");
		System.out.println("request.getRequestURL() : " + request.getRequestURL() );
		System.out.println("handler : " + handler);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		System.out.println("인터셉터 시작- postHandle");
		List<Board> list = (List)modelAndView.getModel().get("list");
		System.out.println("List.size : " + list.size());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		System.out.println("인터셉터 시작- afterCompletion");
		
	}
}