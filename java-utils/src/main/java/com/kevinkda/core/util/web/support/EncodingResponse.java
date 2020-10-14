package com.kevinkda.core.util.web.support;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 修改 {@link HttpServletRequest} 对象字符编码
 *
 * @author Kevin KDA on 2020/10/13 15:26
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.web.support
 * @classname EncodingResponse
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class EncodingResponse extends HttpServletResponseWrapper {
    /**
     * 修改字符编码的 Request
     *
     * @since 1.0.0
     */
    private HttpServletResponse resp;

    @Override
    public PrintWriter getWriter() throws IOException {
        return super.getWriter();
    }

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response 传入网页取得的 {@link HttpServletResponse} 对象
     * @throws IllegalArgumentException if the response is null
     */
    public EncodingResponse(HttpServletResponse response) {
        super(response);
        this.resp = response;
    }
}
