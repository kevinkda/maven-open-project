package com.kevinkda.core.util.security;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;

/**
 * @author Kevin KDA on 2020/10/13 15:51
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.security
 * @classname SerializeKey
 * @apiNote <p></p>
 * @since 1.0.0
 */
public interface SerializeKey {
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:04")
     String encode(byte[] encoded);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:04")
    String encode(PrivateKey aPrivate);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:04")
    String encode(PublicKey aPublic);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:07")
    String[] encode(KeyPair keyPair);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:15")
    byte[] decode(String encode);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:17")
    List<byte[]> decode(String[] keyPair);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/26 22:17")
    List<byte[]> decode(String publicKey, String privateKey);
}
