/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.security.jwt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Kevin KDA on 2020/10/14 17:15
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.security.jwt.config
 * @classname JwtConfig
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Configuration
public class JwtConfig {
//    header
    /**
     * 加密算法
     *
     * @since 1.0.0
     */
    @Value("${jwt.algorithm}")
    public static String ALGORITHM;
    /**
     * 数据类型
     *
     * @since 1.0.0
     */
    @Value("${jwt.type}")
    public static String TYPE;


//    Payload
    /**
     * 签发人
     *
     * @since 1.0.0
     */
    @Value("${jwt.issuer}")
    public static String ISSUER;
    /**
     * 过期时间
     *
     * @since 1.0.0
     */
    @Value("${jwt.exptime}")
    public static String EXPIRATION_TIME;
    /**
     * 主题
     *
     * @since 1.0.0
     */
    @Value("${jwt.subject}")
    public static String SUBJECT;
    /**
     * 受众
     *
     * @since 1.0.0
     */
    @Value("${jwt.audience}")
    public static String AUDIENCE;
    /**
     * 生效时间
     *
     * @since 1.0.0
     */
    @Value("${jwt.notbefore}")
    public static String NOT_BEFORE;
    /**
     * 签发时间
     *
     * @since 1.0.0
     */
    @Value("${jwt.issuedat}")
    public static String ISSUED_AT;
    /**
     * 编号
     *
     * @since 1.0.0
     */
    @Value("${jwt.jwtid}")
    public static String JWT_ID;

}
