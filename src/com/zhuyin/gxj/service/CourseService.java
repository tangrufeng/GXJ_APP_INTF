package com.zhuyin.gxj.service;

import java.util.List;
import java.util.Map;

public interface CourseService {

	public List<Map<String, String>> getNewestList(Map<String, String> params);


	public List<Map<String, String>> getHotList(Map<String, String> params);

	public List<Map<String,String>> getCataList();

	public List<Map<String, String>> getCourseList(Map<String, String> params);

    public List<Map<String, String>> search(Map<String, String> params);
}
