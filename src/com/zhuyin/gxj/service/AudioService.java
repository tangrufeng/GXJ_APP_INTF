package com.zhuyin.gxj.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
public interface AudioService {


    public List<Map<String,String>> getAudioList(String courseId);
}
