package com.cos.service;

import org.springframework.stereotype.Service;

import com.cos.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User login() throws Exception {
		User user = new User();
		user.setUid("test1");
		user.setUname("홍길동");
		user.setUpw("1234");
		user.setUpoint(1);
		return user;
	}


	
}
