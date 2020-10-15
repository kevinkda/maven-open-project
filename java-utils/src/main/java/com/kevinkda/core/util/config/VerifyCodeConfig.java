/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.config;

import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.util.Random;

/**
 * @author Kevin KDA on 2020/10/14 15:16
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.config
 * @classname VerifyCodeConfig
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Configuration
public class VerifyCodeConfig {
    /**
     * 图像宽度
     *
     * @since 1.0.0
     */
    public final int width = 70;
    /**
     * 图像高度
     *
     * @since 1.0.0
     */
    public final int height = 35;
    /**
     * 随机取值
     *
     * @since 1.0.0
     */
    public final Random random = new Random();
    /**
     * 可选取的字体名
     *
     * @since 1.0.0
     */
    public final String[] fontNames = {"宋体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"};
    /**
     * 可使用的字符
     *
     * @since 1.0.0
     */
    public final String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
    /**
     * 背景色
     *
     * @since 1.0.0
     */
    public final Color bgColor = new Color(255, 255, 255);

}
