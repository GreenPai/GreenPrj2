package com.green.menu.dao;

import java.util.List;

import com.green.menu.vo.MenuVo;

public interface MenuDao {

	List<MenuVo> getMenuList();

	void insertMenu(MenuVo vo);

	MenuVo getMenu(MenuVo vo);

	void updateMenu(MenuVo vo);

	void deleteMenu(MenuVo vo);

	void insertMenu2(MenuVo vo);

	String getMenu_name(String menu_id);

}
