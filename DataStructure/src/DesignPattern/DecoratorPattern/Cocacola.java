package DesignPattern.DecoratorPattern;

/**
 * @Date 2019/4/9 8:56
 */
public class Cocacola extends StarFuck {
    //加可乐价格
    @Override
    public double cost() {
        return 3.0;
    }

    public Cocacola() {
        description = "可口可乐";
    }
}
