package com.zhuyin.gxj.service;

import com.zhuyin.gxj.entity.PlayListInfoBean;

/**
 * Created by Tom on 16/7/25.
 */
public interface PlayerService {

    public PlayListInfoBean getPlayListInfo(String deviceSN);
}
