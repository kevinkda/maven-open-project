package com.kevinkda.core.util.exception.web;

import com.alibaba.fastjson.JSONObject;
import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;

import java.util.Date;
import java.util.Map;

/**
 * 成功或错误信息服务
 *
 * @author Kevin KDA on 2020/10/13 15:39
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.exception.web
 * @classname ErrorCode
 * @apiNote
 * @implSpec
 * @implNote
 * @since 0.0.4
 */
public interface ErrorCode extends ErrorMessages {
    /**
     * 传入枚举类型错误编码信息，自动转化错误代码和错误信息
     *
     * @param code 传入枚举类型错误编码信息
     * @author Kevin KDA on 2020/10/16 11:59
     * @description ErrorCode / setErrorCode
     * @version 1.0.0
     * @apiNote <p>方法传入类型需为{@link com.kevinkda.core.util.exception.web.enumeration.ErrorCode}枚举类型常量</p>
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    void setErrorCode(com.kevinkda.core.util.exception.web.enumeration.ErrorCode code);

    /**
     * 存入键值对
     *
     * @param key   传入索引键
     * @param value 传入值
     * @author Kevin KDA on 2020/10/16 13:08
     * @description ErrorCode / putData
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    void putData(String key, Object value);

    /**
     * 存入所有键值对
     *
     * @param data 传入{@code Map<String, ?>}对象
     * @author Kevin KDA on 2020/10/16 13:11
     * @description ErrorCode / putAllData
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/16 13:11")
    void putAllData(Map<String, ?> data);


    /**
     * 返回错误信息的JSON数据
     *
     * @return java.lang.String 返回JSON数据
     * @author Kevin KDA on 2020/5/16 20:02
     * @description ErrorCode / toJson
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    Object toJson();

    /**
     * 将本对象相信转为Map对象
     *
     * @return {@code java.util.Map<java.lang.String,?>} Map对象
     * @author Kevin KDA on 2020/10/16 14:05
     * @description ErrorCode / toMap
     * @version 0.0.4
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    Map<String, Object> toMap();

    /**
     * 返回错误信息的JSON数据
     *
     * @return java.lang.String 返回JSON字符串数据
     * @author Kevin KDA on 2020/10/16 11:20
     * @description ErrorCode / toJsonString
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    String toJsonString();

    /**
     * 返回错误信息的JSONP数据
     *
     * @param callback 传入回调方法名
     * @return java.lang.String 返沪JSON数据
     * @author Kevin KDA on 2020/5/16 20:02
     * @description ErrorMessages / toJsonpString
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    String toJsonpString(String callback);


    /**
     * 获得错误代码值
     *
     * @return int 错误代码值
     * @author Kevin KDA on 2020/10/16 13:50
     * @description ErrorCode / getCode
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    int getCode();

    /**
     * 设置错误代码值
     *
     * @param code 传入错误代码值
     * @author Kevin KDA on 2020/10/16 13:50
     * @description ErrorCode / setCode
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    void setCode(int code);

    /**
     * 获得错误代码信息
     *
     * @return java.lang.String 错误代码信息
     * @author Kevin KDA on 2020/10/16 13:51
     * @description ErrorCode / getMessage
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    String getMessage();

    /**
     * 设置错误代码信息
     *
     * @param message 传入错误代码信息
     * @author Kevin KDA on 2020/10/16 13:51
     * @description ErrorCode / setMessage
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    void setMessage(String message);

    /**
     * 获得错误代码更新时间
     *
     * @return java.util.Date 更新时间
     * @author Kevin KDA on 2020/10/16 13:52
     * @description ErrorCode / getUpTime
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    Date getUpTime();

    /**
     * 设置错误代码更新时间
     *
     * @param upTime 传入错误代码更新时间
     * @author Kevin KDA on 2020/10/16 13:52
     * @description ErrorCode / setUpTime
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    void setUpTime(Date upTime);

    /**
     * 获得返回信息
     *
     * @return com.alibaba.fastjson.JSONObject 返回信息
     * @author Kevin KDA on 2020/10/16 13:52
     * @description ErrorCode / getBackData
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    JSONObject getBackData();

    /**
     * 设置返回信息
     *
     * @param backData 传入返回信息
     * @author Kevin KDA on 2020/10/16 13:52
     * @description ErrorCode / setBackData
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    void setBackData(JSONObject backData);

}
