package com.victor.h5blog.action.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.victor.h5blog.constant.ConfigConstant;
import com.victor.h5blog.entity.Headline;
import com.victor.h5blog.entity.vo.HeadlineVo;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.exception.UploadException;
import com.victor.h5blog.service.ConfigService;
import com.victor.h5blog.service.TemplateService;
import com.victor.h5blog.util.SSUtils;

@RequestMapping("/manage/headline")
@Controller
public class ManageHeadlineAction extends ManageBaseAction {

	@Autowired
	private ConfigService configService;

	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(ModelMap modelMap, HttpServletRequest request) {
		List<HeadlineVo> headlineList = headlineService.getHeadlineList();
		String homeName = configService
				.getStringByKey(ConfigConstant.LEGOO_TEMPLATE);
		modelMap.put("headlineList", headlineList);
		modelMap.put("homeName", homeName);
		return "manage/headline/list";
	}

	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String add(ModelMap modelMap, HttpServletRequest request) {
		int width = configService.getIntKey("shishuo_headline_image_width");
		int height = configService.getIntKey("shishuo_headline_image_height");
		modelMap.put("width", width);
		modelMap.put("height", height);
		return "manage/headline/add";
	}

	@RequestMapping(value = "/update/{headlineId}.htm", method = RequestMethod.GET)
	public String update(@PathVariable long headlineId, ModelMap modelMap,
			HttpServletRequest request) {
		Headline headline = headlineService.getHeadlineById(headlineId);
		modelMap.put("headline", headline);
		return "manage/headline/update";
	}

	@ResponseBody
	@RequestMapping(value = "/addHome.json", method = RequestMethod.POST)
	public JsonVo<String> addHome(HttpServletRequest request, HttpServletResponse response) {
		JsonVo<String> json = new JsonVo<String>();
		String url = request.getParameter("homeName");
		if (!url.equals("")) {
			configService
					.updagteConfigByKey(ConfigConstant.LEGOO_TEMPLATE, url);
		}
		json.setResult(true);
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public JsonVo<String> upload(
			@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "url") String url, HttpServletRequest request) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			headlineService.addHeadline(file, SSUtils.toText(name),
					SSUtils.toText(url));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (UploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		json.setResult(true);
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public JsonVo<String> update(
			@RequestParam(value = "headlineId") long headlineId,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "url") String url,
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			headlineService.updateHeadlineById(headlineId,
					SSUtils.toText(name), file, SSUtils.toText(url));
		} catch (UploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		json.setResult(true);
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public JsonVo<String> deleteFile(
			@RequestParam(value = "headlineId") long headlineId) {
		JsonVo<String> json = new JsonVo<String>();
		HeadlineVo headline = headlineService.getHeadlineById(headlineId);
		headlineService.deleteHeadline(headlineId, headline.getPicture());
		json.setResult(true);
		return json;
	}

	/**
	 * @author 目录排序
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/sort.json", method = RequestMethod.POST)
	public JsonVo<String> sort(@RequestParam(value = "sortJson") String sortJson) {
		JsonVo<String> json = new JsonVo<String>();
		JSONArray array = JSONArray.fromObject(sortJson);
		for (int i = 0; i < array.size(); i++) {
			JSONObject headline = array.getJSONObject(i);
			String headlineId = headline.get("headlineId").toString();
			String sort = headline.get("sort").toString();
			headlineService.updateSortById(Long.parseLong(headlineId),
					Integer.parseInt(sort));
		}
		json.setResult(true);
		return json;
	}
}
