package com.zhuyin.gxj.service.impl;

import com.zhuyin.gxj.dao.DeviceActionDAO;
import com.zhuyin.gxj.dao.DeviceDAO;
import com.zhuyin.gxj.dao.TaskDAO;
import com.zhuyin.gxj.redis.TaskActionRedisDAO;
import com.zhuyin.gxj.service.TaskService;

import com.zhuyin.gxj.utils.DeviceActionEnum;
import com.zhuyin.gxj.utils.TaskUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Tom on 16/7/11.
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

    private final static Logger logger = Logger.getLogger(TaskService.class);

    @Autowired
    TaskDAO taskDAO;

    @Autowired
    TaskActionRedisDAO taskActionRedisDAO;

    @Autowired
    DeviceDAO deviceDAO;

    @Autowired
    DeviceActionDAO deviceActionDAO;

    @Override
    public int addTask(Map<String, Object> params) {
        logger.debug("before====>" + params);
        int i = taskDAO.addTask(params);
        if (i == 1) {
            long taskId = (Long) params.get("id");
            ArrayList<Map<String, String>> musics = (ArrayList<Map<String, String>>) params.get("musics");
            for (Map<String, String> music : musics) {
                music.put("task_id", taskId + "");
                taskDAO.addTaskAudio(music);
            }
            String deviceId=String.valueOf(params.get("deviceId"));
            String deviceSN=deviceDAO.getDeviceSNById(deviceId);
            String actionId= TaskUtil.getTaskActionId();

            Map<String,String> map=new HashMap<>();
            map.put("id",actionId);
            map.put("deviceId",deviceId);
            map.put("taskId",String.valueOf(taskId));
            map.put("action", DeviceActionEnum.setCronJob.name());
            deviceActionDAO.addDeviceAction(map);
            taskActionRedisDAO.addAction(deviceId,deviceSN,actionId,DeviceActionEnum.setCronJob.name());
        }
        logger.debug("after=====>" + params);
        return 0;
    }

    @Override
    public List<Map<String, Object>> getPlayTaskList(String userId, String deviceId) {

        List<Map<String,Object>> list=taskDAO.getPlayTaskList(userId,deviceId);

        for(Map<String,Object> task:list){

            String taskId=String.valueOf(task.get("id"));
            List<Map<String,String>> musics =taskDAO.getTaskAudio(taskId);
            task.put("musics",musics);
        }

        return list;
    }

	@Override
	public int deleteTask(String userId, String taskId) {
		return taskDAO.deleteTask(userId, taskId);
	}

	@Override
	public int deleteTaskAudio(String taskId, String audioId) {
		return taskDAO.deleteTaskAudio(taskId, audioId);
	}

    public static void main(String[] args) {
        System.out.println(DeviceActionEnum.setCronJob.name());
    }
    
}
