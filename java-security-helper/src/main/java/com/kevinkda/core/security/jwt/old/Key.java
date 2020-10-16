/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.security.jwt.old;

import java.io.Serializable;

/**
 * @author Kevin KDA on 2020/10/13 15:42
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.security
 * @classname Key
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface Key extends Serializable {
    /**
     * 存储数据公钥名
     *
     * @since 1.0.0
     */
    public static final String PUBLIC = "public";
    /**
     * 存储数据私钥名
     *
     * @since 1.0.0
     */
    public static final String PRIVATE = "private";

}
