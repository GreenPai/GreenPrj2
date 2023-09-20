package com.green.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.menu.service.MenuService;
import com.green.menu.vo.MenuVo;

@Controller
@RequestMapping("/Menus")
public class MenuController {

	@Autowired
	private  MenuService  menuService;
	
//	@RequestMapping("/Menus/List")
	@RequestMapping("/List")
	public  String list( Model model ) {
		
		List<MenuVo> menuList = menuService.getMenuList();
		//System.out.println("contr menuList:" + menuList);
		
		model.addAttribute("menuList", menuList);
		
		return "menus/list";
	}
	
	// /Menus/WriteForm : 메뉴 등록
	@RequestMapping("/WriteForm")
	public  String   writeForm() {
		
		return  "menus/write";				
	}
	
	// /Menus/Write
	@RequestMapping("/Write")
	public  String   write( MenuVo vo ) {
		
		menuService.insertMenu( vo );
		
		return "redirect:/Menus/List";		 
	}
	
	// /Menus/WriteForm2 : 메뉴 등록
	@RequestMapping("/WriteForm2")
	public  String   writeForm2() {
		
		return  "menus/write2";				
	}
	
	// /Menus/Write2
	@RequestMapping("/Write2")
	public String write2(MenuVo vo) {

		menuService.insertMenu2(vo);

		return "redirect:/Menus/List";
	}
		
	// /Menus/UpdateForm?menu_id=MENU01
	@RequestMapping("/UpdateForm")
	public  String  updateForm(MenuVo vo, Model model) {
		
		// 수정하기 위한 데이터 조회 : menu_id
		MenuVo  menuVo  =  	menuService.getMenu( vo );
		model.addAttribute("menuVo", menuVo);
		
		return  "menus/update";
	}
	
	// /Menus/Update
	@RequestMapping("/Update")
	public  String  update( MenuVo vo ) {
		
		menuService.updateMenu( vo );
		
		return  "redirect:/Menus/List";		
	} 
	
	// /Menus/Delete?menu_id=MENU01
	@RequestMapping("/Delete")
	public  String  delete( MenuVo vo ) {
		
		menuService.deleteMenu( vo );
		
		return  "redirect:/Menus/List";
		
	}
	
}
























