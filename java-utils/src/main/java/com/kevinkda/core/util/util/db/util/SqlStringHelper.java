/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.db.util;

/**
 * The type Sql string process.
 *
 * @author Kevin KDA on 2020/10/13 17:20
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.db.util
 * @classname SqlStringHelper
  * @apiNote 
 * @implSpec
 * @implNote

 * @since 1.0.0
 */
public interface SqlStringHelper {
    /**
     * 提供根据条件进行SQL语句的拼接方法
     * 返回样例A SELECT TableA.C1,TableA.C2 FROM TableA,TableB
     * 返回样例B SELECT TableA.C1,TableA.C2 FROM TableA,TableB WHERE TableA.C1=? AND 1=1
     *
     * @param strTable           传入需要查询数据表名
     * @param strColumn          传入需要查询数据列名，如是多表查询需提供包含表名完整的完成列名                           参数格式：TABLE_A.COLUMN_A,TABLE_B.COLUMN_B
     * @param strConditionColumn 传入需要检索条件的列名，若不进行条件检索请赋空
     * @return java.lang.StringBuilder 返回拼接完成的SQL语句
     * @author Kevin KDA on 2020/4/26 17:21
     * @description SqlStringProcess / appendSqlString
     * @version 1.1.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.2.0
     */
    StringBuilder appendSqlString(String[] strTable, String[] strColumn, String[] strConditionColumn);

    /**
     * 提供对数据表查询的字符串拼接
     * 返回样例 SELECT TableA.C1,TableA.C2
     *
     * @param stringBuilder 传入原有StringBuilder对象
     * @param args          传入待拼接的字符串数组
     * @return java.lang.StringBuilder 返回拼接完成的字符串
     * @author Kevin KDA on 2020/4/26 17:22
     * @description SqlStringProcess / strSplicingSelect
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    StringBuilder strSplicingSelect(StringBuilder stringBuilder, String[] args);

    /**
     * 提供对数据表插入、更新、删除的字符串拼接
     * 返回样例 SELECT ?,?
     *
     * @param stringBuilder 传入原有StringBuilder对象
     * @param count         传入数据长度
     * @return java.lang.StringBuilder 返回拼接完成的字符串
     * @author Kevin KDA on 2020/4/26 18:53
     * @description SqlStringProcess / strSplicingUp
     * @version 1.2.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.0.0
     */
    StringBuilder strSplicingUp(StringBuilder stringBuilder, int count);

    /**
     * 提供对数据表插入、更新、删除的字符串拼接
     * 返回样例 SELECT ?,?
     *
     * @param stringBuilder 传入原有StringBuilder对象
     * @param args          传入参数组
     * @return java.lang.StringBuilder 返回拼接完成的字符串
     * @author Kevin KDA on 2020/4/26 18:53
     * @description SqlStringProcess / strSplicingUp
     * @version 1.2.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    StringBuilder strSplicingUp(StringBuilder stringBuilder, Object[] args);

    /**
     * 提供依据传入的模版进行字符串拼接
     * 返回样例 SELECT ?,?
     *
     * @param stringBuilder 传入原有StringBuilder对象
     * @param count         传入数据长度
     * @param cutStr        传入拼接模版
     * @return java.lang.StringBuilder 返回拼接完成的字符串
     * @author Kevin KDA on 2020/4/26 18:53
     * @description SqlStringProcess / strSplicingPart
     * @version 1.2.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.0.0
     */
    StringBuilder strSplicingPart(StringBuilder stringBuilder, int count, String cutStr);

    /**
     * 提供追加分页字符串的方法
     *
     * @param str   传入原有SQL语句 {@code SELECT TABLE_A.COLUMN_A FROM TABLE_A WHERE CONDITION_A = ?}
     * @param pCode 传入请求页面号
     * @param pSize 传入请求页面长度
     * @return java.lang.StringBuilder 返回拼接完成的字符串
     * 返回代码样例 {@code SELECT TABLE_A.COLUMN_A FROM TABLE_A WHERE CONDITION_A = ? LIMIT PAGE_CODE, PAGE_SIZE}
     * @author Kevin KDA on 2020/4/27 23:08
     * @description SqlStringProcess / appendPageString
     * @version 1.2.0
     * @apiNote <p>提供追加分页字符串的方法</p>
     * <p>返回代码样例 {@code SELECT TABLE_A.COLUMN_A FROM TABLE_A WHERE CONDITION_A = ? LIMIT PAGE_CODE, PAGE_SIZE}</p>
     * @implSpec
     * @implNote
     * @since 1.2.0
     */
    StringBuilder appendPageString(StringBuilder str, int pCode, int pSize);

    /**
     * 提供对SQL语句的拼接，拼接过程将会移除字段为 NULL 的项目
     *
     * @param table     传入执行插入的数据表名
     * @param fieldName 传入执行插入的字段名
     * @param params    传入执行插入的参数名
     * @return java.lang.Object[]
     * @author Kevin KDA on 2020/5/18 23:33
     * @description SqlStringProcess / strSplicingForInsertRemoveNull
     * @version 1.0.0
     * @apiNote <p>此方法将会移除值为NULL和{@code ""}的项目</p>
     * <p>数据字段名个数需与待提交参数需个数相等，同时排列位置相同</p>
     * <p>返回字段中下标0为拼接完成的SQL语句，下标0为去除空项得到的待提交参数</p>
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    Object[] strSplicingForInsertRemoveNull(String table, String[] fieldName, Object[] params);
}
