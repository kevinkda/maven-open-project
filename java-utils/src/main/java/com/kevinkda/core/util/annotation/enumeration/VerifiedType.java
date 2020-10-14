package com.kevinkda.core.util.annotation.enumeration;

/**
 * The enum Verified type.
 *
 * @author Kevin KDA on 2020/10/13 15:20
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.annotation.enumeration
 * @classname VerifiedType
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public enum VerifiedType {
    /**
     * 尚未验证
     *
     * @since 1.0.0
     */
    Unverified,
    /**
     * 验证通过
     *
     * @since 1.0.0
     */
    Pass,
    /**
     * 验证存在错误，尚未修复
     *
     * @since 1.0.0
     */
    Error
}
