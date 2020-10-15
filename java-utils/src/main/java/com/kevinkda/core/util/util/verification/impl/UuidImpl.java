/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.verification.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.util.verification.Uuid;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.UUID;

/**
 * UUID服务类
 *
 * @author Kevin KDA on 2020/10/14 14:30
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.verification.impl
 * @classname UuidImpl
 * @apiNote <p>本类已实现 {@link Serializable} 接口</p>
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class UuidImpl implements Uuid {
    /**
     * 获得UUID
     *
     * @return java.lang.String 返回带有中横线分隔符的UUID
     * @author Kevin KDA on 2020/5/5 14:51
     * @description Uuid / getUuid
     * @version 1.0.0
     * @apiNote <p>返回值均为大写字母</p>
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 14:51")
    public String getUuid() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 获得UUID
     *
     * @return java.lang.String 返回没有中横线分隔符的UUID
     * @author Kevin KDA on 2020/5/5 14:54
     * @description Uuid / getUuidString
     * @version 1.0.0
     * @apiNote <p>返回值均为大写字母</p>
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 14:54")
    public String getUuidString() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 对传入对UUID进行大写处理，并去除中横线
     *
     * @param uuid 传入以获得的UUID
     * @return java.lang.String
     * @author Kevin KDA on 2020/5/9 10:55
     * @description Uuid / toUpperCase
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/9 10:55")
    public String toUpperCase(String uuid) {
        return uuid.replace("-", "").toUpperCase();
    }

    public UuidImpl() {
    }

}
