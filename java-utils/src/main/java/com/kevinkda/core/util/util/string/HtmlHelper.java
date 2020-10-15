/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.string;

/**
 * 提供拆分HTML的方法
 *
 * @author Kevin KDA on 2020/10/14 15:24
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.string
 * @classname HtmlHelper
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface HtmlHelper {
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
    String[] splitHtml(String html);
}
