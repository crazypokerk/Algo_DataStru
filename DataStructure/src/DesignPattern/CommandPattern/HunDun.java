package DesignPattern.CommandPattern;

/**
 * @Date 2019/4/13 18:43
 */
public class HunDun extends Breakfast {
	private HunDunCook receiver;
	
	public HunDun() {
		receiver = new HunDunCook();
	}
	
	@Override
	public void cooking() {
		receiver.cooking();
	}
}
