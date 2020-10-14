package com.kevinkda.core.util.annotation.func.container;

import com.kevinkda.core.util.annotation.func.TestInfo;

import java.lang.annotation.*;

/**
 * The interface Test info container.
 *
 * @author Kevin KDA on 2020/10/13 15:23
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.annotation.func.container
 * @classname TestInfoContainer
 * @apiNote <p></p>
 * @since 1.0.0
 */
//@Target(ElementType.TYPE)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
//@Scope("request")
public @interface TestInfoContainer {
    /**
     * Value test info [ ].
     *
     * @return the test info [ ]
     */
    TestInfo[] value();
}
