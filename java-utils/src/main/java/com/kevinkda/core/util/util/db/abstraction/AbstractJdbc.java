/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.db.abstraction;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.util.db.Jdbc;

import java.util.ResourceBundle;

/**
 * 提供对于JDBC的链接信息抽象
 *
 * @author Kevin KDA on 2020/10/13 17:14
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.db.abstraction
 * @classname
 * @apiNote <p></p>
 * @since 1.0.0
 */
public abstract class AbstractJdbc implements Jdbc {
    /**
     * 资源文件包路径
     */
    String strResourcePath;
//    String strResourcePath = "com.kevinkda.resource.db.db";
    /**
     * 当前使用的数据库
     */
    static int DATABASE_CURRENTLY_IN_USE = 0;
    /**
     * 批处理最大接收数值
     */
    static int BATCH_MAX = 0;
    /**
     * 批处理当前接收数值
     */
    protected int intBatchCount = 0;
//    /**
//     * 数据库类型MySQL
//     */
//    static final int MYSQL = 1;
//    /**
//     * 数据库类型Oracle
//     */
//    static final int ORACLE = 2;
//    /**
//     * 数据库类型SQL Server
//     */
//    static final int SQL_SERVER = 3;
    /**
     * 数据库驱动名称
     */
    protected String driver = null;
    /**
     * 数据库链接地址
     */
    protected String url = null;
    /**
     * 数据库用户名
     */
    protected String user = null;
    /**
     * 数据库用户密码
     */
    protected String pass = null;


//    作为第三方库被依赖调用

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
     * @since 3.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/27 10:48")
    public boolean use(String path) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(path);
        BATCH_MAX = Integer.parseInt(resourceBundle.getString("db.BatchMax"));
        driver = resourceBundle.getString("jdbc.driver");
        url = resourceBundle.getString("jdbc.url");
        user = resourceBundle.getString("jdbc.user");
        pass = resourceBundle.getString("jdbc.password");
        return true;
    }


//    初始化对象
//
//    /**
//     * 设置当前使用的数据库
//     *
//     * @param choose 选择数据库类型，请根据本类提供的final修饰字段选择
//     * @return boolean 返回获取结果
//     * @author Kevin KDA on 2020/4/26 15:39
//     * @description AbstractJdbc / chooseTypeInit
//     * @version 1.0.0
//     * @apiNote <p>若选择错误本类将使用MySQL作为默认数据库</p>
//     * <p>程序提供的数据库如下:</p>
//     * <ol><li>MySQL</li>
//     * <li>Oracle</li>
//     * <li>SQL Server</li></ol>
//     * @since 1.0.0
//     */
//    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/4/26 15:39", note = "调用方法测试 static块")
//    protected boolean chooseTypeInit(int choose) {
//        ResourceBundle resourceBundle = ResourceBundle.getBundle(strResourcePath);
//        BATCH_MAX = Integer.parseInt(resourceBundle.getString("db.BatchMax"));
//        switch (DATABASE_CURRENTLY_IN_USE) {
//            case ORACLE:
//                driver = resourceBundle.getString("jdbc.oracle.driver");
//                url = resourceBundle.getString("jdbc.oracle.url");
//                user = resourceBundle.getString("jdbc.oracle.user");
//                pass = resourceBundle.getString("jdbc.oracle.password");
//                return true;
//            case SQL_SERVER:
//                driver = resourceBundle.getString("jdbc.sqlserver.driver");
//                url = resourceBundle.getString("jdbc.sqlserver.url");
//                user = resourceBundle.getString("jdbc.sqlserver.user");
//                pass = resourceBundle.getString("jdbc.sqlserver.password");
//                return true;
//            case MYSQL:
//            default:
//                driver = resourceBundle.getString("jdbc.mysql.driver");
//                url = resourceBundle.getString("jdbc.mysql.url");
//                user = resourceBundle.getString("jdbc.mysql.user");
//                pass = resourceBundle.getString("jdbc.mysql.password");
//                return true;
//        }
//    }


//    Constructor、Getter、Setter

    /**
     * Instantiates a new Abstract jdbc.
     */
    public AbstractJdbc() {
    }

    public AbstractJdbc(String path) {
        use(path);
    }


    //    获得链接数据
//    static {
//        ResourceBundle resourceBundle = ResourceBundle.getBundle(strResourcePath);
//        DATABASE_CURRENTLY_IN_USE = Integer.parseInt(resourceBundle.getString("db.DatabaseCurrentlyInUse"));
//        chooseTypeInit(DATABASE_CURRENTLY_IN_USE);
//    }

    /**
     * Gets str resource path.
     *
     * @return the str resource path
     */
    public String getStrResourcePath() {
        return strResourcePath;
    }

    /**
     * Gets database currently in use.
     *
     * @return the database currently in use
     */
    public static int getDatabaseCurrentlyInUse() {
        return DATABASE_CURRENTLY_IN_USE;
    }

    /**
     * Sets database currently in use.
     *
     * @param databaseCurrentlyInUse the database currently in use
     */
    public static void setDatabaseCurrentlyInUse(int databaseCurrentlyInUse) {
        DATABASE_CURRENTLY_IN_USE = databaseCurrentlyInUse;
    }

    /**
     * Gets batch max.
     *
     * @return the batch max
     */
    public static int getBatchMax() {
        return BATCH_MAX;
    }

    /**
     * Sets batch max.
     *
     * @param batchMax the batch max
     */
    public static void setBatchMax(int batchMax) {
        BATCH_MAX = batchMax;
    }

    /**
     * Gets int batch count.
     *
     * @return the int batch count
     */
    public int getIntBatchCount() {
        return intBatchCount;
    }

    /**
     * Sets int batch count.
     *
     * @param intBatchCount the int batch count
     */
    public void setIntBatchCount(int intBatchCount) {
        this.intBatchCount = intBatchCount;
    }

//    /**
//     * Gets mysql.
//     *
//     * @return the mysql
//     */
//    public static int getMysql() {
//        return MYSQL;
//    }
//
//    /**
//     * Gets oracle.
//     *
//     * @return the oracle
//     */
//    public static int getOracle() {
//        return ORACLE;
//    }
//
//    /**
//     * Gets sql server.
//     *
//     * @return the sql server
//     */
//    public static int getSqlServer() {
//        return SQL_SERVER;
//    }

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
