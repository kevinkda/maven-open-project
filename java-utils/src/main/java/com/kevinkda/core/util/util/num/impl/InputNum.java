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

import java.util.Scanner;

/**
 * @author Kevin KDA on 2020/10/14 16:38
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.num.impl
 * @classname InputNum
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class InputNum {
    /**
     * 终端输入对象
     *
     * @since 1.0.0
     */
    @Autowired
    private static Scanner SCANNER;

    /**
     * 提供键盘接收的操作
     *
     * @param prompt 提示信息
     * @return {@link int} 返回一个可以使用的数字
     * @author Kevin KDA on 2020/4/26 15:03
     * @description InputNum / getInt
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/4/26 15:03")
    public static int getInt(String prompt) {
        int num = 0;
        boolean flag = true;
        do {
            try {
//                打印提示信息
                System.out.print(prompt);
                int i = SCANNER.nextInt();
                flag = false;
                num = i;
            } catch (Exception e) {
                System.out.println("输入的内容不是数字！");
                flag = true;
                String str = SCANNER.nextLine();
            }
        } while (flag);
        return num;
    }

    /**
     * 提供键盘接收的操作
     *
     * @param prompt 提示信息
     * @return {@link double} 返回一个可以使用的数字
     * @author Kevin KDA on 2020/4/26 15:05
     * @description InputNum / getDouble
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/4/26 15:05")
    public static double getDouble(String prompt) {
        double num = 0;
        boolean bl = true;
        do {
            try {
//                打印提示信息
                System.out.print(prompt);
                double i = SCANNER.nextDouble();
                bl = false;
                num = i;
            } catch (Exception e) {
                System.out.println("输入的内容不是数字或格式错误！");
                bl = true;
                String str = SCANNER.nextLine();
            }
        } while (bl);
        return num;
    }


    public InputNum() {
    }
}
