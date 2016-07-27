package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.entity.ActionBean;
import com.zhuyin.gxj.entity.ActionResultListBean;
import com.zhuyin.gxj.entity.DeviceRedisBean;
import com.zhuyin.gxj.entity.PlayListInfoBean;
import com.zhuyin.gxj.service.DeviceSerivce;
import com.zhuyin.gxj.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Tom on 16/7/22.
 */
@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/player/getCornList")
    @ResponseBody
    public PlayListInfoBean getCornTaskInfo(@RequestParam("deviceSN") String deviceSN, @RequestParam("taskId") String taskId) {
        return playerService.getPlayListInfo(deviceSN);
    }

}
