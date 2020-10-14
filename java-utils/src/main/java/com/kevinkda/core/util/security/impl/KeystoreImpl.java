package com.kevinkda.core.util.security.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.security.Keystore;
import com.kevinkda.core.util.security.SerializeKey;
import com.kevinkda.core.util.util.io.property.PropertyModify;
import com.kevinkda.core.util.util.io.property.impl.PropertyModifyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kevin KDA on 2020/10/13 15:48
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.security.impl
 * @classname
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class KeystoreImpl implements Keystore {
    @Autowired
    private static SerializeKey serializeKey;

    /**
     * 向 Property 存储密钥对
     *
     * @param path    传入Property路径
     * @param keyPair 传入密钥对
     
     * @author Kevin KDA on 2020/5/26 23:03
     * @description Keystore / saveForProperty
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 23:03")
    public static void saveForProperty(String path, KeyPair keyPair) {
//        创建 Property 修改对象
        PropertyModify modify = new PropertyModifyImpl(path);
//        存入序列化后的公钥
        modify.addProperty(PUBLIC, serializeKey.encode(keyPair.getPublic()));
//        存入序列化后的私钥
        modify.addProperty(PRIVATE, serializeKey.encode(keyPair.getPrivate()));
    }

    /**
     * 向 Property 存储密钥对
     *
     * @param path       传入Property路径
     * @param publicKey  传入公钥
     * @param privateKey 传入私钥
     
     * @author Kevin KDA on 2020/5/26 23:03
     * @description Keystore / saveForProperty
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 23:03")
    public static void saveForProperty(String path, PublicKey publicKey, PrivateKey privateKey) {
//        创建 Property 修改对象
        PropertyModify modify = new PropertyModifyImpl(path);
//        存入序列化后的公钥
        modify.addProperty(PUBLIC, serializeKey.encode(publicKey.getEncoded()));
//        存入序列化后的私钥
        modify.addProperty(PRIVATE, serializeKey.encode(privateKey.getEncoded()));
    }

    /**
     * 向 Property 存储密钥对
     *
     * @param path       传入Property路径
     * @param publicKey  传入公钥
     * @param privateKey 传入私钥
     
     * @author Kevin KDA on 2020/5/26 23:03
     * @description Keystore / saveForProperty
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 23:03")
    public static void saveForProperty(String path, String publicKey, String privateKey) {
//        创建 Property 修改对象
        PropertyModify modify = new PropertyModifyImpl(path);
//        存入序列化后的公钥
        modify.addProperty(PUBLIC, publicKey);
//        存入序列化后的私钥
        modify.addProperty(PRIVATE, privateKey);
    }


    /**
     * 从 Property 读取已存储的存储密钥对
     *
     * @param path 传入Property路径
     * @return java.lang.String[] 返回序列化后{@link String}类型密钥
     * @author Kevin KDA on 2020/5/26 23:04
     * @description Keystore / readFromPropertyOfString
     * @version 1.0.0
     * @apiNote <p>返回数据下标0：私钥编码</p>
     * <p>返回数据下标1：公钥编码</p>
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 23:04")
    public static String[] readFromPropertyOfString(String path) {
//        创建 Property 修改对象
        PropertyModify modify = new PropertyModifyImpl(path);
//        获得序列化后的公钥
        String publicKey = modify.getProperty(PUBLIC);
//        获得序列化后的私钥
        String privateKey = modify.getProperty(PRIVATE);
//        返回数据
        return new String[]{publicKey, privateKey};
    }

    /**
     * 从 Property 读取已存储的存储密钥对
     *
     * @param path 传入Property路径
     * @return {@code java.util.List<byte[]>} 返回反序列化后{@link byte[]}类型密钥
     * @author Kevin KDA on 2020/5/26 23:06
     * @description Keystore / readFromProperty
     * @version 1.0.0
     * @apiNote <p>返回数据下标0：私钥编码</p>
     * <p>返回数据下标1：公钥编码</p>
     * @implSpec
     * @implNote
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 23:06")
    public static List<byte[]> readFromProperty(String path) {
//        创建 Property 修改对象
        PropertyModify modify = new PropertyModifyImpl(path);

//        获得反序列化后的公钥
        byte[] publicKey = serializeKey.decode(modify.getProperty(PUBLIC));
//        获得反序列化后的私钥
        byte[] privateKey = serializeKey.decode(modify.getProperty(PRIVATE));

//        返回数据
        return new ArrayList<byte[]>(Arrays.asList(publicKey, privateKey));
    }


    public KeystoreImpl() {
    }
}
