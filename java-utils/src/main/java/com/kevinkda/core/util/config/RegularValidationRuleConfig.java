/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 正则验证规则配置
 *
 * @author Kevin KDA on 2020/10/14 14:36
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.config
 * @classname RegularValidationRuleConfig
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Configuration
public class RegularValidationRuleConfig {
//    @Value("${utils.regex.rule.email}")
    public static String RULE_EMAIL = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
//    public static String RULE_EMAIL;

    public static String RULE_IPV4 = "([12]?[0-9]?[0-9]\\.){3}([12]?[0-9]?[0-9])";



}
