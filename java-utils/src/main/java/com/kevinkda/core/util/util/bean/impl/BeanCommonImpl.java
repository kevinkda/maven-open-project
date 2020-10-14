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
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * JavaBean 常用方法
 *
 * @author Kevin KDA on 2020/10/13 16:37
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.bean.impl
 * @classname
 * @apiNote <p></p>
 * @since 1.0.0
 */
@Service
public class BeanCommonImpl implements BeanCommon {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanCommonImpl.class);

    /**
     * 将{@link Map}对象转为JavaBean对象
     *
     * @param map   传入待转换的Map对象
     * @param clazz 传入JavaBean类型
     * @return T 返回转换后的JavaBean对象
     * @throws RuntimeException 转换错误
     * @author Kevin KDA on 2020/5/5 15:04
     * @description BeanCommon / toBean
     * @version 1.0.0
     * @apiNote <p></p>
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

    public BeanCommonImpl() {
    }

}
