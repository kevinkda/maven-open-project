/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.io.file.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.util.io.file.FileHelper;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * 提供基于文件本身的处理方法
 *
 * @author Kevin KDA on 2020/10/14 11:48
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.io.file.impl
 * @classname {@code FileHelperImpl<T>}
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class FileHelperImpl<T> implements FileHelper<T> {
    /**
     * 请求打开文件的路径
     *
     * @since 1.0.0
     */
    private String src;
    /**
     * 存储打开文件的对象
     *
     * @since 1.0.0
     */
    private File file;
    /**
     * 存储流对象
     *
     * @since 1.0.0
     */
    private OutputStream outputStream;


    /**
     * 文件/目录判断，并调用相印方法
     *
     * @param src 源文件路径
     * @param des 目标文件路径
     * @return boolean 拷贝成功True，否则False
     * @author Kevin KDA on 2020/5/4 13:25
     * @description FileUtil / copy
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:25")
    public boolean copy(String src, String des) {
        //        源文件必须存在
        if (src == null || des == null) {
            return false;
        }
        File srcFile = new File(src);
        File desFile = new File(des);
//        检测是否是文件
        if (srcFile.isFile()) {
            return copyFile(srcFile, desFile);
        } else {
//            是目录进行目录递归调用
            return copyDir(srcFile, desFile);
        }
    }

    /**
     * 文件拷贝处理
     *
     * @param srcFile 源文件路径
     * @param desFile 目标文件路径
     * @return boolean 拷贝成功True，否则False
     * @author Kevin KDA on 2020/5/4 13:25
     * @description FileUtil / copyFile
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:25")
    public boolean copyFile(File srcFile, File desFile) {
//        源文件不存在直接结束
        if (!srcFile.exists()) {
            return false;
        }
//        如果目标路径不存在将创建父路径
        if (!desFile.getParentFile().exists()) {
            boolean mkdirs = desFile.getParentFile().mkdirs();
        }
//        开辟一个拷贝的緩神区
        byte[] bytes = new byte[1024];
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(desFile);
            int len = 0;
            /*
            1.读取数据到数组之中，随后返回读取的个数   len = inputStream.read(bytes)
            2.判断个数是否是-1, 如果不是则进行写入    outputStream.write(bytes, 0, len)
             */
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
//            do {
////                拷贝的内容都在 data 数组
//                len = inputStream.read(bytes);
//                if (len != -1) {
//                    outputStream.write(bytes, 0, len);
//                }
//            } while (len != -1);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件拷贝处理
     *
     * @param srcFile 源文件路径
     * @param desFile 目标文件路径
     * @return boolean 拷贝成功True，否则False
     * @author Kevin KDA on 2020/5/4 13:25
     * @description FileUtil / copyFileEarly
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:25")
    public boolean copyFileEarly(File srcFile, File desFile) {
//        源文件不存在直接结束
        if (!srcFile.exists()) {
            return false;
        }
//        如果目标路径不存在将创建父路径
        if (!desFile.getParentFile().exists()) {
            boolean mkdirs = desFile.getParentFile().mkdirs();
        }
//        开辟一个拷贝的緩神区
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(desFile);
//            inputStream.transferTo(outputStream);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件夹拷贝处理
     *
     * @param srcFile 源文件路径
     * @param desFile 目标文件路径
     * @return boolean 拷贝成功True，否则False
     * @author Kevin KDA on 2020/5/4 13:26
     * @description FileUtil / copyDir
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:26")
    public boolean copyDir(File srcFile, File desFile) {
        try {
            copyDirImpl(srcFile, desFile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 递归调用取得目录结构或复制文件方法
     *
     * @param srcFile 源文件路径
     * @param desFile 目标文件路径
     * @return void
     * @author Kevin KDA on 2020/5/4 13:27
     * @description FileUtil / copyDirImpl
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:27")
    private void copyDirImpl(File srcFile, File desFile) {
//        检测是否是目录
        if (srcFile.isDirectory()) {
//            列出全部目录组成
            File[] results = file.listFiles();
            if (results != null) {
                for (File i :
                        results) {
                    copyDirImpl(i, desFile);
                }
            }
        } else {
            String newFilePath = file.getPath().replace(srcFile.getPath() + File.separator, "");
//            拷贝的目标路径
            File newFile = new File(desFile, newFilePath);
            copyFile(srcFile, newFile);
        }
    }


    /**
     * 打开文件操作
     *
     * @param src 传入需要打开的文件路径
     * @return boolean  返回打开结果
     * @author Kevin KDA on 2020/5/4 13:27
     * @description FileUtil / open
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:27")
    public boolean open(String src) {
//        指定要操作的文件路径
        File file = new File(src);
//        检测文件是否存在
        if (!file.getParentFile().exists()) {
//            创建父目录
            file.getParentFile().mkdirs();
        }
        try {
            outputStream = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            System.out.println();
        }
        return true;
    }


    /**
     * 读取文件
     *
     * @param file 传入需要读取的文件对象引用
     * @return java.lang.Object[] 获得文件引用数组
     * @author Kevin KDA on 2020/5/4 13:28
     * @description FileUtil / read
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:28")
    public Object[] read(File file) {
        return new Object[0];
    }

    /**
     * 写入文件
     *
     * @param items 传入需要写入的文件对象引用
     * @return boolean 返回写入结果
     * @author Kevin KDA on 2020/5/4 13:29
     * @description FileUtil / write
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:29")
    public boolean write(T items) {
//        if (items != null) {
//            for (T i :
//                    items) {
//                try {
//                    outputStream.write(i.toString().getBytes());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return true;
//        } else {
//            return false;
//        }

        try {
            outputStream.write(String.valueOf(items).getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 关闭文件
     *
     * @author Kevin KDA on 2020/5/4 13:28
     * @description FileUtil / close
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:28")
    public void close() {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public FileHelperImpl() {
    }

    @Override
    public OutputStream getOutputStream() {
        return outputStream;
    }

    //    @Override
    private void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
