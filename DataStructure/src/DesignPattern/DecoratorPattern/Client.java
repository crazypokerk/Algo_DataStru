package DesignPattern.DecoratorPattern;

/**
 * @Date 2019/4/9 9:09
 */
public class Client {
    public static void main(String[] args) {
        StarFuck starFuck = new Cocacola();
        System.out.println(starFuck.getDescription() + " ￥" + starFuck.cost());

        StarFuck starFuck1 = new Milk();
        starFuck1 = new Ice(starFuck1);
        System.out.println(starFuck1.getDescription() + " ￥" + starFuck1.cost());

        StarFuck starFuck2 = new JLaoWang();
        starFuck2 = new Ice(starFuck2);
        starFuck2 = new Lemon(starFuck2);
        System.out.println(starFuck2.getDescription() + " ￥" + starFuck2.cost());
    }
}
