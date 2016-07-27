package com.zhuyin.gxj.controller;

import com.zhuyin.gxj.common.Common;
import com.zhuyin.gxj.entity.ResultBean;
import com.zhuyin.gxj.service.UserService;
import com.zhuyin.gxj.utils.SMSUtils;
import com.zhuyin.gxj.utils.ValiCodeCache;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Tom on 16/6/18.
 */
@Controller
public class ValiMobileController extends BaseController {

    @Autowired
    ValiCodeCache cache;

    @Autowired
    SMSUtils smsUtils;
    
    @Autowired
    UserService userService;

    @RequestMapping("app/sendValiCode")
    @ResponseBody
    public ResultBean sendValiCode(@RequestParam String mobileNo) {
        ResultBean rst = new ResultBean();
        int valiCode = (int) ((Math.random() * 9 + 1) * 100000);
        if (smsUtils.sendSMS(mobileNo, Common.SMS_CONTENT_VALICODE.replace("#CODE#", String.valueOf(valiCode)))) {
            cache.put(mobileNo, String.valueOf(valiCode));
        } else {
            rst.setErrCode(1);
            rst.setErrMsg("验证短信发送失败,请重试!");
        }

        rst.setErrCode(0);
        return rst;
    }

    @RequestMapping("/app/valiMobile")
    @ResponseBody
    public ResultBean sendValiCode(@RequestParam String mobileNo, @RequestParam String valiCode) {
        ResultBean rst = new ResultBean();
//        int i = cache.valiCode(mobileNo, valiCode);
        int i=0;
        switch (i) {
            case 0:
            	String userToken=userService.getUserTokenByMobile(mobileNo);
            	if(StringUtils.isEmpty(userToken)){
            		userService.saveUser(mobileNo);
            		userToken=userService.getUserTokenByMobile(mobileNo);
            	}
            	rst.setUserToken(userToken);
                rst.setErrCode(0);
                rst.setErrMsg("手机验证成功");
                break;
            case 1:
                rst.setErrCode(1);
                rst.setErrMsg("验证码错误");
                break;
            case 2:
                rst.setErrCode(2);
                rst.setErrMsg("验证码已过期");
                break;
        }

        return rst;
    }


}
