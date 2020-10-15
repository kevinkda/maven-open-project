/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.bean.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.util.bean.BeanCommon;
import com.kevinkda.core.util.util.string.impl.StringHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JavaBean 常用方法
 *
 * @author Kevin KDA on 2020/10/13 16:37
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.bean.impl
 * @classname
 * @apiNote
 * @since 1.0.0
 */
@Service
public class BeanCommonImpl implements BeanCommon {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanCommonImpl.class);

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
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 15:04")
    public <T> T toBean(Map<String, Object> map, Class<T> clazz) {
//        创建指定类型的 javabean 对象
//        T bean = null;
        try {
            T bean = clazz.newInstance();
//            创建指定类型的 javabean 对象
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            LOGGER.debug(e.getLocalizedMessage());
            LOGGER.debug(e.getMessage());
            LOGGER.debug(String.valueOf(e.getCause()));
            throw new RuntimeException(e);
        }
    }

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
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:52")
    public void setValue(Object o, String value) {
//        按照"｜"进行每一组的属性拆分
        String[] results = value.split("\\|");
//        循环设置属性内容
        for (int i = 0; i < results.length; i++) {
//            attval[0]保存的是属性名称，attval[1]保存的是属性内容
//            获取"属性名称"与内容
            String[] attval = results[i].split(":");
            Object currentObject = o;
            try {
//                多级配置
                if (attval[0].contains("\\.")) {
                    String[] temp = attval[0].split("\\.");
//                    最后一位肯定是指定类中的属性名称，所以不在本次实例化处理的范畴之内
                    for (int j = 0; j < temp.length - 1; j++) {
//                        调用相应的 getter 方法，如果 getter 方法返回了 nu11 表示该对家未实例化
                        Method getMethod = o.getClass().getDeclaredMethod("get" + StringHelper.initialUppercase(temp[j]));
                        Object tempObject = getMethod.invoke(currentObject);
//                        如果该对象现在并没有实例化
                        if (tempObject == null) {
//                            获取属性类型
                            Field field = currentObject.getClass().getDeclaredField(temp[j]);
                            Method method = currentObject.getClass().getDeclaredMethod("set" + StringHelper.initialUppercase(temp[j], field.getType()));
                            Object newObject = field.getType().getDeclaredConstructor().newInstance();
                            method.invoke(currentObject, newObject);
                            currentObject = newObject;
                        } else {
                            currentObject = tempObject;
                        }
                    }
//                    进行属性内容的设置
//                    获取成员
                    Field field = currentObject.getClass().getDeclaredField(temp[temp.length - 1]);
                    Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringHelper.initialUppercase(temp[temp.length - 1], field.getType()));
                    Object convertValue = convertAttributeValue(field.getType().getName(), attval[1]);
//                    调用setter方法设置内容
                    Object invoke = setMethod.invoke(currentObject, convertValue);
                } else {
//                    获取成员
                    Field field = o.getClass().getDeclaredField(attval[0]);
                    Method setMethod = o.getClass().getDeclaredMethod("set" + StringHelper.initialUppercase(attval[0], field.getType()));
                    Object convertValue = convertAttributeValue(field.getType().getName(), attval[1]);
//                    调用setter方法设置内容
                    Object invoke = setMethod.invoke(o, convertValue);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现属性类型转换处理
     *
     * @param type  属性类型，通过Field获取
     * @param value 属性的内容，传入的都是字符串，需要将其变为指定类型
     * @return java.lang.Object 转换后的数据
     * @author Kevin KDA on 2020/5/4 13:53
     * @description BeanUtils / convertAttributeValue
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:53")
    private Object convertAttributeValue(String type, String value) {
//        检查传入类型
        if ("long".equals(type) || "java.lang.Long".equals(type)) {
//            长整型
            return Long.parseLong(value);
        } else if ("int".equals(type) || "java.lang.int".equals(type)) {
            return Integer.parseInt(value);
        } else if ("double".equals(type) || "java.lang.double".equals(type)) {
            return Double.parseDouble(value);
        } else if ("java.lang.Date".equals(type)) {
//            日期类型
            SimpleDateFormat simpleDateFormat = null;
            if (value.matches("\\d{4}-\\d{2}-\\d{2}")) {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            } else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            } else {
//                当前日期
                return new Date();
            }
            try {
                return simpleDateFormat.parse(value);
            } catch (ParseException e) {
//                当前日期
                return new Date();
            }
        } else {
            return value;
        }
    }


    /**
     * 将任意vo转化成Map
     *
     * @param <T> 传入指定类型
     * @param t   vo对象
     * @return {@code java.util.Map<?, ?>}
     * @author Kevin KDA on 2020/10/15 15:04
     * @description BeanCommonImpl / convert2Map
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/15 15:04")
    public <T> Map<?, ?> convert2Map(T t) {
        Map<String, Object> result = new HashMap<>();
        Method[] methods = t.getClass().getMethods();
        try {
            for (Method method : methods) {
                Class<?>[] paramClass = method.getParameterTypes();
                // 如果方法带参数，则跳过
                if (paramClass.length > 0) {
                    continue;
                }
                String methodName = method.getName();
                if (methodName.startsWith("get")) {
                    Object value = method.invoke(t);
                    result.put(methodName, value);
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | SecurityException e) {
            e.printStackTrace();
        }
        return result;
    }


    public BeanCommonImpl() {
    }

}
