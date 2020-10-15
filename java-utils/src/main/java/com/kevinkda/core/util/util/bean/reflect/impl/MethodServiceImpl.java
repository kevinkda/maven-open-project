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
import com.kevinkda.core.util.util.bean.reflect.MethodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取方法信息
 *
 * @author Kevin KDA on 2020/10/14 16:14
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.bean.reflect.impl
 * @classname
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class MethodServiceImpl implements MethodService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodServiceImpl.class);


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
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:56")
    public void showMethodInformation(Class<?> cls) {
//        Class<?> cls = InputNum.class;
        Method[] methods = cls.getMethods();
        StringBuilder builder;
        for (Method met :
                methods) {
            builder = new StringBuilder();
//            修饰符
            int mod = met.getModifiers();
            builder.append(Modifier.toString(mod)).append(" ");
            builder.append(met.getReturnType().getName()).append(" ");
            builder.append(met.getName()).append("(");
//            获取参数类型
            Class<?>[] params = met.getParameterTypes();
            for (int x = 0; x < params.length; x++) {
                builder.append(params[x].getName()).append(" ").append("arg-").append(x);
                if (x < params.length - 1) {
                    builder.append(", ");
                }
            }
            builder.append(")");
            Class<?>[] exp = met.getExceptionTypes();
            if (exp.length > 0) {
                builder.append(" throws ");
            }
            for (int i = 0; i < exp.length; i++) {
                builder.append(exp[i].getName());
                if (i < exp.length - 1) {
                    builder.append(",");
                }
            }
            LOGGER.info(builder.toString());
        }
    }

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
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:57")
    public List<String> getMethodInformation(Class<?> cls) {
        List<String> list = new ArrayList<>();
        StringBuilder builder;
        Method[] methods = cls.getMethods();
        for (Method met :
                methods) {
//            修饰符
            builder = new StringBuilder();
            int mod = met.getModifiers();
            builder.append(Modifier.toString(mod));
            builder.append(" ");
            builder.append(met.getReturnType().getName());
            builder.append(" ");
            builder.append(met.getName());
            builder.append("(");
//            获取参数类型
            Class<?>[] params = met.getParameterTypes();
            for (int x = 0; x < params.length; x++) {
                builder.append(params[x].getName());
                builder.append(" ");
                builder.append("arg-");
                builder.append(x);
                if (x < params.length - 1) {
                    builder.append(", ");
                }
            }
            builder.append(")");
            Class<?>[] exp = met.getExceptionTypes();
            if (exp.length > 0) {
                builder.append(" throws ");

            }
            for (int i = 0; i < exp.length; i++) {
                builder.append(exp[i].getName());
                if (i < exp.length - 1) {
                    builder.append(",");
                }
            }
            list.add(builder.toString());
        }
        return list;
    }
}
