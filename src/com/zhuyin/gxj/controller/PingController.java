package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.entity.*;
import com.zhuyin.gxj.service.DeviceSerivce;
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
public class PingController {

    @Autowired
    DeviceSerivce deviceSerivce;

    @RequestMapping("/rest/ping")
    @ResponseBody
    public ActionResultListBean ping(@RequestParam("device_sn") String deviceSN,
                                     @RequestParam(value = "sd_size",required = false) Long sdSize,
                                     @RequestParam(value = "sd_used",required = false) Long sdUsed,
                                     @RequestParam(value = "sd_state",required = false) Integer state,
                                     @RequestParam(value = "net_ip",required = false) String ip,
                                     @RequestParam(value = "net_gw",required = false) String gw,
                                     @RequestParam(value = "net_dns",required = false) String dns,
                                     @RequestParam(value = "net_mac",required = false) String mac,
                                     @RequestParam(value = "fw_version",required = false) String fw_version,
                                     @RequestParam("rand") String rand) {

        ActionResultListBean arlb = new ActionResultListBean();

        DeviceRedisBean drb = new DeviceRedisBean();
        drb.setDeviceSN(deviceSN);
        drb.setSdSize(sdSize==null?0l:sdSize.longValue());
        drb.setSdUsed(sdUsed==null?0l:sdUsed.longValue());
        drb.setState(state==null?-1:state.intValue());
        drb.setIp(ip);
        drb.setGw(gw);
        drb.setDns(dns);
        drb.setMac(mac);
        drb.setVersion(fw_version);
        drb.setLastPingTime(System.currentTimeMillis());
        List<ActionBean> actions = deviceSerivce.getDeviceAction(drb);
        arlb.getActions().addAll(actions);
        arlb.setTimestamp(System.currentTimeMillis());
        return arlb;
    }

}
