package com.victor.h5blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.LeftMenuDao;
import com.victor.h5blog.entity.LeftMenu;
import com.victor.h5blog.entity.LeftMenuExample;

@Service
public class LeftMenuService {
	
	@Autowired
	private LeftMenuDao leftMenuDao;
	
	public List<LeftMenu> findLeftMenu(String key){
		LeftMenuExample example = new LeftMenuExample();
		example.createCriteria().andKeyEqualTo(key);
		example.setOrderByClause("MENU_ORDER");
		return leftMenuDao.selectByExample(example);
	}
	
	public List<LeftMenu> findAllLeftMenu(){
		LeftMenuExample example = new LeftMenuExample();
		return leftMenuDao.selectByExample(example);
	}
	
	public LeftMenu getLeftMenuById(Long menuId){
		return leftMenuDao.selectByPrimaryKey(menuId);
	}
	
	public void updateMenu(LeftMenu menu){
		leftMenuDao.updateByPrimaryKey(menu);
	}
	
	public void addMenu(LeftMenu menu){
		leftMenuDao.insert(menu);
	}
	
	public void deleteMenu(Long menuId){
		leftMenuDao.deleteByPrimaryKey(menuId);
	}
	
	
}
