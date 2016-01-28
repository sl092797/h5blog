package com.victor.h5blog.action.ccb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.victor.h5blog.action.BaseAction;
import com.victor.h5blog.annotation.SystemControllerLog;
import com.victor.h5blog.entity.Ti;

/**
 * route for ccb
 * 
 * @author shengli
 * @date 2015年11月11日
 */
@Controller
@RequestMapping("/ccb")
public class CcbAction extends BaseAction {

	/**
	 * active
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/active.htm", method = RequestMethod.GET)
	@SystemControllerLog(description = "ccb")
	public String active(ModelMap modelMap) {
		modelMap.addAttribute("webTitle", "中国建设银行(亚洲) - 预付卡");
		modelMap.addAttribute("PublicKeyN", "1");
		modelMap.addAttribute("PublicKeyE", "1");
		modelMap.addAttribute("rsaPublicKeyN", "1");
		modelMap.addAttribute("rsaPublicKeyE", "1");
		modelMap.addAttribute("logoAlt", "China Construction Bank (Asia)");
		modelMap.addAttribute("userName", "userName");
		modelMap.addAttribute("pageName", "active");

		return "/template/ccb/pages/active";
	}
	
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	@SystemControllerLog(description = "ccb")
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("webTitle", "中国建设银行(亚洲) - 预付卡");
		
		return "/template/ccb/pages/active";
	}

	/**
	 * activeDate
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/activeDate.htm", method = RequestMethod.GET)
	@SystemControllerLog(description = "ccb")
	public String activeDate(ModelMap modelMap) {
		modelMap.addAttribute("webTitle", "中国建设银行(亚洲) - 预付卡");
		modelMap.addAttribute("PublicKeyN", "1");
		modelMap.addAttribute("PublicKeyE", "1");
		modelMap.addAttribute("rsaPublicKeyN", "1");
		modelMap.addAttribute("rsaPublicKeyE", "1");
		modelMap.addAttribute("logoAlt", "China Construction Bank (Asia)");
		modelMap.addAttribute("userName", "userName");
		modelMap.addAttribute("pageName", "activeDate");
		modelMap.addAttribute("activeDate", "2016年10月22日");

		return "/template/ccb/pages/activeDate";
	}

	/**
	 * badCard
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/badCard.htm", method = RequestMethod.GET)
	@SystemControllerLog(description = "ccb")
	public String badCard(ModelMap modelMap) {
		modelMap.addAttribute("webTitle", "中国建设银行(亚洲) - 预付卡");
		modelMap.addAttribute("PublicKeyN", "1");
		modelMap.addAttribute("PublicKeyE", "1");
		modelMap.addAttribute("rsaPublicKeyN", "1");
		modelMap.addAttribute("rsaPublicKeyE", "1");
		modelMap.addAttribute("logoAlt", "China Construction Bank (Asia)");
		modelMap.addAttribute("userName", "userName");
		modelMap.addAttribute("pageName", "badCard");

		return "/template/ccb/pages/badCard";
	}

	/**
	 * balQuery
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/balQuery.htm", method = RequestMethod.GET)
	@SystemControllerLog(description = "ccb")
	public String balQuery(ModelMap modelMap) {
		modelMap.addAttribute("webTitle", "中国建设银行(亚洲) - 预付卡");
		modelMap.addAttribute("PublicKeyN", "1");
		modelMap.addAttribute("PublicKeyE", "1");
		modelMap.addAttribute("rsaPublicKeyN", "1");
		modelMap.addAttribute("rsaPublicKeyE", "1");
		modelMap.addAttribute("logoAlt", "China Construction Bank (Asia)");
		modelMap.addAttribute("userName", "userName");
		modelMap.addAttribute("pageName", "balQuery");

		modelMap.addAttribute("balnce", "1024");

		return "/template/ccb/pages/balquery";
	}

	/**
	 * message
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/message.htm", method = RequestMethod.GET)
	@SystemControllerLog(description = "ccb")
	public String message(ModelMap modelMap) {
		modelMap.addAttribute("webTitle", "中国建设银行(亚洲) - 预付卡");
		modelMap.addAttribute("PublicKeyN", "1");
		modelMap.addAttribute("PublicKeyE", "1");
		modelMap.addAttribute("rsaPublicKeyN", "1");
		modelMap.addAttribute("rsaPublicKeyE", "1");
		modelMap.addAttribute("logoAlt", "China Construction Bank (Asia)");
		modelMap.addAttribute("userName", "userName");
		modelMap.addAttribute("pageName", "message");

		return "/template/ccb/pages/message";
	}

	/**
	 * suggest
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/suggest.htm", method = RequestMethod.GET)
	@SystemControllerLog(description = "ccb")
	public String suggest(ModelMap modelMap) {
		modelMap.addAttribute("webTitle", "中国建设银行(亚洲) - 预付卡");
		modelMap.addAttribute("PublicKeyN", "1");
		modelMap.addAttribute("PublicKeyE", "1");
		modelMap.addAttribute("rsaPublicKeyN", "1");
		modelMap.addAttribute("rsaPublicKeyE", "1");
		modelMap.addAttribute("logoAlt", "China Construction Bank (Asia)");
		modelMap.addAttribute("userName", "userName");
		modelMap.addAttribute("pageName", "suggest");

		return "/template/ccb/pages/suggest";
	}

	/**
	 * tradeQuery
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/tradeQuery.htm", method = RequestMethod.GET)
	@SystemControllerLog(description = "ccb")
	public String tradeQuery(ModelMap modelMap) {
		modelMap.addAttribute("webTitle", "中国建设银行(亚洲) - 预付卡");
		modelMap.addAttribute("PublicKeyN", "1");
		modelMap.addAttribute("PublicKeyE", "1");
		modelMap.addAttribute("rsaPublicKeyN", "1");
		modelMap.addAttribute("rsaPublicKeyE", "1");
		modelMap.addAttribute("logoAlt", "China Construction Bank (Asia)");
		modelMap.addAttribute("userName", "userName");
		modelMap.addAttribute("pageName", "tradeQuery");



		Ti ti = new Ti();
		ti.setAmtTrans("20");
		ti.setCurrTrans("10");
		ti.setShopName("麦当劳");
		ti.setTranDesc("餐饮消费");
		ti.setWorkDate("2015年10月25日");

		List<Ti> tis = new ArrayList<Ti>();
		tis.add(ti);

		modelMap.addAttribute("tis", tis);
		return "/template/ccb/pages/tradeQuery";
	}
}
