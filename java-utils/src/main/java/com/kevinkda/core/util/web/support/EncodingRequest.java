package com.kevinkda.core.util.web.support;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.nio.charset.StandardCharsets;

/**
 * 修改 {@link HttpServletRequest} 对象字符编码
 *
 * @author Kevin KDA on 2020/10/13 15:15
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.web.support
 * @classname EncodingRequest
 * @apiNote <p></p>
 * @since 1.0.0
 */
@Service
public class EncodingRequest extends HttpServletRequestWrapper {
    /**
     * 修改字符编码的 Request
     */
    private HttpServletRequest req;

    /**
     * 返回UTF-8编码结果
     *
     * @param name 传入需要获取的值的Key
     * @return java.lang.String 返回UTF-8编码结果
     * @author Kevin KDA on 2020/5/3 12:02
     * @description EncodingRequest / getParameter
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/3 12:02")
    @Override
    public String getParameter(String name) {
//        获得原始的 ISO_8859_1 编码值
        String value = req.getParameter(name);

//        处理编码问题
        try {
            value = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        返回处理后的结果
        return value;
    }

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request 传入网页取得的 {@link HttpServletRequest} 对象
     * @throws IllegalArgumentException if the request is null
     */
    public EncodingRequest(HttpServletRequest request) {
        super(request);
        this.req = request;
    }
}
