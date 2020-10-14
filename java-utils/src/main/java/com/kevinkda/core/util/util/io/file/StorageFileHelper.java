/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.io.file;

import java.util.List;

/**
 * 实现文件存储和读取
 *
 * @author Kevin KDA on 2020/10/14 11:44
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.io.file
 * @classname StorageFileHelper
 * @apiNote <p></p>
 * @since 1.0.0
 */
public interface StorageFileHelper<T> {
    /**
     * 进行文件存储
     *
     * @param filepath 传入输出文件路径
     * @param listData 传入需存储的数据
     * @return boolean 返回存储结果
     * @author Kevin KDA on 2020/5/4 13:20
     * @description StorageFile / storage
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    boolean storage(String filepath, List<T> listData);

    /**
     * 进行文件存储
     *
     * @param filepath 传入输出文件路径
     * @param listData 传入需存储的数据
     * @return boolean 返回存储结果
     * @author Kevin KDA on 2020/5/4 13:22
     * @description StorageFile / storage
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    boolean storage(String filepath, Object listData);

    /**
     * 读取文件并返回List<T>数据，如文件不存在直接返回null
     *
     * @param filepath 传入读取文件路径
     * @return java.util.List<T> 传入读取文件获得的列表
     * @author Kevin KDA on 2020/5/4 13:22
     * @description StorageFile / readList
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    List<T> readList(String filepath);

    /**
     * 读取文件并返回Object[]数据，如文件不存在直接返回null
     *
     * @param filepath 传入读取文件路径
     * @return java.lang.Object[] 传入读取文件获得的列表
     * @author Kevin KDA on 2020/5/4 13:21
     * @description StorageFile / readObject
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    Object[] readObject(String filepath);

}
