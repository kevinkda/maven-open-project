/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.string.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.util.string.HtmlHelper;
import org.springframework.stereotype.Service;

/**
 * 提供拆分HTML的方法
 *
 * @author Kevin KDA on 2020/10/14 15:24
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.string.impl
 * @classname
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class HtmlHelperImpl implements HtmlHelper {
    /**
     * 分割HTML文档
     *
     * @param html 传入HTML文档
     * @return java.lang.String[] 返回分割后的HTML属性
     * @author Kevin KDA on 2020/5/4 14:03
     * @description HtmlHelperImpl / splitHtml
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 14:03")
    public String[] splitHtml(String html) {
//        String regex = "\\w+=\"[a-zA-Z0-9,\\+]+\"";
        String[] result = null;
//        Matcher matcher = Pattern.compile(regex).matcher(html);
//        int foot = 0;
//        while (matcher.find()) {
//            String temp = matcher.group(0);
//            result = temp.split("=");
//            for (int i = 0; i < result.length; i+=2) {
//
//            }
//            result[0] + "\t" + result[1].replaceAll("\"", "")
//            foot += 2;
//        }
        return result;
    }
}
