package DesignPattern.DecoratorPattern;

/**
 * @Date 2019/4/9 8:59
 */
public class JLaoWang extends StarFuck {
    //加王老吉价格
    @Override
    public double cost() {
        return 5.6;
    }

    public JLaoWang() {
        description = "王老吉";
    }
}
