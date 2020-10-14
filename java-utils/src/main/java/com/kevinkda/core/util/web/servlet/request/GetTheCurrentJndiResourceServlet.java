package com.kevinkda.core.util.web.servlet.request;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

/**
 * @author Kevin KDA on 2020/10/13 15:28
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.web.servlet.request
 * @classname GetTheCurrentJndiResourceServlet
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@WebServlet(name = "GetTheCurrentJndiResourceServlet", urlPatterns = "/GetTheCurrentJndiResourceServlet")
public class GetTheCurrentJndiResourceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        创建 JNDI 的上下文对象
        try {
            Context context = new InitialContext();
//            查询出入口
//            Context envContext = (Context) context.lookup("java:comp/env");
//            再进行二次查询，找到我们的资源
//            使用的是名称与<Resource>元素的 name 对应
//            DataSource dataSource = (DataSource) envContext.lookup("jdbc/dataSource");

            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/dataSource");
            Connection connection = dataSource.getConnection();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        doPost(req, resp);
    }

}
