/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.db.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.util.db.Jdbc;
import com.kevinkda.core.util.util.db.abstraction.AbstractJdbc;
import com.kevinkda.core.util.util.db.util.SqlStringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提供对于JDBC的操纵服务
 *
 * @author Kevin KDA on 2020/10/13 17:12
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.db.impl
 * @classname JdbcImpl
 * @interfaces {@link AutoCloseable} 实现自动关闭
 * @apiNote <p>使用本类时请先{@code use()}方法传入资源文件路径，
 * 或使用构造方法{@code public JdbcImpl(String path)}传入资源文件路径</p>
 * <p>请不用使用同一实例对象完成多重类型操作，若需完成多重操作请实例化多个{@link JdbcImpl}对象，尽最大可能避免异常抛出</p>
 * <p>此项目希望做到提供尽可能的通用方法，但某些特殊情况可能无法提供处理。</p>
 * <p>此封装类已实现对{@link AutoCloseable}的支持，调用方可以获取它的资源直到结束，这将自动调用{@code close}。</p>
 * <p>此封装类已尽可能的对{@link Exception}进行{@code try}捕获，
 * 不可避免的这可能将会导致后续程序的在特定情况下产生{@link NullPointerException}。</p>
 * <p>自本方法v3.1.0开始，使用本类执行提交后将会自动关闭{@link JdbcImpl}所有链接</p>
 * @since 1.0.0 (JDK 1.7)
 */
@Service
public class JdbcImpl extends AbstractJdbc implements Jdbc {
    @Autowired
    private SqlStringHelper sqlStringHelper;

    /**
     * Connection
     */
    private Connection connection;
    /**
     * Statement
     */
    private Statement statement;
    /**
     * PreparedStatement
     */
    private PreparedStatement preparedStatement;
    /**
     * CallableStatement
     */
    private CallableStatement callableStatement;
    /**
     * ResultSet
     */
    private ResultSet resultSet;


//    获得连接

