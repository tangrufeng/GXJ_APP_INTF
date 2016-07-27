package com.zhuyin.gxj.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
@Repository("userDAO")
public interface UserDAO {


    @Select("SELECT  convert(MAX(a.age),char(3)) AS maxAge, convert(MIN(a.age),char(3)) AS minAge FROM (SELECT  " +
            "DATE_FORMAT(FROM_DAYS(TO_DAYS(NOW()) - TO_DAYS(birth_month)), '%Y') + 0 AS age FROM user_device_relation" +
            " where userId=#{userId}) AS a")
    public Map<String, String> getAgeFromBirthday(String userId);

    @Select("select id from user_info where token=#{token} and status=0")
    public String getUserIdByToken(String token);
    
    @Select("select token from user_info where telephone=#{mobile} and status=0")
    public String getUserTokenByMobile(String mobile);
    
    @Insert("insert user_info(`telephone`,`create_time`,`token`) values(#{mobileNO},DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s'),upper(replace(uuid(),'-','')))")
    public int saveUser(String mobileNO);
}
