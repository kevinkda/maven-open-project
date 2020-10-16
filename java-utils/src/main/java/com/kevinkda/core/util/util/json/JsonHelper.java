/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.json;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Kevin KDA on 2020/10/13 16:25
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.json
 * @classname JsonHelper
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface JsonHelper {

    /**
     * 将传入数据转换成JSON字符串信息
     *
     * @param code 传入待转换的对象
     * @return java.lang.String 返回JSON数据
     * @author Kevin KDA on 2020/5/16 20:02
     * @description ErrorMessages / toJsonString
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public static String toJsonString(Object code) {
        return JSON.toJSONString(code);
    }

    String backResult(boolean status, Object data);


    String backError(String err);

    String getJsonp(String jsonData);

    String getJsonp(String callback, String jsonData);


    Map<String, Object> getCallbacks(Map<String, Object> mapBody);

    String getCallback(Map<String, Object> mapBody);

    Map<String, Object> getCallbackByReq(HttpServletRequest request);

    String getJson(Map<String, Object> data);

    Map<String, Object> merge(Map<String, Object> dataA, Map<String, Object> dataB);
}
