package DesignPattern.StrategyPattern;

/**
 * @Date 2019/4/10 18:39
 */
public class CDriverLicense implements License {
    @Override
    public void driverCarType() {
        System.out.println("C照，可以开轿车、SUV！");
    }
}
