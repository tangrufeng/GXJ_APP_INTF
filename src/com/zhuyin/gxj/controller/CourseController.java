package com.zhuyin.gxj.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuyin.gxj.common.Common;
import com.zhuyin.gxj.entity.ResultListBean;
import com.zhuyin.gxj.service.CourseService;
import com.zhuyin.gxj.service.UserService;

/**
 * Created by Tom on 16/7/9.
 */
@Controller
public class CourseController {

	private final static Logger logger = Logger
			.getLogger(CourseController.class);

	@Autowired
	CourseService courseService;

	@Autowired
	UserService userService;

	@RequestMapping("/app/recommendList")
	@ResponseBody
	public ResultListBean getRecommendList(
			@RequestParam(value = "userToken", required = false) String userToken,
			@RequestParam(value = "page", required = false, defaultValue = Common.PAGE_DEFAULT) int page,
			@RequestParam(value = "pageSize", required = false, defaultValue = Common.PAGESIZE_DEFAULT) int pageSize) {
		// TODO 完成推荐列表
		ResultListBean rsb = new ResultListBean();
		Map<String, String> params = new HashMap<String, String>();
		fillAgeParams(userToken, params);
		params.put("page", String.valueOf(page));
		params.put("pageSize", String.valueOf(pageSize));
		List<Map<String, String>> list = courseService.getNewestList(params);
		logger.debug(list);
		rsb.getList().addAll(list);
		rsb.setCnt(list.size());

		return rsb;
	}

	@RequestMapping("/app/newestList")
	@ResponseBody
	public ResultListBean getNewestList(
			@RequestParam(value = "userToken", required = false) String userToken,
			@RequestParam(value = "page", required = false, defaultValue = Common.PAGE_DEFAULT) int page,
			@RequestParam(value = "pageSize", required = false, defaultValue = Common.PAGESIZE_DEFAULT) int pageSize) {
		ResultListBean rsb = new ResultListBean();
		Map<String, String> params = new HashMap<String, String>();
		fillAgeParams(userToken, params);
		params.put("page", String.valueOf(page));
		params.put("pageSize", String.valueOf(pageSize));
		List<Map<String, String>> list = courseService.getNewestList(params);
		logger.debug(list);
		rsb.getList().addAll(list);
		rsb.setCnt(list.size());

		return rsb;
	}

	@RequestMapping("/app/hotList")
	@ResponseBody
	public ResultListBean getHotList(
			@RequestParam(value = "userToken", required = false) String userToken,
			@RequestParam(value = "page", required = false, defaultValue = Common.PAGE_DEFAULT) int page,
			@RequestParam(value = "pageSize", required = false, defaultValue = Common.PAGESIZE_DEFAULT) int pageSize) {
		ResultListBean rlb = new ResultListBean();
		Map<String, String> params = new HashMap<String, String>();
		fillAgeParams(userToken, params);
		params.put("page", String.valueOf(page));
		params.put("pageSize", String.valueOf(pageSize));
		List<Map<String, String>> list = courseService.getHotList(params);
		logger.debug(list);
		rlb.getList().addAll(list);
		rlb.setCnt(list.size());

		return rlb;
	}

	private void fillAgeParams(String userToken, Map<String, String> params) {
		if (!StringUtils.isEmpty(userToken)) {
			String userId = userService.getUserIdByToken(userToken);
			if (StringUtils.isNotEmpty(userId)) {
				Map<String, String> map = userService
						.getAgeFromBirthday(userId);
				params.putAll(map);
			}
		}
	}

	@RequestMapping("/app/cataList")
	@ResponseBody
	public ResultListBean getHotList() {
		ResultListBean rlb = new ResultListBean();
		List<Map<String, String>> list = courseService.getCataList();
		rlb.getList().addAll(list);
		rlb.setCnt(list.size());
		return rlb;
	}

	@RequestMapping("/app/courseList")
	@ResponseBody
	public ResultListBean getCourseList(
			@RequestParam(value = "cataId", required = false) int cataId,
			@RequestParam(value = "page", required = false, defaultValue = Common.PAGE_DEFAULT) int page,
			@RequestParam(value = "pageSize", required = false, defaultValue = Common.PAGESIZE_DEFAULT) int pageSize) {
		ResultListBean rlb = new ResultListBean();
		Map<String, String> params = new HashMap<String, String>();
		params.put("cataId", String.valueOf(cataId));
		params.put("page", String.valueOf(page));
		params.put("pageSize", String.valueOf(pageSize));
		List<Map<String, String>> list = courseService.getCourseList(params);
		logger.debug(list);
		rlb.getList().addAll(list);
		rlb.setCnt(list.size());

		return rlb;
	}

	/**
	 * 搜索
	 * 
	 * @param userToken
	 * @param page
	 * @param pageSize
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/app/search")
	@ResponseBody
	public ResultListBean search(
			@RequestParam(value = "userToken", required = false) String userToken,
			@RequestParam(value = "page", required = false, defaultValue = Common.PAGE_DEFAULT) int page,
			@RequestParam(value = "pageSize", required = false, defaultValue = Common.PAGESIZE_DEFAULT) int pageSize,
			@RequestParam("key") String key)
			throws UnsupportedEncodingException {
		ResultListBean rsb = new ResultListBean();
		Map<String, String> params = new HashMap<String, String>();
		fillAgeParams(userToken, params);
		params.put("key", URLDecoder.decode(key, "UTF-8"));
		params.put("page", String.valueOf(page));
		params.put("pageSize", String.valueOf(pageSize));
		List<Map<String, String>> list = courseService.search(params);
		logger.debug(list);
		rsb.getList().addAll(list);
		rsb.setCnt(list.size());

		return rsb;
	}

}
