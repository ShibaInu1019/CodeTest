package vcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws IOException {

        Random rd = new Random();
/*
        //生成n位的随机整数
        int n = 4;

        int a = (int) Math.pow(10, n - 1);
        System.out.println(rd.nextInt(9 * a) + a);


        //生产随机小写字母   97------97+25
        char c = (char) (rd.nextInt(26) + 97);
        System.out.println(c);
*/

        //利用数组  生成随机字符
        char[] cs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'};
        String code = "";
        for (int i = 0; i < 4; i++) {
            code += cs[rd.nextInt(cs.length)];
        }


        /*定义画布*/
        int width = 100;
        int height = 40;
        //定义画布
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        //获取画布的画笔
        Graphics gra = img.getGraphics();
        //设置颜色（背景）
        gra.setColor(Color.decode("#CCCCCC"));
        //填充背景
        gra.fillRect(0, 0, width, height);


        /*干扰线*/
        gra.setColor(Color.GRAY);
        for (int i = 0; i < 50; i++) {
            gra.drawLine(rd.nextInt(width),
                    rd.nextInt(height),
                    rd.nextInt(width),
                    rd.nextInt(height));
        }

        /*画文字*/

        //设置验证码颜色
        gra.setColor(Color.BLACK);
        //设置字体（字体名  样式  字号）
        gra.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
        //画文字
        for (int i = 0; i < code.length(); i++) {
            gra.drawString(code.charAt(i) + "", 20 * i + 9, 28);
        }



        /*输出流*/
        FileOutputStream fos = new FileOutputStream("code.png");
        //通过图像IO对象，向输出流中输出img对象
        ImageIO.write(img, "png", fos);

        fos.close();

    }
}
