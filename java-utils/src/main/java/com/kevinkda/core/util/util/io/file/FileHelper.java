/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.io.file;


import java.io.File;
import java.io.OutputStream;

/**
 * 提供基于文件本身的处理方法
 *
 * @author Kevin KDA on 2020/10/14 11:48
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.io.file
 * @classname FileHelper<T>
 * @apiNote <p></p>
 * @since 1.0.0
 */
public interface FileHelper<T> extends IFile<T> {

    /**
     * 列出文件路径或目录下所有内容
     *
     * @param file 传入文件或文件夹路径
     * @return void
     * @author Kevin KDA on 2020/5/4 13:24
     * @description FileUtil / listDir
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    static void listDir(File file) {
//        如果是一个目录
        if (file.isDirectory()) {
//            列出目录中的全部内容
            File[] results = file.listFiles();
            if (results != null) {
                for (File f :
                        results) {
                    listDir(f);
                }
            }
        }
//        获取完整路径
        System.out.println(file);
    }

    /**
     * 更改目录名
     *
     * @param file 传入文件或文件夹路径
     * @return void
     * @author Kevin KDA on 2020/5/4 13:24
     * @description FileUtil / listDir
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    static void renameDir(File file) {
//        如果是一个目录
        if (file.isDirectory()) {
//            列出目录中的全部内容
            File[] results = file.listFiles();
            if (results != null) {
                for (int i = 0; i < results.length; i++) {
                    renameDir(results[i]);
                }
            } else {
                if (file.isFile()) {
//                    如果是文件则必须进行重命名
                    String fileName = null;
                    if (file.getName().contains(".")) {
                        fileName = file.getName().substring(0, file.getName().lastIndexOf(".")) + ".txt";
                    } else {
                        fileName = file.getName() + ".txt";
                    }
                    File newFile = new File(file.getParentFile(), fileName);
                    boolean b = file.renameTo(newFile);
                }
            }
        }
//        获取完整路径
        System.out.println(file);
    }

    /**
     * 文件/目录判断，并调用相印方法
     *
     * @param src 源文件路径
     * @param des 目标文件路径
     * @return boolean 拷贝成功True，否则False
     * @author Kevin KDA on 2020/5/4 13:25
     * @description FileUtil / copy
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    boolean copy(String src, String des);

    /**
     * 文件拷贝处理
     *
     * @param srcFile 源文件路径
     * @param desFile 目标文件路径
     * @return boolean 拷贝成功True，否则False
     * @author Kevin KDA on 2020/5/4 13:25
     * @description FileUtil / copyFile
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    boolean copyFile(File srcFile, File desFile);

    /**
     * 文件拷贝处理
     *
     * @param srcFile 源文件路径
     * @param desFile 目标文件路径
     * @return boolean 拷贝成功True，否则False
     * @author Kevin KDA on 2020/5/4 13:25
     * @description FileUtil / copyFileEarly
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    boolean copyFileEarly(File srcFile, File desFile);

    /**
     * 文件夹拷贝处理
     *
     * @param srcFile 源文件路径
     * @param desFile 目标文件路径
     * @return boolean 拷贝成功True，否则False
     * @author Kevin KDA on 2020/5/4 13:26
     * @description FileUtil / copyDir
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    boolean copyDir(File srcFile, File desFile);


    OutputStream getOutputStream();
}
