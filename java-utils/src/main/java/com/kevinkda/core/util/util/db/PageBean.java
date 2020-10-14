/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.db;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * 提供对于JDBC页面分页服务
 *
 * @author Kevin KDA on 2020/10/14 00:03
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.db
 * @classname PageBean
 * @apiNote <p>使用本类时请先{@code use()}方法传入资源文件路径，
 * 或使用构造方法{@code public JdbcImpl(String path)}传入资源文件路径</p>
 * <p>为避免出现超出预期的错误，请仅在 PageBean 实例中使用同一套SQL查询</p>
 * <p>此项目希望做到提供尽可能的通用方法，但某些特殊情况可能无法提供处理。</p>
 * <p>此封装类已尽可能的对{@link Exception}进行{@code try}捕获。</p>
 * <p>不可避免的这可能将会导致后续程序的在特定情况下产生{@link NullPointerException}。</p>
 * <p>本类数据分页部分依赖{@link Jdbc}提供的方法实现。</p>
 * @since 1.0.0
 */
public interface PageBean {
//    获得分页后的ResultSet结果集

    /**
     * 提供获得ResultSet对象的方法
     *
     * @param sql 需要查询SQL语句
     * @return java.sql.ResultSet 返回ResultSet，请求数据自行处理
     * @author Kevin KDA on 2020/4/27 22:49
     * @description PageBean / getResultSet
     * @version 1.1.0
     * @apiNote 返回结果集需自行处理
     * @since 1.1.0
     */
    ResultSet getResultSet(String sql);

    /**
     * 提供获得ResultSet对象的方法
     *
     * @param sql            需要查询SQL语句
     * @param conditionValue 传入与需要检索条件的列名称对应的检索值
     * @return java.sql.ResultSet 返回ResultSet，请求数据自行处理
     * @author Kevin KDA on 2020/4/27 22:51
     * @description PageBean / getResultSet
     * @version 1.1.0
     * @apiNote 返回结果集需自行处理
     * @since 1.1.0
     */
    ResultSet getResultSet(String sql, Object[] conditionValue);

    /**
     * 提供获得ResultSet对象的方法
     *
     * @param strTable           传入需要查询数据表名
     * @param strColumn          传入需要查询数据列名，如是多表查询需提供包含表名完整的完成列名
     *                           参数格式：TABLE_A,TABLE_B.COLUMN_A
     * @param strConditionColumn 传入需要检索条件的列名，若不进行条件检索请赋空
     * @param conditionValue     传入与需要检索条件的列名称对应的检索值
     * @return java.sql.ResultSet 返回ResultSet，请求数据自行处理
     * @author Kevin KDA on 2020/4/27 22:52
     * @description PageBean / getResultSet
     * @version 1.1.0
     * @apiNote 返回结果集需自行处理
     * @since 1.1.0
     */
    ResultSet getResultSet(String[] strTable, String[] strColumn,
                           String[] strConditionColumn, Object[] conditionValue);


//    获得分页后的List<Map<String, Object>>对象

    /**
     * 提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理
     *
     * @param sql 需要查询SQL语句
     * @return {@code java.util.List<java.util.Map<java.lang.String, java.lang.Object>>} 返回键值对数组，其中键为数据表中列名，值为与列对应的值
     * @author Kevin KDA on 2020/4/27 23:28
     * @description PageBean / getResultListMap
     * @version 1.2.0
     * @apiNote <p>提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理</p>
     * @since 1.1.0
     */
    List<Map<String, Object>> getResultListMap(String sql);

    /**
     * 提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理
     *
     * @param sql            需要查询SQL语句
     * @param conditionValue 传入与需要检索条件的列名称对应的检索值
     * @return {@code java.util.List<java.util.Map<java.lang.String, java.lang.Object>>} 返回键值对数组，其中键为数据表中列名，值为与列对应的值
     * @author Kevin KDA on 2020/4/27 23:32
     * @description PageBean / getResultListMap
     * @version 1.2.0
     * @apiNote <p>提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理</p>
     * @since 1.1.0
     */
    List<Map<String, Object>> getResultListMap(String sql, Object[] conditionValue);

    /**
     * 提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理
     *
     * @param strTable           传入需要查询数据表名
     * @param strColumn          传入需要查询数据列名，如是多表查询需提供包含表名完整的完成列名
     *                           参数格式：TABLE_A,TABLE_B.COLUMN_A
     * @param strConditionColumn 传入需要检索条件的列名，若不进行条件检索请赋空
     * @param conditionValue     传入与需要检索条件的列名称对应的检索值
     * @return {@code java.util.List<java.util.Map<java.lang.String, java.lang.Object>>} 返回键值对数组，其中键为数据表中列名，值为与列对应的值
     * @author Kevin KDA on 2020/4/27 23:33
     * @description PageBean / getResultListMap
     * @version 1.2.0
     * @apiNote <p>提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理</p>
     * @since 1.1.0
     */
    List<Map<String, Object>> getResultListMap(String[] strTable, String[] strColumn,
                                               String[] strConditionColumn, Object[] conditionValue);


