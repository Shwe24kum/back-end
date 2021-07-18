package com.cg.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.dao.UserRepo;
import com.cg.springboot.entity.User;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;

	@Override
	public void register(User user) {
		
		userRepo.save(user);
		
	}
	
	@Override
	public String signIn(User user) {
		
		Optional<User> data = userRepo.findByUserIdAndPasswordAndRole(user.getUserId(),user.getPassword(),user.getRole());
		if(data.isPresent()) {
			return "log in successful";
			
		}
		else {
			return "login failed";
		}
	}

}
