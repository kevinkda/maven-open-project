package com.kevinkda.core.util.annotation.func.container;

import com.kevinkda.core.util.annotation.func.FuncVerification;

import java.lang.annotation.*;

/**
 * The interface Func verification container.
 *
 * @author Kevin KDA on 2020/10/13 15:22
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.annotation.func.container
 * @classname FuncVerificationContainer
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
//@Target(ElementType.TYPE)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
//@Scope("request")
public @interface FuncVerificationContainer {
    /**
     * Value func verification [ ].
     *
     * @return the func verification [ ]
     */
    FuncVerification[] value();
}
