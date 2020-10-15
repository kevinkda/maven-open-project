/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.security.old;

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
