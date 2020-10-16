/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.exception.web;

import com.kevinkda.core.util.exception.web.impl.ErrorCodeByJsonImpl;
import com.kevinkda.core.util.util.json.JsonHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;

/**
 * @author Kevin KDA on 2020/10/16 13:57
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.exception.web
 * @classname com.kevinkda.core.util.exception.web.ErrorCode
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
class ErrorCodeTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorCodeTest.class);

    @Autowired
    @Qualifier("errorCodeByJsonImpl")
    private ErrorCode errorCode;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
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
    void toJson() {
        LOGGER.info(String.valueOf(errorCode.getClass()));
        ErrorCodeByJsonImpl errorCodeByJson = new ErrorCodeByJsonImpl();
        errorCodeByJson.setCode(123);
        errorCodeByJson.setMessage("sdga");
//        errorCodeByJson.setBackData("3089");
        errorCodeByJson.setUpTime(new Date(System.currentTimeMillis()));

        LOGGER.info(JsonHelper.toJsonString(errorCodeByJson));

    }

    @Test
    void toJsonString() {
    }

    @Test
    void toJsonpString() {
    }

    @Test
    void getCode() {
    }

    @Test
    void setCode() {
    }

    @Test
    void getMessage() {
    }

    @Test
    void setMessage() {
    }

    @Test
    void getUpTime() {
    }

    @Test
    void setUpTime() {
    }

    @Test
    void getBackData() {
    }

    @Test
    void setBackData() {
    }
}