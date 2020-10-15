/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.verification;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Kevin KDA on 2020/10/14 15:17
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.verification
 * @classname VerifyCodeService
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
public interface VerifyCodeService {

    //    获得图片

    /**
     * 获得验证码图片
     *
     * @return java.awt.image.BufferedImage 返回带有验证码的图片
     * @author Kevin KDA on 2020/5/4 15:39
     * @description VerifyCode / getImage
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    public BufferedImage getImage();


//    保存文件

    /**
     * 保存图片文件
     *
     * @param image 传入绘制的图片
     * @param out   传入带有保存位置的输出流
     * @throws IOException 可能存在保存失败的情况
     * @author Kevin KDA on 2020/5/4 15:47
     * @description VerifyCode / output
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    public void output(BufferedImage image, OutputStream out) throws IOException;

//    验证

    /**
     * 验证用户输入的验证码
     *
     * @param userCode 传入用户输入的验证码
     * @return int 返回对比结果
     * @author Kevin KDA on 2020/5/4 16:17
     * @description VerifyCode / verify
     * @version 1.0.0
     * @apiNote <p>返回结果可能情况:</p>
     * <p>-1 用户未输入</p>
     * <p>0  用户输入错误</p>
     * <p>1  用户输入正确</p>
     * @implSpec
     * @implNote
     * @since 3.1.0
     */
    public int verify(String userCode);


    String getStrText();
}
