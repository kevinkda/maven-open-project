/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.exception.web.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.exception.web.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 错误信息代码实现类
 *
 * @author Kevin KDA on 2020/10/16 09:19
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.exception.web.impl
 * @classname
 * @apiNote
 * @implSpec
 * @implNote
 * @since 0.0.4
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Primary
@Service
public class ErrorCodeByJsonImpl implements ErrorCode, Serializable {
    /**
     * 成功或错误代码
     *
     * @since 0.0.4
     */
    @JSONField(name = E_CODE, ordinal = 1, serialize = true, deserialize = true)
    private int code;
    /**
     * 成功或错误代码信息
     *
     * @since 0.0.4
     */
    @JSONField(name = E_MSG, ordinal = 2, serialize = true, deserialize = true)
    private String message;
    /**
     * 成功或错误代码更新时间
     *
     * @since 0.0.4
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    @JSONField(name = DATE_TIME, ordinal = 3, format = "yyyy-MM-dd HH:mm:ss.SSS", serialize = true, deserialize = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date upTime;
    /**
     * 返回信息
     *
     * @since 0.0.4
     */
    @JSONField(name = DATA, ordinal = 4, serialize = true, deserialize = true)
    private JSONObject backData;


    /**
     * 传入枚举类型错误编码信息，自动转化错误代码和错误信息
     *
     * @param code 传入枚举类型错误编码信息
     * @author Kevin KDA on 2020/10/16 12:10
     * @description ErrorCodeByJsonImpl / setErrorCode
     * @version 1.0.0
     * @apiNote <p>方法传入类型需为{@link com.kevinkda.core.util.exception.web.enumeration.ErrorCode}枚举类型常量</p>
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/10/16 12:10")
    @Override
    public void setErrorCode(com.kevinkda.core.util.exception.web.enumeration.ErrorCode code) {
        setCode(code.getCode());
        setMessage(code.getMessage());
    }

    /**
     * 存入键值对
     *
     * @param key   传入索引键
     * @param value 传入值
     * @author Kevin KDA on 2020/10/16 13:18
     * @description ErrorCodeByJsonImpl / putData
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/10/16 13:18")
    @Override
    public void putData(String key, Object value) {
        backData.put(key, value);
    }

    /**
     * 存入所有键值对
     *
     * @param data 传入{@code Map<String, ?>}对象
     * @author Kevin KDA on 2020/10/16 13:18
     * @description ErrorCodeByJsonImpl / putAllData
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/10/16 13:18")
    @Override
    public void putAllData(Map<String, ?> data) {
        backData.putAll(data);
    }


    /**
     * 核验使用者是否传入更新时间
     *
     * @author Kevin KDA on 2020/10/16 13:22
     * @description ErrorCodeByJsonImpl / isUpTimeNull
     * @version 1.0.0
     * @apiNote <p>核验使用者是否传入更新时间, 如未传入即载入系统当前时间</p>
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/10/16 13:22")
    private void isUpTimeNull() {
        if (upTime == null) {
            upTime = new Date(System.currentTimeMillis());
        }
    }


    /**
     * 返回错误信息的JSON数据
     *
     * @return java.lang.String 返回JSON数据
     * @author Kevin KDA on 2020/10/16 13:46
     * @description ErrorCodeByJsonImpl / toJson
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/10/16 13:46")
    @Override
    public Object toJson() {
        isUpTimeNull();
        return JSONObject.toJSON(this);
    }

    /**
     * 将本对象相信转为Map对象
     *
     * @return {@code java.util.Map<java.lang.String,?>} Map对象
     * @author Kevin KDA on 2020/10/16 14:05
     * @description ErrorCodeByJsonImpl / toMap
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/16 14:05")
    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>(4);
        map.put(E_CODE, code);
        map.put(E_MSG, message);
        map.put(DATE_TIME, upTime);
        map.put(DATA, backData.getInnerMap());
        return map;
    }

    /**
     * 返回错误信息的JSON数据
     *
     * @return java.lang.String 返回JSON字符串数据
     * @author Kevin KDA on 2020/10/16 13:47
     * @description ErrorCodeByJsonImpl / toJsonString
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/10/16 13:47")
    @Override
    public String toJsonString() {
        isUpTimeNull();
        return JSON.toJSONString(this);
    }

    /**
     * 返回错误信息的JSONP数据
     *
     * @param callback 传入回调方法名
     * @return java.lang.String 返沪JSON数据
     * @author Kevin KDA on 2020/10/16 13:49
     * @description ErrorCodeByJsonImpl / toJsonpString
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 0.0.4
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/10/16 13:49")
    @Override
    public String toJsonpString(String callback) {
        isUpTimeNull();
        return callback + "(" + toJson() + ")";
    }


    public ErrorCodeByJsonImpl(int code, String message, JSONObject backData) {
        this.code = code;
        this.message = message;
        this.backData = backData;
    }


    @Override
    public String toString() {
        return "ErrorCodeByJsonImpl{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", upTime=" + upTime +
                ", backData='" + backData + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ErrorCodeByJsonImpl)) {
            return false;
        }
        ErrorCodeByJsonImpl that = (ErrorCodeByJsonImpl) o;
        return getCode() == that.getCode() &&
                getMessage().equals(that.getMessage()) &&
                getUpTime().equals(that.getUpTime()) &&
                getBackData().equals(that.getBackData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getMessage(), getUpTime(), getBackData());
    }

}
