/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.jwt.abstraction;

import com.kevinkda.core.util.exception.web.enumeration.ErrorCode;
import com.kevinkda.core.util.util.jwt.Jwt;
import io.jsonwebtoken.JwtBuilder;

/**
 * @author Kevin KDA on 2020/10/14 15:47
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.jwt.abstraction
 * @classname AbstractJwt
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public abstract class AbstractJwt implements Jwt {
    /**
     * JWT Sign 段加密密钥
     *
     * @since 3.1.2
     */
    static String SECRET;
    /**
     * JWT 生成字段
     *
     * @since 3.1.2
     */
    protected JwtBuilder builder;

    @Override
    public int getSecret() {
        SECRET = "THIS_SECRET";
        return ErrorCode.SUCCESS.getCode();
    }
}
