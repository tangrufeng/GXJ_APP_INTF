package com.zhuyin.gxj.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 16/7/22.
 */
public class ActionBean implements Serializable{

    private final static long serialVersionUID = 1805851618278324458l;

    private String action;

    private String id;

    private Map<String,String> params=new HashMap<>();

    @Override
    public String toString() {
        return "ActionBean{" +
                "action='" + action + '\'' +
                ", id='" + id + '\'' +
                ", params=" + params +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionBean that = (ActionBean) o;

        return action.equals(that.action);

    }

    @Override
    public int hashCode() {
        return action.hashCode();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String,String> getParams() {
        return params;
    }

    public void setParams(Map<String,String> params) {
        this.params = params;
    }
}
