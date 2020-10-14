/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.string;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * 字符串处理方法
 *
 * @author Kevin KDA on 2020/10/13 17:27
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.string
 * @classname StringHelper
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public class StringHelper {
    /**
     * 首字母小写的字符串
     *
     * @param str 传入原始字符串
     * @return java.lang.String 返回首字母小写的字符串
     * @author Kevin KDA on 2020/5/5 20:59
     * @description StringProcess / initialLowercase
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 20:59")
    public static String initialLowercase(String str) {
//        str.replaceFirst()
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /**
     * 首字母大写的字符串
     *
     * @param str 传入原始字符串
     * @return java.lang.String 返回首字母大写的字符串
     * @author Kevin KDA on 2020/5/5 21:00
     * @description StringProcess / initialUppercase
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 21:00")
    public static String initialUppercase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * 用于Web请求将ISO_8859_1转换为UTF-8
     *
     * @param oldStr 传入非UTF-8字符集字符串
     * @return java.lang.String 返回UTF-8字符编码字符串
     * @author Kevin KDA on 2020/5/8 09:46
     * @description StringProcess / getUtfStringFromHtml
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/8 09:46")
    public static String getUtfStringFromHtml(String oldStr) {
        String strUtf8 = oldStr;
//        进行字符编码转换，传入原有 ISO_8859_1 字符编码字符串，转换为 UTF_8
        strUtf8 = new String(strUtf8.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return strUtf8;
    }

    /**
     * 用于Web请求将ISO_8859_1转换为UTF-8
     *
     * @param oldStr 传入非UTF-8字符集字符串
     * @param req    传入原有{@link HttpServletRequest}
     * @return java.lang.String[] 返回UTF-8字符编码字符串
     * @author Kevin KDA on 2020/5/8 09:44
     * @description StringProcess / getUtfStringsFromHtml
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/8 09:44")
    public static String[] getUtfStringsFromHtml(String[] oldStr, HttpServletRequest req) {
//        初始化返回数组长度
        String[] strUtf8 = new String[oldStr.length];
//        循环遍历获得request重的值
        for (int i = 0; i < strUtf8.length; i++) {
            strUtf8[i] = req.getParameter(oldStr[i]);
        }
//        循环遍历获得UTF-8编码值
        for (int i = 0; i < strUtf8.length; i++) {
            strUtf8[i] = new String(strUtf8[i].getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        }
        return strUtf8;
    }


    private StringHelper() {
    }

}
