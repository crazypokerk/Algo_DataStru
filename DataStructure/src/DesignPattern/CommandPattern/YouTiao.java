package DesignPattern.CommandPattern;

/**
 * @Date 2019/4/13 18:43
 */
public class YouTiao extends Breakfast {
	private YouTiaoCook receiver;
	
	public YouTiao() {
		receiver = new YouTiaoCook();
	}
	
	@Override
	public void cooking() {
		receiver.cooking();
	}
}
