package com.iteasyup.myprj.service;

import org.springframework.stereotype.Service;

import com.iteasyup.myprj.controller.bean.SigninForm;
import com.iteasyup.myprj.controller.bean.SignupForm;
import com.iteasyup.myprj.dao.UserDao;
import com.iteasyup.myprj.dao.entity.UserEntity;
import com.iteasyup.myprj.service.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
	private final UserDao userDao;
	
	public User getUserByUsername(String username) {
		
		UserEntity userEntity = userDao.searchUserExitsByUsername(username);
		
		if(userEntity != null) {
			return new User(userEntity.getId(),
					        userEntity.getUsername(),
					        userEntity.getEmail(),
					        userEntity.getPassword());
		}
		return null;
	}
	
	public int addUser(SignupForm signupForm) {
		UserEntity userEntity  = 
				        new UserEntity(0,
				               signupForm.getUsername(),
				               signupForm.getEmail(),
				               signupForm.getPassword(),
				               null);
		
		int result = userDao.addUser(userEntity);
		
		return result;
	}
	
	public User signinByUsernameAndPassword(SigninForm signinForm) {
		
		UserEntity userEntity =
				userDao.searchUserByUsernameAndPassword(signinForm.getUsername(), signinForm.getPassword());
		
		if(userEntity != null) {
			return new User(userEntity.getId(),
					        userEntity.getUsername(),
					        userEntity.getEmail(),
					        userEntity.getPassword());
		}
		return null;
	}
}
