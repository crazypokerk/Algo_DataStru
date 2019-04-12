package DesignPattern.StrategyPattern;

/**
 * @Date 2019/4/10 18:44
 */
public class SmallWang {
    //构造函数，要用哪种驾照
    private License license;
    public SmallWang(License l) {
        this.license = l;
    }

    //使用驾照
    public void driver() {
        this.license.driverCarType();
    }
}
