package com.green.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.user.service.UserService;
import com.green.user.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private  UserService   userService;
	
	// 회원목록조회	 /User/List
	@RequestMapping("/User/List")
	public  String  list( Model model  ) {
		
		// db 조회 정보가지고 온다
		List<UserVo>  userList = userService.getUserList();
		//System.out.println("cont userList:" + userList);
		model.addAttribute( "userList" , userList);
		
		return  "user/list";  // /WEB-INF/views/user/list.jsp
	}
	
	//회원가입  /User/WriteForm
	@RequestMapping("/User/WriteForm")
	public  String  writeform() {
		return  "user/write";  // /WEB-INF/views/  user/write  .jsp
	}
	
	//회원가입 -> 저장  /User/Write
	//String userid, String passwd, String username, String email
	@RequestMapping("/User/Write")
	public  String  write(	UserVo  vo ) {
		
		//System.out.println(vo.toString());
		
		// 회원정보저장
		userService.insertUser(vo);					
		
		return "redirect:/User/List";   // 목록 조회
	}
	/*
	@RequestMapping("/User/Write")
	public  String  write(	UserVo  vo, Model model ) {
		
		//System.out.println(vo.toString());
		
		// 회원정보저장
		userService.insertUser(vo);					
		
		// 저장된 목록 새로 조회
		List<UserVo> userList =  userService.getUserList();
		model.addAttribute("userList", userList );
		
		return "user/list";   // 목록 조회
	}
	*/
	
	// 회원정보보기   /User/View?userid=bbb
	@RequestMapping("/User/View")
	public  String   view( UserVo vo, Model model ) {
	 //  public  String   view( String userid ) {
		
		UserVo user = userService.getView( vo );
		model.addAttribute("user", user);
		
		return  "user/view";    // user/view.jsp
	}
	
	// 회원삭제  // /User/Delete
	@RequestMapping("/User/Delete/{userid}")
	public   String   delete(  
		//@PathVariable   String  userid
	    UserVo vo	
		) {
				
		userService.deleteUser( vo );
		
		return "redirect:/User/List";
	}
	
	// 회원정보 수정 /User/UpdateForm?userid=kkk
	@RequestMapping("/User/UpdateForm")
	public  String   updateForm(UserVo vo, Model model) {
		
		// 수정할 정보를 조회한다
		UserVo  userVo  =  userService.getView(vo);
		model.addAttribute( "user", userVo );
		
		return  "user/update";
	}
	// 수정 정보 저장
	@RequestMapping("/User/Update")
	public  String   update( UserVo vo  ) {
		
		System.out.println(vo);
		
		userService.updateUser( vo );
		
		return "redirect:/User/List";
	}
}
















