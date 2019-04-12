package DesignPattern.ObserverPattren;

/**
 * @Date 2019/4/12 9:15
 */
public class SunQuan implements Observer {
    //孙权老哥
    @Override
    public void update(String context) {
        System.out.println("孙权：观察到诸葛亮有动作，干我毛事...");
        this.kanReNao(context);
        System.out.println("孙权：看看热闹...\n");
    }

    //汇报给曹操
    public void kanReNao(String reportContext) {
        System.out.println(reportContext + "！" + "孙权：我就安安静静的当个吃瓜群众...");
    }
}
