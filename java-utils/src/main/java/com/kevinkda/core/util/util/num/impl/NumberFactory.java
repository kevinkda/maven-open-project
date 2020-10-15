/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.num.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * The type Number factory.
 *
 * @author Kevin KDA on 2020/10/14 16:41
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.num.impl
 * @classname NumberFactory
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class NumberFactory {
    /**
     * 随机数对象
     *
     * @since 1.0.0
     */
    @Autowired
    private static Random RANDOM;

    /**
     * 生成1-30随机数
     * 通过随机数来生成一个数组的内容，该内容不包括有0
     *
     * @param len 要开辟的数组大小
     * @return int[] 包含有随机数的内容
     * @author Kevin KDA on 2020/4/26 15:11
     * @description NumberFactory / createRandomArray
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/4/26 15:11")
    public static int[] createRandomArray(int len) {
//        开辟新的效组
        int[] data = new int[len];
        int foot = 0;
        while (foot < data.length) {
            int num = RANDOM.nextInt(30);
            if (num != 0) {
//                保存数据
                data[foot++] = num;
            }
        }
        return data;
    }

    /**
     * 保留指定位数小数
     *
     * @param num   传入需处理的double类型数据
     * @param scale 传入指定保留位数
     * @return double double
     * @author Kevin KDA on 2020/4/26 15:16
     * @description NumberFactory / round
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/4/26 15:16")
    public static double round(double num, int scale) {
        return Math.round(Math.pow(10, scale) * num) / Math.pow(10, scale);
    }

    public NumberFactory() {
    }
}
