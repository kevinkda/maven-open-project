/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.exception.web.impl;

import com.alibaba.fastjson.JSONObject;
import com.kevinkda.core.util.exception.web.ErrorCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Kevin KDA on 2020/10/16 10:03
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.exception.web.impl
 * @classname com.kevinkda.core.util.exception.web.impl.ErrorCodeByJsonImpl
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ErrorCodeByJsonImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorCodeByJsonImplTest.class);


    @Test
    public void test() {
        JSONObject json = new JSONObject();
        json.put("value", "123");
        LOGGER.info(json.toString());
        LOGGER.info(json.toJSONString());
        Assert.assertEquals(json.toJSONString(), "{\"value\":\"123\"}");

        LOGGER.info(json.getInnerMap().toString());
    }

    @Autowired
    @Qualifier("errorCodeByJsonImpl")
    private ErrorCode errorCode;

    @Test
    void toJson() {
        errorCode.setCode(12);
        LOGGER.info(String.valueOf(errorCode.getClass()));
        LOGGER.info(errorCode.toJsonString());


        ErrorCode code = new ErrorCodeByJsonImpl(1, "dsa", null);

        ErrorCodeByJsonImpl errorCodeByJson = new ErrorCodeByJsonImpl();
        errorCodeByJson.setMessage("dgs");
        LOGGER.info(String.valueOf(errorCodeByJson.getClass()));
        LOGGER.info(errorCodeByJson.toJsonString());

    }

    @Test
    void toJsonp() {
    }

    @Test
    void getMessage() {
    }

    @Test
    void getCode() {
    }

    @Test
    void getMsg() {
    }

    @Test
    void setErrorCode() {
    }

    @Test
    void putData() {
    }

    @Test
    void putAllData() {
    }

    @Test
    void testToJson() {
    }

    @Test
    void toJsonString() {
    }

    @Test
    void toJsonpString() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testGetCode() {
    }

    @Test
    void testGetMessage() {
    }

    @Test
    void getUpTime() {
    }

    @Test
    void getBackData() {
    }

    @Test
    void setCode() {
    }

    @Test
    void setMessage() {
    }

    @Test
    void setUpTime() {
    }

    @Test
    void setBackData() {
    }

    @Test
    void toMap() {
    }


}