package com.kevinkda.core.util.security;

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
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface SerializeKey {
    String encode(byte[] encoded);

    String encode(PrivateKey aPrivate);

    String encode(PublicKey aPublic);

    String[] encode(KeyPair keyPair);

    byte[] decode(String encode);

    List<byte[]> decode(String[] keyPair);

    List<byte[]> decode(String publicKey, String privateKey);
}
