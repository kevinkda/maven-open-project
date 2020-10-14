/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.date;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 提供日期格式转换和日期计算
 *
 * @author Kevin KDA on 2020/10/13 16:42
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.date
 * @classname DateTimeUtil
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public class DateTimeUtil {
    /**
     * 将日期格式化成规定合适的字符串后返回
     *
     * @param date 传入Date类型日期
     * @return java.lang.String 返回字符串类型日期数据
     * @author Kevin KDA on 2020/5/4 13:06
     * @description DateTimeUtil / formatStringByDateTime
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:06")
    public static String formatStringByDateTime(Date date) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
    }

    /**
     * 提供将{@link String}类型日期转化为{@link Date}类型日期的方法
     *
     * @param date 传入字符串类型日期
     * @return java.util.Date 返回转化后的日期
     * @author Kevin KDA on 2020/5/24 00:03
     * @description DateTimeUtil / formatStringByDate
     * @version 1.0.0
     * @apiNote <p>转换过程中如产生{@link ParseException}异常将会返回NULL，程序异常已捕获</p>
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/24 00:03")
    public static Date formatStringByDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateBack = null;
        try {
            dateBack = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateBack;
    }

    /**
     * 时间戳转日期时间
     *
     * @param s 传入字符串类型时间
     * @return java.util.Date 返回格式化后的日期对象
     * @author Kevin KDA on 2020/5/4 13:06
     * @description DateTimeUtil / stampToDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:06")
    public static Date stampToDate(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        return new Date(lt);
    }

    /**
     * 计算现在到某一个日期的间隔天数
     *
     * @param startDate 传入开始日期
     * @return long 返回间隔天数
     * @author Kevin KDA on 2020/5/4 13:06
     * @description DateTimeUtil / currentToStart
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:06")
    public static long currentToStart(Date startDate) {
        return Math.abs(currentToEnd(startDate));
    }

    /**
     * 计算现在到某一个日期的间隔天数
     *
     * @param endDate 传入结束日期
     * @return long 返回间隔天数
     * @author Kevin KDA on 2020/5/4 13:06
     * @description DateTimeUtil / currentToEnd
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:06")
    public static long currentToEnd(Date endDate) {
        String[] currentStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).split("-");
        String[] endStr = new SimpleDateFormat("yyyy-MM-dd").format(endDate).split("-");
        Integer currentYear = Integer.parseInt(currentStr[0]);
        Integer currentMonth = Integer.parseInt(currentStr[1]);
        Integer currentDay = Integer.parseInt(currentStr[2]);
        int endYear = Integer.parseInt(endStr[0]);
        int endMonth = Integer.parseInt(endStr[1]);
        int endDay = Integer.parseInt(endStr[2]);
        LocalDate endLocalDate = LocalDate.of(endYear, endMonth, endDay);
        return LocalDate.now().until(endLocalDate, ChronoUnit.DAYS);
    }

    /**
     * 计算两个日期之间的间隔天数
     *
     * @param startDate 传入开始日期
     * @param endDate   传入结束日期
     * @return long 返回间隔天数
     * @author Kevin KDA on 2020/5/4 13:06
     * @description DateTimeUtil / startToEnd
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:06")
    public static long startToEnd(Date startDate, Date endDate) {
        String[] startStr = new SimpleDateFormat("yyyy-MM-dd").format(startDate).split("-");
        String[] endStr = new SimpleDateFormat("yyyy-MM-dd").format(endDate).split("-");
        int startYear = Integer.parseInt(startStr[0]);
        int startMonth = Integer.parseInt(startStr[1]);
        int startDay = Integer.parseInt(startStr[2]);
        int endYear = Integer.parseInt(endStr[0]);
        int endMonth = Integer.parseInt(endStr[1]);
        int endDay = Integer.parseInt(endStr[2]);
        LocalDate endLocalDate = LocalDate.of(endYear, endMonth, endDay);
        LocalDate startLocalDate = LocalDate.of(startYear, startMonth, startDay);
        return startLocalDate.until(endLocalDate, ChronoUnit.DAYS);
    }


//    时间加减法

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addMillisecond
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addMillisecond(Date date, long param) {
        return addMillisecond(date.getTime(), param);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addMillisecond
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addMillisecond(long date, long param) {
        return date + param;
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addMillisecondOfDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addMillisecondOfDate(Date date, long param) {
        return new Date(date.getTime() + param);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addMillisecondOfDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addMillisecondOfDate(long date, long param) {
        return new Date(addMillisecond(date, param));
    }


    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addSecond
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addSecond(Date date, long param) {
        return addSecond(date.getTime(), param);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addSecond
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addSecond(long date, long param) {
        return addMillisecond(date, param * 1000);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addSecondOfDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addSecondOfDate(Date date, long param) {
        return new Date(addSecond(date.getTime(), param));
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addSecondOfDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addSecondOfDate(long date, long param) {
        return new Date(addSecond(date, param));
    }


    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addMinute
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addMinute(Date date, double param) {
        return addMinute(date.getTime(), param);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addMinute
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addMinute(long date, double param) {
        return addSecond(date, (long) (param * 60));
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addMinuteOfDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addMinuteOfDate(Date date, double param) {
        return new Date(addMinute(date.getTime(), param));
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addMinuteOfDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addMinuteOfDate(long date, double param) {
        return new Date(addMinute(date, param));
    }


    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addHour
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addHour(Date date, double param) {
        return addHour(date.getTime(), param);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addHour
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addHour(long date, double param) {
        return addMinute(date, param * 60);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addHourOfDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addHourOfDate(Date date, double param) {
        return new Date(addHour(date.getTime(), param));
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addHourOfDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addHourOfDate(long date, double param) {
        return new Date(addHour(date, param));
    }


    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addDay
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addDay(Date date, double param) {
        return addDay(date.getTime(), param);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addDay
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addDay(long date, double param) {
        return addHour(date, param * 24);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addDayOfDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addDayOfDate(Date date, double param) {
        return new Date(addDay(date.getTime(), param));
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addDayOfDate
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addDayOfDate(long date, double param) {
        return new Date(addDay(date, param));
    }


    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addMonth
     * @version 1.0.0
     * @apiNote <p>本方法默认以一个月30天计算</p>
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addMonth(Date date, double param) {
        return addMonth(date.getTime(), param);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return long 返回整型时间
     * @author Kevin KDA on 2020/5/28 23:22
     * @description DateTimeUtil / addMonth
     * @version 1.0.0
     * @apiNote <p>本方法默认以一个月30天计算</p>
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:22")
    public static long addMonth(long date, double param) {
        return addDay(date, param * 30);
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addMonth
     * @version 1.0.0
     * @apiNote <p>本方法默认以一个月30天计算</p>
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addMonthOfDate(Date date, double param) {
        return new Date(addMonth(date.getTime(), param));
    }

    /**
     * 提供对于时间的加减法操作
     *
     * @param date  传入待计算的时间
     * @param param 传入计算值，传入整数
     * @return java.util.Date 返回Date类型时间
     * @author Kevin KDA on 2020/5/28 23:28
     * @description DateTimeUtil / addMonth
     * @version 1.0.0
     * @apiNote <p>本方法默认以一个月30天计算</p>
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 23:28")
    public static Date addMonthOfDate(long date, double param) {
        return new Date(addMonth(date, param));
    }


    public DateTimeUtil() {
    }
}
