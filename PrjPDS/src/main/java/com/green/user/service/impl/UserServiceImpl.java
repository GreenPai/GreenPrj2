package com.green.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.user.dao.UserDao;
import com.green.user.service.UserService;
import com.green.user.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private  UserDao  userDao;
	
	@Override
	public void insertUser(UserVo vo) {
		
		userDao.insertUser( vo );

	}

	@Override
	public List<UserVo> getUserList() {
		
		List<UserVo>  userList  =  userDao.getUserList(); 
		return    userList;
	}

	@Override
	public UserVo getView(UserVo vo) {
		
		UserVo  user = userDao.getView(vo);
		
		return  user;
	}

	@Override
	public void deleteUser(UserVo vo) {
		
		userDao.deleteUser( vo );
		
	}

	@Override
	public void updateUser(UserVo vo) {
		
		userDao.updateUser( vo );
		
	}



}












