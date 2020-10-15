/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.verification;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.config.RegularValidationRuleConfig;

/**
 * 专用验证程序验证程序类
 *
 * @author Kevin KDA on 2020/10/14 14:34
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.verification
 * @classname ValidatorService
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface ValidatorService {
    /**
     * 验证EMAIL有效性
     * e.g. kevin_finance-china@yahoo.com.au
     *
     * @param eMail 传入带检测的Email地址
     * @return boolean 返回检查结果
     * @author Kevin KDA on 2020/5/4 14:05
     * @description ValidatorService / isEmail
     * @version 1.0.0
     * @apiNote <p>被允许的的构成0-9、A-Z、a-z、_、-</p>
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 14:05")
    static boolean isEmail(String eMail) {
        if (eMail == null || "".equals(eMail)) {
            return false;
        }
        return eMail.matches(RegularValidationRuleConfig.RULE_EMAIL);
    }


    /**
     * 验证是否是合法的IP地址
     *
     * @param ip 传入带检测的IP地址
     * @return boolean 返回检查结果
     * @author Kevin KDA on 2020/5/4 14:06
     * @description Validator / isIpV4
     * @version 1.0.0
     * @apiNote <p>本方法允许检测IPv4地址</p>
     * @implSpec
     * @implNote
     * @since 1.0.0
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 14:06")
    static boolean isIpV4(String ip) {
        if (ip == null || "".equals(ip)) {
            return false;
        }
        /*
        <iframe frameborder="0" width="783" height="203" src="https://jex.im/regulex/#!embed=true&flags=&re=(%5B12%5D%3F%5B0-9%5D%3F%5B0-9%5D%5C.)%7B3%7D(%5B12%5D%3F%5B0-9%5D%3F%5B0-9%5D)"></iframe>
         */

        if (ip.matches(RegularValidationRuleConfig.RULE_IPV4)) {
            String[] result = ip.split("\\.");
            for (String temp :
                    result) {
                int i = Integer.parseInt(temp);
                if (i > 255) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

}
