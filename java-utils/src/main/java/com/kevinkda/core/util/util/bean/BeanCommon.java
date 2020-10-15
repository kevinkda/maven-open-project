/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.bean;

import java.util.Map;

/**
 * JavaBean 常用方
 *
 * @author Kevin KDA on 2020/10/13 16:37
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.bean
 * @classname BeanCommon
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface BeanCommon {
    /**
     * 将{@link Map}对象转为JavaBean对象
     *
     * @param <T>   传入指定类型
     * @param map   传入待转换的Map对象
     * @param clazz 传入JavaBean类型
     * @return T 返回转换后的JavaBean对象
     * @throws RuntimeException 转换错误
     * @author Kevin KDA on 2020/5/5 15:04
     * @description BeanCommon / toBean
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    <T> T toBean(Map<String, Object> map, Class<T> clazz);

    /**
     * 实现指定对象的属性设置
     *
     * @param o     要进行反射操作的实例化对象
     * @param value 包含有指定内容的字符串，格式"属性：内容｜属性：内容"
     * @author Kevin KDA on 2020/5/4 13:52
     * @description BeanUtils / setValue
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public void setValue(Object o, String value);

}
