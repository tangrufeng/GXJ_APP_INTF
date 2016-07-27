package com.zhuyin.gxj.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository("areaDAO")
public interface AreaDAO {


    @Select("SELECT city_id as id,city_name as name FROM city where prov_id=#{proviceId} and status=1")
    public List<Map<String, String>> getCities(String proviceId);


    @Select("SELECT prov_id as id,prov_name as name FROM province where  status=1")
    public List<Map<String, String>> getProvices();
}
