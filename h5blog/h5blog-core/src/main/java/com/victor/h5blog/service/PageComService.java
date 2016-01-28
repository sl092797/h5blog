package com.victor.h5blog.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.dao.PageComDao;
import com.victor.h5blog.dao.PageComDefDao;
import com.victor.h5blog.dao.PageComValDao;
import com.victor.h5blog.dao.PageComVarDao;
import com.victor.h5blog.entity.PageCom;
import com.victor.h5blog.entity.PageComDef;
import com.victor.h5blog.entity.PageComDefExample;
import com.victor.h5blog.entity.PageComExample;
import com.victor.h5blog.entity.PageComVal;
import com.victor.h5blog.entity.PageComValExample;
import com.victor.h5blog.entity.PageComVar;
import com.victor.h5blog.entity.PageComVarExample;
import com.victor.h5blog.entity.vo.PageComDefVo;
import com.victor.h5blog.entity.vo.PageComValVo;
import com.victor.h5blog.entity.vo.PageComVarVo;
import com.victor.h5blog.entity.vo.PageComVo;
import com.victor.h5blog.util.MediaUtils;

/**
 * PageCompositeService CRUD PageComposite
 * 
 * @author shengli
 * @date 2015年11月17日
 */
@Service
public class PageComService {
	
	private static Logger logger = LoggerFactory
			.getLogger(PageComService.class);


	@Autowired
	private PageComDao pageComDao;
	@Autowired
	private PageComDefDao pageComDefDao;
	@Autowired
	private PageComVarDao pageComVarDao;
	@Autowired
	private PageComValDao pageComValDao;

	
	@Cacheable(value="pageCom")
	public PageCom selectPageComById(Long comId){
		return pageComDao.selectByPrimaryKey(comId);
	}
	
	@Cacheable(value="pageComDef")
	public PageComDef selectPageComDefById(Long comDefId){
		return pageComDefDao.selectByPrimaryKey(comDefId);
	}
	
	/**
	 * @Title: selectPageComVarById
	 * @Description: TODO
	 * @param id
	 * @return PageComVar
	 * @throws
	 */
	@Cacheable(value="pageComVar")
	public PageComVar selectPageComVarById(Long id) {
		return pageComVarDao.selectByPrimaryKey(id);
	}

	/**
	 * 
	 * @Title: selectPageComValVoByPageComValId
	 * @Description: TODO
	 * @param id
	 * @return PageComValVo
	 * @throws
	 */
	@Cacheable(value="pageComVal")
	public PageComValVo selectPageComValVoByPageComValId(Long id) {
		PageComValVo pcvv = new PageComValVo();
		PageComVal pcv = pageComValDao.selectByPrimaryKey(id);
		PageComVar pcvr = pageComVarDao.selectByPrimaryKey(pcv.getPgComVarId());
		pcvv.setPageComVar(pcvr);
		BeanUtils.copyProperties(pcv, pcvv);
		return pcvv;
	}
	

	/**
	 * @Title: selectPageComValByPageComDefAndPageComVar
	 * @Description: TODO
	 * @param pageComDefId
	 * @param pageComVarId
	 * @return PageComVal
	 * @throws
	 */
	public PageComVal selectPageComValByPageComDefAndPageComVar(
			Long pageComDefId, Long pageComVarId) {
		PageComValExample pcve = new PageComValExample();
		pcve.or().andPgComDefIdEqualTo(pageComDefId)
				.andPgComVarIdEqualTo(pageComVarId);
		return pageComValDao.selectByExample(pcve).size() > 0 ? pageComValDao
				.selectByExample(pcve).get(0) : new PageComVal();
	}
	
	/**
	 * select pageComposite
	 * 
	 * @return List<PageCom>
	 */
	public List<PageCom> findAllPageCom() {
		return pageComDao.selectByExample(new PageComExample());
	}

	/**
	 * select pageComposite define
	 * 
	 * @return List<PageComDefVo>
	 */
	public List<PageComDefVo> findAllPageComDef() {
		List<PageComDef> pcdlist = pageComDefDao
				.selectByExample(new PageComDefExample());
		List<PageComDefVo> pcdvlist = new ArrayList<PageComDefVo>();
		for (PageComDef pcd : pcdlist) {
			PageComDefVo pcdv = new PageComDefVo();
			PageCom pc = pageComDao.selectByPrimaryKey(pcd.getPgComId());
			pcdv.setPageCom(pc);
			BeanUtils.copyProperties(pcd, pcdv);
			pcdvlist.add(pcdv);
		}
		return pcdvlist;
	}
	
