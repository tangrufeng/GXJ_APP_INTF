package com.zhuyin.gxj.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/9.
 */
public interface AreaService {


    public List<Map<String, String>> getCities(String proviceId);


    public List<Map<String, String>> getProvices();
}
