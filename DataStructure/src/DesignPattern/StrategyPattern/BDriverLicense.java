package DesignPattern.StrategyPattern;

/**
 * @Date 2019/4/10 18:39
 */
public class BDriverLicense implements License {
    @Override
    public void driverCarType() {
        System.out.println("B照，可以开公交、客车");
    }
}
