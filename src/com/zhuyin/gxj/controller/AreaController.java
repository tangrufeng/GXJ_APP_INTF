package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.entity.ResultListBean;
import com.zhuyin.gxj.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/app/province")
    public ResultListBean getProvices(){
        ResultListBean rlb=new ResultListBean();
        List<Map<String,String>> list=areaService.getProvices();
        rlb.getList().addAll(list);
        rlb.setCnt(list.size());
        return rlb;
    }


    @RequestMapping("/app/cities")
    public ResultListBean getCities(@RequestParam("proviceId") String proviceId){
        ResultListBean rlb=new ResultListBean();
        List<Map<String,String>> list=areaService.getCities(proviceId);
        rlb.getList().addAll(list);
        rlb.setCnt(list.size());
        return rlb;
    }
}
