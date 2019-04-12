package DesignPattern.BuilderPattern;

/**
 * @Date 2019/4/5 10:22
 */
public class BenzModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("奔驰开了！");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰停了！");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰咚咚~");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰BOOM!");
    }
}
