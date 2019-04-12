package DesignPattern.PrototypePattern;

/**
 * @Date 2019/4/8 19:07
 */
public class AdvTemplate {
    //广告信名称
    private String advSubject = "鬼泣5新游发售活动重磅开启啦！";
    //广告信内容
    private String advContext = "性感但丁，在线骚舞。神秘VV，蜜汁男子。衰逼尼禄，我右臂呢？";

    //获取广告信的名称
    public String getAdvSubject() {
        return advSubject;
    }

    //获取广告信的内容
    public String getAdvContext() {
        return advContext;
    }
}
