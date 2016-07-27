package com.zhuyin.gxj.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuyin.gxj.dao.CourseDAO;
import com.zhuyin.gxj.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO=null;
	
	@Override
	public List<Map<String, String>> getNewestList(Map<String, String> params) {
		return courseDAO.getNewestList(params);
	}


	@Override
	public List<Map<String, String>> getHotList(Map<String, String> params) {
		return courseDAO.getHotList(params);
	}

	@Override
	public List<Map<String, String>> getCataList() {
		return courseDAO.getCataList();
	}

	@Override
	public List<Map<String, String>> getCourseList(Map<String, String> params) {
		return courseDAO.getCourseList(params);
	}


	@Override
	public List<Map<String, String>> search(Map<String, String> params) {
		return courseDAO.search(params);
	}
}
