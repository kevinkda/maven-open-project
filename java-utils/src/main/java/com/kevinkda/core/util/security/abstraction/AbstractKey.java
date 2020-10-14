package com.kevinkda.core.util.security.abstraction;

import com.kevinkda.core.util.security.Key;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.security.KeyPair;

/**
 * @author Kevin KDA on 2020/10/13 15:43
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.security.abstraction
 * @classname AbstractKey
 * @apiNote <p></p>
 * @since 1.0.0
 */
public class AbstractKey implements Key {
    /**
     * 生成对称密钥
     *
     * @param signatureAlgorithm 传入请求的加密算法类型
     * @return javax.crypto.SecretKey 返回生成的密钥
     * @author Kevin KDA on 2020/5/26 14:42
     * @description AbstractKey / getSymmetricKey
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.2.0
     */
    public static SecretKey getSymmetricKey(SignatureAlgorithm signatureAlgorithm) {
        return null;
    }

    /**
     * 生成非对称密钥对
     *
     * @param signatureAlgorithm 传入请求的加密算法类型
     * @return java.security.KeyPair 返回生成的密钥对
     * @author Kevin KDA on 2020/5/26 14:41
     * @description AbstractKey / getAsymmetricKey
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.2.0
     */
    public static KeyPair getAsymmetricKey(SignatureAlgorithm signatureAlgorithm) {
        return null;
    }

}
