package DesignPattern.DecoratorPattern;

/**
 * @Date 2019/4/9 9:02
 */
public class Ice extends CondimentDecorator {
    StarFuck starFuck;

    public Ice(StarFuck s) {
        this.starFuck = s;
    }

    @Override
    public String getDescription() {
        return starFuck.getDescription() + ",加一份冰块！";
    }

    //加冰块价格
    @Override
    public double cost() {
        return 0.5 + starFuck.cost();
    }
}
