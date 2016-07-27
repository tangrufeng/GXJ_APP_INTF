package com.zhuyin.gxj.service.impl;

import com.zhuyin.gxj.dao.AudioDAO;
import com.zhuyin.gxj.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
@Service("audioService")
public class AudioServiceImpl implements AudioService {
    @Autowired
    AudioDAO audioDAO;

    @Override
    public List<Map<String, String>> getAudioList(String courseId) {
        return audioDAO.getAudioList(courseId);
    }
}
