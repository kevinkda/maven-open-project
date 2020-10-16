/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.security.jwt.domain;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.security.jwt.config.JwtConfig;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * JWT实体
 *
 * @author Kevin KDA on 2020/10/14 16:45
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.security.jwt.domain
 * @classname Jwt
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jwt extends JwtConfig {
//    header
    /**
     * 加密算法
     *
     * @since 1.0.0
     */
    private String alg;
    /**
     * 数据类型
     *
     * @since 1.0.0
     */
    private String typ;


//    Payload
    /**
     * 签发人
     *
     * @since 1.0.0
     */
    private String iss;
    /**
     * 过期时间
     *
     * @since 1.0.0
     */
    private String exp;
    /**
     * 主题
     *
     * @since 1.0.0
     */
    private String sub;
    /**
     * 受众
     *
     * @since 1.0.0
     */
    private String aud;
    /**
     * 生效时间
     *
     * @since 1.0.0
     */
    private String nbf;
    /**
     * 签发时间
     *
     * @since 1.0.0
     */
    private String iat;
    /**
     * 编号
     *
     * @since 1.0.0
     */
    private String jti;


    /**
     * 设置JWT默认参数包含请求头和Payload
     *
     * @author Kevin KDA on 2020/10/14 17:39
     * @description Jwt / setDefaultParameters
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 17:39")
    public void setDefaultParameters() {
        setDefaultHeaderParameters();
        setDefaultPayloadParameters();
    }

    /**
     * 设置JWT默认请求头参数
     *
     * @author Kevin KDA on 2020/10/14 17:40
     * @description Jwt / setDefaultHeaderParameters
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 17:40")
    public void setDefaultHeaderParameters() {
        if (alg == null || "".equals(alg)) {
            this.alg = ALGORITHM;
        }
        if (typ == null || "".equals(typ)) {
            this.typ = TYPE;
        }
    }

    /**
     * 设置JWT默认Payload参数
     *
     * @author Kevin KDA on 2020/10/14 17:40
     * @description Jwt / setDefaultPayloadParameters
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 17:40")
    public void setDefaultPayloadParameters() {
        if (iss == null || "".equals(iss)) {
            this.iss = ISSUER;
        }
        if (exp == null || "".equals(exp)) {
            this.exp = EXPIRATION_TIME;
        }
        if (sub == null || "".equals(sub)) {
            this.sub = SUBJECT;
        }
        if (aud == null || "".equals(aud)) {
            this.aud = AUDIENCE;
        }
        if (nbf == null || "".equals(nbf)) {
            this.nbf = NOT_BEFORE;
        }
        if (iat == null || "".equals(iat)) {
            this.iat = ISSUED_AT;
        }
        if (jti == null || "".equals(jti)) {
            this.jti = JWT_ID;
        }
    }


    /**
     * 获得JWT数据头Map
     *
     * @return {@code java.util.Map<java.lang.String,java.lang.Object>}
     * @author Kevin KDA on 2020/10/14 17:31
     * @description Jwt / getHeaderMap
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 17:31")
    public Map<String, Object> getHeaderMap() {
        setDefaultHeaderParameters();
        Map<String, Object> map = new HashMap<>();
        map.put("alg", alg);
        map.put("typ", typ);
        return map;
    }

    /**
     * 获得JWT Payload Map
     *
     * @return {@code java.util.Map<java.lang.String,java.lang.Object>}
     * @author Kevin KDA on 2020/10/14 17:32
     * @description Jwt / getPayloadMap
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 17:32")
    public Map<String, Object> getPayloadMap() {
        setDefaultPayloadParameters();
        Map<String, Object> map = new HashMap<>();
        map.put("iss", iss);
        map.put("exp", exp);
        map.put("sub", sub);
        map.put("aud", aud);
        map.put("nbf", nbf);
        map.put("iat", iat);
        map.put("jti", jti);
        return map;
    }


    public void test() {
        JwtBuilder jwtBuilder=new DefaultJwtBuilder();
    }
}
