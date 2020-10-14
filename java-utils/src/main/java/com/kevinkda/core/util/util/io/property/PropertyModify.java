package com.kevinkda.core.util.util.io.property;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;

import java.io.IOException;

/**
 * 提供对 Properties 文件的更新操作
 *
 * @author Kevin KDA on 2020/10/13 16:00
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.io
 * @classname PropertyModify
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface PropertyModify {
    /**
     * 加载文件
     *
     * @throws IOException 文件不存在
     * @author Kevin KDA on 2020/5/24 21:47
     * @description PropertyModify / load
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/24 21:47")
    void load() throws IOException;

    /**
     * 操作文件
     *
     * @param key   属性键
     * @param value 属性值
     * @return boolean
     * @author Kevin KDA on 2020/5/24 21:46
     * @description PropertyModify / optionProperty
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/24 21:46")
    boolean optionProperty(String key, String value);

    /**
     * 更新属性值
     *
     * @param key   属性键
     * @param value 属性值
     * @return java.lang.Boolean 返回状态值
     * @author Kevin KDA on 2020/5/24 21:45
     * @description PropertyModify / updateProperty
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/24 21:45")
    boolean updateProperty(String key, String value);

    /**
     * 添加属性值
     *
     * @param key   属性键
     * @param value 属性值
     * @return boolean 返回状态值
     * @author Kevin KDA on 2020/5/24 21:44
     * @description PropertyModify / addProperty
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/24 21:44")
    boolean addProperty(String key, String value);

    /**
     * 获得属性值
     *
     * @param key 属性值的键
     * @return java.lang.String 返回属性值
     * @author Kevin KDA on 2020/5/24 21:43
     * @description PropertyModify / getProperty
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.2
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/24 21:43")
    String getProperty(String key);
}
