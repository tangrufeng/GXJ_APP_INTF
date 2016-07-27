package com.zhuyin.gxj.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 16/7/25.
 */
public class PlayListInfoBean {

    private String FileType="";

    private List<PlayListBean> classItems=new ArrayList<>();

    public String getFileType() {
        return FileType;
    }

    public void setFileType(String fileType) {
        FileType = fileType;
    }

    public List<PlayListBean> getClassItems() {
        return classItems;
    }

    public void setClassItems(List<PlayListBean> classItems) {
        this.classItems = classItems;
    }

    @Override
    public String toString() {
        return "PlayListInfoBean{" +
                "FileType='" + FileType + '\'' +
                ", classItems=" + classItems +
                '}';
    }
}
