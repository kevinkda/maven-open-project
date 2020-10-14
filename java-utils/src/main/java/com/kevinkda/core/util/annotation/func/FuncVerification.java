package com.kevinkda.core.util.annotation.func;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.container.FuncVerificationContainer;

import java.lang.annotation.*;

/**
 * 标注方法测试状态
 *
 * @author Kevin KDA on 2020/10/13 15:17
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.annotation.func
 * @classname FuncVerification
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
@Repeatable(FuncVerificationContainer.class)
@Documented
public @interface FuncVerification {

    /**
     * 标注测试版本号
     *
     * @return the string
     * @author Kevin KDA on 2020/4/17 14:59
     * @since 1.0.0
     */
    public String version() default "1.0.0";

    /**
     * 标注测试状态
     *
     * @return the verified type
     * @author Kevin KDA on 2020/4/17 14:59
     * @since 1.0.0
     */
    public VerifiedType status() default VerifiedType.Unverified;

    /**
     * 标注测试时间
     *
     * @return the string
     * @author Kevin KDA on 2020/4/17 14:59
     * @since 1.0.0
     */
    public String date() default "";

    /**
     * 标注测试备注
     *
     * @return the string
     * @author Kevin KDA on 2020/4/26 15:28
     * @since 1.0.0
     */
    public String note() default "";
}
