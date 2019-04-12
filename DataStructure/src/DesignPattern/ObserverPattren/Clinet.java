package DesignPattern.ObserverPattren;

/**
 * @Date 2019/4/12 9:16
 */
public class Clinet {
    public static void main(String[] args) {
        //生产出三个观察者
        Observer wst = new WangSiTu();
        Observer lb = new LiuBei();
        Observer sq = new SunQuan();

        //定义出诸葛亮
        ZhuGeLiang zgl = new ZhuGeLiang();

        zgl.addObserver(wst);
        zgl.addObserver(lb);
        zgl.addObserver(sq);

        zgl.planB();
        //zgl.attack();
    }
}
