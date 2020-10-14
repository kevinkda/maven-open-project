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

/**
 * 提供计时方法
 *
 * @author Kevin KDA on 2020/10/13 16:46
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.date
 * @classname TimeUtil
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface TimeUtil {
    /**
     * 开始计时
     *
     * @author Kevin KDA on 2020/5/4 13:11
     * @description TimeUtil / startTime
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:11")
    void startTime();

    /**
     * 结束计时
     *
     * @return long 返回时间间隔
     * @author Kevin KDA on 2020/5/4 13:11
     * @description TimeUtil / stopTime
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:11")
    long stopTime();

    /**
     * 获取时长，返回毫秒
     *
     * @return long 返回毫秒级时间间隔
     * @author Kevin KDA on 2020/5/4 13:12
     * @description TimeUtil / getDurationByMillisecond
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:12")
    long getDurationByMillisecond();

    /**
     * 获取时长，返回秒
     *
     * @return double 返回秒级时间间隔
     * @author Kevin KDA on 2020/5/4 13:13
     * @description TimeUtil / getDurationBySecond
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:13")
    double getDurationBySecond();

    /**
     * 进行毫秒到秒的转换
     *
     * @param time 获取去转换的毫秒数
     * @return double 返回秒级时间间隔
     * @author Kevin KDA on 2020/5/4 13:13
     * @description TimeUtil / millisecondsToSeconds
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:13")
    double millisecondsToSeconds(long time);

    /**
     * 进行毫秒到分的转换
     *
     * @param time 获取去转换的毫秒数
     * @return double 返回分级时间间隔
     * @author Kevin KDA on 2020/5/4 13:14
     * @description TimeUtil / millisecondsToMinute
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:14")
    double millisecondsToMinute(long time);
}
