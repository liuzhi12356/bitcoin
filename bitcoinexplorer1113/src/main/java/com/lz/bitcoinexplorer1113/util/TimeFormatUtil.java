package com.lz.bitcoinexplorer1113.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatUtil {


    public static String timeAgo(Long time){
        long time1 = new Date().getTime()/1000;
        long x=new Long(time1-time);
        int c= (int) x;
        if(x>=31536000){
            return (int)Math.floor(x/31536000)+"years";
        }else if(x>=2592000&&x<31536000){
            return (int)Math.floor(x/2592000)+"mouths";
        }else if(x>=604800&&x<2592000){
            return (int)Math.floor(x/604800)+"weeks";
        }else if(x>=86400&&x<604800){
            return (int)Math.floor(x/86400)+"days";
        }else if(x>=3600&&x<86400){
            return (int)Math.floor(x/3600)+"hours";
        }else if(x>=60&&x<3600){
            return (int)Math.floor(x/60)+"minutes";
        }else if(x>=1&&x<60){
            return (int)Math.floor(x/1)+"seconds";
        }
        return null;
    }

    public static String nowTimes(Long time){
        Date date = new Date(time * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        return format.substring(11,16);
    }

    public static String blocktime(Long time){
        Date date = new Date(time * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sdf.format(date);
        return format;
    }
}
