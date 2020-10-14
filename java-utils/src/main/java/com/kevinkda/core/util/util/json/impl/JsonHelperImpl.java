/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.json.impl;

import com.alibaba.fastjson.JSONObject;
import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.exception.web.enumeration.ErrorCode;
import com.kevinkda.core.util.util.json.JsonHelper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * JSON 处理帮助服务
 *
 * @author Kevin KDA on 2020/10/13 16:25
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.json.impl
 * @classname
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class JsonHelperImpl implements JsonHelper {
    /**
     * 保存callback数据
     *
     * @since 3.1.2 / 1.0.0
     */
    private String callback;


    /**
     * 获得JSONP回调数据
     *
     * @param jsonData 传入JSON数据
     * @return java.lang.String 返回JSONP数据
     * @author Kevin KDA on 2020/5/10 00:08
     * @description JsonProcess / getJsonp
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/10 00:08", note = "依赖前端项目测试")
    public String getJsonp(String jsonData) {
        return this.callback + "(" + jsonData + ")";
    }

    /**
     * 获得JSONP回调数据
     *
     * @param callback 传入回调函数名
     * @param jsonData 传入JSON数据
     * @return java.lang.String 返回JSONP数据
     * @author Kevin KDA on 2020/5/10 00:08
     * @description JsonProcess / getJsonp
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/10 00:08", note = "依赖前端项目测试")
    public String getJsonp(String callback, String jsonData) {
        return callback + "(" + jsonData + ")";
    }

    /**
     * 获得JSONP回调函数名
     *
     * @param mapBody 传入 {@code HttpServletRequest}
     * @return {@code java.util.Map<java.lang.String,java.lang.Object>} 返回获取结果
     * @author Kevin KDA on 2020/5/10 00:35
     * @description JsonProcess / getCallbacks
     * @version 1.0.0
     * @apiNote <p>本方法将尝试获取两种类型的回调函数名，即callback和cb，若两种均不存在将返回错误代码</p>
     * <p>正确返回结果包含两个Key，即 status 和 callback</p>
     * <p>错误返回结果包含两个Key，即 status 和 errorCode</p>
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/10 00:35", note = "依赖前端项目测试")
    public Map<String, Object> getCallbacks(Map<String, Object> mapBody) {
        Map<String, Object> backCode = new HashMap<>(2);

//        获得回调函数名，callback
        getCallback(mapBody);

//        进行回调函数名的二次检查，仍然为空，返回错误结果
        if (this.callback == null) {
//            存入错误代码
            backCode.put(ErrorCode.E_CODE, ErrorCode.NULL_CALLBACK.getCode());
//            存入错误信息
            backCode.put(ErrorCode.E_MSG, ErrorCode.NULL_CALLBACK.getMsg());
//            存入程序执行数据
            backCode.put(ErrorCode.DATA, ErrorCode.NO_PRO);
            return backCode;
        }
//        callback值存在，存入错误代码
        backCode.put(ErrorCode.E_CODE, ErrorCode.SUCCESS.getCode());
//        存入错误信息
        backCode.put(ErrorCode.E_MSG, ErrorCode.SUCCESS.getMsg());
        return backCode;
    }

    /**
     * 获得JSONP回调函数名
     *
     * @param mapBody 传入 {@code HttpServletRequest}
     * @return java.lang.String 返回回调函数名
     * @author Kevin KDA on 2020/5/17 15:45
     * @description JsonProcess / getCallback
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/17 15:45")
    public String getCallback(Map<String, Object> mapBody) {
//        获得回调函数名，callback
        this.callback = (String) mapBody.get("callback");
//        如果前端的参数名不为 callback 进行 cb 检查
        if (this.callback == null) {
//            获得回调函数名，cb
            this.callback = (String) mapBody.get("cb");
        }
        return callback;
    }

    /**
     * 获得JSONP回调函数名
     *
     * @param request 传入 {@code HttpServletRequest}
     * @return {@code java.util.Map<java.lang.String,java.lang.Object>} 返回获取结果
     * @author Kevin KDA on 2020/5/10 00:35
     * @description JsonProcess / getCallbackByReq
     * @version 1.0.0
     * @apiNote <p>本方法将尝试获取两种类型的回调函数名，即callback和cb，若两种均不存在将返回错误代码</p>
     * <p>正确返回结果包含两个Key，即 status 和 callback</p>
     * <p>错误返回结果包含两个Key，即 status 和 errorCode</p>
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/10 00:35", note = "依赖前端项目测试")
    public Map<String, Object> getCallbackByReq(HttpServletRequest request) {
        Map<String, Object> rb = new HashMap<>(2);

//        获得回调函数名，callback
        String callback = request.getParameter("callback");
//        如果前端的参数名不为 callback 进行 cb 检查
        if (callback == null) {
//            获得回调函数名，cb
            callback = request.getParameter("cb");
        }
//        进行回调函数名的二次检查
        if (callback == null) {
//            仍然为空，返回错误结果
            rb.put("status", false);
            rb.put("errorCode", backError("Wrong callback function name"));
            return rb;
        }
//        callback值存在
        rb.put("status", true);
        rb.put("callback", callback);
        return rb;
    }

    /**
     * 获得JSON字符串数据
     *
     * @param data 传入Map数据
     * @return java.lang.String 返回序列化后的JSON字符串数据
     * @author Kevin KDA on 2020/5/12 01:43
     * @description JsonProcess / getJson
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/12 01:43")
    public String getJson(Map<String, Object> data) {
        return new JSONObject(data).toJSONString();
    }

    /**
     * 合并两次请求的数据返回值
     *
     * @param dataA 被合并Map
     * @param dataB 合并数据
     * @return {@code java.util.Map<java.lang.String, java.lang.Object>}
     * @author Kevin KDA on 2020/5/12 02:54
     * @description JsonProcess / merge
     * @version 1.0.0
     * @apiNote <p>本方法将会把dataB合并至dataA</p>
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/12 02:54")
    public Map<String, Object> merge(Map<String, Object> dataA, Map<String, Object> dataB) {
//        合并数据
        dataA.putAll(dataB);
        return dataA;
    }

    /**
     * 处理返回结果
     * 预期返回结果为适应JavaScript，生成JSON数据后序列化为String返回
     *
     * @param status 传入结果标识
     * @param data   传入返回数据
     * @return java.lang.String 返回JSON字符串
     * @author Kevin KDA on 2020/4/28 21:18
     * @description JsonProcess / backResult
     * @version 1.0.0
     * @apiNote <p>预期返回结果为适应JavaScript，生成JSON数据后序列化为String返回</p>
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/28 21:18", note = "依赖方法测试 loginAdmin")
    public String backResult(boolean status, Object data) {
        JSONObject jsonObject = new JSONObject();

//        传入用户名、密码检查状态，置入登陆状态，可能的结果true、false
        jsonObject.put(ErrorCode.E_CODE, status);
//        传入获取到的数据
        jsonObject.put(ErrorCode.E_MSG, data);
//        将JSON序列化为字符串返回
        return jsonObject.toString();
    }

    /**
     * 返回调用失败的错误代码
     * 预期返回结果为适应JavaScript，生成JSON数据后序列化为String返回
     *
     * @param err 传入错误代码
     * @return java.lang.String 返回JSON数据
     * @author Kevin KDA on 2020/5/10 00:28
     * @description JsonProcess / backError
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/29 13:36", note = "依赖方法测试 getCallback")
    public String backError(String err) {
        JSONObject jsonObject = new JSONObject();
//         传入调用失败 false
        jsonObject.put(ErrorCode.E_CODE, false);
//        传入获取到的数据
        jsonObject.put(ErrorCode.E_MSG, err);
//        将JSON序列化为字符串返回
        return jsonObject.toString();
    }


    public JsonHelperImpl() {
    }
}
