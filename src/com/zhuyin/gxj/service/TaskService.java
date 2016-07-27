package com.zhuyin.gxj.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Tom on 16/7/11.
 */
public interface TaskService {



    public int addTask(Map<String,Object> params);

    public List<Map<String,Object>> getPlayTaskList(String userId, String deviceId);
    
	public int deleteTask(String userId, String taskId);

	public int deleteTaskAudio(String taskId,String audioId);
}
