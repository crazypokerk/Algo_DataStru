package DesignPattern.StrategyPattern;

/**
 * @Date 2019/4/10 18:45
 */
public class Clinet {
    public static void main(String[] args) {
        //小王出场了，他根据拿的驾照来开对应的车
        License license;
        System.out.println("---今天试试A照---");
        license = new ADriverLicense();
        license.driverCarType();
        System.out.println("---明天试试B照---");
        license = new BDriverLicense();
        license.driverCarType();
        System.out.println("---后天试试C照---");
        license = new CDriverLicense();
        license.driverCarType();
    }
}
