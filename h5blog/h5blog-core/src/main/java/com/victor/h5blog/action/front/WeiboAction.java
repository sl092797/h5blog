package com.victor.h5blog.action.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victor.h5blog.entity.vo.CatlogVo;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.rss.RssParse;
import com.victor.h5blog.rss.Weibo;

@Controller
@RequestMapping("/front/weibo")
public class WeiboAction {
	@ResponseBody
	@RequestMapping(value = "/getWeibos.json", method = RequestMethod.POST)
	public JsonVo<List<Weibo>> getWeibos(
			HttpServletRequest request, ModelMap modelMap) {
		JsonVo<List<Weibo>> json = new JsonVo<List<Weibo>>();
		List<Weibo> wlist = RssParse.parseRss();
		json.setT(wlist);
		json.setResult(true);
		return json;
	}
}
