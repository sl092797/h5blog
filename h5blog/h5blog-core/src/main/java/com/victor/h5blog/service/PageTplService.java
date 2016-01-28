package com.victor.h5blog.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.dao.PageTemplateAreaDao;
import com.victor.h5blog.dao.PageTemplateDao;
import com.victor.h5blog.entity.PageTemplate;
import com.victor.h5blog.entity.PageTemplateArea;
import com.victor.h5blog.entity.PageTemplateAreaExample;
import com.victor.h5blog.entity.PageTemplateExample;
import com.victor.h5blog.util.MediaUtils;

@Service
public class PageTplService {

	private static Logger logger = LoggerFactory
			.getLogger(PageTplService.class);

	@Autowired
	private PageTemplateDao pageTemplateDao;

	@Autowired
	private PageTemplateAreaDao pageTemplateAreaDao;

	public void initPageTpl() {
		String tplFolderPath = SystemConstant.LEGOO_CMS_ROOT + "/"
				+ SystemConstant.PAGE_TPL_FOLDER;
		List<File> files = new ArrayList<File>();
		File pageTplFolder = new File(tplFolderPath);
		MediaUtils.findTplFiles(pageTplFolder, files);
		for (File f : files) {
			String path = f.getAbsolutePath().replace("\\", "/");
			path = path.substring(path.indexOf(SystemConstant.PAGE_TPL_FOLDER));
			path = path.substring(path.indexOf("/") + 1);
			path = path.substring(0, path.lastIndexOf("."));
			PageTemplateExample example = new PageTemplateExample();
			example.createCriteria().andPathEqualTo(path);
			List<PageTemplate> pageTplList = pageTemplateDao
					.selectByExample(example);
			if (pageTplList == null || pageTplList.size() < 1) {
				PageTemplate pageTpl = new PageTemplate();
				pageTpl.setName(f.getName());
				pageTpl.setDesc(f.getName());
				pageTpl.setPath(path);
				pageTemplateDao.insert(pageTpl);

				Long pageTplId = pageTpl.getId();
				addArea(pageTplId, f.getAbsolutePath());
			} else {
				updateArea(pageTplList.get(0).getId(), f.getAbsolutePath());
			}

		}
	}

	public List<PageTemplate> getPageTemplateList() {
		PageTemplateExample example = new PageTemplateExample();
		return pageTemplateDao.selectByExample(example);
	}

	@Cacheable(value="pageTpl")
	public PageTemplate getPageTemplateById(Long id) {
		return pageTemplateDao.selectByPrimaryKey(id);
	}

	public void addPageTemplate(MultipartFile file, String name, String desc) {

		String fulpath = "";
		try {
			fulpath = MediaUtils.save(file, SystemConstant.PAGE_TPL_FOLDER);
		} catch (IOException e) {
			logger.error("", e);
		}
		String path = SystemConstant.PAGE_TPL_FOLDER + "/"
				+ file.getOriginalFilename();
		path = path.substring(path.indexOf("/") + 1);
		path = path.replace(MediaUtils.getFileExt(file.getOriginalFilename()),
				"");
		PageTemplate pageTpl = new PageTemplate();
		pageTpl.setName(name);
		pageTpl.setDesc(desc);
		pageTpl.setPath(path);

		pageTemplateDao.insert(pageTpl);

		Long pageTplId = pageTpl.getId();
		addArea(pageTplId, fulpath);

	}

	public void addArea(Long pageTplId, String path) {
		File file = new File(path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if (tempString.contains(SystemConstant.PAGE_TPL_AREA)) {
					int index = tempString
							.indexOf(SystemConstant.PAGE_TPL_AREA);
					String areaName = tempString.substring(index, index
							+ SystemConstant.PAGE_TPL_AREA.length() + 1);
					PageTemplateArea area = new PageTemplateArea();
					area.setPgTplId(pageTplId);
					area.setAreaName(areaName);
					pageTemplateAreaDao.insert(area);
				}
			}
			reader.close();
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

	@CacheEvict(value="pageTemplateArea",allEntries = true)
	public void updateArea(Long pageTplId, String path) {
		PageTemplateAreaExample example = new PageTemplateAreaExample();
		example.createCriteria().andPgTplIdEqualTo(pageTplId);
		List<String> areaNameList = pageTemplateAreaDao
				.selectAreaNameByExample(example);
		List<String> newAreaNameList = new ArrayList<String>();
		File file = new File(path);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				if (tempString.contains(SystemConstant.PAGE_TPL_AREA)) {
					int index = tempString
							.indexOf(SystemConstant.PAGE_TPL_AREA);
					String areaName = tempString.substring(index, index
							+ SystemConstant.PAGE_TPL_AREA.length() + 1);
					newAreaNameList.add(areaName);
					if (!areaNameList.contains(areaName)) {
						PageTemplateArea area = new PageTemplateArea();
						area.setPgTplId(pageTplId);
						area.setAreaName(areaName);
						pageTemplateAreaDao.insert(area);
					}

				}
			}
			reader.close();
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		for (String areaName : areaNameList) {
			if (!newAreaNameList.contains(areaName)) {
				PageTemplateAreaExample example2 = new PageTemplateAreaExample();
				example2.createCriteria().andPgTplIdEqualTo(pageTplId)
						.andAreaNameEqualTo(areaName);
				pageTemplateAreaDao.deleteByExample(example);
			}
		}
	}

	public List<PageTemplateArea> getAreaListByTplId(Long tplId) {
		PageTemplateAreaExample example = new PageTemplateAreaExample();
		example.createCriteria().andPgTplIdEqualTo(tplId);
		return pageTemplateAreaDao.selectByExample(example);
	}

	@Cacheable(value="pageTemplateArea")
	public List<PageTemplateArea> getAreaListByDefId(Long pageDefId, Long tplId) {
		Map<String, Long> param = new HashMap<String, Long>();
		param.put("pageDefId", pageDefId);
		param.put("tplId", tplId);
		return pageTemplateAreaDao.selectByPageDefKey(param);
	}

	@CacheEvict(value="pageTpl",key="#pageTpl.getId()")
	public void updatePageTpl(PageTemplate pageTpl) {
		pageTemplateDao.updateByPrimaryKey(pageTpl);
	}
}
