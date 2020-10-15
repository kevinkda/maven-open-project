/*
 * Copyright (c) KevinKDA 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.kevinkda.core.util.util.verification.impl;

import com.kevinkda.core.util.annotation.enumeration.VerifiedType;
import com.kevinkda.core.util.annotation.func.FuncVerification;
import com.kevinkda.core.util.config.VerifyCodeConfig;
import com.kevinkda.core.util.util.verification.VerifyCodeService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @author Kevin KDA on 2020/10/14 15:18
 * @version 1.0.0
 * @project maven-open-project
 * @package com.kevinkda.core.util.util.verification.impl
 * @classname
 * @apiNote
 * @implSpec
 * @implNote
 * @since 1.0.0
 */
@Service
public class VerifyCodeServiceImpl extends VerifyCodeConfig implements VerifyCodeService {
    /**
     * 程序返回的验证码字符串
     *
     * @since 1.0.0
     */
    public String strText;


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
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 15:39")
    public BufferedImage getImage() {
//        创建图片冲区
        BufferedImage image = createImage();
//        得到绘制环境
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
//        用来装戟生成的验证码文本
        StringBuilder stringBuilder = new StringBuilder();
//        向图片中画 4 个字符,循环四次，每次生成一个字符
        for (int i = 0; i < 4; i++) {
//            随机生成一个字母
            String s = randomChar() + "";
//            把字母添加到 StringBuilder 中
            stringBuilder.append(s);
//            设置当前字符的 x 轴坐标
            float x = i * 1.0F * width / 4;
//            设置随机字体
            graphics2D.setFont(randomFont());
//            设置随机颜色
            graphics2D.setColor(randomColor());
//            画图
            graphics2D.drawString(s, x, height - 5);
        }
//        把生成字符串赋给strText
        this.strText = stringBuilder.toString();
//        添加干扰线
        drawLine(image);
        return image;
    }


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
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 15:47")
    public void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }


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
    @Override
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 16:17")
    public int verify(String userCode) {
        if (userCode.toLowerCase().equals(strText.toLowerCase())) {
            return 1;
        } else if ("".equals(userCode.trim())) {
            return -1;
        }
        return 0;
    }


//    私有Utils

    /**
     * 获取文字颜色
     *
     * @return java.awt.Color 返回RGB颜色
     * @author Kevin KDA on 2020/5/4 15:10
     * @description VerifyCode / randomColor
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 15:10")
    private Color randomColor() {
//        获得RGB值
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
//        从随机获得RGB值中取得RGB颜色
        return new Color(red, green, blue);
    }

    /**
     * 获取文字样式
     *
     * @return java.awt.Font 返回文字样式
     * @author Kevin KDA on 2020/5/4 15:17
     * @description VerifyCode / randomFont
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 15:17")
    private Font randomFont() {
//        获得字体下标索引
        int index = random.nextInt(fontNames.length);
//        获得下标索引对应的字体名
        String fontName = fontNames[index];
//        生成随机的样式，0（无样式）,1（相体）,2（斜体）,3（粗体+斜体）
        int style = random.nextInt(4);
//        获得字体大小    24-28
        int size = random.nextInt(5) + 24;
//        返回字体样式
        return new Font(fontName, style, size);
    }

    /**
     * 对验证码图片进行处理，画干扰线
     *
     * @param image 传入待处理的图片流
     * @return void
     * @author Kevin KDA on 2020/5/4 15:23
     * @description VerifyCode / drawLine
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 15:23")
    private void drawLine(BufferedImage image) {
//        共画 3 条
        int num = 3;
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
//        生成两个点的坐标，即 4 个值
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics2D.setStroke(new BasicStroke(1.5F));
//            设置干扰线颜色为蓝色
            graphics2D.setColor(Color.BLUE);
//            绘制线条
            graphics2D.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 随机获得字符
     *
     * @return char 返回可使用的字符
     * @author Kevin KDA on 2020/5/4 15:27
     * @description VerifyCode / randomChar
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 15:27")
    private char randomChar() {
//        获得可使用的字符下标索引
        int index = random.nextInt(codes.length());
//        返回下标索引对应的字符
        return codes.charAt(index);
    }

    /**
     * 创建图片
     *
     * @return java.awt.image.BufferedImage 返回已创建的图片
     * @author Kevin KDA on 2020/5/4 15:28
     * @description VerifyCode / createImage
     * @version 1.0.0
     * @apiNote
     * @implSpec
     * @implNote
     * @since 3.1.1
     */
    @FuncVerification(version = "1.0.0", status = VerifiedType.Unverified, date = "2020/5/4 15:28")
    private BufferedImage createImage() {
//        使用宽高，创建RGB图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//        绘制图片
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
//        设置背景颜色
        graphics2D.setColor(this.bgColor);

        graphics2D.fillRect(0, 0, width, height);
//        返回绘制的图片
        return image;
    }


    public VerifyCodeServiceImpl() {
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Random getRandom() {
        return random;
    }

    public String[] getFontNames() {
        return fontNames;
    }

    public String getCodes() {
        return codes;
    }

    public Color getBgColor() {
        return bgColor;
    }

    @Override
    public String getStrText() {
        return strText;
    }

    public void setStrText(String strText) {
        this.strText = strText;
    }
}