    /**
     * 对外提供一个方法来获取数据库连接
     * 本方法默认开启自动提交
     *
     * @return java.sql.Connection connection
     * @author Kevin KDA on 2020/4/26 16:07
     * @description JdbcImpl / getConnection
     * @version 1.0.0
     * @apiNote <p>此方法需要实例化，对于批处理方式请按照如下方式执行：</p>
     * <ol><li>实例化对象获得{@link Connection}连接</li>
     * <li>使用{@link Connection}连接获得{@link PreparedStatement}对象</li>
     * <li>使用{@code addBatch()}向{@link PreparedStatement}追加参数</li>
     * <li>使用{@code executeBatch()}提交批处理</li>
     * <li>清楚批处理缓存</li></ol>
     * @since 1.5.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 16:07")
    public Connection getConnection() {
        return getConnection(true);
    }

    /**
     * 对外提供一个方法来获取数据库连接
     *
     * @param flag 传入boolean值，设置setAutoCommit事务自动提交
     * @return java.sql.Connection 返回Connection
     * @author Kevin KDA on 2020/4/26 16:09
     * @description JdbcImpl / getConnection
     * @version 1.0.0
     * @apiNote <p>此方法需要实例化，对于批处理方式请按照如下方式执行：</p>
     * <ol><li>实例化对象获得{@link Connection}连接</li>
     * <li>使用{@link Connection}连接获得{@link PreparedStatement}对象</li>
     * <li>使用{@code addBatch()}向{@link PreparedStatement}追加参数</li>
     * <li>使用{@code executeBatch()}提交批处理</li>
     * <li>清楚批处理缓存</li></ol>
     * @since 1.5.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 16:09")
    public Connection getConnection(boolean flag) {
        if (connection == null) {
            try {
//            1.加载驱动程序
                Class.forName(driver);
//            2.获得数据库的连接
                connection = DriverManager.getConnection(url, user, pass);
                connection.setAutoCommit(flag);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 提供获得PreparedStatement对象的方法
     * 本方法默认开启自动提交
     *
     * @param sql 提供创建PreparedStatement的SQL语句
     * @return java.sql.PreparedStatement 返回PreparedStatement
     * @author Kevin KDA on 2020/4/26 16:17
     * @description JdbcImpl / getPreparedStatement
     * @version 1.0.0
     * @apiNote <p>此方法在创建{@link PreparedStatement}时追加了
     * {@code ResultSet.TYPE_SCROLL_INSENSITIVE} 和 {@code ResultSet.CONCUR_READ_ONLY}参数，所获得的结果集支持滚动</p>
     * <p>{@code ResultSet.TYPE_SCROLL_INSENSITIVE}
     * 结果集的游标可以上下移动，当数据库变化时，当前结果集不变。</p>
     * <p>{@code ResultSet.CONCUR_READ_ONLY} 不能用结果集更新数据库中的表.</p>
     * <p>此方法需要实例化，对于批处理方式请按照如下方式执行：</p>
     * <ol><li>实例化对象获得{@link Connection}连接</li>
     * <li>使用{@link Connection}连接获得{@link PreparedStatement}对象</li>
     * <li>使用{@code addBatch()}向{@link PreparedStatement}追加参数</li>
     * <li>使用{@code executeBatch()}提交批处理</li>
     * <li>清楚批处理缓存</li></ol>
     * @since 1.5.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 16:17")
    public PreparedStatement getPreparedStatement(String sql) {
        return getPreparedStatement(sql, true);
    }

    /**
     * 提供获得PreparedStatement对象的方法
     *
     * @param sql  提供创建PreparedStatement的SQL语句
     * @param flag the flag
     * @return java.sql.PreparedStatement 返回PreparedStatement
     * @author Kevin KDA on 2020/4/26 16:17
     * @description JdbcImpl / getPreparedStatement
     * @version 1.0.0
     * @apiNote <p>此方法在创建{@link PreparedStatement}时追加了
     * {@code ResultSet.TYPE_SCROLL_INSENSITIVE} 和 {@code ResultSet.CONCUR_READ_ONLY}参数，所获得的结果集支持滚动</p>
     * <p>{@code ResultSet.TYPE_SCROLL_INSENSITIVE} 结果集的游标可以上下移动，当数据库变化时，当前结果集不变。</p>
     * <p>{@code ResultSet.CONCUR_READ_ONLY} 不能用结果集更新数据库中的表.</p>
     * <p>此方法需要实例化，对于批处理方式请按照如下方式执行：</p>
     * <ol><li>实例化对象获得{@link Connection}连接</li>
     * <li>使用{@link Connection}连接获得{@link PreparedStatement}对象</li>
     * <li>使用{@code addBatch()}向{@link PreparedStatement}追加参数</li>
     * <li>使用{@code executeBatch()}提交批处理</li>
     * <li>清楚批处理缓存</li></ol>
     * @since 1.5.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 16:17")
    public PreparedStatement getPreparedStatement(String sql, boolean flag) {
        try {
            if (preparedStatement == null) {
                getConnection(flag);
                preparedStatement = connection.prepareStatement(
                        sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return preparedStatement;
    }


//    查询操作获得ResultSet结果集

    /**
     * 提供获得ResultSet对象的方法
     *
     * @param sql 需要查询SQL语句
     * @return java.sql.ResultSet 返回ResultSet，请求数据自行处理
     * @author Kevin KDA on 2020/4/26 17:12
     * @description JdbcImpl / getResultSet
     * @version 1.0.0
     * @apiNote
     * @since 1.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 17:12")
    public ResultSet getResultSet(String sql) {
        return getResultSet(sql, null);
    }

    /**
     * 提供获得ResultSet对象的方法
     *
     * @param sql            需要查询SQL语句
     * @param conditionValue 传入与需要检索条件的列名称对应的检索值
     * @return java.sql.ResultSet 返回ResultSet，请求数据自行处理
     * @author Kevin KDA on 2020/4/26 17:12
     * @description JdbcImpl / getResultSet
     * @version 1.0.0
     * @apiNote
     * @since 1.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 17:12")
    public ResultSet getResultSet(String sql, Object[] conditionValue) {
        getPreparedStatement(sql);
        append(conditionValue);
        return executeQuery();
    }

    /**
     * 提供获得ResultSet对象的方法
     *
     * @param strTable           传入需要查询数据表名
     * @param strColumn          传入需要查询数据列名，如是多表查询需提供包含表名完整的完成列名                           参数格式：TABLE_A,TABLE_B.COLUMN_A
     * @param strConditionColumn 传入需要检索条件的列名，若不进行条件检索请赋空
     * @param conditionValue     传入与需要检索条件的列名称对应的检索值
     * @return java.sql.ResultSet 返回ResultSet，请求数据自行处理
     * @author Kevin KDA on 2020/4/26 17:12
     * @description JdbcImpl / getResultSet
     * @version 1.0.0
     * @apiNote
     * @since 1.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 17:12")
    public ResultSet getResultSet(String[] strTable, String[] strColumn,
                                  String[] strConditionColumn, Object[] conditionValue) {
        StringBuilder stringBuilder = sqlStringHelper.appendSqlString(strTable, strColumn, strConditionColumn);
        getResultSet(stringBuilder.toString(), conditionValue);
        return executeQuery();
    }


//    追加查询请求参数

    /**
     * 提供向PreparedStatement添加参数的方法
     *
     * @param args 传入需提交的参数
     * @return boolean 返回参数是否添加成功
     * @author Kevin KDA on 2020/4/26 19:17
     * @description JdbcImpl / append
     * @version 1.0.0
     * @apiNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 19:17", note = "调用方法测试 getResultSet")
    public boolean append(Object[] args) {
        try {
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


//    查询操作获得List<Map<String, Object>>结果集

    /**
     * 提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理
     *
     * @param sql 需要查询SQL语句
     * @return {@code java.util.List<java.util.Map<java.lang.String, java.lang.Object>>} 返回键值对数组，其中键为数据表中列名，值为与列对应的值
     * @author Kevin KDA on 2020/4/26 20:31
     * @description JdbcImpl / getResultListMap
     * @version 1.0.0
     * @apiNote
     * @since 1.1.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 20:31")
    public List<Map<String, Object>> getResultListMap(String sql) {
        return getResultListMap(sql, null);
    }

    /**
     * 提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理
     *
     * @param sql            需要查询SQL语句
     * @param conditionValue 传入与需要检索条件的列名称对应的检索值
     * @return {@code java.util.List<java.util.Map<java.lang.String, java.lang.Object>>} 返回键值对数组，其中键为数据表中列名，值为与列对应的值
     * @author Kevin KDA on 2020/4/26 20:31
     * @description JdbcImpl / getResultListMap
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.1.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 20:31")
    public List<Map<String, Object>> getResultListMap(String sql, Object[] conditionValue) {
        return getListMap(getResultSet(sql, conditionValue));
    }

    /**
     * 提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理
     *
     * @param strTable           传入需要查询数据表名
     * @param strColumn          传入需要查询数据列名，如是多表查询需提供包含表名完整的完成列名                           参数格式：TABLE_A,TABLE_B.COLUMN_A
     * @param strConditionColumn 传入需要检索条件的列名，若不进行条件检索请赋空
     * @param conditionValue     传入与需要检索条件的列名称对应的检索值
     * @return {@code java.util.List<java.util.Map<java.lang.String, java.lang.Object>>} 返回键值对数组，其中键为数据表中列名，值为与列对应的值
     * @author Kevin KDA on 2020/4/26 20:33
     * @description JdbcImpl / getResultListMap
     * @version 1.0.0
     * @apiNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 20:33")
    public List<Map<String, Object>> getResultListMap(String[] strTable, String[] strColumn,
                                                      String[] strConditionColumn, Object[] conditionValue) {
        return getListMap(getResultSet(strTable, strColumn, strConditionColumn, conditionValue));
    }


//    Utils 获得List<Map<String, Object>>集合

    /**
     * 提供提取ResultSet中详细数据的方法，返回键值对数组供后续处理
     * 私有公用方法
     *
     * @param resultSet 传入  已获取的结果集
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object> > 返回键值对数组，其中键为数据表中列名，值为与列对应的值
     * @author Kevin KDA on 2020/4/26 20:36
     * @description JdbcImpl / getListMap
     * @version 1.1.0
     * @apiNote
     * @since 1.1.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Pass, date = "2020/4/26 20:36")
    public List<Map<String, Object>> getListMap(ResultSet resultSet) {
        int countColumn = getResultSetCountColumn(resultSet);
        List<Map<String, Object>> list = new ArrayList<>(getResultSetCountRow(resultSet));
        try {
            Map<String, Object> temp;
            while (resultSet.next()) {
                temp = new HashMap<>(countColumn);
                for (int i = 1; i < countColumn + 1; i++) {
                    String key = resultSet.getMetaData().getColumnName(i);
                    Object value = resultSet.getObject(i);
                    temp.put(key, value);
                }
//                将泛型对象存入集合
                list.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


//    获得结果集行数、列数

    /**
     * 提供获得ResultSet行数的方法
     *
     * @param resultSet 传入带操作的结果集
     * @return int 返回ResultSet行数
     * @author Kevin KDA on 2020/4/26 20:34
     * @description JdbcImpl / getResultSetCountRow
     * @version 1.1.0
     * @apiNote <p>返回结果为-1即调用失败</p>
     * <p>返回结果为0即调用成功，传入的ResultSet为空</p>
     * <p>返回结果为大于或等于1即调用成功，返回传入的ResultSet实际行数</p>
     * @since 1.3.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Pass, date = "2020/4/26 20:34", note = "调用方法测试 getListMap")
    public int getResultSetCountRow(ResultSet resultSet) {
        int count = -1;
        try {
//            数据表当前行指针移动至末行
            resultSet.last();
//            获得数据表当前行指针行号
            count = resultSet.getRow();
//            移动当前数据表行指针至首行前，使后续程序能继续使用
            resultSet.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 提供获得ResultSet列数的方法
     *
     * @param resultSet 传入带操作的结果集
     * @return int 返回ResultSet列数
     * @author Kevin KDA on 2020/4/26 20:35
     * @description JdbcImpl / getResultSetCountColumn
     * @version 1.1.0
     * @apiNote <p>返回结果为-1即调用失败</p>
     * <p>返回结果为0即调用成功，传入的ResultSet为空</p>
     * <p>返回结果为大于或等于1即调用成功，返回传入的ResultSet实际行数</p>
     * @since 1.3.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Pass, date = "2020/4/26 20:35", note = "调用方法测试 getListMap")
    public int getResultSetCountColumn(ResultSet resultSet) {
        int count = -1;
        try {
//            获得当前数据表列数
            count = resultSet.getMetaData().getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


//    提交ResultSet查询请求

    /**
     * 提供统一向数据库提交查询的SQL请求
     *
     * @return java.sql.ResultSet 返回ResultSet结果集 即表
     * @author Kevin KDA on 2020/4/26 19:07
     * @description JdbcImpl / executeQuery
     * @version 1.0.0
     * @apiNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 19:07")
    public ResultSet executeQuery() {
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 提供统一向数据库提交查询的SQL请求
     *
     * @param sql 需要查询SQL语句
     * @return java.sql.ResultSet 返回ResultSet结果集 即表
     * @author Kevin KDA on 2020/4/26 19:12
     * @description JdbcImpl / executeQuery
     * @version 1.1.0
     * @apiNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Pass, date = "2020/4/26 19:12")
    public ResultSet executeQuery(String sql) {
        getPreparedStatement(sql);
        executeQuery();
        return resultSet;
    }


//    增删改 insert、update、delete


//    提供基于传入完整SQL的插入、更新、删除操作

    /**
     * 提供传入完整SQL语句进行插入、更新、删除单行数据的方法
     *
     * @param sql 传入标准SQL语句
     * @return int 返回受影响行数
     * @throws SQLException Statement执行异常
     * @author Kevin KDA on 2020/4/27 00:53
     * @description JdbcImpl / singleSql
     * @version 1.1.0
     * @apiNote <p>本方法调用{@link Statement}</p>
     * @since 1.5.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Pass, date = "2020/4/27 00:53")
    public int singleSql(String sql) throws SQLException {
        getConnection();
        statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }

    /**
     * 提供传入完整SQL语句进行插入、更新、删除单行数据的方法
     *
     * @param sql  传入标准SQL语句
     * @param args 传入将要插入的值
     * @return int 返回受影响行数
     * @author Kevin KDA on 2020/4/27 00:52
     * @description JdbcImpl / singleSql
     * @version 1.0.0
     * @apiNote <p>本方法调用{@link PreparedStatement}</p>
     * @since 1.5.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/4/27 00:52")
    public int singleSql(String sql, Object[] args) {
        getPreparedStatement(sql);
        append(args);
        return executeUpdate();
    }


//    提供基于字符串拼接的插入、更新、删除操作

    /**
     * 提供基于字符串拼接的单个数据插入方法
     *
     * @param strTableName 传入需要操纵的数据库表名
     *                     参数格式：TABLE_A(COLUMN_A,COLUMN_B,COLUMN_C)
     * @param args         传入将要插入的值
     * @return int 返回受影响行数
     * @author Kevin KDA on 2020/4/27 00:01
     * @description JdbcImpl / insertSingle
     * @version 1.1.0
     * @apiNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Unverified, date = "2020/4/27 00:01")
    public int insertSingle(String strTableName, Object[] args) {
//        拼接表头
        StringBuilder stringBuilder = new StringBuilder("insert into " + strTableName + " values ");
//        拼接占位符，并创建PreparedStatement
        getPreparedStatement(
                sqlStringHelper.strSplicingUp(
                        stringBuilder,
                        args.length
                ).toString()
        );
//        向占位符替换参数
        append(args);
//        向服务器提交数据
        return executeUpdate();
    }

    /**
     * 提供基于字符串拼接的单个数据更新方法
     *
     * @param strTable      传入需要操纵的数据库表名
     * @param strColumnName 传入需要操纵的数据表列名称，最后一项为条件列，即表主键
     *                      参数格式：TABLE_A,TABLE_B,TABLE_C
     * @param args          传入将要更新后的值
     * @return int 返回受影响行数
     * @author Kevin KDA on 2020/4/27 00:25
     * @description JdbcImpl / updateSingle
     * @version 1.1.0
     * @apiNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Unverified, date = "2020/4/27 00:25")
    public int updateSingle(String strTable, String[] strColumnName, Object[] args) {
//        拼接表头
        StringBuilder stringBuilder = new StringBuilder("UPDATE " + strTable + " SET ");
//        遍历添加修改值的字段名和占位符
        for (int i = 0; i < strColumnName.length - 1; i++) {
//            拼接修改值的字段名
            stringBuilder.append(strColumnName[i]);
//            拼接占位符
            stringBuilder.append("=?,");
        }
//        去除末尾多余的空格
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
//        拼接条件字段
        stringBuilder.append(" WHERE ");
//        拼接条件字段的列名
        stringBuilder.append(strColumnName[strColumnName.length - 1]);
//        拼接占位符
        stringBuilder.append("=? AND 1=1");
//        创建PreparedStatement
        getPreparedStatement(stringBuilder.toString());
//        向占位符替换参数
        append(args);
//        向服务器提交数据
        return executeUpdate();
    }

    /**
     * 提供基于字符串拼接的多条数据插入方法
     *
     * @param strTable      传入需要操纵的数据库表名
     * @param strColumnName 传入条件列名称，即表主键名
     * @param strIds        传入索引值 参数格式：1,2,3
     * @return int 返回受影响行数
     * @author Kevin KDA on 2020/4/27 00:46
     * @description JdbcImpl / delete
     * @version 1.0.0
     * @apiNote <p>建议传入主键字段</p>
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/4/27 00:46")
    public int delete(String strTable, String strColumnName, String strIds) {
//        拼接SQL语句
        String sql = "DELETE FROM " + strTable + " WHERE " + strColumnName + " IN(" + strIds + ")";
//        创建PreparedStatement
        getPreparedStatement(sql);
//        向服务器提交数据
        return executeUpdate();
    }


//    非批处理提交方法

    /**
     * 提供逐行向数据库提交的方法 非批处理
     *
     * @return int 返回受影响行数
     * @author Kevin KDA on 2020/4/26 19:15
     * @description JdbcImpl / executeUpdate
     * @version 1.1.0
     * @apiNote <p>自本方法v1.1.0开始，使用此方法执行提交后将会自动关闭{@link JdbcImpl}所有链接</p>
     * @errorReport <p>向数据库更新时未自动关闭数据库链接，数据复现为JavaWeb开发中，Servlet将会持久化本类的数据库链接</p>
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Error, date = "2020/4/26 19:15", note = "向数据库更新时未自动关闭数据库链接，数据复现为JavaWeb开发中，Servlet将会持久化本类的数据库链接")
    @FuncVerification(version = "1.1.0", status = VerifiedType.Pass, date = "2020/5/2 11:10", note = "本次版本将在执行提交后手动关闭数据库链接")
    public int executeUpdate() {
        int count = -1;
        try {
            count = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }


//    存储过程

    /**
     * 调用存储过程，返回执行结果集
     *
     * @param proc 传入完整SQL语句
     *             参数形式{@code CALL procedure(?...)}
     * @param args 传入存储过程参数组
     * @return java.sql.ResultSet 返回结果集
     * @author Kevin KDA on 2020/4/27 01:06
     * @description JdbcImpl / runCallableStatement
     * @version 1.0.0
     * @apiNote <p>在使用存储过程前，请了解需要调用的存储过程所需传入的参数和返回结果</p>
     * @since 2.1.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/4/27 01:06")
    public ResultSet runCallableStatement(String proc, Object[] args) {
        try {
            callableStatement = getConnection().prepareCall(proc);
            for (int i = 0; i < args.length; i++) {
                callableStatement.setObject(i + 1, args[i]);
            }
            resultSet = callableStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 调用存储过程，返回{@link CallableStatement}
     *
     * @param proc    传入完整SQL语句
     *                参数形式{@code CALL procedure(?...)}
     * @param args    传入存储过程参数组
     * @param outArgs 传入返回值参数
     * @return java.sql.CallableStatement 返回{@link CallableStatement}
     * @author Kevin KDA on 2020/5/18 21:19
     * @description JdbcImpl / runCallableStatement
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Error, date = "2020/5/18 21:19")
    @Override
    public CallableStatement runCallableStatement(String proc, Object[] args, Object[] outArgs) {
        try {
            callableStatement = getConnection().prepareCall(proc);
            for (int i = 0; i < args.length; i++) {
                callableStatement.setObject(i + 1, args[i]);
            }
            for (int i = 1; i <= outArgs.length; i += 2) {
                callableStatement.registerOutParameter((Integer) outArgs[i], (Integer) outArgs[i + 1]);
            }
            callableStatement.execute();
            return callableStatement;
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage() + "==");
            return null;
        }
    }


//    批处理


//    事务处理

    /**
     * 开启事务，设置事务自动提交为false
     *
     * @return int 返回是否成功
     * @author Kevin KDA on 2020/4/26 21:51
     * @description JdbcImpl / begin
     * @version 1.1.0
     * @apiNote <p>返回结果为-1即调用失败</p>
     * <p>返回结果为0即调用成功，{@code connection}已存在</p>
     * <p>返回结果为等于1即调用成功</p>
     * @since 1.3.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Unverified, date = "2020/4/26 21:51")
    public int begin() {
        if (connection != null) {
            return 0;
        }
        try {
            getConnection();
            connection.setAutoCommit(false);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 提交事务
     *
     * @return int 返回是否成功
     * @author Kevin KDA on 2020/4/26 21:59
     * @description JdbcImpl / commitTransaction
     * @version 1.1.0
     * @apiNote <p>返回结果为-1即调用失败</p>
     * <p>返回结果为0即调用成功，{@code connection}不存在，需重新开启事务</p>
     * @since 1.3.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Unverified, date = "2020/4/26 21:59")
    public int commitTransaction() {
        if (connection == null) {
            return 0;
        }
        try {
            getConnection();
            connection.commit();
            intBatchCount = 0;
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 回滚事务
     *
     * @return int 返回是否成功
     * @author Kevin KDA on 2020/4/26 21:57
     * @description JdbcImpl / rollback
     * @version 1.1.0
     * @apiNote <p>返回结果为-1即调用失败</p>
     * <p>返回结果为0即调用成功，{@code connection}不存在，需重新开启事务</p>
     * <p>返回结果为等于1即调用成功</p>
     * @since 1.3.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Unverified, date = "2020/4/26 21:57")
    public int rollback() {
        if (connection == null) {
            return 0;
        }
        try {
            getConnection();
            connection.rollback();
            intBatchCount = 0;
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 设置自动提交关闭
     *
     * @return int 返回设置结果
     * @author Kevin KDA on 2020/4/27 01:03
     * @description JdbcImpl / changeAutoCommit
     * @version 1.1.0
     * @apiNote <p>返回结果为-1即调用失败</p>
     * <p>返回结果为0即调用成功，{@code connection}不存在，需重新开启事务</p>
     * <p>返回结果为等于1即调用成功</p>
     * @since 2.0.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Unverified, date = "2020/4/27 01:03")
    public int changeAutoCommit() {
        if (connection == null) {
            return 0;
        }
        try {
            connection.setAutoCommit(false);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }


//    批处理追加数据方法

    /**
     * 提供插入、更新、删除单行数据的方法
     * 提供向Statement添加参数的方法
     *
     * @param sql 传入需提交的SQL语句
     * @return int 返回参数是否添加成功
     * @author Kevin KDA on 2020/4/26 23:07
     * @description JdbcImpl / add
     * @version 1.1.0
     * @apiNote <p>返回结果为-1，{@code statement}不存在且创建失败</p>
     * <p>返回结果为0即调用成功，未执行任何添加操作</p>
     * <p>返回结果为等于1即调用成功</p>
     * <p>本方法执行完成后系统将不会提交本次批处理</p>
     * <ol><li>实例化对象获得{@link Connection}连接</li>
     * <li>使用{@link Connection}连接获得{@link Statement}对象</li>
     * <li>使用{@code addBatch()}向{@link Statement}追加参数</li>
     * <li>使用{@code executeBatch()}提交批处理</li>
     * <li>清楚批处理缓存</li></ol>
     * @since 3.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/4/26 23:07")
    public int add(String sql) {
//        检查statement是否为null
        if (statement == null) {
//            statement为null，执行创建statement
            try {
//                创建statement
                statement = getConnection().createStatement();
//                创建完成，递归调用进行添加任务
                return add(sql);
            } catch (SQLException e) {
                e.printStackTrace();
//                statement创建失败
                return -1;
            }
        }
        add(new String[]{});
        try {
//            向Statement添加SQL语句
            statement.addBatch(sql);
//            将本次添加成功计数汇总
            intBatchCount++;
//            返回成功添加条数
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
//            未执行任何添加操作
            return 0;
        }
    }

    /**
     * 提供插入、更新、删除多行数据的方法
     * 提供向Statement添加参数的方法
     *
     * @param sql 传入需提交的SQL语句
     * @return int 返回参数是否添加成功
     * @author Kevin KDA on 2020/4/26 22:04
     * @description JdbcImpl / add
     * @version 1.1.0
     * @apiNote <p>返回结果为-1，{@code statement}不存在且创建失败</p>
     * <p>返回结果为0即调用成功，未执行任何添加操作</p>
     * <p>返回结果为大于等于1即调用成功，返回添加成功的实际行数，请检查返回数值是否与传入参数行数相同</p>
     * <p>本方法采用正序添加至statement，若返回数值小于传入参数行数，截取下标为返回数值开始至末行的数据重新添加。
     * e.g. 如传入参数为50行，本方法执行后返回数值21，请续传下标为21-49的SQL语句</p>
     * <p>本方法执行完成后系统将不会提交本次批处理</p>
     * <ol><li>实例化对象获得{@link Connection}连接</li>
     * <li>使用{@link Connection}连接获得{@link Statement}对象</li>
     * <li>使用{@code addBatch()}向{@link Statement}追加参数</li>
     * <li>使用{@code executeBatch()}提交批处理</li>
     * <li>清楚批处理缓存</li></ol>
     * @since 3.0.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Unverified, date = "2020/4/26 22:04")
    public int add(String[] sql) {
//        检查statement是否为null
        if (statement == null) {
//            statement为null，执行创建statement
            try {
//                创建statement
                statement = getConnection().createStatement();
//                创建完成，递归调用进行添加任务
                return add(sql);
            } catch (SQLException e) {
                e.printStackTrace();
//                statement创建失败
                return -1;
            }
        }
//        本次添加计数
        int count = 0;
        try {
//            遍历添加SQL
            for (String s :
                    sql) {
//                获得计数添加成功的计数
                count++;
//                向Statement添加SQL语句
                statement.addBatch(s);
            }
//            将本次添加成功计数汇总
            intBatchCount += count;
//            返回成功添加条数
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
//            检查是否在添加中产生异常
            if (count != 0) {
//                产生异常的行未能成功添加，回退1行后返回数据
                count--;
//                将本次添加成功计数汇总
                intBatchCount += count;
//                返回产生异常前成功添加条数
                return count;
            }
//            未执行任何添加操作
            return 0;
        }
    }

    /**
     * 提供插入、更新、删除单行数据的方法
     * 提供向PreparedStatement添加参数的方法
     *
     * @param args 传入需提交的参数
     * @return int 返回参数是否添加成功
     * @author Kevin KDA on 2020/4/26 22:04
     * @description JdbcImpl / addBatch
     * @version 1.1.0
     * @apiNote <p>返回结果为-1即调用失败</p>
     * <p>返回结果为0即调用成功，{@code connection}不存在，需创建{@link PreparedStatement}</p>
     * <p>返回结果为等于1即调用成功，返回传入的ResultSet实际行数</p>
     * <p>本方法执行完成后系统将不会提交本次批处理</p>
     * <ol><li>实例化对象获得{@link Connection}连接</li>
     * <li>使用{@link Connection}连接获得{@link PreparedStatement}对象</li>
     * <li>使用{@code addBatch()}向{@link PreparedStatement}追加参数</li>
     * <li>使用{@code executeBatch()}提交批处理</li>
     * <li>清楚批处理缓存</li></ol>
     * @since 1.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Unverified, date = "2020/4/26 22:04")
    public int addBatch(Object[] args) {
        if (preparedStatement == null) {
            return 0;
        }
        try {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.addBatch();
            intBatchCount++;
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }


//    批处理提交数据方法

    /**
     * 提供统一向数据库提交的方法 批处理
     *
     * @return int 返回受影响行数
     * @author Kevin KDA on 2020/4/26 23:19
     * @description JdbcImpl / executeBatch
     * @version 1.1.0
     * @apiNote <p>作者认为此方法并不安全，建议使用{@code JdbcImpl.executeBatch(String type)方法}，
     * 由于使用者将两种类型的请求在同一实例化对象中完成，可能导致最终提交数据并不是使用者希望提交的数据</p>
     * <p>返回结果为-2即调用失败，调用过程中产生异常</p>
     * <p>返回结果为-1即调用失败，{@code statement preparedStatement}均为null</p>
     * <p>返回结果为大于等于0即调用成功，返回受影响行数</p>
     * <p>本方法执行完成后系统将不会提交本次批处理</p>
     * <ol><li>实例化对象获得{@link Connection}连接</li>
     * <li>使用{@link Connection}连接获得{@link PreparedStatement}对象</li>
     * <li>使用{@code addBatch()}向{@link PreparedStatement}追加参数</li>
     * <li>使用{@code executeBatch()}提交批处理</li>
     * <li>清楚批处理缓存</li></ol>
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Unverified, date = "2020/4/26 23:19")
    public int executeBatch() {
//        程序返回的计数
        int count = 0;
//        提交批处理后得到的成功数组
        int[] tempCount;
        try {
//            检查进行哪一项提交，仅执行一项提交
            if (statement != null) {
//                statement不为空，执行提交获得返回数组
                tempCount = statement.executeBatch();
//                清空批处理缓存
                statement.clearBatch();
            } else if (preparedStatement != null) {
//                preparedStatement不为空，执行提交获得返回数组
                tempCount = preparedStatement.executeBatch();
//                清空批处理缓存
                preparedStatement.clearBatch();
            } else {
//                两项均为空
                return -1;
            }
//            遍历取得的受影响行数数组，进行数值统计
            for (int i :
                    tempCount) {
                count += i;
            }
//            返回受影响行数
            return count;
        } catch (Exception e) {
            e.printStackTrace();
//            返回异常代码
            return -2;
        }
    }

    /**
     * 提供统一向数据库提交的方法 批处理
     *
     * @param type 传入将进行提交的类型，输入错误将返回错误代码-1             <ol><li>Statement</li>             <li>PreparedStatement</li></ol>
     * @return int 返回受影响行数
     * @author Kevin KDA on 2020/4/26 23:19
     * @description JdbcImpl / executeBatch
     * @version 1.1.0
     * @apiNote <p>作者认为此方法并不安全，建议使用{@code JdbcImpl.executeBatch(String type)方法}，
     * 由于使用者将两种类型的请求在同一实例化对象中完成，可能导致最终提交数据并不是使用者希望提交的数据</p>
     * <p>返回结果为-2即调用失败，调用过程中产生异常</p>
     * <p>返回结果为-1即调用失败，参数 {@code type} 传递错误</p>
     * <p>返回结果为大于等于0即调用成功，返回受影响行数</p>
     * <p>本方法执行完成后系统将不会提交本次批处理</p>
     * <ol><li>实例化对象获得{@link Connection}连接</li>
     * <li>使用{@link Connection}连接获得{@link PreparedStatement}对象</li>
     * <li>使用{@code addBatch()}向{@link PreparedStatement}追加参数</li>
     * <li>使用{@code executeBatch()}提交批处理</li>
     * <li>清楚批处理缓存</li></ol>
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Unverified, date = "2020/4/26 23:19")
    public int executeBatch(int type) {
//        程序返回的计数
        int count = 0;
//        提交批处理后得到的成功数组
        int[] tempCount;
        try {
            switch (type) {
                case 1:
//                    statement不为空，执行提交获得返回数组
                    tempCount = statement.executeBatch();
//                    清空批处理缓存
                    statement.clearBatch();
                    break;
                case 2:
//                    preparedStatement不为空，执行提交获得返回数组
                    tempCount = preparedStatement.executeBatch();
//                    清空批处理缓存
                    preparedStatement.clearBatch();
                    break;
                default:
//                    参数传递错误
                    return -1;
            }
//            遍历取得的受影响行数数组，进行数值统计
            for (int i :
                    tempCount) {
                count += i;
            }
//            返回受影响行数
            return count;
        } catch (Exception e) {
            e.printStackTrace();
//            返回异常代码
            return -2;
        }
    }


//    实现AutoCloseable接口

    /**
     * 保持数据库链接，关闭其他数据对象
     *
     * @return void
     * @author Kevin KDA on 2020/5/12 11:50
     * @description JdbcImpl / closePart
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/12 11:50")
    public void closePart() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (callableStatement != null) {
                callableStatement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 实现AutoCloseable接口 关闭数据库链接
     *
     * @return void
     * @throws Exception AutoClosed
     * @author Kevin KDA on 2020/4/26 16:04
     * @description JdbcImpl / close
     * @version 1.0.0
     * @apiNote
     * @since 1.0.0
     */
    @Override
    public void close() throws Exception {
        try {
            closePart();
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


//    Constructor、Getter、Setter

    /**
     * Instantiates a new Jdbc utils.
     */
    public JdbcImpl() {
    }

    /**
     * 初始化实例对象，指明数据库传入地址
     *
     * @param path 传入资源文件路径
     * @author Kevin KDA on 2020/4/28 13:52
     * @description JdbcImpl / JdbcImpl
     * @version 1.0.0
     * @apiNote
     * @since 3.0.4
     */
    public JdbcImpl(String path) {
        super.use(path);
    }

    /**
     * Gets statement.
     *
     * @return the statement
     */
    @Override
    public Statement getStatement() {
        return statement;
    }

    /**
     * Gets prepared statement.
     *
     * @return the prepared statement
     */
    @Override
    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    /**
     * Gets callable statement.
     *
     * @return the callable statement
     */
    @Override
    public CallableStatement getCallableStatement() {
        return callableStatement;
    }

    /**
     * Gets result set.
     *
     * @return the result set
     */
    @Override
    public ResultSet getResultSet() {
        return resultSet;
    }
}
