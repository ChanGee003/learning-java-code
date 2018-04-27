package com.ziv.springboot.dao;

import java.util.List;

import com.ziv.springboot.bean.Menu;

public interface MenuMapper {

	public List<Menu> queryAllParentMenu();
	
	public List<Menu> querySubMenuByParentId(Integer menuId);
}
