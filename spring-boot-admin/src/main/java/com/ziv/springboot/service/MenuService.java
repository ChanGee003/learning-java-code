package com.ziv.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziv.springboot.bean.Menu;
import com.ziv.springboot.dao.MenuMapper;

@Service
public class MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	public List<Menu> queryAllMenu(){
		List<Menu> parentMenus = queryAllParentMenu();
		for(Menu menu:parentMenus){
			List<Menu> subMenus = querySubMenuByParentId(menu.getMenuId());
			menu.setSubMenu(subMenus);
		}
		return parentMenus;
	}
	
	public List<Menu> queryAllParentMenu(){
		return menuMapper.queryAllParentMenu();
	}
	
	public List<Menu> querySubMenuByParentId(Integer menuId){
		return menuMapper.querySubMenuByParentId(menuId);
	}
	
	
//	public List<MenuNode> queryNodesByRoleID(Integer roleID){
//		return menuNodeMapper.queryNodesByRoleID(roleID);
//	}
}
