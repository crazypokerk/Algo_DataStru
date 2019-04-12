package DesignPattern.StrategyPattern;

/**
 * @Date 2019/4/10 18:39
 */
public class ADriverLicense implements License{
    @Override
    public void driverCarType() {
        System.out.println("A照，可以开重卡、大货！");
    }
}
