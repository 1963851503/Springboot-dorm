package com.jsjx.dorm.baseutils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>概要：共通-业务上公用的Utilities</p>
 * <p>内容：共通-业务上公用的工具类 - 工具类<br />
 * 这里只写跟数据库无关、跟业务相关的内容。<br />
 * 比如：取UUID、数据加工等。
 */
public class DormUtils {

    /**
     * 取大写的UUID
     *
     * @return 返回大写的UUID
     */
    public static String fetchUuid() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

    /**
     * 把日期转换成日期字符串（yyyy-MM）。
     *
     * @param date 日期
     * @return 格式化后的日期字符串
     */
    public static String convertDateToStringYyyyMm(Date date) {
        if (date == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        return sdf.format(date);
    }

    /**
     * 把日期转换成日期字符串（yyyy-MM-dd）。
     *
     * @param date 日期
     * @return 格式化后的日期字符串
     */
    public static String convertDateToStringYyyyMmDd(Date date) {
        if (date == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(date);
    }

    /**
     * 把日期转换成日期字符串（yyyy-MM-dd）。
     *
     * @param dateFmt 日期
     * @return 格式化后的日期字符串
     */
    public static Date convertStringToDateYyyyMmDd(String dateFmt) {
        if (dateFmt == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        return null;//sdf.format(date);
    }

    /**
     * 把日期转换成日期字符串（yyyy-MM）。
     *
     * @param date 日期
     * @return 格式化后的日期字符串
     */
    public static String convertDateToStringYyyyMmDdHhMmSs(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sdf.format(date);
    }

    /**
     * 获取日期
     *
     * @author Daivd.Tsou
     * @version 1.0
     * @email zoudezhi@neusoft.com
     * @add 2017-12-07
     */
    // 获得当天0点时间
    public static Date getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    // 获得当天24点时间
    public static Date getTimesnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    // 获得本周一0点时间
    public static Date getTimesWeekmorning() {
//        Calendar cal = Calendar.getInstance();
//        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
//        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        return  cal.getTime();
        Calendar cal = Calendar.getInstance();
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
            cal.add(Calendar.DATE, -day_of_week + 1);
        } else {
            cal.add(Calendar.DATE, -day_of_week + 1);
        }
        return cal.getTime();
    }

    // 获得本周日24点时间
    public static Date getTimesWeeknight() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getTimesWeekmorning());
        cal.add(Calendar.DAY_OF_WEEK, 7);
        return cal.getTime();
    }

    // 获得本月第一天0点时间
    public static Date getTimesMonthmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    // 获得本月最后一天24点时间
    public static Date getTimesMonthnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTime();
    }

    /***
     * 比较年月日，d1是否大于d2
     * @param d1
     * @param d2
     * @return
     */
    public static boolean afterDate(Date d1, Date d2)
    {
        if(null==d1||null==d2)
        {
            return  false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        cal1.set(Calendar.HOUR_OF_DAY,0);
        cal1.set(Calendar.MINUTE,0);
        cal1.set(Calendar.SECOND,0);
        cal1.set(Calendar.MILLISECOND,0);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        cal2.set(Calendar.HOUR_OF_DAY,0);
        cal2.set(Calendar.MINUTE,0);
        cal2.set(Calendar.SECOND,0);
        cal2.set(Calendar.MILLISECOND,0);

        return   cal1.getTime().after(cal2.getTime());
    }
    /***
     * 比较年月日，d1是否小于于d2
     * @param d1
     * @param d2
     * @return
     */
    public static boolean beforeDate(Date d1, Date d2)
    {
        if(null==d1||null==d2) {
            return  false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        cal1.set(Calendar.HOUR_OF_DAY,0);
        cal1.set(Calendar.MINUTE,0);
        cal1.set(Calendar.SECOND,0);
        cal1.set(Calendar.MILLISECOND,0);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        cal2.set(Calendar.HOUR_OF_DAY,0);
        cal2.set(Calendar.MINUTE,0);
        cal2.set(Calendar.SECOND,0);
        cal2.set(Calendar.MILLISECOND,0);

        return   cal1.getTime().before(cal2.getTime());
    }

    /**
     * By Gao
     * 实现同.net的String.format效果。
     *
     * @param str
     * @param args
     * @return
     */
    public static String format(String str,String ... args) {

        //这里用于验证数据有效性
        if(StringUtils.isEmpty(str))
            return "";

        String result = str;

        //这里的作用是只匹配{}里面是数字的子字符串
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\{(\\d+)\\}");
        java.util.regex.Matcher m = p.matcher(str);

        while(m.find()) {
            //获取{}里面的数字作为匹配组的下标取值
            int index=Integer.parseInt(m.group(1));

            if (args == null) {
                result=result.replace(m.group(), "");
            } else if(index<args.length) {//这里考虑数组越界问题
                //替换，以{}数字为下标，在参数数组中取值
                if (args[index] != null) {
                    result = result.replace(m.group(), args[index]);
                } else {
                    result=result.replace(m.group(), "");
                }
            }
        }
        return result;
    }

    /**
     * 接收人 去重处理
     * @param list
     * @return
     */
    public static List<String> duplicateRemoval(List<String> list){
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);//去重
        return  list;
    }

}

