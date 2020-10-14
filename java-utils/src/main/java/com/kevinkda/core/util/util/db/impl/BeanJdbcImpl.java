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
import com.kevinkda.core.util.util.db.BeanJdbc;
import com.kevinkda.core.util.util.db.Jdbc;
import com.kevinkda.core.util.util.db.util.SqlStringHelper;
import com.kevinkda.core.util.util.string.StringHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin KDA on 2020/10/13 17:26
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.db.impl
 * @classname
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class BeanJdbcImpl<T> implements BeanJdbc {
    @Autowired
    private SqlStringHelper sqlStringHelper;
    @Autowired
    private Jdbc jdbc;


//    转换JavaBean

    /**
     * 提供将ResultSet的数据转换为JavaBean
     *
     * @param sql 需要查询SQL语句
     * @return {@code java.util.List<T>} 返回类型为需求JavaBean类型的 {@code java.util.List<T>} 集合
     * @author Kevin KDA on 2020/5/5 23:07
     * @description BeanJdbcImpl / getBean
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 23:07")
    public List<T> getBean(String sql) {
        return this.getBean(sql, null);
    }

    /**
     * 提供获得ResultSet中详细数据的方法，返回集合{@code java.util.List<T>}供后续处理
     *
     * @param sql            需要查询SQL语句
     * @param conditionValue 传入与需要检索条件的列名称对应的检索值
     * @return {@code java.util.List<T>} 返回类型为需求JavaBean类型的 {@code java.util.List<T>} 集合
     * @author Kevin KDA on 2020/5/5 19:28
     * @description BeanJdbcImpl / getBean
     * @version 1.0.0
     * @apiNote <p>使用本方法需在数据库链接URL中添加{@code useOldAliasMetadataBehavior=true}</p>
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 19:28")
    public List<T> getBean(String sql, Object[] conditionValue) {
//        获得查询结果 List<Map<String, Object>> 对象
        ResultSet resultSet = jdbc.getResultSet(sql, conditionValue);
//         获得结果集列数
        int rowCount = jdbc.getResultSetCountColumn(resultSet);
//        创建返回的实例化对象，用于保存数据
        List<T> listT = new ArrayList<T>(jdbc.getResultSetCountRow(resultSet));
        try {
//            声明泛型对象
            T entity = null;
            while (resultSet.next()) {
//                实例化泛型对象
                entity = (T) entity.getClass().getConstructor();
//                循环获得列名和值，并存入 JavaBean 对象
                for (int i = 1; i < rowCount + 1; i++) {
//                    获得数据表列名，即 JavaBean 对象属性字段名
                    String key = resultSet.getMetaData().getColumnName(i);
//                    获得数据表列名对应的值，即 JavaBean 对象属性字段值
                    Object value = resultSet.getObject(i);
//                    将值存入 JavaBean 对象
                    BeanUtils.setProperty(entity, key, value);
                }

//                将泛型对象存入集合
                listT.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        返回集合
        return listT;
    }

    /**
     * 提供将ResultSet的数据转换为JavaBean
     *
     * @param strTable           传入需要查询数据表名
     * @param strColumn          传入需要查询数据列名，如是多表查询需提供包含表名完整的完成列名                           参数格式：TABLE_A,TABLE_B.COLUMN_A
     * @param strConditionColumn 传入需要检索条件的列名，若不进行条件检索请赋空
     * @param conditionValue     传入与需要检索条件的列名称对应的检索值
     * @return {@code java.util.List<T>} 返回类型为需求JavaBean类型的 {@code java.util.List<T>} 集合
     * @author Kevin KDA on 2020/5/5 23:16
     * @description BeanJdbcImpl / getBean
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 23:16")
    public List<T> getBean(String[] strTable, String[] strColumn,
                           String[] strConditionColumn, Object[] conditionValue) {
        StringBuilder stringBuilder = sqlStringHelper.appendSqlString(strTable, strColumn, strConditionColumn);
        return this.getBean(stringBuilder.toString(), conditionValue);
    }

//    传入 Class

    /**
     * 提供将ResultSet的数据转换为JavaBean
     *
     * @param sql   需要查询SQL语句
     * @param clazz 传入JavaBean对象的类型
     * @return {@code java.util.List<T>} 返回类型为需求JavaBean类型的 {@code java.util.List<T>} 集合
     * @author Kevin KDA on 2020/5/5 23:07
     * @description BeanJdbcImpl / getBeanByClass
     * @version 1.0.0
     * @apiNote <p>本方法需要传入Class对象类型</p>
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 23:07")
    public List<T> getBeanByClass(String sql, Class<T> clazz) {
        return this.getBeanByClass(sql, null, clazz);
    }

    /**
     * 提供将ResultSet的数据转换为JavaBean
     *
     * @param sql            需要查询SQL语句
     * @param conditionValue 传入与需要检索条件的列名称对应的检索值
     * @param clazz          传入JavaBean对象的类型
     * @return {@code java.util.List<T>} 返回类型为需求JavaBean类型的 {@code java.util.List<T>} 集合
     * @author Kevin KDA on 2020/5/5 22:59
     * @description BeanJdbcImpl / getBeanByClass
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 22:59")
    public List<T> getBeanByClass(String sql, Object[] conditionValue, Class<T> clazz) {
//        获得查询结果 List<Map<String, Object>> 对象
        ResultSet resultSet = jdbc.getResultSet(sql, conditionValue);
//         获得结果集列数
        int rowCount = jdbc.getResultSetCountColumn(resultSet);
//        创建返回的实例化对象，用于保存数据
        List<T> listT = new ArrayList<T>(jdbc.getResultSetCountRow(resultSet));
        try {
//            声明泛型对象
            T entity;
            while (resultSet.next()) {
//                实例化泛型对象
                entity = clazz.newInstance();
//                循环获得列名和值，并存入 JavaBean 对象
                for (int i = 1; i < rowCount + 1; i++) {
//                    获得数据表列名，即 JavaBean 对象属性字段名
//                    String key = checkFieldName(resultSet.getMetaData().getColumnName(i));

//                    获得数据表列别名，即 JavaBean 对象属性字段名
                    String key = checkFieldName(resultSet.getMetaData().getColumnLabel(i));
//                    获得数据表列名对应的值，即 JavaBean 对象属性字段值
                    Object value = resultSet.getObject(i);
//                    将值存入 JavaBean 对象
                    BeanUtils.setProperty(entity, key, value);
                }
//                将泛型对象存入集合
                listT.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        返回集合
        return listT;
    }

    /**
     * 提供将ResultSet的数据转换为JavaBean
     *
     * @param strTable           传入需要查询数据表名
     * @param strColumn          传入需要查询数据列名，如是多表查询需提供包含表名完整的完成列名                           参数格式：TABLE_A,TABLE_B.COLUMN_A
     * @param strConditionColumn 传入需要检索条件的列名，若不进行条件检索请赋空
     * @param conditionValue     传入与需要检索条件的列名称对应的检索值
     * @param clazz              传入JavaBean对象的类型
     * @return {@code java.util.List<T>} 返回类型为需求JavaBean类型的 {@code java.util.List<T>} 集合
     * @author Kevin KDA on 2020/5/5 23:07
     * @description BeanJdbcImpl / getBeanByClass
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 23:07")
    public List<T> getBeanByClass(String[] strTable, String[] strColumn,
                                  String[] strConditionColumn, Object[] conditionValue, Class<T> clazz) {
        StringBuilder stringBuilder = sqlStringHelper.appendSqlString(strTable, strColumn, strConditionColumn);
        return this.getBeanByClass(stringBuilder.toString(), conditionValue, clazz);
    }


//    从父类的 getResultListMap 方法获得数据

    /**
     * 提供获得ResultSet中详细数据的方法，返回集合{@code java.util.List<T>}供后续处理
     *
     * @param sql 需要查询SQL语句
     * @return {@code java.util.List<T>} 返回类型为需求JavaBean类型的 {@code java.util.List<T>} 集合
     * @author Kevin KDA on 2020/5/5 19:09
     * @description BeanJdbcImpl / getBeanByMap
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 19:09")
    public List<T> getBeanByMap(String sql) {
        return this.getBeanByMap(sql, null);
    }

    /**
     * 提供获得ResultSet中详细数据的方法，返回集合{@code java.util.List<T>}供后续处理
     *
     * @param sql            需要查询SQL语句
     * @param conditionValue 传入与需要检索条件的列名称对应的检索值
     * @return {@code java.util.List<T>} 返回类型为需求JavaBean类型的 {@code java.util.List<T>} 集合
     * @author Kevin KDA on 2020/5/5 19:03
     * @description BeanJdbcImpl / getBeanByMap
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 19:03")
    public List<T> getBeanByMap(String sql, Object[] conditionValue) {
//        获得查询结果 List<Map<String, Object>> 对象
        List<Map<String, Object>> mapList = jdbc.getResultListMap(sql, conditionValue);
//        创建返回的实例化对象，用于保存数据
        List<T> listT = new ArrayList<>();
        try {
//            获得泛型对象类型
            Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//            声明泛型对象
            T entity;
//            循环遍历从数据库获得的 List Map 对象，转换成 JavaBean
            for (Map<String, Object> map :
                    mapList) {
//                实例化泛型对象
                entity = entityClass.newInstance();
//                将Map中的数据存入JavaBean
                BeanUtils.populate(entity, map);
//                将泛型对象存入集合
                listT.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        返回集合
        return listT;
    }

    /**
     * 提供获得ResultSet中详细数据的方法，返回键值对数组供后续处理
     *
     * @param strTable           传入需要查询数据表名
     * @param strColumn          传入需要查询数据列名，如是多表查询需提供包含表名完整的完成列名                           参数格式：TABLE_A,TABLE_B.COLUMN_A
     * @param strConditionColumn 传入需要检索条件的列名，若不进行条件检索请赋空
     * @param conditionValue     传入与需要检索条件的列名称对应的检索值
     * @return {@code java.util.List<T>} 返回类型为需求JavaBean类型的 {@code java.util.List<T>} 集合
     * @author Kevin KDA on 2020/5/5 19:14
     * @description BeanJdbcImpl / getBeanByMap
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 19:14")
    public List<T> getBeanByMap(String[] strTable, String[] strColumn,
                                String[] strConditionColumn, Object[] conditionValue) {
        StringBuilder stringBuilder = sqlStringHelper.appendSqlString(strTable, strColumn, strConditionColumn);
        return this.getBeanByMap(stringBuilder.toString(), conditionValue);
    }


//    字符串处理

    /**
     * 进行字符串检查
     *
     * @param str 传入原始字符串
     * @return java.lang.String 返回首字母小写的字符串
     * @author Kevin KDA on 2020/5/5 21:21
     * @description BeanJdbcImpl / checkFieldName
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/5 21:21")
    private String checkFieldName(String str) {
        if ("ID".equals(str.toUpperCase())) {
            return "id";
        }
        return StringHelper.initialLowercase(str);
    }


//    Constructor、Getter、Setter

    public BeanJdbcImpl() {
        super();
    }

    public BeanJdbcImpl(String path) {
        jdbc.use(path);
    }
}
