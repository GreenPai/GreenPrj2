package com.green.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.menu.dao.MenuDao;
import com.green.menu.service.MenuService;
import com.green.menu.vo.MenuVo;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private   MenuDao  menuDao;
	
	@Override
	public List<MenuVo> getMenuList() {
		
		List<MenuVo>  menuList = menuDao.getMenuList();
		return        menuList;
		
	}

	@Override
	public void insertMenu(MenuVo vo) {
		
		menuDao.insertMenu( vo );
		
	}

	@Override
	public MenuVo getMenu(MenuVo vo) {
		
		MenuVo  menuVo  =  menuDao.getMenu( vo );   		
		return  menuVo;
	}

	@Override
	public void updateMenu(MenuVo vo) {
		
		menuDao.updateMenu( vo );
		
	}

	@Override
	public void deleteMenu(MenuVo vo) {
		
		menuDao.deleteMenu( vo );
		
	}

	@Override
	public void insertMenu2(MenuVo vo) {
		
		menuDao.insertMenu2( vo );
		
	}

	@Override
	public String getMenu_name(String menu_id) {
		
		String  menu_name  =  menuDao.getMenu_name( menu_id ); 
		return  menu_name;
	}

}






