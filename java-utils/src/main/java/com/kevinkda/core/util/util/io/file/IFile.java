/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.io.file;

/**
 * 提供基于文件本身的处理方法
 *
 * @author Kevin KDA on 2020/10/14 11:52
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.io.file
 * @classname {@code IFile<T>}
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface IFile<T> extends AutoCloseable {
    /**
     * 打开文件操作
     *
     * @param src 传入需要打开的文件路径
     * @return boolean 返回打开结果
     * @author Kevin KDA on 2020/5/4 13:16
     * @description IFile / open
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public boolean open(String src);

    /**
     * 读取文件
     *
     * @param file 传入需要读取的文件对象引用
     * @return java.lang.Object[] 获得文件引用数组
     * @author Kevin KDA on 2020/5/4 13:18
     * @description IFile / read
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public Object[] read(java.io.File file);

    /**
     * 写入文件
     *
     * @param items 传入需要写入的文件对象引用
     * @return boolean 返回写入结果
     * @author Kevin KDA on 2020/5/4 13:18
     * @description IFile / write
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    public boolean write(T items);

    /**
     * 关闭文件
     *
     * @author Kevin KDA on 2020/5/4 13:17
     * @description IFile / close
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    public void close();

}
