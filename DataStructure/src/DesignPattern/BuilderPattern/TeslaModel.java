package DesignPattern.BuilderPattern;

/**
 * @Date 2019/4/5 10:31
 */
public class TeslaModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("特斯拉跑了!");
    }

    @Override
    protected void stop() {
        System.out.println("特斯拉停了！");
    }

    @Override
    protected void alarm() {
        System.out.println("特斯拉哔哔~");
    }

    @Override
    protected void engineBoom() {
        System.out.println("特斯拉BOOM!");
    }
}