	/**
	 * select pageCompositeVariable by pageCompositeDefineId
	 * 
	 * @param pageComDefId
	 * @return List<PageComVarVo>
	 */
	public List<PageComVarVo> findPageComVarByPageComDefId(Long pageComDefId) {
		PageComDef pcd = pageComDefDao.selectByPrimaryKey(pageComDefId);
		PageComVarExample e = new PageComVarExample();
		e.or().andPgComIdEqualTo(pcd.getPgComId());
		List<PageComVar> pcvlist = pageComVarDao.selectByExample(e);
		List<PageComVarVo> pcvvlist = new ArrayList<PageComVarVo>();
		for (PageComVar pcv : pcvlist) {
			PageComVarVo pcvv = new PageComVarVo();
			PageComVal pcval = selectPageComValByPageComDefAndPageComVar(
					pageComDefId, pcv.getId());
			pcvv.setPageComVal(pcval);
			BeanUtils.copyProperties(pcv, pcvv);
			pcvvlist.add(pcvv);
		}
		return pcvvlist;
	}
	
	
	public List<PageComVal> findAllPageComValByPageComDefId(Long comDefId){
		List<PageComVal> pcvlist = new ArrayList<PageComVal>();
		List<PageComVarVo> pcvvlist = this.findPageComVarByPageComDefId(comDefId);
		for(PageComVarVo pcvv:pcvvlist){
			PageComVal pcv = this.selectPageComValByPageComDefAndPageComVar(comDefId, pcvv.getId());
			pcvlist.add(pcv);
		}
		return pcvlist;
	}
	
	
	public List<PageComDefVo> findPageComDefVoByCatlogId(Long catlogId){
		if(catlogId!=null&&catlogId == 0L){
			return findAllPageComDef();
		}
		PageComDefExample e = new PageComDefExample();
		if(catlogId == null){
			e.createCriteria().andCatlogIdIsNull();
		}else{
			e.createCriteria().andCatlogIdEqualTo(catlogId);
		}
		List<PageComDef> pcdlist = pageComDefDao.selectByExample(e);
		
		List<PageComDefVo> pcdvlist = new ArrayList<PageComDefVo>();
		for (PageComDef pcd : pcdlist) {
			PageComDefVo pcdv = new PageComDefVo();
			PageCom pc = pageComDao.selectByPrimaryKey(pcd.getPgComId());
			pcdv.setPageCom(pc);
			BeanUtils.copyProperties(pcd, pcdv);
			pcdvlist.add(pcdv);
		}
		return pcdvlist;
	}


	/**
	 * @Title: addPageCom
	 * @Description: TODO
	 * @param pageCom
	 * @return Long
	 * @throws
	 */
	@CacheEvict(value="pageCom",key="#pcVo.getId()")
	public Long addAndUpdatePageCom(PageComVo pcVo) {
		PageCom pc = new PageCom();
		BeanUtils.copyProperties(pcVo, pc);
		if(pc.getId()==null){
			return pageComDao.insert(pc);
		}else{
			pageComDao.updateByPrimaryKey(pc);
			return pc.getId();
		}
	}

	/**
	 * add PageCompositeDefine by PageCompositeId
	 * 
	 * @param pageComId
	 * @param userName
	 * @return PageComDef
	 */
	public PageComDef addPageComDefByPageComId(Long pageComId,String desc, String userName) {
		PageComDef record = new PageComDef();
		record.setDesc(desc);
		record.setCreateUser(userName);
		record.setCreateDate(new Date());
		record.setPgComId(pageComId);
		record.setAval(SystemConstant.PAGE_COMDEF_AVAL_FALSE);
		pageComDefDao.insert(record);
		return record;
	}


	
	
	


	/**
	 * @Title: addPageComVarByPageComId
	 * @Description: TODO
	 * @param pageComVarVo
	 * @param pcId
	 *            void
	 * @throws
	 */
	public void addPageComVarByPageComId(PageComVar pcv, Long pcId) {
		pcv.setPgComId(pcId);
		pageComVarDao.insert(pcv);
	}

	

	/**
	 * add or update PageCompositeValue
	 * 
	 * @param pageComValVo
	 * @param userName
	 */
//	@CacheEvict(value="pageComVal",key="#pageComValVo.getId()")
//	public void addAndUpdatePageComVal(PageComValVo pageComValVo,
//			String userName) {
//		PageComVal pcv = new PageComVal();
//		BeanUtils.copyProperties(pageComValVo, pcv);
//		if (pcv.getId() == null) {
//			pcv.setCreateUser(userName);
//			pcv.setCreateDate(new Date());
//			pageComValDao.insert(pcv);
//			PageComDef pcd = pageComDefDao.selectByPrimaryKey(pcv.getPgComDefId());
//			if (IsComDefAval(pcv.getPgComDefId())) {
//				pcd.setAval(SystemConstant.PAGE_COMDEF_AVAL_TRUE);
//			} else {
//				pcd.setAval(SystemConstant.PAGE_COMDEF_AVAL_FALSE);
//			}
//			pageComDefDao.updateByPrimaryKey(pcd);
//		} else {
//			pcv.setChangeUser(userName);
//			pcv.setChangeDate(new Date());
//			pageComValDao.updateByPrimaryKey(pcv);
//		}
//	}
	
	public void addPageComVal(PageComVal pcv){
		pageComValDao.insert(pcv);
		PageComDef pcd = pageComDefDao.selectByPrimaryKey(pcv.getPgComDefId());
		if (IsComDefAval(pcv.getPgComDefId())) {
			pcd.setAval(SystemConstant.PAGE_COMDEF_AVAL_TRUE);
		} else {
			pcd.setAval(SystemConstant.PAGE_COMDEF_AVAL_FALSE);
		}
		pageComDefDao.updateByPrimaryKey(pcd);
	}

