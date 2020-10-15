/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.config;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.TestInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Kevin KDA on 2020/10/14 14:41
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.config
 * @classname com.kevinkda.core.util.config.RegularValidationRuleConfig
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class RegularValidationRuleConfigTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegularValidationRuleConfigTest.class);


    @TestInfo(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/10/14 14:42")
    @Test
    public void getRuleEmail() {
//        LOGGER.info("Test:RegularValidationRuleConfig.getRuleEmail");
        LOGGER.info(RegularValidationRuleConfig.RULE_EMAIL);

    }
}