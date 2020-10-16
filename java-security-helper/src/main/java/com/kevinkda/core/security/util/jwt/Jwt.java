/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.security.util.jwt;

/**
 * @author Kevin KDA on 2020/10/14 15:48
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.security.util.jwt
 * @classname Jwt
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface Jwt {

    /**
     * 签发人
     *
     * @since 3.2.0
     */
    public static final String ISSUER = "iss";
    /**
     * 过期时间
     *
     * @since 3.2.0
     */
    public static final String EXPIRATION_TIME = "exp";
    /**
     * 主题
     *
     * @since 3.2.0
     */
    public static final String SUBJECT = "sub";
    /**
     * 受众
     *
     * @since 3.2.0
     */
    public static final String AUDIENCE = "aud";
    /**
     * 生效时间
     *
     * @since 3.2.0
     */
    public static final String NOT_BEFORE = "nbf";
    /**
     * 签发时间
     *
     * @since 3.2.0
     */
    public static final String ISSUED_AT = "iat";
    /**
     * 编号
     *
     * @since 3.2.0
     */
    public static final String JWT_ID = "jti";


    /**
     * 得到 JWT Sign 段加密密钥
     *
     * @return int 返回处理状态值
     * @author Kevin KDA on 2020/5/26 09:19
     * @description Jwt / getSecret
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    int getSecret();


    String createJwt();

}
