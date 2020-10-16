package com.kevinkda.core.util.exception.web.obsolete;

import java.io.Serializable;

/**
 * @author Kevin KDA on 2020/10/13 15:40
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.exception.web
 * @classname ErrorMessages
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface ErrorMessages extends Serializable {
    /**
     * 错误代码名
     *
     * @since 1.0.0
     */
    public static final String E_CODE = "errcode";
    /**
     * 错误信息名
     *
     * @since 1.0.0
     */
    public static final String E_MSG = "errmsg";
    /**
     * 请求处理数据
     *
     * @since 1.0.0
     */
    public static final String DATA = "data";
    /**
     * 请求处理使时间
     *
     * @since 1.0.0
     */
    public static final String DATE_TIME = "dateTime";
    /**
     * 请求未处理
     *
     * @since 1.0.0
     */
    public static final String NO_PRO = "Request not processed";
    /**
     * 访问验证请求返回的jwt
     */
    public static final String JWT = "jwt";


    int getCode();

    String getMsg();
}
