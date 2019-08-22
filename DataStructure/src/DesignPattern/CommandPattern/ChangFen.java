package DesignPattern.CommandPattern;

/**
 * @Date 2019/4/13 18:42
 */
public class ChangFen extends Breakfast {
	private ChangFenCook receiver;
	
	public ChangFen() {
		receiver = new ChangFenCook();
	}
	
	@Override
	public void cooking() {
		receiver.cooking();
	}
}
