/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.db.util.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.util.db.util.SqlStringHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin KDA on 2020/10/13 17:21
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.db.util.impl
 * @classname
 * @apiNote <p></p>
 * @since 1.0.0
 */
@Service
public class SqlStringHelperImpl implements SqlStringHelper {
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
     * @since 1.2.0
     */
    @Override
    @FuncVerification(version = "1.1.0", status = VerifiedType.Pass, date = "2020/4/26 17:21")
    public StringBuilder appendSqlString(String[] strTable, String[] strColumn, String[] strConditionColumn) {
//        拼接SELECT字段名
//        得到数据格式  SELECT TABLE_A.COLUMN_A,TABLE_B.COLUMN_B
        StringBuilder stringBuilder = new StringBuilder("SELECT ");
        strSplicingSelect(stringBuilder, strColumn);
//        拼接数据表名
//        得到数据格式 FROM TABLE_A, TABLE_B
        stringBuilder.append(" FROM ");
        strSplicingSelect(stringBuilder, strTable);
//        截止此处数据结果格式  SELECT TABLE_A.COLUMN_A,TABLE_B.COLUMN_B FROM TABLE_A, TABLE_B

//        如存在条件字段，进行条件字段拼接
        if (strConditionColumn != null && strConditionColumn.length != 0) {
            stringBuilder.append(" WHERE ");
            for (String s : strConditionColumn) {
                stringBuilder.append(s);
                stringBuilder.append("= ? AND ");
            }
//            拼接完成后向SQL追加1 = 1，数据结果格式 SELECT TABLE_A.COLUMN_A, TABLE_B.COLUMN_B FROM TABLE_A, TABLE_B WHERE COLUMN_B =? AND 1 = 1
            stringBuilder.append("1=1");
        }
        return stringBuilder;
    }

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
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 17:22")
    public StringBuilder strSplicingSelect(StringBuilder stringBuilder, String[] args) {
        for (String s :
                args) {
            stringBuilder.append(s);
            stringBuilder.append(",");
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return stringBuilder;
    }

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
     * @since 3.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 18:53")
    @FuncVerification(version = "1.2.0", status = VerifiedType.Pass, date = "2020/4/27 00:18")
    public StringBuilder strSplicingUp(StringBuilder stringBuilder, int count) {
//        添加正括号开始拼接
        stringBuilder.append("(");
//        调用公共方法平接字符串，传入拼接模版
        stringBuilder = strSplicingPart(stringBuilder, count, "?,");
//        添加反括号封闭
        stringBuilder.append(")");
//        返回拼接完成的字符串
        return stringBuilder;
    }

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
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 18:53")
    @FuncVerification(version = "1.2.0", status = VerifiedType.Unverified, date = "2020/4/27 00:18")
    public StringBuilder strSplicingUp(StringBuilder stringBuilder, Object[] args) {
        return strSplicingUp(stringBuilder, args.length);
    }

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
     * @since 3.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 18:53")
    @FuncVerification(version = "1.2.0", status = VerifiedType.Pass, date = "2020/4/27 00:18")
    public StringBuilder strSplicingPart(StringBuilder stringBuilder, int count, String cutStr) {
//        遍历添加占位符
        for (int i = 0; i < count; i++) {
//            添加占位符
            stringBuilder.append(cutStr);
        }
//        去除末尾","
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
//        返回拼接完成的字符串
        return stringBuilder;
    }

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
     * @since 1.2.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/4/27 23:08")
    public StringBuilder appendPageString(StringBuilder str, int pCode, int pSize) {
        int intStartingItemNo = (pCode - 1) * pSize;
        str.append(" LIMIT ");
        str.append(intStartingItemNo);
        str.append(" , ");
        str.append(pSize);
        return str;
    }

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
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/18 23:33")
    public Object[] strSplicingForInsertRemoveNull(String table, String[] fieldName, Object[] params) {
//        返回SQL语句保存域，载入数据库插入语句头
        StringBuilder builder = new StringBuilder("INSERT INTO ");
//        返回待插入参数保存域
        List<Object> list = new ArrayList<>(params.length);

//        载入待数据库的表名
        builder.append(table);
//        添加SQL格式化字符
        builder.append(" (");

//        记录非空个数
        int notNullCount = 0;

//        进行待传入参数非空检查
        for (int i = 0; i < params.length; i++) {
//            检查待传参数不为 null 和 ""
            if (params[i] != null && !("".equals(params[i]))) {
//                非空个数增加
                notNullCount++;
//                添加字段名
                builder.append(fieldName[i]);
//                添加SQL格式化字符
                builder.append(", ");
//                添加非空的待传参数
                list.add(params[i]);
            }
        }
//        待传参数检查完成，去除末尾 ","
        builder.delete(builder.length() - 2, builder.length());
//        进行字段名封闭
        builder.append(") VALUES ");
//        进行 VALUES 拼接
        builder = strSplicingUp(builder, notNullCount);

//        返回数据
        return new Object[]{builder.toString(), list.toArray()};
    }

    public SqlStringHelperImpl() {
    }

}
