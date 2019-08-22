package com.exe.wenda.util;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @Date 2019/6/17 14:31
 */
public class ValidateCode {
  public static void getImage(OutputStream out, String number)
          throws ServletException, IOException {
    //0.创建空白图片
    BufferedImage image=new BufferedImage(100,30,BufferedImage.TYPE_INT_RGB);
    //1.获取图片画笔
    Graphics g = image.getGraphics();
    Random r=new Random();
    //2.设置画笔颜色(Random类中的nextInt(n)返回一个大于等于0，小于n的随机数)
    g.setColor(new Color(r.nextInt(255),r.nextInt(255), r.nextInt(255)));
    //3.绘制矩形的背景
    g.fillRect(0, 0, 100, 30);
    //4.调用自定义的方法，获取长度为4的字母数字组合的字符串
    g.setColor(new Color(0,0,0));
    g.setFont(new Font(null,Font.BOLD,24));
    //5.设置颜色字体后，绘制字符串（x/y,最左边字符所处的位置）
    g.drawString(number, 20, 24);
    //6.绘制8条干扰线(alpha表示透明度)
    for(int i=0;i<8;i++){
      g.setColor(new Color(r.nextInt(255),r.nextInt(255), r.nextInt(255),r.nextInt(255)));
      g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
    }
    ImageIO.write(image, "jpeg", out);
  }

  //自定义方法，获取长度为size的字母数字组合的字符串
  public static String getNumber(int size){
    String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String number="";
    Random r = new Random();
    for(int i=0;i<size;i++){
      number+=str.charAt(r.nextInt(str.length()));
    }
    return number;
  }
}
