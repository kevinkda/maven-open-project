package com.kevinkda.core.util.web.servlet.request;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author Kevin KDA on 2020/10/13 15:32
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.web.servlet.request
 * @classname RequestServices
 * @apiNote <p></p>
 * @since 1.0.0
 */
@Service
public class RequestServices {
    /**
     * 获得所有请求头和请求体数据，请求数据类型需为Text
     *
     * @param request 传入请求的 Request {@link HttpServletRequest}
     * @return {@code java.util.List<java.util.Map<java.lang.String,java.lang.Object>>} 回传请求头和请求体数据
     * @author Kevin KDA on 2020/5/11 21:46
     * @description RequestServices / getParametersForText
     * @version 1.0.0
     * @apiNote <p>本方法返回{@link HttpServletRequest}包含的请求头和请求体数据</p>
     * <p>其中数组下标0是请求头数据</p>
     * <p>其中数组下标1是请求体数据</p>
     * @since 3.1.2
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/11 21:46")
    public List<Map<?, ?>> getParametersForText(HttpServletRequest request) {
//        返回请求头和请求体数组
        return new ArrayList<>(
                Arrays.asList(
//                        加入请求头Map
                        getRequestHead(request),
//                        加入请求体Map
                        getRequestBody(request)
                )
        );
    }

    /**
     * 获得请求头数据
     *
     * @param request 传入请求的Request {@link HttpServletRequest}
     * @return {@code java.util.Map<java.lang.String, java.lang.Object>} 回传请求头数据
     * @author Kevin KDA on 2020/5/1 14:37
     * @description RequestServices / getRequestHead
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.0.5
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/1 14:37")
    public Map<?, ?> getRequestHead(HttpServletRequest request) {
//        获取所有的头Head信息
        Enumeration<String> requestHeaderNames = request.getHeaderNames();
//        存储所有请求头数据
        Map<String, String> requestHead = new HashMap<>();
//        临时Key变量的存储空间，减少变量开辟和 GC 工作
        String tempKey;
//        requestHeaderNames 有值则继续
        while (requestHeaderNames.hasMoreElements()) {
//            获得头信息类型，临时保存供取得值使用
            tempKey = requestHeaderNames.nextElement();
//            获得请求类型值，并存入Map中
            requestHead.put(tempKey, request.getHeader(tempKey));
        }
//        返回所有请求头信息
        return requestHead;
    }

    /**
     * 获得请求体数据
     *
     * @param request 传入请求的Request {@link HttpServletRequest}
     * @return {@code java.util.Map<java.lang.String, java.lang.Object>} 回传请求体数据
     * @author Kevin KDA on 2020/5/11 21:54
     * @description RequestServices / getRequestBody
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.1.2
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/11 21:54")
    public Map<?, ?> getRequestBody(HttpServletRequest request) {
//        获取所有的头Head信息
        Enumeration<String> requestHeaderNames = request.getParameterNames();
//        存储所有请求头数据
        Map<String, Object> requestBody = new HashMap<>();

//        临时Key和Value变量的存储空间，减少变量开辟和 GC 工作
        String paramName;
        String[] paramValues;

//        requestHeaderNames 有值则继续
        while (requestHeaderNames.hasMoreElements()) {
//            获得头信息类型，临时保存供取得值使用
            paramName = requestHeaderNames.nextElement();
//            获得头信息值，此处可能是数组，e.g.前端Checkbox传入的组对象
            paramValues = request.getParameterValues(paramName);

//            检查头信息值是否存在，如数组长度仅一位，保存数组首位
            if (paramValues.length == 1) {
//                获得临时数据，用于检验值的有效性，即数据是否为空，为空即舍弃
                String paramValue = paramValues[0];
//                检验值的有效性，即数据是否为空，为空即舍弃
//                if (paramValue.length() != 0) {
                if (!(null == paramValue || "".equals(paramValue))) {
//                    数据不为空存入Map
                    requestBody.put(paramName, paramValue);
                }
            } else if (paramValues.length > 1) {
//                如数组长度大于一位，保存数组
                requestBody.put(paramName, paramValues);
            }
        }

//        返回所有请求头信息
        return requestBody;
    }

    /**
     * 打印所有参数
     *
     * @param map 传入已获得的请求参数，需为 {@code Map<String, Object>} 对象
     * @return void 本方法直接输出，无返回值
     * @author Kevin KDA on 2020/5/11 22:15
     * @description RequestServices / printParameters
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.1.2
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/11 22:15")
    public void printParameters(Map<String, Object> map) {
        Set<Map.Entry<String, Object>> set = map.entrySet();
        for (Map.Entry entry :
                set) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
//        等价于上forEach
//        set.stream().map(entry -> entry.getKey() + ":" + entry.getValue()).forEach(System.out::println);
    }

    /**
     * 显示获得的所有参数
     *
     * @param map 传入已获得的请求参数，需为 {@code Map<String, Object>} 对象
     * @return java.lang.String[] 返回所有参数的String[]信息
     * @author Kevin KDA on 2020/5/11 22:15
     * @description RequestServices / showParameters
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.1.2
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/11 22:15")
    public String[] showParameters(Map<?, ?> map) {
        List<String> list = new ArrayList<>();
        Set<? extends Map.Entry<?, ?>> set = map.entrySet();
        for (Map.Entry entry :
                set) {
            list.add(entry.getKey() + ":" + entry.getValue());
        }
//        等价于上forEach
//        (String[]) set.stream().map(entry -> entry.getKey() + ":" + entry.getValue()).toArray();
        return (String[]) list.toArray();
    }

    /**
     * 获得Post请求体数据
     *
     * @param request 传入请求的Request {@link javax.servlet.http.HttpServletRequest}
     * @return java.lang.String 返回请求的方法体
     * @author Kevin KDA on 2020/5/1 14:30
     * @description RequestServices / getPostBody
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.0.5
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/1 14:30", note = "依赖测试")
    @Deprecated
    public String getPostBody(HttpServletRequest request) {
//        记录请求体数据
        String bodyInfo = "";
        try {
//            获得输入流对象
            InputStream i;
//            从request中取得输入流，即获得请求体
            i = request.getInputStream();
//            获得请求体，并转换为UTF-8字符编码字符串
            bodyInfo = IOUtils.toString(i, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        返回请求体数据
        return bodyInfo;
    }


//    处理JSON形式的数据

    /**
     * 获得所有请求头和请求体数据，请求数据类型需为JSON
     *
     * @param request 传入请求的 Request {@link HttpServletRequest}
     * @return {@code java.util.List<java.util.Map<java.lang.String,java.lang.Object>>} 回传请求头和请求体数据
     * @author Kevin KDA on 2020/5/11 21:46
     * @description RequestServices / getParametersForText
     * @version 1.0.0
     * @apiNote <p>本方法返回{@link HttpServletRequest}包含的请求头和请求体数据</p>
     * <p>其中数组下标0是请求头数据</p>
     * <p>其中数组下标1是请求体数据</p>
     * @since 3.1.2
     */
    public List<Map<?, ?>> getParametersForJson(HttpServletRequest request) {
////        返回请求头和请求体数组
//        return new ArrayList<>(
//                Arrays.asList(
////                        加入请求头Map
//                        getRequestHead(request),
////                        加入请求体Map
//                        getRequestBody(request)
//                )
//        );
        return null;
    }


    public RequestServices() {
    }
}
