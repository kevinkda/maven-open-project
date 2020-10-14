/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.io.file.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.TestInfo;
import com.kevinkda.core.util.util.io.file.FileHelper;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author Kevin KDA on 2020/10/14 11:54
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.io.file.impl
 * @classname com.kevinkda.core.util.util.io.file.impl.FileHelperImpl
 * @apiNote <p></p>
 * @since 1.0.0
 */
class FileHelperImplTest {

    @Test
    void copy() {
    }

    @TestInfo(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 11:54")
    @Test
    public void testA() {
        System.out.println("Test:");
        FileHelper fileHelper = new FileHelperImpl();
        FileHelper.listDir(new File(""));
    }
}