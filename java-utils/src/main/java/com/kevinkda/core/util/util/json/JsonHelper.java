/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.json;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Kevin KDA on 2020/10/13 16:25
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.json
 * @classname JsonHelper
 * @apiNote <p></p>
 * @since 1.0.0
 */
public interface JsonHelper {

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/28 21:18", note = "依赖方法测试 loginAdmin")
     String backResult(boolean status, Object data);


    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/29 13:36", note = "依赖方法测试 getCallback")
     String backError(String err);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/10 00:08", note = "依赖前端项目测试")
    String getJsonp(String jsonData);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/10 00:08", note = "依赖前端项目测试")
    String getJsonp(String callback, String jsonData);


    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/10 00:35", note = "依赖前端项目测试")
    Map<String, Object> getCallbacks(Map<String, Object> mapBody);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/17 15:45")
    String getCallback(Map<String, Object> mapBody);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/10 00:35", note = "依赖前端项目测试")
    Map<String, Object> getCallbackByReq(HttpServletRequest request);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/12 01:43")
    String getJson(Map<String, Object> data);

    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/12 02:54")
    Map<String, Object> merge(Map<String, Object> dataA, Map<String, Object> dataB);
}
