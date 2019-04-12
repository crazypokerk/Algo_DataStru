package DesignPattern.PrototypePattern;

import java.util.Random;

/**
 * @Date 2019/4/8 19:18
 */
public class Client {
    //发送广告的数量，这个值是从数据库中获得
    private static int MAX_COUNT = 6;

    public static void main(String[] args)  {
        //模拟发邮件
        int i = 0;
        //把模板定义出来。这个是从数据中获得
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("所有解释权归卡婊所有！");
        while (i < MAX_COUNT) {
            //以下是没封邮件不同的地方
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation(getRandomString(5)+" 先生（女士） ");
            cloneMail.setReciver(getRandomString(5) + "@" + getRandomString(8) + ".com");
            //然后发送邮件
            sendMail(cloneMail);
            ++i;
        }
    }

    public static void sendMail(Mail mail) {
        System.out.println("标题： " + mail.getSubject() + "\t收件人：" + mail.getReciver() + "\t...发送成功！");
        System.out.println("内容： "+mail.getContext());
    }

    public static String getRandomString(int maxLength) {
        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < maxLength; i++) {
            sb.append(source.charAt(random.nextInt(source.length())));
        }
        return sb.toString();
    }
}

