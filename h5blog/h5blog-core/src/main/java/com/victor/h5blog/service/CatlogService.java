package com.victor.h5blog.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.CatlogDao;
import com.victor.h5blog.entity.Catlog;
import com.victor.h5blog.entity.CatlogExample;
import com.victor.h5blog.entity.PageDef;

/**
 * 
 * @author 立
 *
 */
@Service
public class CatlogService {
	private static Logger logger = LoggerFactory
			.getLogger(CatlogService.class);
	
	@Autowired
	private CatlogDao catlogDao;
	
	public List<Catlog> findCatlogByType(long type){
		CatlogExample e = new CatlogExample();
		e.createCriteria().andTypeEqualTo(type);
		List<Catlog> clist = catlogDao.selectByExample(e);
		return clist;
	}
	
	public void addCatlog(Catlog catlog) {
		catlogDao.insert(catlog);
	}
	
	public Catlog selectCatlogById(long id){
		return catlogDao.selectByPrimaryKey(id);
	}
	
	public int updateCatlog(Catlog record){
		return catlogDao.updateByPrimaryKey(record);
	}
	
	public int deletCatlog(long id){
		return catlogDao.deleteByPrimaryKey(id);
	}
	
	public List<Catlog> findChildren(long id){
		CatlogExample e = new CatlogExample();
		e.createCriteria().andFatherIdEqualTo(id);
		List<Catlog> catloglist = catlogDao.selectByExample(e);
		return catloglist;
	}
}
