package DesignPattern.AdapterPattern;

/**
 * @Date 2019/4/11 9:43
 */
public class Laptop implements LaptopPlug {
    @Override
    public void boot() {
        System.out.println("我需要稳定220v电源，没电开不了机");
    }

    @Override
    public void playR6() {
        System.out.println("幻想中：rush b never stop!!!gogogogo!!!");
    }

    @Override
    public void zzRW() {
        System.out.println("看不见杂志直播...");
    }
}
