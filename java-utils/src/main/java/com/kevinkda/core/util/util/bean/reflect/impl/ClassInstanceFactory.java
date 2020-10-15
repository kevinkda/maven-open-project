/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.bean.reflect.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.util.bean.BeanCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kevin KDA on 2020/10/14 16:31
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.bean.reflect.impl
 * @classname ClassInstanceFactory
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class ClassInstanceFactory {
    @Autowired
    private static BeanCommon beanCommon;

    /**
     * 实例化对象的创建方法，该对象可以根据传入的字符串结构"属性：内容｜属性：内容"
     *
     * @param <T> 传入参数类型
     * @param clazz 要进行反射实例化的Class类对象，有Class就可以反射实例化对象
     * @param value 要设置给对象的属性类容
     * @return T 返回泛型数据
     * @author Kevin KDA on 2020/5/4 13:58
     * @description ClassInstanceFactory / create
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:58")
    public static <T> T create(Class<T> clazz, String value) {
        try {
//            如果要想采用反射进行简单Java类对象属性设置的时候，类中必须要有无参构造
            Object o = clazz.getDeclaredConstructor().newInstance();
//            通过反射设置属性
            beanCommon.setValue(o, value);
//            返回对象
            return (T) o;
        } catch (Exception e) {
//            如果此时真的出现了错误，本质上抛出异常也没用
            e.printStackTrace();
            return null;
        }
    }
}
