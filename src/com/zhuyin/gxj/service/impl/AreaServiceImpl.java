package com.zhuyin.gxj.service.impl;

import com.zhuyin.gxj.dao.AreaDAO;
import com.zhuyin.gxj.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDAO areaDAO;


    @Override
    public List<Map<String, String>> getCities(String proviceId) {
        return areaDAO.getCities(proviceId);
    }

    @Override
    public List<Map<String, String>> getProvices() {
        return areaDAO.getProvices();
    }
}
