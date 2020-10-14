/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.db;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.util.db.impl.JdbcImpl;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin KDA on 2020/10/13 17:12
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.db
 * @classname Jdbc
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface Jdbc extends AutoCloseable {
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
     * @implSpec
     * @implNote
     * @since 1.5.0
     */
    Connection getConnection();

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
     * @implSpec
     * @implNote
     * @since 1.5.0
     */
    Connection getConnection(boolean flag);

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
     * @implSpec
     * @implNote
     * @since 1.5.0
     */
    PreparedStatement getPreparedStatement(String sql);

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
     * @implSpec
     * @implNote
     * @since 1.5.0
     */
    PreparedStatement getPreparedStatement(String sql, boolean flag);


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
     * @implSpec
     * @implNote
     * @since 1.2.0
     */
    ResultSet getResultSet(String sql);

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
     * @implSpec
     * @implNote
     * @since 1.2.0
     */
    ResultSet getResultSet(String sql, Object[] conditionValue);

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
     * @implSpec
     * @implNote
     * @since 1.2.0
     */
    ResultSet getResultSet(String[] strTable, String[] strColumn,
                           String[] strConditionColumn, Object[] conditionValue);


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
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    boolean append(Object[] args);


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
     * @implSpec
     * @implNote
     * @since 1.1.0
     */
    List<Map<String, Object>> getResultListMap(String sql);

    /**
     * 提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理
     *
     * @param sql            需要查询SQL语句
     * @param conditionValue 传入与需要检索条件的列名称对应的检索值
     * @return {@code java.util.List<java.util.Map<java.lang.String, java.lang.Object>>} 返回键值对数组，其中键为数据表中列名，值为与列对应的值
     * @author Kevin KDA on 2020/4/26 20:31
     * @description JdbcImpl / getResultListMap
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.1.0
     */
    List<Map<String, Object>> getResultListMap(String sql, Object[] conditionValue);

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
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    List<Map<String, Object>> getResultListMap(String[] strTable, String[] strColumn,
                                               String[] strConditionColumn, Object[] conditionValue);


//    Utils 获得List<Map<String, Object>>集合

    /**
     * 提供提取ResultSet中详细数据的方法，返回键值对数组供后续处理
     * 私有公用方法
     *
     * @param resultSet 传入  已获取的结果集
     * @return {@code java.util.List<java.util.Map<java.lang.String, java.lang.Object>>}  返回键值对数组，其中键为数据表中列名，值为与列对应的值
     * @author Kevin KDA on 2020/4/26 20:36
     * @description JdbcImpl / getListMap
     * @version 1.1.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.1.0
     */
    List<Map<String, Object>> getListMap(ResultSet resultSet);


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
     * @implSpec
     * @implNote
     * @since 1.3.0
     */
    int getResultSetCountRow(ResultSet resultSet);

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
     * @implSpec
     * @implNote
     * @since 1.3.0
     */
    int getResultSetCountColumn(ResultSet resultSet);


//    提交ResultSet查询请求

    /**
     * 提供统一向数据库提交查询的SQL请求
     *
     * @return java.sql.ResultSet 返回ResultSet结果集 即表
     * @author Kevin KDA on 2020/4/26 19:07
     * @description JdbcImpl / executeQuery
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    ResultSet executeQuery();

    /**
     * 提供统一向数据库提交查询的SQL请求
     *
     * @param sql 需要查询SQL语句
     * @return java.sql.ResultSet 返回ResultSet结果集 即表
     * @author Kevin KDA on 2020/4/26 19:12
     * @description JdbcImpl / executeQuery
     * @version 1.1.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    ResultSet executeQuery(String sql);


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
     * @implSpec
     * @implNote
     * @since 1.5.0
     */
    int singleSql(String sql) throws SQLException;

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
     * @implSpec
     * @implNote
     * @since 1.5.0
     */
    int singleSql(String sql, Object[] args);


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
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    int insertSingle(String strTableName, Object[] args);

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
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    int updateSingle(String strTable, String[] strColumnName, Object[] args);

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
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    int delete(String strTable, String strColumnName, String strIds);


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
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    int executeUpdate();


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
     * @implSpec
     * @implNote
     * @since 2.1.0
     */
    ResultSet runCallableStatement(String proc, Object[] args);

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
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    CallableStatement runCallableStatement(String proc, Object[] args, Object[] outArgs);


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
     * @implSpec
     * @implNote
     * @since 1.3.0
     */
    int begin();

    /**
     * 提交事务
     *
     * @return int 返回是否成功
     * @author Kevin KDA on 2020/4/26 21:59
     * @description JdbcImpl / commitTransaction
     * @version 1.1.0
     * @apiNote <p>返回结果为-1即调用失败</p>
     * <p>返回结果为0即调用成功，{@code connection}不存在，需重新开启事务</p>
     * @implSpec
     * @implNote
     * @since 1.3.0
     */
    int commitTransaction();

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
     * @implSpec
     * @implNote
     * @since 1.3.0
     */
    int rollback();

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
     * @implSpec
     * @implNote
     * @since 2.0.0
     */
    int changeAutoCommit();


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
     * @implSpec
     * @implNote
     * @since 3.0.0
     */
    int add(String sql);

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
     * @implSpec
     * @implNote
     * @since 3.0.0
     */
    int add(String[] sql);

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
     * @implSpec
     * @implNote
     * @since 1.0
     */
    int addBatch(Object[] args);


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
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    int executeBatch();

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
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    int executeBatch(int type);


//    实现AutoCloseable接口

    /**
     * 保持数据库链接，关闭其他数据对象
     *
     * @author Kevin KDA on 2020/5/12 11:50
     * @description JdbcImpl / closePart
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/12 11:50")
    void closePart();

    /**
     * 实现AutoCloseable接口 关闭数据库链接
     *
     * @throws Exception AutoClosed
     * @author Kevin KDA on 2020/4/26 16:04
     * @description JdbcImpl / close
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    void close() throws Exception;


//    Constructor、Getter、Setter


    /**
     * Gets statement.
     *
     * @return the statement
     */
    Statement getStatement();

    /**
     * Gets prepared statement.
     *
     * @return the prepared statement
     */
    PreparedStatement getPreparedStatement();

    /**
     * Gets callable statement.
     *
     * @return the callable statement
     */
    CallableStatement getCallableStatement();

    /**
     * Gets result set.
     *
     * @return the result set
     */
    ResultSet getResultSet();


    /**
     * 当本程序作为第三方库被调用/依赖时，使用此方法
     *
     * @param path 传入配置文件路径
     * @return boolean 返回调用结果
     * @author Kevin KDA on 2020/4/27 10:48
     * @description AbstractJdbc / use
     * @version 1.0.0
     * @apiNote <p>当传入路径不正确程序会抛异常，请确保传入路径正确</p>
     * <p>当被依赖项目为Maven时请将资源文件放置resources资源包中，否则无法找到路径</p>
     * <p>当被依赖项目为Maven时不必将资源文件放置resources资源包中</p>
     * <p>资源包必须包含如下参数，否则程序异常：</p>
     * <p>{@code db.BatchMax}</p>
     * <p>{@code jdbc.driver}</p>
     * <p>{@code jdbc.url}</p>
     * <p>{@code jdbc.user}</p>
     * <p>{@code jdbc.password}</p>
     * @implSpec
     * @implNote
     * @since 3.0.0
     */
    boolean use(String path);
}
