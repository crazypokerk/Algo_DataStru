package DesignPattern.DecoratorPattern;

/**
 * @Date 2019/4/9 9:07
 */
public class Lemon extends CondimentDecorator {
    StarFuck starFuck;
    public Lemon(StarFuck s) {
        this.starFuck = s;
    }

    @Override
    public String getDescription() {
        return starFuck.getDescription() + "加一份柠檬！";
    }

    //加一份柠檬价格
    @Override
    public double cost() {
        return 1.2 + starFuck.cost();
    }
}
