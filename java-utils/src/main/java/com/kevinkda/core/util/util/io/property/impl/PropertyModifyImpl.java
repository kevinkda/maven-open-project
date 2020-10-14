package com.kevinkda.core.util.util.io.property.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.util.io.property.PropertyModify;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 提供对 Properties 文件的更新操作
 *
 * @author Kevin KDA on 2020/10/13 16:00
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.io.property.impl
 * @classname
 * @apiNote <p></p>
 * @since 1.0.0
 */
@Service
public class PropertyModifyImpl implements PropertyModify {
    /**
     * Properties
     */
    private Properties properties;
    /**
     * 文件路径
     */
    private String propertiesUrl;
    /**
     * 文件名
     */
    private String propertiesName;
//    src/main/resources/version.properties


    /**
     * 加载文件
     *
     * @return void
     * @throws IOException 文件不存在
     * @author Kevin KDA on 2020/5/24 21:47
     * @description PropertyModify / load
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/24 21:47")
    public void load() throws IOException {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(propertiesUrl)) {
            properties.load(fis);
        }
    }

    /**
     * 操作文件
     *
     * @param key   属性键
     * @param value 属性值
     * @return boolean 返回状态值
     * @author Kevin KDA on 2020/5/24 21:46
     * @description PropertyModify / optionProperty
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/24 21:46")
    public boolean optionProperty(String key, String value) {
        try (FileOutputStream fos = new FileOutputStream(propertiesUrl)) {
            if (properties == null) {
                load();
            }
            properties.setProperty(key, value);
            // 将Properties集合保存到流中
            properties.store(fos, "Copyright (c) KevinKDA");
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * 更新属性值
     *
     * @param key   属性键
     * @param value 属性值
     * @return boolean 返回状态值
     * @author Kevin KDA on 2020/5/24 21:45
     * @description PropertyModify / updateProperty
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/24 21:45")
    public boolean updateProperty(String key, String value) {
        if (getProperty(key) == null) {
            return false;
        }
        return optionProperty(key, value);
    }

    /**
     * 添加属性值
     *
     * @param key   属性键
     * @param value 属性值
     * @return boolean 返回状态值
     * @author Kevin KDA on 2020/5/24 21:44
     * @description PropertyModify / addProperty
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 1.0.0
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/24 21:44")
    public boolean addProperty(String key, String value) {
        if (getProperty(key) != null) {
            return false;
        }
        return optionProperty(key, value);
    }

    /**
     * 获得属性值
     *
     * @param key 属性值的键
     * @return java.lang.String 返回属性值
     * @author Kevin KDA on 2020/5/24 21:43
     * @description PropertyModify / getProperty
     * @version 1.0.0
     * @apiNote <p></p>
     * @since 3.1.2
     */
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Pass, date = "2020/5/24 21:43")
    public String getProperty(String key) {
        try (FileInputStream fis = new FileInputStream(propertiesUrl)) {
            if (properties == null) {
                load();
            }
            properties.load(fis);
        } catch (IOException e) {
            return null;
        }
        return properties.getProperty(key);
    }


    public PropertyModifyImpl() {
    }

    public PropertyModifyImpl(String propertiesUrl) {
        setPropertiesUrl(propertiesUrl);
    }


    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getPropertiesUrl() {
        return propertiesUrl;
    }

    public void setPropertiesUrl(String propertiesUrl) {
        this.propertiesUrl = propertiesUrl;
        String[] urlArr = propertiesUrl.split("/");
        propertiesName = urlArr[urlArr.length - 1];
    }

    public String getPropertiesName() {
        return propertiesName;
    }

    public void setPropertiesName(String propertiesName) {
        this.propertiesName = propertiesName;
    }
}
