package com.zhuyin.gxj.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Tom on 16/7/21.
 */
public class TaskUtil {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static String getTaskActionId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static String getTaskEndTime(String strTaskBegin, String strTaskDur) {
        if(StringUtils.isEmpty(strTaskBegin)||StringUtils.isEmpty(strTaskDur)){
            return strTaskBegin;
        }
        try {
            Date beginTime = sdf.parse(strTaskBegin);
            Date durationTime = sdf.parse(strTaskDur);
            Calendar calBegin = Calendar.getInstance();
            Calendar calDur = Calendar.getInstance();
            calBegin.setTime(beginTime);
            calDur.setTime(durationTime);
            calBegin.add(Calendar.SECOND,calDur.get(Calendar.SECOND));
            calBegin.add(Calendar.MINUTE,calDur.get(Calendar.MINUTE));
            calBegin.add(Calendar.HOUR,calDur.get(Calendar.HOUR));
            return sdf.format(calBegin.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
