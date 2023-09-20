package com.green.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.user.dao.UserDao;
import com.green.user.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private  SqlSession sqlSession;
	
	@Override
	public void insertUser(UserVo vo) {
		
		// sqlSession :Mybatis 라이브러리를 사용한다
		sqlSession.insert("User.UserInsert", vo);

	}
	
	/*
	@Autowired
	private DataSource dataSource;
	*/

	@Override
	public List<UserVo> getUserList() {
		
		/*
		Connection         conn  = null;
		PreparedStatement  pstmt = null;
		
		List<UserVo>    userList = new ArrayList<>();  
		try {		
	//		conn           = DriverManager.getConnection("", "", "");
			conn           = dataSource.getConnection();
			String     sql = "SELECT * FROM TUSER";
			pstmt          = conn.prepareStatement(sql);
			ResultSet  rs  = pstmt.executeQuery();
			while( rs.next() ) {
				String userid   = rs.getString("userid");
				String passwd   = rs.getString("passwd");
				String username = rs.getString("username");
				String email    = rs.getString("email");
				String indate   = rs.getString("indate");
				
				UserVo vo       = new UserVo();
				vo.setUserid(userid);
				vo.setPasswd(passwd);
				vo.setUsername(username);
				vo.setEmail(email);
				vo.setIndate(indate);
				
				userList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		*/ 
		
		List<UserVo>  userList =  sqlSession.selectList("User.getUserList");
		
		return userList;
	}

	@Override
	public UserVo getView(UserVo vo) {
		
		UserVo  user  =  sqlSession.selectOne("User.getUser", vo);
		//System.out.println("userDao : " + user);
		
		return  user;
	}

	@Override
	public void deleteUser(UserVo vo) {
		
		sqlSession.delete( "User.UserDelete", vo );
		
	}

	@Override
	public void updateUser(UserVo vo) {
						
		sqlSession.update("User.UserUpdate", vo);
		
	}

}





