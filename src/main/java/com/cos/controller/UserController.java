package com.cos.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.cos.domain.User;
import com.cos.interceptors.SessionNames;
import com.cos.service.UserService;
import com.cos.vo.LoginVo;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/logout")
	public void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/logout 시작");
		session.removeAttribute(SessionNames.LOGIN);
		session.invalidate();
		
		Cookie loginCookie = WebUtils.getCookie(request, SessionNames.LOGIN_COOKIE);
		
		if (loginCookie != null) {
			loginCookie.setPath("/");
			loginCookie.setMaxAge(0);
			
			response.addCookie(loginCookie);
		}
	}
	
	@RequestMapping(value = "/loginPost")
	public void loginPost(LoginVo vo, Model model ) throws Exception {
		System.out.println("/loginpost 시작");
		User user =  service.login();
		if (user != null) {	// login fail
			model.addAttribute("user", user);
		}else {
			model.addAttribute("loginResult","Login Fail");
		}
	}
}
