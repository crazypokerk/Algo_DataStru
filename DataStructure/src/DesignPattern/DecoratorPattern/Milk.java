package DesignPattern.DecoratorPattern;

/**
 * @Date 2019/4/9 8:58
 */
public class Milk extends StarFuck {
    //加牛奶价格
    @Override
    public double cost() {
        return 4.2;
    }

    public Milk() {
        description = "蒙古牛奶";
    }
}
