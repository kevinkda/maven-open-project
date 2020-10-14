package com.kevinkda.core.util.exception.web.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.exception.web.ErrorCode;
import com.kevinkda.core.util.util.json.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin KDA on 2020/10/13 15:39
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.exception.web.impl
 * @classname ErrorCodeImpl
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class ErrorCodeImpl implements ErrorCode {
    @Autowired
    private JsonHelper jsonHelper;

    /**
     * 存储返回信息
     */
    Map<String, Object> data;


    /**
     * 返回错误信息的JSON数据
     *
     * @return java.lang.String 返沪JSON数据
     * @author Kevin KDA on 2020/5/16 19:54
     * @description ErrorCodeImpl / toJson
     * @version 1.0.0
     * @apiNote 
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/16 19:54")
    public String toJson() {
        return jsonHelper.getJson(data);
    }

    /**
     * 返回错误信息的JSONP数据
     *
     * @param callback 传入回调方法名
     * @return java.lang.String 返沪JSON数据
     * @author Kevin KDA on 2020/5/16 19:54
     * @description ErrorCodeImpl / toJson
     * @version 1.0.0
     * @apiNote 
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/16 19:54")
    @Override
    public String toJsonp(String callback) {
        return callback + "(" + toJson() + ")";
    }


    /**
     * 获得错误信息
     *
     * @return {@code java.util.Map<java.lang.String, java.lang.Object>} 返回Map形式的错误信息
     * @author Kevin KDA on 2020/5/16 20:06
     * @description ErrorCodeImpl / getMessage
     * @version 1.0.0
     * @apiNote 
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/16 20:06")
    @Override
    public Map<String, Object> getMessage() {
        return data;
    }


    /**
     * 向当前错误状态域添加子错误状态域
     *
     * @param code 传入子错误状态信息
     * @return {@code java.util.Map<java.lang.String, java.lang.Object>} 返回当前域下所有错误状态信息
     * @author Kevin KDA on 2020/5/19 01:56
     * @description ErrorCodeImpl / subError
     * @version 1.0.0
     * @apiNote 
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/19 01:56")
    public Map<String, Object> subError(ErrorCodeImpl code) {
        this.data.put(ErrorCode.DATA, code.getData());
        return data;
    }

    /**
     * 返回包含子错误的错误信息
     *
     * @param code    传入错误代码
     * @param subCode 传入子错误代码
     * @return {@code java.util.Map<java.lang.String, java.lang.Object>} 返回Map形式的错误信息
     * @author Kevin KDA on 2020/5/17 02:42
     * @description ErrorCodeImpl / subError
     * @version 1.0.0
     * @apiNote 
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/17 02:42")
    public Map<String, Object> subError(ErrorCode code, ErrorCode subCode) {
        this.data.put(ErrorCode.E_CODE, code.getCode());
        this.data.put(ErrorCode.E_MSG, code.getMessage());
//        创建子错误保存域
        Map<String, Object> subMap = new HashMap<>(2);
        subMap.put(ErrorCode.E_CODE, subCode.getCode());
        subMap.put(ErrorCode.E_MSG, subCode.getMessage());
        this.data.put(ErrorCode.DATA, subMap);
        return data;
    }


    /**
     * 向Map存入值
     *
     * @param key   Map Key
     * @param value Map Value
     * @return {@code java.util.Map<java.lang.String,java.lang.Object>} 返回map
     * @author Kevin KDA on 2020/5/28 03:23
     * @description ErrorCodeImpl / put
     * @version 1.0.0
     * @apiNote 
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/28 03:23")
    public Map<String, Object> put(String key, Object value) {
        data.put(key, value);
        return data;
    }

    /**
     * 向Map中存入JWT
     *
     * @param value 传入JWT
     * @return {@code java.util.Map<java.lang.String,java.lang.Object>} 返回map
     * @author Kevin KDA on 2020/5/29 01:50
     * @description ErrorCodeImpl / putJwt
     * @version 1.0.0
     * @apiNote 
     * @since 3.2.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/29 01:50")
    public Map<String, Object> putJwt(String value) {
        put(ErrorCode.JWT, value);
        return data;
    }


    //    Constructor、Getter、Setter

    public ErrorCodeImpl() {
        data = new HashMap<>();
        data.put(ErrorCode.DATE_TIME, new Date());
    }

    public ErrorCodeImpl(ErrorCode code) {
        this(code, (List<Map<String, Object>>) null);
    }

    public ErrorCodeImpl(ErrorCode code, String data) {
        this();
        this.data.put(ErrorCode.E_CODE, code.getCode());
        this.data.put(ErrorCode.E_MSG, code.getMessage());
        this.data.put(ErrorCode.DATA, data);
    }

    public ErrorCodeImpl(ErrorCode code, Map<String, Object> data) {
        this(code.getCode(), code.getMsg(), data);
    }

    public ErrorCodeImpl(ErrorCode code, List<Map<String, Object>> data) {
        this(code.getCode(), code.getMsg(), data);
    }

    public ErrorCodeImpl(int code, String errmsg, Map<String, Object> data) {
        this();
        this.data.put(ErrorCode.E_CODE, code);
        this.data.put(ErrorCode.E_MSG, errmsg);
        this.data.put(ErrorCode.DATA, data);
    }

    public ErrorCodeImpl(int code, String errmsg, List<Map<String, Object>> data) {
        this();
        this.data.put(ErrorCode.E_CODE, code);
        this.data.put(ErrorCode.E_MSG, errmsg);
        this.data.put(ErrorCode.DATA, data);
    }


    public Map<String, Object> getData() {
        return data;
    }

    public Map<String, Object> getMap() {
        return data;
    }


    public void setData(Map<String, Object> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ErrorCodeImpl{" +
                "data=" + data +
                '}';
    }


    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
