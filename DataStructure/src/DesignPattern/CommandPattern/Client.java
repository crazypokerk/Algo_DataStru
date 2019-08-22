package DesignPattern.CommandPattern;

/**
 * @Date 2019/4/13 18:57
 */
public class Client {
	public static void main(String[] args) {
		Breakfast food1 = new ChangFen();
		Breakfast food2 = new HunDun();
		Breakfast food3 = new YouTiao();
		
		Waiter waiter = new Waiter();
		
		//设置菜单
		waiter.setChangFen(food1);
		waiter.setHunDun(food2);
		waiter.setYouTiao(food3);
		
		//选择早餐
		waiter.chooseChangFen();
		waiter.chooseHunDun();
		waiter.chooseYouTiao();
	}
}
