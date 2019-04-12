package DesignPattern.DecoratorPattern;

/**
 * @Date 2019/4/9 8:52
 */
public abstract class StarFuck {
    public String description = "Unknown StarFuck";

    public String getDescription() {
        return description;
    }

    //价格
    public abstract double cost();
}
