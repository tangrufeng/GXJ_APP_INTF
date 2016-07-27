package com.zhuyin.gxj.entity;

/**
 * Created by Tom on 16/7/25.
 */
public class Timer {
    private String bgTime="";

    private String endTime="";

    private String weekDay="";

    public String getBgTime() {
        return bgTime;
    }

    public void setBgTime(String bgTime) {
        this.bgTime = bgTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return "Timer{" +
                "bgTime='" + bgTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", weekDay='" + weekDay + '\'' +
                '}';
    }
}
