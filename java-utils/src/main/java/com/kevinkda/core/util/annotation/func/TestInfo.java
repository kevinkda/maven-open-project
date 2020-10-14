package com.kevinkda.core.util.annotation.func;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.container.TestInfoContainer;

import java.lang.annotation.*;

/**
 * The interface Test info.
 *
 * @author Kevin KDA on 2020/10/13 15:19
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.annotation.func
 * @classname TestInfo
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
//@Target(ElementType.TYPE)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
//@Scope("request")
@Repeatable(TestInfoContainer.class)
@Documented
public @interface TestInfo {
    /**
     * 标注测试版本号
     *
     * @return java.lang.String Version Number
     * @author Kevin KDA on 2020/10/14 12:42
     * @description TestInfo / version
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public String version() default "1.0.0";

    /**
     * 标注测试状态
     *
     * @return java.lang.String the verified type
     * @author Kevin KDA on 2020/10/14 12:42
     * @description TestInfo / version
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public VerifiedType status() default VerifiedType.Unverified;

    /**
     * 标注测试时间
     *
     * @return java.lang.String Test Time
     * @author Kevin KDA on 2020/10/14 12:42
     * @description TestInfo / version
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public String date() default "";

    /**
     * 标注测试备注
     *
     * @return java.lang.String Note
     * @author Kevin KDA on 2020/10/14 12:42
     * @description TestInfo / version
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public String note() default "";

}
