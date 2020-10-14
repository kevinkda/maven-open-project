package com.kevinkda.core.util.security;

import java.io.Serializable;

/**
 * @author Kevin KDA on 2020/10/13 15:42
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.security
 * @classname Key
 * @apiNote <p></p>
 * @since 1.0.0
 */
public interface Key extends Serializable {
    /**
     * 存储数据公钥名
     */
    public static final String PUBLIC = "public";
    /**
     * 存储数据私钥名
     */
    public static final String PRIVATE = "private";

}
