package com.green.menu.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.menu.dao.MenuDao;
import com.green.menu.vo.MenuVo;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private  SqlSession  sqlSession;
	
	@Override
	public List<MenuVo> getMenuList() {
		
		List<MenuVo> menuList = sqlSession.selectList("Menus.MenuList");
		
		return       menuList;
	}

	@Override
	public void insertMenu(MenuVo vo) {
		
		sqlSession.insert("Menus.MenuInsert", vo);
		
	}

	@Override
	public MenuVo getMenu(MenuVo vo) {
		
		MenuVo  menuVo  =  sqlSession.selectOne("Menus.getMenu", vo);
		return  menuVo;
	}

	@Override
	public void updateMenu(MenuVo vo) {
		
		sqlSession.update("Menus.UpdateMenu", vo);
		
	}

	@Override
	public void deleteMenu(MenuVo vo) {
		
		sqlSession.delete("Menus.DeleteMenu", vo);
		
	}

	@Override
	public void insertMenu2(MenuVo vo) {
		
		sqlSession.insert("Menus.MenuInsert2", vo);
		
	}

	@Override
	public String getMenu_name(String menu_id) {
		
		String  menu_name =  sqlSession.selectOne("Menus.MenuName", menu_id);  
		return  menu_name;
	}

}











