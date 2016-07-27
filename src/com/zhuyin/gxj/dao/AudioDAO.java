package com.zhuyin.gxj.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
@Repository("audioDAO")
public interface AudioDAO {

    @Select("select a.* from audio a,course_audio ca where ca.audioId=a.id and ca.courseId=#{courseId} order by ca" +
            ".sort desc")
    public List<Map<String,String>> getAudioList(String courseId);
}
