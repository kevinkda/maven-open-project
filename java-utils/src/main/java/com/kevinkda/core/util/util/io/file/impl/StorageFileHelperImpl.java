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
import com.kevinkda.core.util.util.io.file.StorageFileHelper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 实现文件存储和读取
 *
 * @author Kevin KDA on 2020/10/14 11:45
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.io.file.impl
 * @classname
 * @apiNote <p></p>
 * @since 1.0.0
 */
@Service
public class StorageFileHelperImpl<T> implements Serializable, StorageFileHelper<T> {
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
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:20")
    public boolean storage(String filepath, List<T> listData) {
        File file = new File(filepath);
        //        如果目标路径不存在将创建父路径
        if (!file.getParentFile().exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(listData);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                Objects.requireNonNull(objectOutputStream).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

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
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:22")
    public boolean storage(String filepath, Object listData) {
        File file = new File(filepath);
        //        如果目标路径不存在将创建父路径
        if (!file.getParentFile().exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(listData);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                Objects.requireNonNull(objectOutputStream).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

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
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:22")
    public List<T> readList(String filepath) {
        File file = new File(filepath);
//        检查文件是否存在，不存在返回null
        if (!file.exists()) {
            return null;
        }
        List<T> listData = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            listData = (ArrayList<T>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listData;
    }

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
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 13:21")
    public Object[] readObject(String filepath) {
        File file = new File(filepath);
        //        检查文件是否存在，不存在返回null
        if (!file.exists()) {
            return null;
        }
        Object[] data = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            data = (Object[]) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }


    public StorageFileHelperImpl() {
    }

}
