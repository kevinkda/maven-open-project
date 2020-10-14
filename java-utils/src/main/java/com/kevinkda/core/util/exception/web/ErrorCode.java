package com.kevinkda.core.util.exception.web;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;

import java.util.Map;

/**
 * @author Kevin KDA on 2020/10/13 15:39
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.exception.web
 * @classname ErrorCode
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface ErrorCode extends ErrorMessages {
    /**
     * 返回错误信息的JSON数据
     *
     * @return java.lang.String 返沪JSON数据
     * @author Kevin KDA on 2020/5/16 20:02
     * @description ErrorMessages / toJsonp
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public String toJson();

    /**
     * 返回错误信息的JSONP数据
     *
     * @param callback 传入回调方法名
     * @return java.lang.String 返沪JSON数据
     * @author Kevin KDA on 2020/5/16 20:02
     * @description ErrorMessages / toJsonp
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public String toJsonp(String callback);

    /**
     * 获得错误信息
     *
     * @return {@code java.util.Map<java.lang.String, java.lang.Object>} 返回Map形式的错误信息
     * @author Kevin KDA on 2020/5/16 20:05
     * @description ErrorMessages / getMsg
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/16 20:05")
    public Map<String, Object> getMessage();


}
