/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.bean.reflect;

import java.util.List;

/**
 * @author Kevin KDA on 2020/10/14 16:14
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.bean.reflect
 * @classname MethodService
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface MethodService {
    /**
     * 获取指定类的方法信息
     *
     * @param cls 获得指定类的Class对象
     * @author Kevin KDA on 2020/5/4 13:56
     * @description MethodInfo / showMethodInformation
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public void showMethodInformation(Class<?> cls);

    /**
     * 获取指定类的方法信息
     *
     * @param cls 获得指定类的Class对象
     * @return {@code java.util.List<java.lang.String>} 返回方法信息数组
     * @author Kevin KDA on 2020/5/4 13:57
     * @description MethodInfo / getMethodInformation
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public List<String> getMethodInformation(Class<?> cls);

}
