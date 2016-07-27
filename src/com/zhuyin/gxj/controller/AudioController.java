package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.entity.ResultListBean;
import com.zhuyin.gxj.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
@Controller
public class AudioController {


    @Autowired
    AudioService audioService;

    @RequestMapping("/app/audioList")
    @ResponseBody
    public ResultListBean getAudioList(@RequestParam("courseId") String courseId){
        ResultListBean rlb=new ResultListBean();
        List<Map<String,String>>  list=audioService.getAudioList(courseId);
        rlb.getList().addAll(list);
        rlb.setCnt(list.size());
        return rlb;
    }
}
