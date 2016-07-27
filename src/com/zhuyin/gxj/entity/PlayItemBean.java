package com.zhuyin.gxj.entity;

/**
 * Created by Tom on 16/7/25.
 */
public class PlayItemBean {
    private String id="";

    private String type="";

    private String name="";

    private String path ="";

    private int position=0;

    private String duration="";

    private String localCode="";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    @Override
    public String toString() {
        return "PlayItemBean{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", position=" + position +
                ", duration='" + duration + '\'' +
                ", localCode='" + localCode + '\'' +
                '}';
    }
}
