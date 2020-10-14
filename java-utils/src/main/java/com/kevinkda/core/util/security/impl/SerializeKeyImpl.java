package com.kevinkda.core.util.security.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.security.SerializeKey;
import com.kevinkda.core.util.security.abstraction.AbstractKey;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kevin KDA on 2020/10/13 15:51
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.security.impl
 * @classname
 * @apiNote <p></p>
 * @since 1.0.0
 */
@Service
public class SerializeKeyImpl extends AbstractKey implements SerializeKey {
    /**
     * 序列化密钥
     *
     * @param encoded 传入待序列化的密钥字节数组
     * @return java.lang.String 返回序列化后的十六进制密钥编码
     * @author Kevin KDA on 2020/5/26 22:04
     * @description SerializeKey / encode
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:04")
    public String encode(byte[] encoded) {
        return HexBin.encode(encoded);
    }

    /**
     * 序列化密钥
     *
     * @param aPrivate 传入待序列化的私钥
     * @return java.lang.String 返回序列化后的十六进制密钥编码
     * @author Kevin KDA on 2020/5/26 22:04
     * @description SerializeKey / encode
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:04")
    public String encode(PrivateKey aPrivate) {
        return encode(aPrivate.getEncoded());
    }

    /**
     * 序列化密钥
     *
     * @param aPublic 传入待序列化的公钥
     * @return java.lang.String 返回序列化后的十六进制密钥编码
     * @author Kevin KDA on 2020/5/26 22:04
     * @description SerializeKey / encode
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:04")
    public String encode(PublicKey aPublic) {
        return encode(aPublic.getEncoded());
    }

    /**
     * 序列化密钥对
     *
     * @param keyPair 传入待序列化的密钥对
     * @return java.lang.String[] 返回序列化后的十六进制密钥编码
     * @author Kevin KDA on 2020/5/26 22:07
     * @description SerializeKey / encode
     * @version 1.0.0
     * @apiNote <p>返回数据下标0：私钥编码</p>
     * <p>返回数据下标1：公钥编码</p>
     * @since 3.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:07")
    public String[] encode(KeyPair keyPair) {
        return new String[]{
                HexBin.encode(keyPair.getPrivate().getEncoded()),
                HexBin.encode(keyPair.getPrivate().getEncoded())
        };
    }


    /**
     * 反序列化密钥
     *
     * @param encode 传入已序列化的密钥
     * @return byte[] 返回反序列化后的字节数组
     * @author Kevin KDA on 2020/5/26 22:15
     * @description SerializeKey / decode
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:15")
    public byte[] decode(String encode) {
        return HexBin.decode(encode);
    }

    /**
     * 反序列化密钥
     *
     * @param keyPair 传入已序列化的密钥对
     * @return {@code java.util.List<byte[]>} 返回反序列化后的字节数组
     * @author Kevin KDA on 2020/5/26 22:17
     * @description SerializeKey / decode
     * @version 1.0.0
     * @apiNote <p>本方法仅限传入2个参数，回调顺序与调用方法传入顺序一致</p>
     * @since 3.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:17")
    public List<byte[]> decode(String[] keyPair) {
        return new ArrayList<>(Arrays.asList(
                HexBin.decode(keyPair[0]),
                HexBin.decode(keyPair[1])
        ));
    }

    /**
     * 反序列化密钥
     *
     * @param publicKey  传入已序列化的公钥值
     * @param privateKey 传入已序列化的私钥值
     * @return {@code java.util.List<byte[]>} 返回反序列化后的字节数组
     * @author Kevin KDA on 2020/5/26 22:17
     * @description SerializeKey / decode
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:17")
    public List<byte[]> decode(String publicKey, String privateKey) {
        return new ArrayList<>(Arrays.asList(
                HexBin.decode(publicKey),
                HexBin.decode(privateKey)
        ));
    }


    public SerializeKeyImpl() {
    }
}
