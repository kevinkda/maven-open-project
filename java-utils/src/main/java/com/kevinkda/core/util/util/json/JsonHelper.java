/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.json;

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
