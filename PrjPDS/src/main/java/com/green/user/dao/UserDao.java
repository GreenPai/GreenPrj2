package com.green.user.dao;

import java.util.List;

import com.green.user.vo.UserVo;

public interface UserDao {

	void insertUser(UserVo vo);

	List<UserVo> getUserList();

	UserVo getView(UserVo vo);

	void deleteUser(UserVo vo);

	void updateUser(UserVo vo);

}
