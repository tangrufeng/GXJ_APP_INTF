package com.zhuyin.gxj.service.impl;

import com.zhuyin.gxj.dao.UserDAO;
import com.zhuyin.gxj.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
@Service("userService")
public class UserSerivceImpl implements UserService {

    @Autowired
    UserDAO userDAO=null;

    @Override
    public Map<String, String> getAgeFromBirthday(String userToken) {
        return userDAO.getAgeFromBirthday(userToken);
    }

    @Override
    public String getUserIdByToken(String userToken) {
        return userDAO.getUserIdByToken(userToken);
    }

	@Override
	public String getUserTokenByMobile(String mobile) {
		return userDAO.getUserTokenByMobile(mobile);
	}

	@Override
	public int saveUser(String mobileNO) {
		return userDAO.saveUser(mobileNO);
	}
    
    
}