    //    获得请求分页数据总行数

    /**
     * 提供获得ResultSet行数的方法
     * 获得数据表行数，代码样例 {@code SELECT COUNT(*) FROM TABLE_A}
     *
     * @param sql 传入待取值的SQL
     * @return int 返回ResultSet行数
     * @author Kevin KDA on 2020/4/27 23:51
     * @description PageBean / getResultSetCountRow
     * @version 1.2.0
     * @apiNote <p>获得数据表行数，代码样例 {@code SELECT COUNT(*) FROM TABLE_A}</p>
     * <p>调用本方法将调用数据库进行数据统计，请使用 {@code COUNT()} 方法编写SQL语句，并传入</p>
     * @since 1.1.0
     */
    int getResultSetCountRow(String sql);

    /**
     * 提供获得ResultSet行数的方法
     * 获得数据表行数，代码样例 {@code SELECT COUNT(*) FROM TABLE_A WHERE CONDITION_A = ?}
     *
     * @param sql            传入待取值的SQL
     * @param conditionValue 传入请求SQL语句的条件
     * @return int 返回ResultSet行数
     * @author Kevin KDA on 2020/4/27 23:51
     * @description PageBean / getResultSetCountRow
     * @version 1.2.0
     * @apiNote <p>获得数据表行数，代码样例 {@code SELECT COUNT(*) FROM TABLE_A}</p>
     * <p>调用本方法将调用数据库进行数据统计，请使用 {@code COUNT()} 方法编写SQL语句，并传入</p>
     * @since 1.1.0
     */
    int getResultSetCountRow(String sql, Object[] conditionValue);


//    获得分页数据, 进行页面号修改

    /**
     * 分页数据上一页，修改当前页面号
     *
     * @return boolean 返回结果
     * @author Kevin KDA on 2020/4/27 22:17
     * @description PageBean / last
     * @version 1.0.0
     * @apiNote <p>仅提供对当前分页号的修改，数据获取请令行操作</p>
     * @since 1.0.0
     */
    boolean last();

    /**
     * 分页数据上一页，修改当前页面号
     *
     * @return boolean 返回结果
     * @author Kevin KDA on 2020/4/27 22:23
     * @description PageBean / next
     * @version 1.0.0
     * @apiNote <p>仅提供对当前分页号的修改，数据获取请令行操作</p>
     * @since 1.0.0
     */
    boolean next();


//    获得分页数据, 获得ResultSet结果集，数据获取自行处理

    /**
     * 分页数据上一页
     * 获得ResultSet结果集，数据获取自行处理
     *
     * @return java.sql.ResultSet 返回ResultSet结果集
     * @author Kevin KDA on 2020/4/27 22:29
     * @description PageBean / lastResultSet
     * @version 1.1.0
     * @apiNote
     * @since 1.1.0
     */
    ResultSet lastResultSet();

    /**
     * 分页数据下一页
     * 获得ResultSet结果集，数据获取自行处理
     *
     * @return java.sql.ResultSet 返回ResultSet结果集
     * @author Kevin KDA on 2020/4/27 22:30
     * @description PageBean / nextResultSet
     * @version 1.1.0
     * @apiNote
     * @since 1.1.0
     */
    ResultSet nextResultSet();


//    获得分页数据,  {@code List<Map>} 数组，所获得数据可以直接被调用

    /**
     * 分页数据上一页
     * 获得 {@code List<Map>} 数组，所获得数据可以直接被调用
     *
     * @return {@code java.util.List<java.util.Map<java.lang.String, java.lang.Object>>} 返回List结果集
     * @author Kevin KDA on 2020/4/27 22:32
     * @description PageBean / lastPageMap
     * @version 1.1.0
     * @apiNote 获得 {@code List<Map>} 数组，所获得数据可以直接被调用
     * @since 1.1.0
     */
    List<Map<String, Object>> lastPageMap();

    /**
     * 分页数据下一页
     * 获得 {@code List<Map>} 数组，所获得数据可以直接被调用
     *
     * @return {@code java.util.List<java.util.Map<java.lang.String, java.lang.Object>>} 返回List结果集
     * @author Kevin KDA on 2020/4/27 22:35
     * @description PageBean / nextPageMap
     * @version 1.1.0
     * @apiNote
     * @since 1.0.0
     */
    List<Map<String, Object>> nextPageMap();


    public int getIntPageCode();

    public void setIntPageCode(int intPageCode);

    public int getIntTotalPage();

    public void setIntTotalPage();

    public int getIntTotalRecord();

    public void setIntTotalRecord(int intTotalRecord);

    public int getIntPageSize();

    public void setIntPageSize(int intPageSize);

    public int getIntPageColumnSize();

    public void setIntPageColumnSize(int intPageColumnSize);

    public String getSql();

    public void setSql(String sql);

    public Object[] getConditionValue();

    public void setConditionValue(Object[] conditionValue);


}
