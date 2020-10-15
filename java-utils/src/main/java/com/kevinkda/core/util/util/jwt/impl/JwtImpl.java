/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.jwt.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.exception.web.enumeration.ErrorCode;
import com.kevinkda.core.util.security.old.SerializeKey;
import com.kevinkda.core.util.security.old.abstraction.AbstractKey;
import com.kevinkda.core.util.util.jwt.Jwt;
import com.kevinkda.core.util.util.jwt.abstraction.AbstractJwt;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin KDA on 2020/10/14 15:49
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.jwt.impl
 * @classname
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class JwtImpl extends AbstractJwt implements Jwt {

    @Autowired
    private SerializeKey serializeKey;


    @Override
    public int getSecret() {

        return ErrorCode.SUCCESS.getCode();
    }

    @Override
    public String createJwt() {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        KeyPair keyPair = generalKey(signatureAlgorithm);

        JwtBuilder builder = Jwts.builder();

        return null;
    }

    public String createJwt(String path, Map<String, Object> header, Map<String, Object> claims) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
        List<byte[]> keyPair = getKeyPair(path);

        builder.setHeader(header);
        builder.setClaims(claims);
        builder = sign(builder, keyPair.get(1));

        return builder.compact();
    }

    public int verify(String path, String token) {
        List<byte[]> keyPair = getKeyPair(path);
        Jws<Claims> claims = Jwts.parser().setSigningKey(keyPair.get(0)).parseClaimsJws(token);
        claims.getBody();
        return 0;
    }

    private JwtBuilder sign(JwtBuilder builder, byte[] privateKey) {
        return builder.signWith(SignatureAlgorithm.ES256, privateKey);
    }

    /**
     * 生成密钥
     *
     * @param signatureAlgorithm 传入加密算法
     * @return java.security.KeyPair 返回密钥对
     * @author Kevin KDA on 2020/5/26 14:35
     * @description JwtImpl / generalKey
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/26 14:35")
    private KeyPair generalKey(SignatureAlgorithm signatureAlgorithm) {
        KeyPair keyPair = AbstractKey.getAsymmetricKey(signatureAlgorithm);
        return null;
    }

    /**
     * 从Property中读取序列化后的密钥对
     *
     * @param path 传入Property路径
     * @return java.lang.String[] 返回序列化后的密钥对
     * @author Kevin KDA on 2020/5/26 23:25
     * @description JwtImpl / getKeyPairOfString
     * @version 1.0.0
     * @apiNote <p>返回数据下标0：私钥编码</p>
     * <p>返回数据下标1：公钥编码</p>
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/26 23:25")
    private String[] getKeyPairOfString(String path) {
//        return Key.readFromPropertyOfString(path);
        return null;
    }

    /**
     * 从Property中读取反序列化后的密钥对
     *
     * @param path 传入Property路径
     * @return {@code java.util.List<byte[]>} 返回反序列化后的密钥对
     * @author Kevin KDA on 2020/5/26 23:28
     * @description JwtImpl / getKeyPair
     * @version 1.0.0
     * @apiNote <p>返回数据下标0：私钥编码</p>
     * <p>返回数据下标1：公钥编码</p>
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/26 23:28")
    private List<byte[]> getKeyPair(String path) {
//        return Keystore.readFromProperty(path);
        return null;
    }


    public JwtImpl() {
        builder = Jwts.builder();
    }
}
