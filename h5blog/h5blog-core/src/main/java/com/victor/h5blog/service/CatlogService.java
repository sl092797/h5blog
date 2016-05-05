package com.victor.h5blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.CatlogMapper;
import com.victor.h5blog.entity.Catlog;
import com.victor.h5blog.entity.CatlogExample;

@Service
public class CatlogService {

	@Autowired
	private CatlogMapper catlogDao;
	
	public int insertCatlog(Catlog record){
		return catlogDao.insert(record);
	}
	
	public void updateById(Catlog record){
		catlogDao.updateByPrimaryKey(record);
	}
	
	public void deleteById(Long catlogId){
		catlogDao.deleteByPrimaryKey(catlogId);
	}
	
	public List<Catlog> selectByKey(String key){
		CatlogExample e = new CatlogExample();
		e.createCriteria().andCatlogKeyEqualTo(key);
		e.setOrderByClause("create_date DESC");
		return catlogDao.selectByExample(e);
	}
	
	public Catlog selectById(Long catlogId){
		return catlogDao.selectByPrimaryKey(catlogId);
	}
	
	public List<Catlog> findByFatherId(Long catlogId){
		CatlogExample e = new CatlogExample();
		e.createCriteria().andCatlogFatherIdEqualTo(catlogId);
		return catlogDao.selectByExample(e);
	}
}
