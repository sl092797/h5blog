/**
 * 
 */
package com.victor.h5blog.composite;

import static freemarker.template.ObjectWrapper.BEANS_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.entity.PageComDef;
import com.victor.h5blog.entity.PageComVal;
import com.victor.h5blog.entity.vo.ArticleVo;
import com.victor.h5blog.entity.vo.FolderVo;
import com.victor.h5blog.exception.FolderNotFoundException;
import com.victor.h5blog.plugin.TagPlugin;
import com.victor.h5blog.service.ArticleService;
import com.victor.h5blog.service.PageComService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * @author shengli
 * @date 2015年11月26日
 */
@Service
public class BaseComposite extends TagPlugin{
	
	@Autowired
	private PageComService pageComService;
	
	
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 获取组件的参数
		Long pageComDefId = Long.parseLong(params.get("pageComDefId").toString());
		List<PageComVal> pcvlist = pageComService.findAllPageComValByPageComDefId(pageComDefId);
		// 设置组件的参数
		for(PageComVal pcv:pcvlist){
			env.setVariable(pcv.getPgComCode(), BEANS_WRAPPER.wrap(pcv.getPgComValue()));
		}

		body.render(env.getOut());
	}

	public static void main(String[] args) {
		String rawContext = "<img width=\"${width}\" height=\"${height}\" src=\"${url}\" >";
		Map<String, String> codeMap = new HashMap<String, String>();
		codeMap.put("${url}", "abc");
		codeMap.put("${width}", "100px");
		codeMap.put("${height}", "100px");
	}
}