	/**
	 * update PageCompositeValue
	 * 
	 * @param pageComVal
	 * @param userName
	 */
	@CacheEvict(value="pageComVal",key="#pcv.getId()")
	public void updatePageComVal(PageComVal pcv){
		pageComValDao.updateByPrimaryKey(pcv);
	}
	
	/**
	 * 
	 * @param file
	 * @param name
	 * @param desc
	 * @throws IOException 
	 */
	public void addPageComTpl(MultipartFile file, String name, String desc) throws IOException {

		String fulpath = "";
		try {
			fulpath = MediaUtils.save(file, SystemConstant.PAGE_COM_FOLDER);
		} catch (IOException e) {
			logger.error("", e);
		}
		String path = SystemConstant.PAGE_COM_FOLDER + "/"
				+ file.getOriginalFilename();
		path = path.substring(path.indexOf("/"));
		PageCom pageCom = new PageCom();
		pageCom.setName(name);
		pageCom.setDesc(desc);
		File srcFile = new File(fulpath);
		String content = FileUtils.readFileToString(srcFile, SystemConstant.ENCODEING);
		pageCom.setContext(content);
		pageCom.setFtlPath(path);

		pageComDao.insert(pageCom);

		Long pageComId = pageCom.getId();
		addCode(pageComId, fulpath);

	}
	
	@CacheEvict(value="pageComVar",key="#pageComId")
	public void addCode(Long pageComId, String path) {
		File file = new File(path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				List<String> codeList = getCodeList(tempString);
				for(String code : codeList){
					PageComVarExample example = new PageComVarExample();
					example.createCriteria().andPgComIdEqualTo(pageComId).andCodeEqualTo(code);
					List<PageComVar> comVarList = pageComVarDao.selectByExample(example);
					PageComVar comVar = null;
					if(comVarList == null || comVarList.size() < 1){
						comVar = new PageComVar();
						comVar.setCode(code);
						comVar.setPgComId(pageComId);
						pageComVarDao.insert(comVar);
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	
	public void updatePageComDef(PageComDef pageComDef){
		pageComDefDao.updateByPrimaryKey(pageComDef);
	}
	
	public void updatePageComVar(PageComVar record){
		pageComVarDao.updateByPrimaryKey(record);
	}
	
	public void changePageComDefCatlog(Long pageComDefId,Long catlogId){
		PageComDef pageComDef = pageComDefDao.selectByPrimaryKey(pageComDefId);
		pageComDef.setCatlogId(catlogId);
		pageComDefDao.updateByPrimaryKey(pageComDef);
	}
	
	@CacheEvict(value="pageComDef",key="#pageComDefId")
	public void deletePageComDefAndValById(Long pageComDefId){
		PageComDef pcd = this.selectPageComDefById(pageComDefId);
		List<PageComVal> pcvlist = this.findAllPageComValByPageComDefId(pageComDefId);
		List<Long> pcvIds = new ArrayList<Long>();
		for(PageComVal pcv:pcvlist){
			pcvIds.add(pcv.getId());
		}
		PageComValExample e = new PageComValExample();
		e.createCriteria().andIdIn(pcvIds);
		pageComValDao.deleteByExample(e);
		pageComDefDao.deleteByPrimaryKey(pageComDefId);
	}
	
	/**
	 * Initialize Page Component Template
	 */
	public void initPageTpl() {
		String tplFolderPath = SystemConstant.LEGOO_CMS_ROOT + "/"
				+ SystemConstant.PAGE_COM_FOLDER;
		List<File> files = new ArrayList<File>();
		File pageTplFolder = new File(tplFolderPath);
		MediaUtils.findTplFiles(pageTplFolder, files);
	}
	
	/**
	 * @Title: IsComDefAval
	 * @Description: TODO
	 * @param pageComDefId
	 * @return Boolean
	 * @throws
	 */
	public Boolean IsComDefAval(Long pageComDefId) {
		Boolean aval = true;
		PageComVarExample pcve = new PageComVarExample();
		pcve.or().andPgComIdEqualTo(pageComDefId);
		List<PageComVar> pcvlist = pageComVarDao.selectByExample(pcve);
		for (PageComVar pcv : pcvlist) {
			PageComVal pcvl = selectPageComValByPageComDefAndPageComVar(
					pageComDefId, pcv.getId());
			if (pcvl.getId() == null) {
				aval = false;
			}
		}
		return aval;
	}
	

	/**
	 * @Title: codeList
	 * @Description: TODO
	 * @param rawContext
	 * @return List<String>
	 * @throws
	 */
	public List<String> getCodeList(String rawContext) {
		Pattern p = Pattern.compile("\\$\\{(.*?)\\}");
		Matcher m = p.matcher(rawContext);
		List<String> codeList = new ArrayList<String>();
		while (m.find()) {
			codeList.add(m.group(1));
		}
		return codeList;
	}
	
}
