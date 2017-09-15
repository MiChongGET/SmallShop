package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取当前时间类
 * Created by MiChong on 2017/9/15 0015.
 *
 */
public enum   TimeUtils {

    TIME_UTILS;

    public  String getTime(){

        //获取当前的时间戳
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        return format;
    }

}
