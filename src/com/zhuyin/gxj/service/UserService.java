package com.zhuyin.gxj.service;

import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
public interface UserService {

    public Map<String,String> getAgeFromBirthday(String userToken);

    public String getUserIdByToken(String userToken);

    public String getUserTokenByMobile(String mobile);
    
    public int saveUser(String mobileNO);
}
