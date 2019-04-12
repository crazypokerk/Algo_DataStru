package DesignPattern.ObserverPattren;

/**
 * @Date 2019/4/12 9:13
 */
public class LiuBei implements Observer {
    //刘备
    @Override
    public void update(String context) {
        System.out.println("刘备：观察到诸葛亮有动作，干得漂亮...");
        this.happy(context);
        System.out.println("刘备：老诸很牛逼啊...\n");
    }

    //汇报给曹操
    public void happy(String reportContext) {
        System.out.println(reportContext + "！" + "刘备：回来重赏诸葛村夫！");
    }
}
