package com.victor.h5blog.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.PageDefAreaComDao;
import com.victor.h5blog.dao.PageDefDao;
import com.victor.h5blog.entity.PageDef;
import com.victor.h5blog.entity.PageDefAreaCom;
import com.victor.h5blog.entity.PageDefAreaComExample;
import com.victor.h5blog.entity.PageDefExample;

@Service
public class PageDefService {

	@Autowired
	private PageDefDao pageDefDao;
	
	@Autowired
	private PageDefAreaComDao pageDefAreaComDao;
	
	public List<PageDef> getPages(){
		PageDefExample example = new PageDefExample();
		return pageDefDao.selectByExample(example);
	}
	
	
	@Cacheable(value="pageDef")
	public PageDef getPageById(Long id) {
		return pageDefDao.selectByPrimaryKey(id);
	}

	@CacheEvict(value="pageDef",key="#page.getId()")
	public void updatePage(PageDef page) {
		pageDefDao.updateByPrimaryKey(page);
	}

	public void addPage(PageDef page) {
		pageDefDao.insert(page);
	}
	
	public List<PageDefAreaCom> getAreaCom(Long pageDefId, Long areaId){
		PageDefAreaComExample example = new PageDefAreaComExample();
		example.createCriteria().andDefIdEqualTo(pageDefId).andTplAreaIdEqualTo(areaId);
		return pageDefAreaComDao.selectByExample(example);
	}
	
	public void addAeraCom(PageDefAreaCom areaCom){
		pageDefAreaComDao.insert(areaCom);
	}
	
	public void updateAreaComDef(PageDefAreaCom areaCom){
		pageDefAreaComDao.updateByPrimaryKey(areaCom);
	}
	

	/**
	 * 根据角色获取页面信息
	 * 
	 * @param codeValue
	 * @return
	 */
	public ArrayList<PageDef> getPagesByAuthCode(String codeValue) {
		return pageDefDao.getPagesByAuthCode(codeValue);
	}

	/**
	 * 针对同一个页面多个角色进行处理
	 * 
	 * @param codeValue
	 * @return
	 */
	public ArrayList<String> getPagesByAuthRole(String codeValue) {
		ArrayList<String> urls = new ArrayList<String>();
		List<PageDef> pageList = getPages();
		for (PageDef page : pageList) {
			String authCode = page.getAuthCode();
			if (authCode == null) {
				authCode = "0";
			}
			if (authCode.equals(codeValue)) {
				String url = page.getUrl();
				urls.add(url);
			}
		}
		return urls;
	}
	
	@CacheEvict(value="pageDef",key="#id")
	public void deletePageDef(Long id){
		pageDefDao.deleteByPrimaryKey(id);
		PageDefAreaComExample pacExample = new PageDefAreaComExample();
		pacExample.createCriteria().andDefIdEqualTo(id);
		pageDefAreaComDao.deleteByExample(pacExample);
	}
}
