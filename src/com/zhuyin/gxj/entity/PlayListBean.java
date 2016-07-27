package com.zhuyin.gxj.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 16/7/25.
 */
public class PlayListBean {

    private String id="";

    private int begin=0;

    private String module="";

    private List<PlayItemBean> musics=new ArrayList<>();

    private List<Timer> timers=null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<PlayItemBean> getMusics() {
        return musics;
    }

    public void setMusics(List<PlayItemBean> musics) {
        this.musics = musics;
    }

    public List<Timer> getTimers() {
        return timers;
    }

    public void setTimers(List<Timer> timers) {
        this.timers = timers;
    }

    @Override
    public String toString() {
        return "PlayListBean{" +
                "id='" + id + '\'' +
                ", begin=" + begin +
                ", module='" + module + '\'' +
                ", musics=" + musics +
                ", timers=" + timers +
                '}';
    }
}
