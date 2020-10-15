/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.bean.reflect.impl;

import com.kevinkda.core.util.util.bean.reflect.MethodService;
import com.kevinkda.core.util.util.json.impl.JsonHelperImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Kevin KDA on 2020/10/14 16:22
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.bean.reflect.impl
 * @classname com.kevinkda.core.util.util.bean.reflect.impl.MethodServiceImpl
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class MethodServiceImplTest {

    @Autowired
    private MethodService methodService;

    @Test
    void showMethodInformation() {
        methodService.showMethodInformation(JsonHelperImpl.class);
    }

    @Test
    void getMethodInformation() {
    }
}