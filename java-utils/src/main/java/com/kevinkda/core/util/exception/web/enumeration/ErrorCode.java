/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.exception.web.enumeration;

import com.kevinkda.core.util.exception.web.ErrorMessages;

/**
 * 全局统一错误代码
 *
 * @author Kevin KDA on 2020/10/13 15:36
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.exception.web.enumeration
 * @classname ErrorCode
 * @apiNote <p>统一格式：A-BB-CCC，6位长度整形int。</p>
 * <p>A：代表错误级别，1 表示系统级错误，2 表示服务级错误。</p>
 * <p>BB：代表错误项目或者模块号，从 00 开始。</p>
 * <p>CC：具体错误编号，自增，从 00 开始。</p>
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public enum ErrorCode implements ErrorMessages {
    /**
     * 请求成功，SUCCESS
     *
     * @since 1.0.0
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 请求失败，FAILED
     *
     * @since 1.0.0
     */
    FAILED(1, "FAILED"),


    /**
     * 未知错误，unknown error
     *
     * @since 1.0.0
     */
    UNKNOWN_ERROR(10000, "unknown error"),
    /**
     * 未传入指定参数：Callback，Specified parameter not passed in: callback
     *
     * @since 1.0.0
     */
    NULL_CALLBACK(10001, "Specified parameter not passed in: callback"),
    /**
     * 功能未实现，禁止访问，Function not implemented, access forbidden
     *
     * @since 1.0.0
     */
    NOT_IMPL(10002, "Function not implemented, access forbidden"),
    /**
     * 服务器内部错误，停止访问，Server internal error, stop access
     *
     * @since 1.0.0
     */
    SERVER_ERR(10003, "Server internal error, stop access"),
    /**
     * 没有传入该业务逻辑指定参数，No parameters specified in the business logic were passed in
     *
     * @since 1.0.0
     */
    NULL_PARAMETERS(10004, "No parameters specified in the business logic were passed in"),
    /**
     * 未传入指定参数：userAcc，Specified parameter not passed in: userAcc
     *
     * @since 1.0.0
     */
    NULL_USERNAME(10005, "Specified parameter not passed in: userAcc"),
    /**
     * 未传入指定参数：userPass，Specified parameter not passed in: userPass
     *
     * @since 1.0.0
     */
    NULL_USER_PASS(10006, "Specified parameter not passed in: userPass"),
    /**
     * 未传入指定参数：userType，Specified parameter not passed in: userType
     *
     * @since 1.0.0
     */
    NULL_USER_TYPE(10007, "Specified parameter not passed in: userType"),

    /**
     * 数据库插入错误，访问执行拒绝，Database insertion error, access execution denied
     *
     * @since 1.0.0
     */
    DB_INSERT_ERR(10100, "Database insertion error, access execution denied"),
    /**
     * 数据库部分数据插入错误，访问执行允许执行，Database partial data insertion error, access execution allowed
     *
     * @since 1.0.0
     */
    DB_INSERT_PART_ERR(10101, "Database partial data insertion error, access execution allowed"),

    /**
     * 用户请求类型为GET，拒绝服务，User request type is get, denial of service
     *
     * @since 1.0.0
     */
    DENIED_GET_REQUEST(10200, "User request type is get, denial of service"),

    /**
     * 正则验证错误：userAcc，Regular validation error: userAcc
     *
     * @since 1.0.0
     */
    REGEX_USER_ACC_ERR(10300, "Regular validation error: userAcc"),
    /**
     * 正则验证错误：userPass，Regular validation error: userPass
     *
     * @since 1.0.0
     */
    REGEX_USER_PASS_ERR(10301, "Regular validation error: userPass"),

    /**
     * JWT非法，JWT illegal
     *
     * @since 3.2.0
     */
    JWT_ILLEGAL(10400, "JWT illegal"),


    /**
     * 用户名不存在，user name does not exist
     *
     * @since 1.0.0
     */
    USER_ACC_NOT_EXIST(20000, "user name does not exist"),
    /**
     * 用户密码错误，Wrong user name or password
     *
     * @since 1.0.0
     */
    USER_PASS_ERROR(20001, "Wrong user name or password"),
    /**
     * 用户类型错误，Wrong user type
     *
     * @since 1.0.0
     */
    USER_TYPE_ERROR(20002, "Wrong user type"),
    /**
     * 用户名已存在，User name exists
     *
     * @since 1.0.0
     */
    USER_NAME_EXISTS(20003, "User name exists"),
    /**
     * 电子邮件地址已存在，Email address exists
     *
     * @since 1.0.0
     */
    EMAIL_EXISTS(20004, "Email address exists"),

    /**
     * 当前用户拒绝访问，Access denied by current user
     *
     * @since 1.0.0
     */
    USER_ACCESS_DENIED(20100, "Access denied by current user"),
    /**
     * 用户存在异常登录风险，User has abnormal login risk
     *
     * @since 1.0.0
     */
    RISK_ABNORMAL_LOGIN(20101, "User has abnormal login risk"),
    /**
     * 用户正常登录，无异常风险，Normal login without abnormal risk
     *
     * @since 1.0.0
     */
    RISK_NORMAL_LOGIN(20102, "Normal login without abnormal risk"),


    TEST(70000, "Dev Test");


    /**
     * JSON返回的错误代码
     *
     * @since 1.0.0
     */
    private int code;
    /**
     * JSON返回的错误信息
     *
     * @since 1.0.0
     */
    private String msg;


    private ErrorCode() {
    }

    private ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return msg;
    }


    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }


}
